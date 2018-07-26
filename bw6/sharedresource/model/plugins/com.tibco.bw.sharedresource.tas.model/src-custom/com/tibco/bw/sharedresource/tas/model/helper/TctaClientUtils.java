package com.tibco.bw.sharedresource.tas.model.helper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

public class TctaClientUtils {

	public static String requestCreateTransaction(String token,
			String tasBaseUrl, String body) {
		String result = null;
		CookieManager cookiemanager = new CookieManager();
		cookiemanager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
		CookieHandler.setDefault(cookiemanager);

		if(tasBaseUrl.endsWith("/")){
			tasBaseUrl = tasBaseUrl.substring(0,tasBaseUrl.length()-1);
		}
		String idmUrl = tasBaseUrl + "/idm/v2/login-oauth";
		HttpURLConnection httpConn;
		try {
			Map<String, String> params = new HashMap<String,String>();
			params.put("AccessToken", token);
			params.put("TenantId", "tcta");
			httpConn = buildpostHttpUrlConnection(idmUrl, params, getsettingMap());
			String messagebody = getHttpRequestBody(httpConn);
			int statusCode = httpConn.getResponseCode();

			if(statusCode == HttpURLConnection.HTTP_OK){
				String transactionUrl = tasBaseUrl + "/tcta/dataserver/transactions";
				httpConn = buildpostHttpUrlConnectionWithJson(transactionUrl, body,
						getsettingMap("application/json","application/json"));
				result = getHttpRequestBody(httpConn);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
//		Client client = ClientBuilder.newBuilder().build();
//
//		WebTarget base = client.target(tasBaseUtl);
//		WebTarget idm = base.path("/idm/v2/login-oauth");
//		Invocation.Builder invocationBuilder = idm.request();
//
//		Form form = new Form();
//		form.param("AccessToken", token);
//		form.param("TenantId", "tas");
//
//		Entity<Form> formEntity = Entity.entity(form,
//				MediaType.APPLICATION_FORM_URLENCODED_TYPE);
//		Response response = invocationBuilder.post(formEntity);
//		if (response.getStatus() == 200) {
//			WebTarget transaction = base.path("/tcta/dataserver/transactions");
//			invocationBuilder = transaction
//					.request(MediaType.APPLICATION_JSON_TYPE);
//			Entity content = Entity.json(body);
//			response = invocationBuilder.post(content);
//			if (response.getStatus() == 200) {
//				result = response.readEntity(String.class);
//			}
//		}
		return result;
	}

	public static String getToken(String username, String password) {
		String token = null;
//		Client client = ClientBuilder.newBuilder().build();
//
//		String taUrl = "https://sso-awsqa.tibco.com/as/token.oauth2";
//		WebTarget taTarget = client.target(taUrl);
//		Invocation.Builder invocationBuilder = taTarget.request();
//
//		Form form = new Form();
//		form.param("username", username);
//		form.param("password", password);
//		form.param("grant_type", "password");
//		form.param("client_id", "ropc_ipass");
//		Entity<Form> formEntity = Entity.entity(form,
//				MediaType.APPLICATION_FORM_URLENCODED_TYPE);
//
//		Response response = invocationBuilder.post(formEntity);
//		int statusCode = response.getStatus();
//		if (statusCode == 200) {
//			JsonReader node = new JsonReader(response.readEntity(String.class));
//			if (node.getNode("access_token") != null) {
//				token = node.getNode("access_token").textValue();
//			}
//		}
		String taUrl = "https://sso-awsqa.tibco.com/as/token.oauth2";
		Map<String, String> params = new HashMap<String,String>();
		params.put("username", username);
		params.put("password", password);
		params.put("grant_type", "password");
		params.put("client_id", "ropc_ipass");

		HttpURLConnection httpConn;
		try {
			httpConn = buildpostHttpUrlConnection(taUrl, params, getsettingMap());
			String messagebody = getHttpRequestBody(httpConn);
			int statusCode = httpConn.getResponseCode();

			if(statusCode == HttpURLConnection.HTTP_OK){
				JsonReader node = new JsonReader(messagebody);
				if(node.getNode("access_token")!=null){
					token = node.getNode("access_token").textValue();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return token;
	}

	public static JsonNode getSchema(String tasBaseUrl, String token, String body, int type){
		CookieManager cookiemanager = new CookieManager();
		cookiemanager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
		CookieHandler.setDefault(cookiemanager);
		if(tasBaseUrl.endsWith("/")){
			tasBaseUrl = tasBaseUrl.substring(0,tasBaseUrl.length()-1);
		}

		String idmUrl = tasBaseUrl + "/idm/v2/login-oauth";
		HttpURLConnection httpConn;
		try {
			Map<String, String> params = new HashMap<String,String>();
			params.put("AccessToken", token);
			params.put("TenantId", "tcta");
			httpConn = buildpostHttpUrlConnection(idmUrl, params, getsettingMap());
			String messagebody = getHttpRequestBody(httpConn);
			int statusCode = httpConn.getResponseCode();

			if(statusCode == HttpURLConnection.HTTP_OK){
				String schemaUrl = tasBaseUrl + "/tcta/dataserver/schema";
				httpConn = buildpostHttpUrlConnectionWithJson(schemaUrl, body,
						getsettingMap("application/json","application/json"));
				messagebody = getHttpRequestBody(httpConn);
				statusCode = httpConn.getResponseCode();

				if(statusCode == HttpURLConnection.HTTP_OK){
					JsonReader node = new JsonReader(messagebody);
					if(type == 1 && node.getNode("requestSchema")!=null){
						return node.getNode("requestSchema");
					}else if(type == 2 && node.getNode("responseSchema")!=null){
						return node.getNode("responseSchema");
					}
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return null;
	}

	public static Map<String, String> getsettingMap() {
		return getsettingMap("application/x-www-form-urlencoded", "application/json");
	}

	public static Map<String, String> getsettingMap(String contentType, String acceptType) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("Content-Type", contentType);
		params.put("Accept", acceptType);
		return params;
	}

	public static HttpURLConnection buildpostHttpUrlConnection(String urlstring,
			Map<String, String> formparams, Map<String, String> settingparams)
			throws IOException {
		HttpURLConnection connection = null;
		URL url = new URL(urlstring);
		connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		addUrlConnectionSetting(connection, settingparams);
		if(formparams != null){
			addUrlConnectionParameter(connection, formparams);
		}
		return connection;
	}

	public static HttpURLConnection buildpostHttpUrlConnectionWithJson(String urlstring,
			String json, Map<String, String> settingparams)
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
			String json)
			throws UnsupportedEncodingException, IOException {
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
		if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
			br = new BufferedReader(new InputStreamReader(
					(connection.getInputStream())));
		} else {
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
