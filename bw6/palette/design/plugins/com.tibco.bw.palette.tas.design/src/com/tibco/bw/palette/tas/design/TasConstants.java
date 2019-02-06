package com.tibco.bw.palette.tas.design;

import javax.xml.namespace.QName;

import com.tibco.bw.sharedresource.tas.model.tas.TasPackage;


public interface TasConstants {

	public static final String TAS_ACTIVITY_INPUT = "ActivityInput";
	public static final String TAS_ACTIVITY_OUTPUT = "ActivityOutput";

	String TAG_NAME = "Event";

	String TAG_CRITERIA = "criteria";
	String CRITERIA_BUSINESS_PROCESS = "biz_proc";
	String CRITERIA_TRANS_ID = "transaction_id";
	String CRITERIA_EVENT_SOURCE = "event_source";
	String CRITERIA_EVENT_DEST = "event_destination";
	String CRITERIA_EVENT_STATUS = "event_status";
	String CRITERIA_AUDIT_EVENT = "audit_event";
	String CRITERIA_BEGIN = "begin_timestamp";
	String CRITERIA_END = "end_timestamp";

	String TAG_DATA = "data";
	String TAS_EVENT_ID = "tas_event_id";
	String BLOCKCHAIN_TRANS_ID = "bc_trans_id";
	String EVENT_TIMESTAMP = "event_timestamp";

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
			TasPackage.eNS_URI, "tasConnection",TasPackage.eNS_PREFIX);







}
