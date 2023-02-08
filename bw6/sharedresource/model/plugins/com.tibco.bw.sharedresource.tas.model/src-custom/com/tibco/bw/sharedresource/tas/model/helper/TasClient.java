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
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class TasClient {
	public static final String ENV_INTERNAL_URL = "TIBCO_INTERNAL_INTERCOM_URL";
	public static final String ENV_SUBSCRIPTION_ID = "TIBCO_INTERNAL_TCI_SUBSCRIPTION_ID";
	public static final String PROD_TIBCO_CLOUD = "auditsafe.cloud.tibco.com";
	
	public static final String METHOD_GET_EVENT = "get";
	public static final String METHOD_POST_EVENT = "post";
	
	public static final String TAS_TENANT_ID = "tcta";

	protected static UserAwareCookieManager cookieManager;
	
	private static Map<String, String> tokenMap = new HashMap<String,String>();
	
	private static TasSsoClient ssoClient=null;
	
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
	
	protected static void preExecute(String access_token, String refresh_token) {
		if(ssoClient==null) {
			ssoClient=TasSsoClient.getInstance(access_token, refresh_token);
		}
		ssoClient.preExecute();
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
			boolean isIntercom = internalUrl != null && !internalUrl.isEmpty();
			String subId = System.getProperty(ENV_SUBSCRIPTION_ID);
			
			Map<String, String> params = getsettingMap("application/json", "application/json");
			
			if (isIntercom) {
				getEventUrl = internalUrl
						+ "/tas/dataserver/intercom/transactions/query?tscSubscriptionId="
						+ subId;
				
				params.put("X-Atmosphere-Tenant-Id", TAS_TENANT_ID);
				params.put("X-Atmosphere-Subscription-Id", subId);
			} else {
				getEventUrl = tasBaseUrl
						+ "/tas/dataserver/transactions/query";

			}
			httpConn = buildpostHttpUrlConnectionWithJson(getEventUrl, body, params);
			
			String message = getHttpRequestBody(httpConn);
			int statusCode = httpConn.getResponseCode();
			result.setStatusCode(statusCode);

			if(statusCode == HttpURLConnection.HTTP_OK){
				result.setSuccessfulResponse(message);
			} else if (retry) {
				if(isIntercom){
					result = getAuditEvent(tasBaseUrl, username, password,
							accountId, body, false);
				}else{
					TasResponse authResponse = auth(tasBaseUrl, username, password, accountId);
					if (!authResponse.isHasError()) {
						result = getAuditEvent(tasBaseUrl, username, password,
								accountId, body, false);
					} else {
						return authResponse;
					}
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
	
	public static TasResponse getAuditEventSso(String tasBaseUrl, String access_token, String refresh_token,
			String body, boolean retry) {
		preExecute(access_token, refresh_token);
		TasResponse result = new TasResponse();
		if (tasBaseUrl.endsWith("/")) {
			tasBaseUrl = tasBaseUrl.substring(0, tasBaseUrl.length() - 1);
		}
		try {
			String internalUrl = System.getProperty(ENV_INTERNAL_URL);
			HttpURLConnection httpConn;
			String getEventUrl = "";
			boolean isIntercom = internalUrl != null && !internalUrl.isEmpty();
			String subId = System.getProperty(ENV_SUBSCRIPTION_ID);
			
			Map<String, String> params = getsettingMap("application/json", "application/json");
			
			if (isIntercom) {
				getEventUrl = internalUrl
						+ "/tas/dataserver/intercom/transactions/query?tscSubscriptionId="
						+ subId;
				
				params.put("X-Atmosphere-Tenant-Id", TAS_TENANT_ID);
				params.put("X-Atmosphere-Subscription-Id", subId);
			} else {
				getEventUrl = tasBaseUrl
						+ "/tas/dataserver/events/get";
				params.put("Authorization", "Bearer " + ssoClient.getBearerToken());

			}
			httpConn = buildpostHttpUrlConnectionWithJson(getEventUrl, body, params);
			
			String message = getHttpRequestBody(httpConn);
			int statusCode = httpConn.getResponseCode();
			result.setStatusCode(statusCode);

			if(statusCode == HttpURLConnection.HTTP_OK){
				result.setSuccessfulResponse(message);
			} else if (retry) {
				result = getAuditEventSso(tasBaseUrl, access_token, refresh_token, body, false);
			} else {
				result.setErrorMessage(message);
			}

		} catch (IOException e) {
			result.setErrorMessage(e.getMessage());

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
			boolean isIntercom = internalUrl != null && !internalUrl.isEmpty();
			String subId = System.getProperty(ENV_SUBSCRIPTION_ID);
			
			Map<String, String> params = getsettingMap("application/json", "application/json");
			if (isIntercom) {
				
				postEventUrl = internalUrl
						+ "/tas/dataserver/intercom/transactions?tscSubscriptionId="
						+ subId;
				
				params.put("X-Atmosphere-Tenant-Id", TAS_TENANT_ID);
				params.put("X-Atmosphere-Subscription-Id", subId);
			} else {
				postEventUrl = tasBaseUrl
						+ "/tas/dataserver/transactions";

			}
			httpConn = buildpostHttpUrlConnectionWithJson(postEventUrl, body, params);
			
			String message = getHttpRequestBody(httpConn);
			int statusCode = httpConn.getResponseCode();
			result.setStatusCode(statusCode);

			if(statusCode == HttpURLConnection.HTTP_OK){
				result.setSuccessfulResponse(message);
			} else if (retry) {
				if(isIntercom){
					result = postAuditEvent(tasBaseUrl, username, password,
							accountId, body, false);
				} else {
					TasResponse authResponse = auth(tasBaseUrl, username, password, accountId);
					if (!authResponse.isHasError()) {
						result = postAuditEvent(tasBaseUrl, username, password,
								accountId, body, false);
					} else {
						return authResponse;
					}
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
	
	public static TasResponse postAuditEventbySso(String tasBaseUrl, String access_token, String refresh_token,
			String body, boolean retry) {
		preExecute(access_token, refresh_token);
		TasResponse result = new TasResponse();
		if (tasBaseUrl.endsWith("/")) {
			tasBaseUrl = tasBaseUrl.substring(0, tasBaseUrl.length() - 1);
		}
		try {
			String internalUrl = System.getProperty(ENV_INTERNAL_URL);
			HttpURLConnection httpConn;
			String postEventUrl = "";
			boolean isIntercom = internalUrl != null && !internalUrl.isEmpty();
			String subId = System.getProperty(ENV_SUBSCRIPTION_ID);
			
			Map<String, String> params = getsettingMap("application/json", "application/json");
			if (isIntercom) {
				
				postEventUrl = internalUrl
						+ "/tas/dataserver/intercom/transactions?tscSubscriptionId="
						+ subId;
				
				params.put("X-Atmosphere-Tenant-Id", TAS_TENANT_ID);
				params.put("X-Atmosphere-Subscription-Id", subId);
			} else {
				postEventUrl = tasBaseUrl
						+ "/tas/dataserver/events/post";
				params.put("Authorization", "Bearer " + ssoClient.getBearerToken());
			}
			httpConn = buildpostHttpUrlConnectionWithJson(postEventUrl, body, params);
			
			String message = getHttpRequestBody(httpConn);
			int statusCode = httpConn.getResponseCode();
			result.setStatusCode(statusCode);

			if(statusCode == HttpURLConnection.HTTP_OK){
				result.setSuccessfulResponse(message);
			} else if (retry) {
				result = postAuditEventbySso(tasBaseUrl, access_token, refresh_token, body, false);
			} else {
				result.setErrorMessage(params.toString());
			}

		} catch (IOException e) {
			result.setErrorMessage(e.getMessage());

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
				String ownerEmail = ((ArrayNode)jsonNode.get("ownersInfo")).get(0).get("email")
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
	
	public static TasResponse getSchemaWithAuthToken(String tasBaseUrl, String token, String body, int type) {
		TasResponse result = new TasResponse();
		if (tasBaseUrl.endsWith("/")) {
			tasBaseUrl = tasBaseUrl.substring(0, tasBaseUrl.length() - 1);
		}
		try {

			String schemaUrl = tasBaseUrl + "/tas/dataserver/schema";
			
			Map<String, String> headerMap = getsettingMap("application/json", "application/json");
			headerMap.put("Authorization", "Bearer " + token);
			
			HttpURLConnection httpConn = buildpostHttpUrlConnectionWithJson(schemaUrl, body, headerMap);
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
			
		} catch (Exception e) {
			result.setErrorMessage("Get schema failed! " + e.getMessage());
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
		//support case 01783858
		System.setProperty("http.keepAlive","false");
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
		//support case 01783858
		System.setProperty("http.keepAlive","false");
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

	public static TasResponse getJWTToken(String tasBaseUrl, String username, String password) {
		TasResponse response = new TasResponse();
		
		String body = "{\"username\": \""+ username 
				+"\", \"password\": \""+ Base64.getEncoder().encodeToString(password.getBytes())+"\"}";

		
		if (tasBaseUrl.endsWith("/")) {
			tasBaseUrl = tasBaseUrl.substring(0, tasBaseUrl.length() - 1);
		}
		String url = tasBaseUrl + "/tas/dataserver/user/auth";
		
		HttpURLConnection httpConn;
		try {
			httpConn = buildpostHttpUrlConnectionWithJson(url, body,
					getsettingMap("application/json", "application/json"));
			String messagebody = getHttpRequestBody(httpConn);
			int statusCode = httpConn.getResponseCode();

			response.setStatusCode(statusCode);
			if (statusCode == HttpURLConnection.HTTP_OK) {
				JsonReader node = new JsonReader(messagebody);
				if (node.getNode("token") != null) {
					response.setSuccessfulResponse(node.getNode("token").textValue());
				}
			} else {
				response.setErrorMessage(messagebody);
			}
		} catch (IOException e) {
			response.setErrorMessage(e.getMessage());
		}

		return response;
	}
	
	public static TasResponse getSchemaEE(String tasBaseUrl, String token, String body, int type) {

		TasResponse result = new TasResponse();
		if (tasBaseUrl.endsWith("/")) {
			tasBaseUrl = tasBaseUrl.substring(0, tasBaseUrl.length() - 1);
		}
		try {

			String schemaUrl = tasBaseUrl + "/tas/dataserver/schema";
			
			Map<String, String> params = getsettingMap("application/json", "application/json");
			params.put("x-atmosphere-token", token);
			HttpURLConnection httpConn = buildpostHttpUrlConnectionWithJson(schemaUrl, body, params);
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
			
		} catch (Exception e) {
			result.setErrorMessage("Get schema failed! " + e.getMessage());
		}

		return result;
	}
	
	public static TasResponse tasEEAction(String method, String tasBaseUrl, String username,
			String password, String body) {
		TasResponse result = new TasResponse();
		String token  = tokenMap.get(username);
		boolean refreshToken = true;
		if(token == null) {
			TasResponse tokenResponse = getJWTToken(tasBaseUrl, username, password);
			if(tokenResponse.isHasError()){
				result.setErrorMessage(tokenResponse.getMessage());
				return result;
			}else {
				token  = tokenResponse.getMessage();
				refreshToken = false;
			}
		}
		
		if (tasBaseUrl.endsWith("/")) {
			tasBaseUrl = tasBaseUrl.substring(0, tasBaseUrl.length() - 1);
		}
		try {
			HttpURLConnection httpConn;
			String actionUrl = "";
			if(METHOD_GET_EVENT.equals(method)){
				actionUrl = tasBaseUrl + "/tas/dataserver/events/get";
			} else if(METHOD_POST_EVENT.equals(method)){
				actionUrl = tasBaseUrl + "/tas/dataserver/events/post";
			}
					
			Map<String, String> params = getsettingMap("application/json", "application/json");
			params.put("x-atmosphere-token", token);
			httpConn = buildpostHttpUrlConnectionWithJson(actionUrl, body, params);
			String message = getHttpRequestBody(httpConn);
			int statusCode = httpConn.getResponseCode();
			result.setStatusCode(statusCode);

			if(statusCode == HttpURLConnection.HTTP_OK){
				result.setSuccessfulResponse(message);
			} 
			else if(refreshToken){
				TasResponse tokenResponse = getJWTToken(tasBaseUrl, username, password);
				
				if(tokenResponse.isHasError()){
					result.setErrorMessage(tokenResponse.getMessage());
				}else {
					token = tokenResponse.getMessage();
					tokenMap.put(username,token);
					params.put("x-atmosphere-token", token);
					httpConn = buildpostHttpUrlConnectionWithJson(actionUrl, body,
							getsettingMap("application/json", "application/json"));
					message = getHttpRequestBody(httpConn);
					statusCode = httpConn.getResponseCode();
					result.setStatusCode(statusCode);
					if(statusCode == HttpURLConnection.HTTP_OK){
						result.setSuccessfulResponse(message);
					} else {
						result.setErrorMessage(message);
					}
				}
			}else {
				result.setErrorMessage(message);
			}

		} catch (IOException e) {
			result.setErrorMessage(e.getMessage());
		}

		return result;
	}
	
	public static TasResponse tasEEActionWithToken(String method, String tasBaseUrl, String token, String body) {
		TasResponse result = new TasResponse();
		
		if (tasBaseUrl.endsWith("/")) {
			tasBaseUrl = tasBaseUrl.substring(0, tasBaseUrl.length() - 1);
		}
		try {
			HttpURLConnection httpConn;
			String actionUrl = "";
			if(METHOD_GET_EVENT.equals(method)){
				actionUrl = tasBaseUrl + "/tas/dataserver/events/get";
			} else if(METHOD_POST_EVENT.equals(method)){
				actionUrl = tasBaseUrl + "/tas/dataserver/events/post";
			}
					
			Map<String, String> params = getsettingMap("application/json", "application/json");
			params.put("x-atmosphere-token", token);
			httpConn = buildpostHttpUrlConnectionWithJson(actionUrl, body, params);
			String message = getHttpRequestBody(httpConn);
			int statusCode = httpConn.getResponseCode();
			result.setStatusCode(statusCode);

			if(statusCode == HttpURLConnection.HTTP_OK){
				result.setSuccessfulResponse(message);
			}else {
				result.setErrorMessage(message);
			}

		} catch (IOException e) {
			result.setErrorMessage(e.getMessage());
		}

		return result;
	}
	
	public static HttpURLConnection buildGetHttpConnection(
			String urlstring, Map<String, String> settingparams) throws IOException {
		
		HttpURLConnection connection = null;
		URL url = new URL(urlstring);
		connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		addUrlConnectionSetting(connection, settingparams);
		return connection;
	}

	public static TasResponse tasActionWithToken(String method, String tasBaseUrl, String clientId, String clientSecret, String body, boolean retry) {
		TasResponse result = new TasResponse();
		if (tasBaseUrl.endsWith("/")) {
			tasBaseUrl = tasBaseUrl.substring(0, tasBaseUrl.length() - 1);
		}
		try {
			String accessToken = tokenMap.get(clientId);
			if(accessToken == null || accessToken.isEmpty()){
				OAuthToken token = getOAuthToken(tasBaseUrl, clientId, clientSecret);
				if(!token.isSuccess()){
					result.setErrorMessage("Get Access Token failed!" + token.getMessage());
					return result;
				}
				return tasActionWithToken(method, tasBaseUrl, clientId, clientSecret, body, false);
			}
			
			String internalUrl = System.getProperty(ENV_INTERNAL_URL);
			HttpURLConnection httpConn;
			String postUrl = "";
			boolean isIntercom = internalUrl != null && !internalUrl.isEmpty();
			String subId = System.getProperty(ENV_SUBSCRIPTION_ID);
			
			Map<String, String> params = getsettingMap("application/json", "application/json");
			
			if (isIntercom) {
				String actionUrl = TasClient.METHOD_GET_EVENT.equals(method)? "/tas/dataserver/intercom/transactions/query?tscSubscriptionId=" 
						: "/tas/dataserver/intercom/transactions?tscSubscriptionId=";
				postUrl = internalUrl + actionUrl + subId;
				
				params.put("X-Atmosphere-Tenant-Id", TAS_TENANT_ID);
				params.put("X-Atmosphere-Subscription-Id", subId);
			} else {
				String actionUrl = TasClient.METHOD_GET_EVENT.equals(method)?"/tas/dataserver/transactions/query" 
						: "/tas/dataserver/transactions";
				postUrl = tasBaseUrl + actionUrl;
				params.put("Authorization", "Bearer " + accessToken);

			}
			httpConn = buildpostHttpUrlConnectionWithJson(postUrl, body, params);
			
			String message = getHttpRequestBody(httpConn);
			int statusCode = httpConn.getResponseCode();
			result.setStatusCode(statusCode);

			if(statusCode == HttpURLConnection.HTTP_OK){
				result.setSuccessfulResponse(message);
			} else if(retry){
				OAuthToken pair = getOAuthToken(tasBaseUrl, clientId, clientSecret);
				if(pair.isSuccess()){
					result = tasActionWithToken(method, tasBaseUrl, clientId, clientSecret, body, false);
				} else {
					result.setErrorMessage("Refresh Token failed! "+ pair.getMessage());
				}
			} else {
				result.setErrorMessage(message);
			}

		} catch (IOException e) {
			result.setErrorMessage(e.getMessage());
		}
		return result;
	}
	
	public static OAuthToken getOAuthToken(String tasBaseUrl, String clientId, String clientSecret){
		OAuthToken token = new OAuthToken();
		
		if (tasBaseUrl.endsWith("/")) {
			tasBaseUrl = tasBaseUrl.substring(0, tasBaseUrl.length() - 1);
		}
		//TODO remove the follwoing line after url problem fixed by TSC team
		tasBaseUrl = tasBaseUrl.replace("auditsafe", "account");
		
		String idmUrl = tasBaseUrl + "/idm/v1/oauth2/token";
		
		Map<String, String> settingMap = getsettingMap();
		String clientInfo = clientId + ":" + clientSecret;
		settingMap.put("Authorization", "Basic " + Base64.getEncoder().encodeToString(clientInfo.getBytes()));
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("scope", "TCTA");
		params.put("grant_type", "client_credentials");

		try {
			HttpURLConnection httpConn = buildpostHttpUrlConnection(idmUrl, params, settingMap);
			String messagebody = getHttpRequestBody(httpConn);
			int statusCode = httpConn.getResponseCode();

			if (statusCode == HttpURLConnection.HTTP_OK) {
				token.setSuccess(true);
				JsonReader node = new JsonReader(messagebody);
				token.setAccessToken(node.getNode("access_token").textValue());
				tokenMap.put(clientId, token.getAccessToken());
			} else {
				token.setSuccess(false);
				token.setMessage(messagebody);
			}
		} catch (IOException e) {
			token.setSuccess(false);
			token.setMessage(e.getMessage());
		}
		
		return token;
	}
	
	public static TasResponse checkAuditUser(String tasBaseUrl, String access_token){
		TasResponse result = new TasResponse();
		
		if (tasBaseUrl.endsWith("/")) {
			tasBaseUrl = tasBaseUrl.substring(0, tasBaseUrl.length() - 1);
		}
		
		String userUrl = tasBaseUrl + "/tas/webserver/users";
		
		Map<String, String> settingMap = getsettingMap();

		settingMap.put("Authorization", "Bearer " + access_token);

		try {
			HttpURLConnection httpConn = buildGetHttpConnection(userUrl,settingMap);
			String messagebody = getHttpRequestBody(httpConn);
			int statusCode = httpConn.getResponseCode();

			if (statusCode == HttpURLConnection.HTTP_OK) {
				result.setStatusCode(statusCode);
				result.setSuccessfulResponse(messagebody);

			} else {
				result.setErrorMessage(messagebody);
			}
		} catch (IOException e) {
			result.setErrorMessage(e.getMessage());
		}
		return result;
	}
	
}

