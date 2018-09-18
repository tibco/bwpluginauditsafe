/*
 *
 * Copyright2011 - 2013 TIBCO Software Inc.
 * All rights reserved.
 *
 * This software is confidential and proprietary information of TIBCO Software Inc.
 * Overridable true
 */

package com.tibco.bw.sharedresource.tas.model.helper;

import javax.xml.namespace.QName;

import com.tibco.bw.sharedresource.tas.model.tas.TasPackage;

/**
 * @author <a href="mailto:zbin@tibco-support.com">Leslie Zhang</a>
 *
 * @since 1.0.0
 */
public interface TasConstants {
	public static final String IMAGE_PATH = "icons/obj48/tasResource_48x48.png";

  	public static final String TASCONNECTION_SHARED_RESOURCE_NAME = "tasConnection";
	public static final QName TASCONNECTION_QNAME = new QName(TasPackage.eNS_URI, TASCONNECTION_SHARED_RESOURCE_NAME, TasPackage.eNS_PREFIX);

	public static final String TASCONNECTION_FILE_NAME_EXTENSION = "tasconnectionResource";
	public static final String TASCONNECTION_FILE_NAME_DEFAULT = "AuditSafeConnection";
	public static final String TASCONNECTION_PAGE_TITLE = "tasconnection";
	public static final String TASCONNECTION_PAGE_DESCRIPTION = "Creates a new tasconnection shared resource";

	public static final String TASCONNECTION_LABEL = "tasconnection";
	public static final String TASCONNECTION_PAGE_HEADER = "tasconnection Editor";
	public static final String TASCONNECTION_MAIN = "tasconnection.main";

	public static final String TASCONNECTION_CONFIGURATION_LABEL = "tasconnection Configuration";

	//TODO change tenant id to tas
	String TENANT_ID = "tcta";
}
