package com.tibco.bw.palette.tcta.design;

import javax.xml.namespace.QName;

import com.tibco.bw.palette.tcta.model.tcta.TctaPackage;

public interface TctaConstants {

	public static final String TCTA_ACTIVITY_INPUT = "Input";
	public static final String TCTA_ACTIVITY_OUTPUT = "Output";

	public static final String START_STAUTS = "status";
	public static final String PROJECT_NAME = "projectName";
	public static final String TOKEN = "token";
	public static final String MESSAGE =  "message";
	public static final String RESPONSE =  "Response";

	public static final QName SHAREDRESOURCE_QNAME = new QName(
			TctaPackage.eNS_URI, "TctaConnection",TctaPackage.eNS_PREFIX);







}
