package com.tibco.bw.sharedresource.tas.model.helper;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status.Family;

import org.glassfish.jersey.SslConfigurator;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TasSsoClient implements TasSsoClientConstant{
	
	private final static Logger logger = LoggerFactory.getLogger("com.tibco.thor.frwk.auditsafe");
	private static TasSsoClient instance = null;

	private Client wsClient;
	private final int connectTimeout = 120000;
	private final int readTimeout = 120000;
	
	private String bearerToken;
	private String refreshToken;

	private long bearerTokenMaxExpireTimeSec;
	private long bearerTokenSaveTimeMs;
	private long refreshTokenMaxExpireTimeSec;
	private long refreshTokenSaveTimeMs;
	
	
	/**
	 * Method to get instance
	 * 
	 * @return
	 */
	public static TasSsoClient getInstance(String access_token, String refresh_token) {
		if (instance == null) {
			synchronized (TasSsoClient.class) {
				if (instance == null) {
					try {
						instance = new TasSsoClient(access_token, refresh_token);
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
	private TasSsoClient(String access_token, String refresh_token) throws Exception {
		init(access_token, refresh_token);
	}
	
	/*
	 * Initialize Jersey Client
	 */
	private void init(String access_token, String refresh_token) {
		ClientConfig clientConfig = new ClientConfig();
		clientConfig = clientConfig.property(ClientProperties.CONNECT_TIMEOUT, connectTimeout);
		clientConfig = clientConfig.property(ClientProperties.READ_TIMEOUT, readTimeout);
		clientConfig.register(JacksonFeature.class).register(MultiPartFeature.class);

		SslConfigurator sslConfig = SslConfigurator.newInstance();
		this.wsClient = ClientBuilder.newBuilder().withConfig(clientConfig).sslContext(sslConfig.createSSLContext()).hostnameVerifier(new HostnameVerifier() {
			@Override
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		}).build();

		TasSsoConfig.getBwHomeDirectory();
		//SoftwareStatementInfo.readSoftwareStatement();
		TasSsoConfig.readSSoConfig();
		TasSsoConfig.readClientConfigFile();
		bearerToken = access_token;
		refreshToken = refresh_token;
		refreshTokenSaveTimeMs = System.currentTimeMillis();
		refreshTokenMaxExpireTimeSec = 100;
		fetchBearerTokenFromRefreshToken();
	}
	
	private Set<String> getDuplicates(List<String> list) {
	    return list.stream().filter(i -> Collections.frequency(list, i) > 1).collect(Collectors.toSet());
	}
	
	
	public Client getWSClient() {
		return this.wsClient;
	}

	public void close() {
		if (this.wsClient != null) {
			this.wsClient.close();
			this.wsClient = null;
		}
	}
	
	protected synchronized void preExecute() {
		if (!validateBearerToken()) {
			fetchBearerTokenFromRefreshToken();
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
	
	protected boolean validateRefreshToken() {
		boolean isValid = false;
		long totolTimeMs = System.currentTimeMillis() - this.refreshTokenSaveTimeMs;
		long totalTimeSec = (totolTimeMs / 1000); // ms to seconds
		if (!(totalTimeSec > this.refreshTokenMaxExpireTimeSec)) {
			isValid = true;
		}
		return isValid;
	}
	
	/**
	 * Method to get URL for to get bearer token from refresh token
	 * 
	 * @return
	 */
	private String getBearerTokenFromRefereshTokenURL() {
		return TasSsoConfig.getAuth_url() + IDM_V1_OAUTH2_TOKEN;
	}
	
	/**
	 * Method to get bearer token from refresh token
	 * 
	 * @param refreshToken refresh token
	 * @return bearer token
	 */
	public void fetchBearerTokenFromRefreshToken() {
		boolean validateRefreshToken = validateRefreshToken();

		if (validateRefreshToken) {
			String buildUrlString = getBearerTokenFromRefereshTokenURL();
			WebTarget webTarget = getWSClient().target(buildUrlString);

			MultivaluedMap<String, String> formData = new MultivaluedHashMap<String, String>();
			formData.add(PARAMETER_REFRESH_TOKEN, refreshToken);
			formData.add(PARAMETER_CLIENT_ID, TasSsoConfig.getClientID());
			formData.add(PARAMETER_GRANT_TYPE, PARAMETER_REFRESH_TOKEN);

			// "application/x-www-form-urlencoded"
			logger.debug("fetchBearerTokenFromRefreshToken try url="+buildUrlString+ " PARAMETER_CLIENT_ID="+ TasSsoConfig.getClientID() +" refreshtoken="+refreshToken.substring(refreshToken.length()-4));
			Response response = webTarget.request().post(Entity.entity(formData, MediaType.APPLICATION_FORM_URLENCODED_TYPE));
			if (!isSuccessful(response)) {
				int statusCode = response.getStatus();
				String reason = response.getStatusInfo() != null ? response.getStatusInfo().getReasonPhrase() : null;
				String message = statusCode + ":" + reason;
				logger.warn("fetchBearerTokenFromRefreshToken failed : "+message);
				//IStatus errorStatus = Activator.createErrorStatus(message);
				//Activator.log(errorStatus);
				//Activator.openErrorDialog("Unable to get Bearer token from Refresh token", errorStatus);

			} else {
				String responseString = response.readEntity(String.class);
				logger.debug("fetchBearerTokenFromRefreshToken ",responseString); //$NON-NLS-1$

				//IStatus infoStatus = Activator.createInfoStatus(responseString);
				//Activator.log(infoStatus);

				ObjectMapper mapper = createObjectMapper(false);
				Map<?, ?> responseMap;
				try {
					responseMap = mapper.readValue(responseString, Map.class);
					if (responseMap != null) {
						bearerToken = (String) responseMap.get(PARAMETER_ACCESS_TOKEN);
						bearerTokenMaxExpireTimeSec = (int) responseMap.get(PARAMETER_EXPIRES_IN);
						bearerTokenSaveTimeMs = System.currentTimeMillis();

						refreshToken = (String) responseMap.get(PARAMETER_REFRESH_TOKEN);
						refreshTokenMaxExpireTimeSec = (int) responseMap.get(PARAMETER_REFRESH_TOKEN_EXPIRES_IN);
						refreshTokenSaveTimeMs = System.currentTimeMillis();
					}
				} catch (JsonParseException e) {
					//IStatus errorStatus = Activator.createErrorStatus(e.getMessage());
					//Activator.log(errorStatus);
					e.printStackTrace();
				} catch (JsonMappingException e) {
					//IStatus errorStatus = Activator.createErrorStatus(e.getMessage());
					//Activator.log(errorStatus);
					e.printStackTrace();
				} catch (IOException e) {
					//IStatus errorStatus = Activator.createErrorStatus(e.getMessage());
					//Activator.log(errorStatus);
					e.printStackTrace();
				}
			}

		} else {
			//IStatus errorStatus = Activator.createErrorStatus("Please login again with SSO ");
			//Activator.log(errorStatus);
			//Activator.openErrorDialog("Unable to get Bearer token from Refresh token", errorStatus);
		}
	}
	
	/**
	 * Check whether a Response is successful or not.
	 * 
	 * @param response
	 * @return Return true if the Response is successful. Otherwise, return false.
	 */
	protected boolean isSuccessful(Response response) {
		if (response != null && response.getStatusInfo() != null) {
			if (Family.SUCCESSFUL.equals(response.getStatusInfo().getFamily())) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * 
	 * @param failOnUnknownProperties
	 * @return
	 */
	protected ObjectMapper createObjectMapper(boolean failOnUnknownProperties) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, failOnUnknownProperties);
		return mapper;
	}

}
