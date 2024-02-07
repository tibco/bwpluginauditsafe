package com.tibco.bw.palette.tas.model.tas;

import javax.xml.namespace.QName;


public interface TasConstants {

	public static final String TAS_ACTIVITY_INPUT = "ActivityInput";
	public static final String TAS_ACTIVITY_OUTPUT = "ActivityOutput";

	String TAG_NAME = "Event";
	String TAG_DATA = "data";
	String TAG_TOAL_NUMBER = "totalResults";
	String TAG_ERROR_MESSAGE = "errorMessage";

	String TAG_CRITERIA = "criteria";
	String TAG_EXTRA_PROP = "extra_props";
//	String TAG_EXTRA_PROP_ITEM = "extra_prop";
	String TAG_EXTRA_PROP_NAME = "prop_name";
	String TAG_EXTRA_PROP_VALUE = "prop_value";
	
	String CRITERIA_BUSINESS_PROCESS = "biz_proc";
	String CRITERIA_TRANS_ID = "transaction_id";

	String CRITERIA_EVENT_SOURCE = "event_source";
	String CRITERIA_EVENT_DEST = "event_destination";
	String CRITERIA_EVENT_STATUS = "event_status";
	String CRITERIA_AUDIT_EVENT = "audit_event";
	String CRITERIA_BEGIN = "event_start_timestamp";
	String CRITERIA_END = "event_stop_timestamp";


	String TAS_EVENT_ID = "tas_event_id";
	String EVENT_TIMESTAMP = "event_timestamp";
	String EVENT_DESCRIPTION = "event_desc";
	String EVENT_CREATE_TIMESTAMP = "create_timestamp";

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
			"http://ns.tibco.com/bw/sharedresource/tas", "tasConnection",TasPackage.eNS_PREFIX);


}
