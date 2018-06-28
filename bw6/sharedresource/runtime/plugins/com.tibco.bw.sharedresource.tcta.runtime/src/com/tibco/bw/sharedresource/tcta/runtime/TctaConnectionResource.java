/*
 *
 * Copyright2011 - 2013 TIBCO Software Inc.
 * All rights reserved.
 *
 * This software is confidential and proprietary information of TIBCO Software Inc.
 * Overridable true
 */
package com.tibco.bw.sharedresource.tcta.runtime;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class TctaConnectionResource {
	private String serverUrl;
	private String username;
	private String password;
	public String getServerUrl() {
		return serverUrl;
	}
	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	public String getToken(){
		Map<String, String> params = new HashMap<String,String>();
		params.put("username", username);
		params.put("password", password);
		params.put("grant_type", "password");
		params.put("client_id", "ropc_ipass");

		HttpURLConnection httpConn;
		String token = "";
		try {
			httpConn = buildpostHttpUrlConnection("https://sso-awsqa.tibco.com/as/token.oauth2", params, getsettingMap());
			String messagebody = getHttpRequestBody(httpConn);
			int statusCode = httpConn.getResponseCode();
			if(statusCode == 200){
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

	private Map<String, String> getsettingMap() {
		Map<String, String> params = new HashMap<String,String>();
		params.put("Content-Type", "application/x-www-form-urlencoded");
		params.put("Accept", "application/json");
		return params;
	}


	private HttpURLConnection buildpostHttpUrlConnection(String urlstring, Map<String, String> formparams,
			Map<String, String> settingparams) throws IOException {
		HttpURLConnection connection = null;
		URL url = new URL(urlstring);
		connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		addUrlConnectionSetting(connection, settingparams);
		addUrlConnectionParameter(connection, formparams);
		return connection;
	}

	private void addUrlConnectionSetting(HttpURLConnection connection, Map<String, String> settingparams) {
		for (String key : settingparams.keySet()) {
			connection.setRequestProperty(key, settingparams.get(key));
		}

	}

	private void addUrlConnectionParameter(HttpURLConnection connection, Map<String, String> formparams)
			throws IOException {
		connection.setDoOutput(true);
		OutputStream os = connection.getOutputStream();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
		writer.write(getPostDataString(formparams));
		writer.flush();
		writer.close();
		os.close();
	}

	private String getPostDataString(Map<String, String> params) throws UnsupportedEncodingException {
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

	private String getHttpRequestBody(HttpURLConnection connection) throws IOException {
		BufferedReader br = null;
		if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
			br = new BufferedReader(new InputStreamReader((connection.getInputStream())));
		} else {
			br = new BufferedReader(new InputStreamReader((connection.getErrorStream())));
		}
		StringBuilder sb = new StringBuilder();
		String output;
		while ((output = br.readLine()) != null) {
			sb.append(output);
		}

		return sb.toString();
	}

}
