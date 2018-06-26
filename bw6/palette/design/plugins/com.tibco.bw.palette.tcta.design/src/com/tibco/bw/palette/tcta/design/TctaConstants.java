package com.tibco.bw.palette.tcta.design;

import javax.xml.namespace.QName;

import com.tibco.bw.palette.tcta.model.tcta.TctaPackage;

public interface TctaConstants {

	public static final String TCTA_ACTIVITY_INPUT = "Input";
	public static final String TCTA_ACTIVITY_OUTPUT = "Output";

	public static final String START_STAUTS = "status";
	public static final String PROJECT_NAME = "projectName";
	public static final String TOKEN = "token";
	public static final String BATCH_STAUTS = "batchStatus";
	public static final String BATCH_ID = "batchProcessId";
	public static final String DATASET_ID = "datasetID";
	public static final String PROJECT_ID = "projectID";
	public static final String PERCENT =  "percent";
	public static final String SOURCENAME =  "SourceName";
	public static final String MESSAGE =  "message";
	public static final String FILECONTENT =  "fileContent";
	public static final String FILENEME =  "fileName";
	public static final String FILE =  "File";
	public static final String RESPONSE =  "Response";

	public static final QName SHAREDRESOURCE_QNAME = new QName(
			TctaPackage.eNS_URI, "TctaConnection",TctaPackage.eNS_PREFIX);







}
