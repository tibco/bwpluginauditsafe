/*
 *
 * Copyright2011 - 2013 TIBCO Software Inc.
 * All rights reserved.
 *
 * This software is confidential and proprietary information of TIBCO Software Inc.
 * Overridable true
 */
package com.tibco.bw.sharedresource.tas.model.helper;

import java.util.ResourceBundle;

import org.eclipse.osgi.util.NLS;

/**
 * @author Leslie
 *
 */
public class Messages extends NLS {

	private static final String BUNDLE_NAME = "com.tibco.bw.sharedresource.tas.model.helper.messages";

	static {
		// initialize resource bundle
		NLS.initializeMessages(Messages.BUNDLE_NAME, Messages.class);
	}

	public static ResourceBundle getBundle() {
		return ResourceBundle.getBundle(BUNDLE_NAME);
	}


	public static String TASCONNECTION_SERVERURL;
	public static String TASCONNECTION_USERNAME;
	public static String TASCONNECTION_PASSWORD;
	public static String TASCONNECTION_ACCOUNTID;
	public static String TASCONNECTION_IS_ENTERPRISE;
	public static String TASCONNECTION_IS_SSO;
	
	public static String TASCONNECTION_USE_TOKEN;
	public static String TASCONNECTION_ACCESS_TOKEN;
	public static String TASCONNECTION_REFRESH_TOKEN;
	public static String TASCONNECTION_CLIENT_ID;
	public static String TASCONNECTION_CLIENT_SECRET;
	
	public static String SHAREDRESOURCE_PARAMETER_VALUE_INVALID;

	public static String TEST_CONNECTION_LABEL_TEXT;
	public static String TEST_DISCONNECTION_LABEL_TEXT;
	public static String CONNECT_BUTTON_TEXT;
	public static String DISCONNECT_BUTTON_TEXT;

	public static String CONNECTED_TO_TAS;

}