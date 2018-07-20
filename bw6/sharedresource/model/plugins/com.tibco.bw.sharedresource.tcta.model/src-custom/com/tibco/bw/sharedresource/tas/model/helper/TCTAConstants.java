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

import com.tibco.bw.sharedresource.tas.model.tas.TctaPackage;

/**
 * @author <a href="mailto:zbin@tibco-support.com">Leslie Zhang</a>
 *
 * @since 1.0.0
 */
public class TCTAConstants {
	public static final String IMAGE_PATH = "icons/obj48/tas_48x48.png";
	
  	public static final String TCTACONNECTION_SHARED_RESOURCE_NAME = "tasConnection";
	public static final QName TCTACONNECTION_QNAME = new QName(TctaPackage.eNS_URI, TCTACONNECTION_SHARED_RESOURCE_NAME, TctaPackage.eNS_PREFIX);
	
	public static final String TCTACONNECTION_FILE_NAME_EXTENSION = "tasconnectionResource";
	public static final String TCTACONNECTION_FILE_NAME_DEFAULT = "tasconnectionResource";
	public static final String TCTACONNECTION_PAGE_TITLE = "tasconnection";
	public static final String TCTACONNECTION_PAGE_DESCRIPTION = "Creates a new tasconnection shared resource";

	public static final String TCTACONNECTION_LABEL = "tasconnection";
	public static final String TCTACONNECTION_PAGE_HEADER = "tasconnection Editor";
	public static final String TCTACONNECTION_MAIN = "tasconnection.main";
	
	public static final String TCTACONNECTION_CONFIGURATION_LABEL = "tasconnection Configuration";
}
