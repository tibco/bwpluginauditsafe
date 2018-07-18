package com.tibco.bw.palette.tcta.design;

import javax.xml.namespace.QName;

import com.tibco.bw.sharedresource.tcta.model.tcta.TctaPackage;

public interface TctaConstants {

	public static final String TCTA_ACTIVITY_INPUT = "ActivityInput";
	public static final String TCTA_ACTIVITY_OUTPUT = "ActivityOutput";

	public static final String START_STAUTS = "status";
	public static final String PROJECT_NAME = "projectName";
	public static final String TOKEN = "token";
	public static final String MESSAGE =  "message";
	public static final String RESPONSE =  "Response";

	String TRANS_SOURCE = "trans_source";
	String TRANS_DESTINATION = "trans_destination";
	String SERVICE_NAME = "service_name";
	String TRANS_TS = "trans_ts";
	String TRANS_DESP = "trans_Desp";
	String USER_TRANS_ID = "user_trans_id";

	public static final QName SHAREDRESOURCE_QNAME = new QName(
			TctaPackage.eNS_URI, "tctaConnection",TctaPackage.eNS_PREFIX);







}
