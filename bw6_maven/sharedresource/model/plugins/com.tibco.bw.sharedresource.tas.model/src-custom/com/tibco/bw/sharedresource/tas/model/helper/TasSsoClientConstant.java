package com.tibco.bw.sharedresource.tas.model.helper;

public interface TasSsoClientConstant {
	//BW env
	static final String PLATFORM_PLUGIN_COM_TIBCO_BW_THOR_LAUNCH_PRODUCT_PROPERTIES = "platform:/plugin/com.tibco.bw.thor.launch/product.properties";
	static final String TIBCO_HOME = "TIBCO_HOME";
	static final String BW_HOME = "BW_HOME";

	static final String CLIENT_DETAILS_PROPERTIES = "clientDetails.properties";
	static final String CLIENT_DETAILS_AZURE_PROPERTIES = "clientDetails_Azure.properties";
	static final String CLIENT_DETAILS_AMAZON_PROPERTIES = "clientDetails_Amazon.properties";
	static final String SOFTWARE_STATEMENT_PROPERTIES = "software_statement.properties";
	static final String SSO_CONFIG_PROPERTIES = "ssoConfig.properties";
	static final String DIR_SECURITY = "security";
	
	// sso client
	public static final String PARAMETER_REFRESH_TOKEN_EXPIRES_IN = "refresh_token_expires_in";
	public static final String PARAMETER_EXPIRES_IN = "expires_in";
	static final String PARAMETER_ACCESS_TOKEN = "access_token";
	static final String PARAMETER_GRANT_TYPE = "grant_type";
	static final String PARAMETER_CLIENT_ID = "client_id";
	static final String PARAMETER_REFRESH_TOKEN = "refresh_token";
	static final String IDM_V1_OAUTH2_TOKEN = "/idm/v1/oauth2/token";
	
	//sso config
	public static final String REDIRECTED_URI_PROPERTY = "redirected_uris";
	public static final String REGION_PROPERTY = "region";
	public static final String AUTH_URL_PROPERTY = "auth_url";
	public static final String TCI_HOST_PROPERTY = "tci_hostname";
	public static final String TCI_PORT_PROPERTY = "tci_portnumber";

}
