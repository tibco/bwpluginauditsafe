package com.tibco.bw.sharedresource.tas.model.helper;

import static com.tibco.bw.sharedresource.tas.model.helper.TasConstants.TENANT_ID;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class TasClient {
	public static final String ENV_INTERNAL_URL = "TIBCO_INTERNAL_INTERCOM_URL";
	public static final String ENV_SUBSCRIPTION_ID = "TIBCO_INTERNAL_TCI_SUBSCRIPTION_ID";
	public static final String PROD_TIBCO_CLOUD = "auditsafe.cloud.tibco.com";

	protected static UserAwareCookieManager cookieManager;

	public synchronized static UserAwareCookieManager getCookieManager() {
		if (cookieManager == null) {
			cookieManager = new UserAwareCookieManager();
			CookieHandler.setDefault(cookieManager);
		}
		return cookieManager;
	}

	protected static void switchUserOn(String username) {
		try {
			getCookieManager().acquire(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected static void switchUserOff() {
		try {
			getCookieManager().release();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static TasResponse getAuditEvent(String tasBaseUrl, String username,
			String password, String accountId, String body,
			boolean retry) {
		switchUserOn(username+accountId);
		TasResponse result = new TasResponse();
		if (tasBaseUrl.endsWith("/")) {
			tasBaseUrl = tasBaseUrl.substring(0, tasBaseUrl.length() - 1);
		}
		try {
			String internalUrl = System.getProperty(ENV_INTERNAL_URL);
			HttpURLConnection httpConn;
			String getEventUrl = "";
			if (internalUrl != null && !internalUrl.isEmpty()) {
				String subId = System.getProperty(ENV_SUBSCRIPTION_ID);
				getEventUrl = internalUrl
						+ "/tas/dataserver/intercom/transactions/query?tscSubscriptionId="
						+ subId;
			} else {
				getEventUrl = tasBaseUrl
						+ "/tas/dataserver/transactions/query";

			}
			httpConn = buildpostHttpUrlConnectionWithJson(getEventUrl, body,
					getsettingMap("application/json", "application/json"));
			String message = getHttpRequestBody(httpConn);
			int statusCode = httpConn.getResponseCode();
			result.setStatusCode(statusCode);

			if(statusCode == HttpURLConnection.HTTP_OK){
				result.setSuccessfulResponse(message);
			} else if (retry) {
				TasResponse authResponse = auth(tasBaseUrl, username, password, accountId);
				if (!authResponse.isHasError()) {
					result = postAuditEvent(tasBaseUrl, username, password,
							accountId, body, false);
				} else {
					return authResponse;
				}
			} else {
				result.setErrorMessage(message);
			}

		} catch (IOException e) {
			result.setErrorMessage(e.getMessage());

		} finally {
			switchUserOff();
		}

		return result;
	}


	public static TasResponse postAuditEvent(String tasBaseUrl, String username,
			String password, String accountId, String body,
			boolean retry) {
		switchUserOn(username+accountId);
		TasResponse result = new TasResponse();
		if (tasBaseUrl.endsWith("/")) {
			tasBaseUrl = tasBaseUrl.substring(0, tasBaseUrl.length() - 1);
		}
		try {
			String internalUrl = System.getProperty(ENV_INTERNAL_URL);
			HttpURLConnection httpConn;
			String postEventUrl = "";
			if (internalUrl != null && !internalUrl.isEmpty()) {
				String subId = System.getProperty(ENV_SUBSCRIPTION_ID);
				postEventUrl = internalUrl
						+ "/tas/dataserver/intercom/transactions?tscSubscriptionId="
						+ subId;
			} else {
				postEventUrl = tasBaseUrl
						+ "/tas/dataserver/transactions";

			}
			httpConn = buildpostHttpUrlConnectionWithJson(postEventUrl, body,
					getsettingMap("application/json", "application/json"));
			String message = getHttpRequestBody(httpConn);
			int statusCode = httpConn.getResponseCode();
			result.setStatusCode(statusCode);

			if(statusCode == HttpURLConnection.HTTP_OK){
				result.setSuccessfulResponse(message);
			} else if (retry) {
				TasResponse authResponse = auth(tasBaseUrl, username, password, accountId);
				if (!authResponse.isHasError()) {
					result = postAuditEvent(tasBaseUrl, username, password,
							accountId, body, false);
				} else {
					return authResponse;
				}
			} else {
				result.setErrorMessage(message);
			}

		} catch (IOException e) {
			result.setErrorMessage(e.getMessage());

		} finally {
			switchUserOff();
		}

		return result;
	}

	public static TasResponse auth(String tasBaseUrl, String username,
			String password, String accountId) {
		TasResponse tr = new TasResponse();
		try {
			TasResponse taResponse = getToken(tasBaseUrl, username, password);
			if(taResponse.isHasError()){
				return taResponse;
			}
			if (tasBaseUrl.endsWith("/")) {
				tasBaseUrl = tasBaseUrl.substring(0, tasBaseUrl.length() - 1);
			}
			String idmUrl = tasBaseUrl + "/idm/v2/login-oauth";
			HttpURLConnection httpConn;

			Map<String, String> params = new HashMap<String, String>();
			params.put("AccessToken", taResponse.getMessage());
			params.put("TenantId", TENANT_ID);
			if(accountId != null && !accountId.isEmpty()){
				params.put("AccountId", accountId);
			}
			httpConn = buildpostHttpUrlConnection(idmUrl, params, getsettingMap());
			String message = getHttpRequestBody(httpConn);
			int statusCode = httpConn.getResponseCode();
			tr.setStatusCode(statusCode);
			if (statusCode == HttpURLConnection.HTTP_OK){
				tr.setSuccessfulResponse(message);
			} else {
				tr.setErrorMessage(message);
			}
		} catch (IOException e) {
			tr.setErrorMessage(e.getMessage());
		}
		return tr;
	}

	public static TasResponse getToken(String tasUrl, String username, String password) {
		TasResponse response = new TasResponse();
		String taUrl = "https://sso-awsqa.tibco.com/as/token.oauth2";
		if(tasUrl.contains(PROD_TIBCO_CLOUD)){
			taUrl = "https://sso-ext.tibco.com/as/token.oauth2";
		}
		Map<String, String> params = new HashMap<String, String>();
		params.put("username", username);
		params.put("password", password);
		params.put("grant_type", "password");
		params.put("client_id", "ropc_ipass");

		HttpURLConnection httpConn;
		try {
			httpConn = buildpostHttpUrlConnection(taUrl, params,
					getsettingMap());
			String messagebody = getHttpRequestBody(httpConn);
			int statusCode = httpConn.getResponseCode();

			response.setStatusCode(statusCode);
			if (statusCode == HttpURLConnection.HTTP_OK) {
				JsonReader node = new JsonReader(messagebody);
				if (node.getNode("access_token") != null) {
					response.setSuccessfulResponse(node.getNode("access_token").textValue());
				}
			} else {
				response.setErrorMessage(messagebody);
			}
		} catch (IOException e) {
			response.setErrorMessage(e.getMessage());
		}

		return response;
	}

	public static HashMap<String, String> getAccountIds(String tasBaseUrl,
			String token) throws IOException {
		if (tasBaseUrl.endsWith("/")) {
			tasBaseUrl = tasBaseUrl.substring(0, tasBaseUrl.length() - 1);
		}
		String idmUrl = tasBaseUrl + "/idm/v2/login-oauth";
		HttpURLConnection httpConn;

		Map<String, String> params = new HashMap<String, String>();
		params.put("AccessToken", token);
		params.put("TenantId", TENANT_ID);
		httpConn = buildpostHttpUrlConnection(idmUrl, params, getsettingMap());
		String messagebody = getHttpRequestBody(httpConn);
		int statusCode = httpConn.getResponseCode();

		HashMap<String, String> accountsInfo = new HashMap<String, String>();
		if (statusCode == HttpURLConnection.HTTP_OK) {
			// if return 200, means there is no multiple organization, just put
			// 1 as key and value
			accountsInfo.put("1", "1");
		} else if (statusCode == 300) {
			JsonReader node = new JsonReader(messagebody);
			ArrayNode info = (ArrayNode) node.getNode("accountsInfo");
			for (JsonNode jsonNode : info) {
				String orgName = jsonNode.get("accountDisplayName").asText();
				String ownerEmail = jsonNode.get("ownerInfo").get("email")
						.asText();
				String accountId = jsonNode.get("accountId").asText();
				accountsInfo.put(orgName + "/(Owner Email: )" + ownerEmail,
						accountId);
			}
		}
		return accountsInfo;
	}

	public static TasResponse getSchema(String tasBaseUrl, String username,
			String password, String accountId, String body, int type) {
		switchUserOn(username+accountId);
		TasResponse result = new TasResponse();
		if (tasBaseUrl.endsWith("/")) {
			tasBaseUrl = tasBaseUrl.substring(0, tasBaseUrl.length() - 1);
		}
		try {
			TasResponse authResponse = auth(tasBaseUrl, username, password, accountId);
			if (authResponse.isHasError()) {
				return authResponse;
			} else{
				String schemaUrl = tasBaseUrl + "/tas/dataserver/schema";
				HttpURLConnection httpConn = buildpostHttpUrlConnectionWithJson(
						schemaUrl, body,
						getsettingMap("application/json", "application/json"));
				String messagebody = getHttpRequestBody(httpConn);
				int statusCode = httpConn.getResponseCode();
				result.setStatusCode(statusCode);

				if (statusCode == HttpURLConnection.HTTP_OK) {
					JsonReader node = new JsonReader(messagebody);
					if (type == 1 && node.getNode("requestSchema") != null) {
						result.setSuccessfulResponse(node.getNode("requestSchema").toString());
					} else if (type == 2 && node.getNode("responseSchema") != null) {
						result.setSuccessfulResponse(node.getNode("responseSchema").toString());
					}
				} else {
					result.setErrorMessage(messagebody);
				}
			}
		} catch (Exception e) {
			result.setErrorMessage("Get schema failed! " + e.getMessage());
		} finally {
			switchUserOff();
		}

		return result;
	}

	public static Map<String, String> getsettingMap() {
		return getsettingMap("application/x-www-form-urlencoded",
				"application/json");
	}

	public static Map<String, String> getsettingMap(String contentType,
			String acceptType) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("Content-Type", contentType);
		params.put("Accept", acceptType);
		return params;
	}

	public static HttpURLConnection buildpostHttpUrlConnection(
			String urlstring, Map<String, String> formparams,
			Map<String, String> settingparams) throws IOException {
		HttpURLConnection connection = null;
		URL url = new URL(urlstring);
		connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		addUrlConnectionSetting(connection, settingparams);
		if (formparams != null) {
			addUrlConnectionParameter(connection, formparams);
		}
		return connection;
	}

	public static HttpURLConnection buildpostHttpUrlConnectionWithJson(
			String urlstring, String json, Map<String, String> settingparams)
			throws IOException {
		HttpURLConnection connection = null;
		URL url = new URL(urlstring);
		connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		addUrlConnectionSetting(connection, settingparams);
		addUrlConnectionJson(connection, json);
		return connection;
	}

	public static void addUrlConnectionSetting(HttpURLConnection connection,
			Map<String, String> settingparams) {
		for (String key : settingparams.keySet()) {
			connection.setRequestProperty(key, settingparams.get(key));
		}

	}

	public static void addUrlConnectionParameter(HttpURLConnection connection,
			Map<String, String> formparams)
			throws UnsupportedEncodingException, IOException {
		connection.setDoOutput(true);
		OutputStream os = connection.getOutputStream();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os,
				"UTF-8"));
		writer.write(getPostDataString(formparams));
		writer.flush();
		writer.close();
		os.close();
	}

	public static void addUrlConnectionJson(HttpURLConnection connection,
			String json) throws UnsupportedEncodingException, IOException {
		connection.setDoOutput(true);
		OutputStream os = connection.getOutputStream();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os,
				"UTF-8"));
		writer.write(json);
		writer.flush();
		writer.close();
		os.close();
	}

	public static String getPostDataString(Map<String, String> params)
			throws UnsupportedEncodingException {
		StringBuilder result = new StringBuilder();
		boolean first = true;
		for (Map.Entry<String, String> entry : params.entrySet()) {
			if (first)
				first = false;
			else
				result.append("&");

			result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
			result.append("=");
			result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
		}

		return result.toString();
	}

	public static String getHttpRequestBody(HttpURLConnection connection)
			throws IOException {
		BufferedReader br = null;
		if (connection.getResponseCode() == HttpURLConnection.HTTP_OK
				|| connection.getResponseCode() == 300) {
			br = new BufferedReader(new InputStreamReader(
					(connection.getInputStream())));
		} else {
			if (connection.getErrorStream() != null)
				br = new BufferedReader(new InputStreamReader(
						(connection.getErrorStream())));
		}
		StringBuilder sb = new StringBuilder();
		String output;
		while ((output = br.readLine()) != null) {
			sb.append(output);
		}

		return sb.toString();
	}


}
