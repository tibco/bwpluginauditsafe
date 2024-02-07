package com.tibco.bw.sharedresource.tas.model.helper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class TasOAuthClient {
	
	private static TasOAuthClient instance = null;
	private final String tasBaseUrl;
	private final String clientId;
	private final String clientSecret;
	private String bearerToken;
	private long bearerTokenMaxExpireTimeSec;
	private long bearerTokenSaveTimeMs;
	
	
	/**
	 * Method to get instance
	 * 
	 * @return
	 */
	public static TasOAuthClient getInstance(String tasBaseUrl, String clientId, String clientSecret) {
		if (instance == null) {
			synchronized (TasOAuthClient.class) {
				if (instance == null) {
					try {
						instance = new TasOAuthClient(tasBaseUrl, clientId, clientSecret);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return instance;
	}

	/**
	 * Constructor
	 * 
	 * @throws Exception
	 */
	private TasOAuthClient(String tasBaseUrl, String clientId, String clientSecret) throws Exception {
		if (tasBaseUrl.endsWith("/")) {
			tasBaseUrl = tasBaseUrl.substring(0, tasBaseUrl.length() - 1);
		}
		//TODO remove the follwoing line after url problem fixed by TSC team
		this.tasBaseUrl = tasBaseUrl.replace("auditsafe", "account");
		this.clientId=clientId;
		this.clientSecret = clientSecret;
		fetchBearerToken();
	}
	
	protected synchronized void preExecute() {
		if (!validateBearerToken()) {
			fetchBearerToken();
		}
	}
	
	public String getBearerToken() {
		return this.bearerToken;
	}
	
	protected boolean validateBearerToken() {
		boolean isValid = false;
		long totolTimeMs = System.currentTimeMillis() - this.bearerTokenSaveTimeMs;
		long totalTimeSec = (totolTimeMs / 1000); // ms to seconds
		if (!(totalTimeSec > this.bearerTokenMaxExpireTimeSec)) {
			isValid = true;
		}
		return isValid;
	}
	
	public void fetchBearerToken() {
		String idmUrl = tasBaseUrl + "/idm/v1/oauth2/token";
		Map<String, String> settingMap = TasClient.getsettingMap();
		String clientInfo = clientId + ":" + clientSecret;
		settingMap.put("Authorization", "Basic " + Base64.getEncoder().encodeToString(clientInfo.getBytes()));
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("scope", "TCTA");
		params.put("grant_type", "client_credentials");

		try {
			HttpURLConnection httpConn = TasClient.buildpostHttpUrlConnection(idmUrl, params, settingMap);
			String messagebody = TasClient.getHttpRequestBody(httpConn);
			int statusCode = httpConn.getResponseCode();

			if (statusCode == HttpURLConnection.HTTP_OK) {
				JsonReader node = new JsonReader(messagebody);
				bearerToken = node.getNode("access_token").textValue();
				bearerTokenSaveTimeMs = System.currentTimeMillis();
				bearerTokenMaxExpireTimeSec = node.getNode("expires_in").longValue();

			} else {
				//token.setSuccess(false);
				//token.setMessage(messagebody);
			}
		} catch (IOException e) {
			//token.setSuccess(false);
			//token.setMessage(e.getMessage());
		}
		
	}
	
	
	
	

}
