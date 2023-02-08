package com.tibco.bw.sharedresource.tas.model.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class TasSsoConfig implements TasSsoClientConstant{
	private static String bwHomeDirectory;
	//private static final String REDIRECTED_URI_PROPERTY = "redirected_uris";
	private static final String REGION_PROPERTY = "region";
	public static final String AUTH_URL_PROPERTY = "auth_url";
	public static final String TCI_HOST_PROPERTY = "tci_hostname";
	private static final String TCI_PORT_PROPERTY = "tci_portnumber";
	private static String auth_url;


	private static String regionPrefix;
	private static String redirected_uri;
	//private static String localHost = "http://127.0.0.1:";
	private static String tci_hostName;
	

	private static ArrayList<String> tci_hosts = new ArrayList<String>();
	private static ArrayList<String> auth_urls = new ArrayList<String>();;
	private static String tci_port;
	private static int webserver_port;
	private static long bearerTokenExpireTime;
	private static long refreshTokenExpireTime;
	
	private static final String CLIENT_ID_PROPERTY = "clientID";
	private static String clientID;

	private static Properties properties = new Properties();
	
	
	public static String getBwHomeDirectory() {
		if(bwHomeDirectory==null) {
			Properties sysProperties = System.getProperties();
			if (sysProperties.containsKey(BW_HOME)) {
				bwHomeDirectory = sysProperties.getProperty(BW_HOME);
			}
		}
		return bwHomeDirectory;
	}
	
	/**
	 * Enum defined to REGION
	 * 
	 * @author Shubham Deshmukh
	 *
	 */
	enum REGION {
		AUSTRALIA("au"), //
		UNITED_STATES(""), //
		EUROPEAN("eu"); //

		final String prefix;

		REGION(String prefix) {
			this.prefix = prefix;
		}
	}

	/**
	 * Method to read SSO config file
	 * 
	 * @return
	 */
	public static void readSSoConfig() {
		String filePath = getSSOConfigFilePath();
		if (Files.exists(Paths.get(filePath))) {
			try (InputStream inputStream = new FileInputStream(filePath)) {
				properties.load(inputStream);
				// Read URL ("auth_url")
				if (properties.containsKey(AUTH_URL_PROPERTY)) {
					addAUTHURL(properties.getProperty(AUTH_URL_PROPERTY));
				}
				// Read Region prefix ("region")
				if (properties.containsKey(REGION_PROPERTY)) {
					String region = properties.getProperty(REGION_PROPERTY);
					regionPrefix = getRegionPrefix(region).prefix;
				}

				// Read redirected_uri ("redirected_uris")
				//webserver_port = Integer.valueOf(getAvailablePort());
				//redirected_uri = localHost + webserver_port + "/auth";

				// Read tci_hostname ("tci_hostname")
				if (properties.containsKey(TCI_HOST_PROPERTY)) {
					addTCIHost(properties.getProperty(TCI_HOST_PROPERTY));
					
				}

				// Read tci_portnumber ("tci_portnumber")
				if (properties.containsKey(TCI_PORT_PROPERTY)) {
					tci_port = properties.getProperty(TCI_PORT_PROPERTY);
				}

				// Read bearer token expires in time ("expires_in")
				if (properties.containsKey(PARAMETER_EXPIRES_IN)) {
					bearerTokenExpireTime = Integer.parseInt(properties.getProperty(PARAMETER_EXPIRES_IN));
				}

				// Read refreshtoken expires in time ("refresh_token_expires_in")
				if (properties.containsKey(PARAMETER_REFRESH_TOKEN_EXPIRES_IN)) {
					bearerTokenExpireTime = Integer.parseInt(properties.getProperty(PARAMETER_REFRESH_TOKEN_EXPIRES_IN));
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void addAUTHURL(String property) {
		String[] authURLs = property.split(";");
		for (String authURL : authURLs) {
			authURL = authURL.trim();
			if(!authURL.startsWith("https")) {
				auth_url = null;
				auth_urls.clear();
				return;
			}
			if(authURL.contains("default")) {
				authURL = authURL.substring(0, authURL.lastIndexOf(":"));
				auth_url = authURL;
			} 
			
			auth_urls.add(authURL);
		}
	}

	private static void addTCIHost(String property) {
		String[] tciHosts = property.split(";");
		for (String tciHost : tciHosts) {
			tciHost = tciHost.trim();
			if(!tciHost.startsWith("https")) {
				tci_hostName = null;
				tci_hosts.clear();
				return;
			}
			if(tciHost.contains("default")) {
				tciHost = tciHost.substring(0, tciHost.lastIndexOf(":"));
				tci_hostName = tciHost;
			} 
			
			tci_hosts.add(tciHost);
		}
	}

	/**
	 * Gives Random PortNumber. Add a redirect URI.
	 */
	/*
	public static String getAvailablePort() {
		ServerSocket socket = null;
		try {
			StringBuilder reddirectURL = new StringBuilder("");
			socket = new ServerSocket(0);
			webserver_port = socket.getLocalPort();
			reddirectURL.append(webserver_port);
			return reddirectURL.toString();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}*/

	/**
	 * Method to get SSO config file path
	 * 
	 * @return file path
	 */
	public static String getSSOConfigFilePath() {
		String bwHomePath = TasSsoConfig.getBwHomeDirectory();
		Path path = Paths.get(bwHomePath + File.separator + DIR_SECURITY);
		String filePath = path + File.separator + SSO_CONFIG_PROPERTIES;
		return filePath;
	}

	/**
	 * Method to get Region prefix
	 * 
	 * @param region region
	 * @return REGION
	 */
	private static REGION getRegionPrefix(String region) {
		return Arrays.stream(REGION.values()).filter(reg -> reg.toString().equals(region)).findFirst().orElseThrow(() -> new IllegalStateException(String.format("Unsupported Type %s", region)));
	}

	public static String getRedirectUris() {
		return redirected_uri;
	}

	/**
	 * @return the auth_url
	 */
	public static String getAuth_url() {
		return auth_url;
	}
	
	public static void setAuth_url(String auth_url) {
		TasSsoConfig.auth_url = auth_url;
	}

	/**
	 * @return the regionPrefix
	 */
	public static String getRegionPrefix() {
		return regionPrefix;
	}

	/**
	 * @return the redirected_uri
	 */
	public static String getRedirected_uri() {
		return redirected_uri;
	}

	/**
	 * @return the tci_hostName
	 */
	public static String getTci_hostName() {
		return tci_hostName;
	}

	public static void setTci_hostName(String tci_hostName) {
		TasSsoConfig.tci_hostName = tci_hostName;
	}
	/**
	 * @return the tci_port
	 */
	public static String getTci_port() {
		return tci_port;
	}

	/**
	 * 
	 * @return the webserver_port
	 */
	public static int getWebserver_port() {
		return webserver_port;
	}

	/**
	 * @return the bearerTokenExpireTime
	 */
	public static long getBearerTokenExpireTime() {
		return bearerTokenExpireTime;
	}

	/**
	 * @return the refreshTokenExpireTime
	 */
	public static long getRefreshTokenExpireTime() {
		return refreshTokenExpireTime;
	}

	public static ArrayList<String> getTci_hosts() {
		return tci_hosts;
	}

	public static void setTci_hosts(ArrayList<String> tci_hosts) {
		TasSsoConfig.tci_hosts = tci_hosts;
	}

	public static ArrayList<String> getAuth_urls() {
		return auth_urls;
	}

	public static void setAuth_urls(ArrayList<String> auth_urls) {
		TasSsoConfig.auth_urls = auth_urls;
	}
	
	/**
	 * Method to read clientDetails.properties
	 * 
	 * @return true if client details present
	 */
	public static boolean readClientConfigFile() {
		boolean isClientConfigPresent = false;
		Properties properties = new Properties();
		String filePath = getClientConfigFilePath();
		if(!Files.exists(Paths.get(filePath))){
			if(auth_url.contains("azure")) {
				filePath=getClientConfigAzureFilePath();
			}else {
				filePath=getClientConfigAmazonFilePath();
			}
		}
		if (Files.exists(Paths.get(filePath))) {
			try (InputStream inputStream = new FileInputStream(filePath)) {
				properties.load(inputStream);
				if (properties.containsKey(CLIENT_ID_PROPERTY)) {
					clientID = properties.getProperty(CLIENT_ID_PROPERTY).trim();
					isClientConfigPresent = true;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return isClientConfigPresent;
	}
	
	/**
	 * Method to get client config file path
	 * 
	 * @return file path
	 */
	public static String getClientConfigFilePath() {
		String bwHomePath = getBwHomeDirectory();
		Path path = Paths.get(bwHomePath + File.separator + DIR_SECURITY);
		String filePath = path + File.separator + CLIENT_DETAILS_PROPERTIES;
		return filePath;
	}
	
	/**
	 * Method to get client config file path
	 * 
	 * @return file path
	 */
	public static String getClientConfigAzureFilePath() {
		String bwHomePath = getBwHomeDirectory();
		Path path = Paths.get(bwHomePath + File.separator + DIR_SECURITY);
		String filePath = path + File.separator + CLIENT_DETAILS_AZURE_PROPERTIES;
		return filePath;
	}
	
	/**
	 * Method to get client config file path
	 * 
	 * @return file path
	 */
	public static String getClientConfigAmazonFilePath() {
		String bwHomePath = getBwHomeDirectory();
		Path path = Paths.get(bwHomePath + File.separator + DIR_SECURITY);
		String filePath = path + File.separator + CLIENT_DETAILS_AMAZON_PROPERTIES;
		return filePath;
	}

	public static String getClientID() {
		return clientID;
	}
	
	
	
	
	

}
