/*
 *
 * Copyright2011 - 2013 TIBCO Software Inc.
 * All rights reserved.
 *
 * This software is confidential and proprietary information of TIBCO Software Inc.
 * Overridable true
 */
package com.tibco.bw.sharedresource.tas.runtime;


public class TasConnectionResource {
	private String serverUrl;
	private String username;
	private String password;
	private String id;
	private String schema;
	private String output;
	private boolean enterprise;
	
	private boolean useToken;
	private String accessToken;
	private String refreshToken;
	private String clientId;
	private String clientSecret;

	public boolean isEnterprise() {
		return enterprise;
	}
	public void setEnterprise(boolean enterprise) {
		this.enterprise = enterprise;
	}
	public String getSchema() {
		return schema;
	}
	public void setSchema(String schema) {
		this.schema = schema;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientSecret() {
		return clientSecret;
	}
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	
	public boolean isUseToken() {
		return useToken;
	}
	public void setUseToken(boolean useToken) {
		this.useToken = useToken;
	}

}
