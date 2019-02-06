package com.tibco.bw.palette.tas.design.queryauditevent;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xsd.XSDCompositor;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDForm;
import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDSchema;

import com.tibco.bw.design.api.BWActivitySignatureUnknown;
import com.tibco.bw.design.util.XSDUtility;
import com.tibco.bw.model.activityconfig.Configuration;
import com.tibco.bw.palette.tas.design.SignatureHelper;
import com.tibco.bw.palette.tas.design.TasBasicSignature;
import com.tibco.bw.palette.tas.design.TasConstants;
import com.tibco.bw.palette.tas.model.tas.QueryAuditEvent;
import com.tibco.bw.sharedresource.tas.model.tas.TasConnection;

public class QueryAuditEventSignature extends TasBasicSignature {
	private static final String SCHEMA_INPUT_ROOT_NAME = "queryAuditEventInput";

	private static final String SCHEMA_OUTPUT_ROOT_NAME = "queryAuditEventOutput";

	@Override
	public boolean hasInput() {
		return true;
	}

	@Override
	public boolean hasOutput() {
		return true;
	}

	@Override
	public String getInputTargetNamespace() {
		return TasBasicSignature.BASIC_NS + SCHEMA_INPUT_ROOT_NAME;
	}

	@Override
	public String getoutputTargetNamespace() {

		return TasBasicSignature.BASIC_NS + SCHEMA_OUTPUT_ROOT_NAME;
	}

	@Override
	public void constructInputType(XSDModelGroup activityInput,
			XSDSchema inputSchema) {
	}

	@Override
	public XSDElementDeclaration getInputType(Configuration config)
			throws BWActivitySignatureUnknown {

		QueryAuditEvent queryAuditEvent = (QueryAuditEvent) getDefaultEMFConfigObject(config);
		String namespace = createNamespace(new Object[] { BASIC_NS,
				SCHEMA_INPUT_ROOT_NAME});
		return buildInputType(namespace,
				queryAuditEvent.getTasConnection(), queryAuditEvent);

	}

	@Override
	public void constructOutputType(XSDModelGroup rootOutPut,
			XSDSchema inputSchema) {
	}

	@Override
	public XSDElementDeclaration getOutputType(Configuration config)
			throws BWActivitySignatureUnknown {

		QueryAuditEvent queryAuditEvent = (QueryAuditEvent) getDefaultEMFConfigObject(config);

		String namespace = createNamespace(new Object[] { BASIC_NS,
				SCHEMA_OUTPUT_ROOT_NAME});
		return buildOutputType(namespace,
				queryAuditEvent.getTasConnection(), queryAuditEvent);


	}

	private XSDElementDeclaration buildOutputType(String namespace, String connection, EObject obj) {
		XSDElementDeclaration outputType = null;
	    XSDSchema outputSchema = XSDUtility.createSchema(namespace);
	    outputSchema.setElementFormDefault(XSDForm.UNQUALIFIED_LITERAL);


		XSDModelGroup rootOutput = XSDUtility.addComplexTypeElement(outputSchema, TasConstants.TAS_ACTIVITY_OUTPUT, "ActivityOutput", XSDCompositor.SEQUENCE_LITERAL);
		if(rootOutput == null ){
			throw new RuntimeException("Create activity Output schema failure !");
		}

		XSDUtility.addSimpleTypeElement(rootOutput, "totalResults", "string", 1, 1);
		XSDModelGroup data = XSDUtility.addComplexTypeElement(rootOutput, TasConstants.TAG_NAME,
				TasConstants.TAG_NAME, 1, -1, XSDCompositor.SEQUENCE_LITERAL);

		XSDUtility.addSimpleTypeElement(data, TasConstants.TAS_EVENT_ID, "string", 1, 1);
		XSDUtility.addSimpleTypeElement(data, TasConstants.CRITERIA_EVENT_SOURCE, "string", 1, 1);
		XSDUtility.addSimpleTypeElement(data, TasConstants.CRITERIA_EVENT_DEST, "string", 1, 1);
		XSDUtility.addSimpleTypeElement(data, TasConstants.CRITERIA_BUSINESS_PROCESS, "string", 1, 1);
		XSDUtility.addSimpleTypeElement(data, TasConstants.EVENT_TIMESTAMP, "string", 1, 1);
		XSDUtility.addSimpleTypeElement(data, TasConstants.CRITERIA_TRANS_ID, "string", 1, 1);
		XSDUtility.addSimpleTypeElement(data, TasConstants.CRITERIA_EVENT_STATUS, "string", 1, 1);
		XSDUtility.addSimpleTypeElement(data, TasConstants.CRITERIA_AUDIT_EVENT, "string", 1, 1);
		XSDUtility.addSimpleTypeElement(data, TasConstants.BLOCKCHAIN_TRANS_ID, "string", 1, 1);

		outputSchema = compileSchema(outputSchema);
		outputType = outputSchema.resolveElementDeclaration("ActivityOutput");

		return outputType;
	}


	private XSDElementDeclaration buildInputType(String namespace, String connection, EObject obj) {

		XSDElementDeclaration inputType = null;
	    XSDSchema inputSchema = XSDUtility.createSchema(namespace);
	    inputSchema.setElementFormDefault(XSDForm.UNQUALIFIED_LITERAL);


		XSDModelGroup rootInput = XSDUtility.addComplexTypeElement(inputSchema, TasConstants.TAS_ACTIVITY_INPUT, "ActivityInput", XSDCompositor.SEQUENCE_LITERAL);


		if(rootInput == null ){
			throw new RuntimeException("Create activity Input schema failure !");
		}

		XSDModelGroup criteria = XSDUtility.addComplexTypeElement(rootInput, TasConstants.TAG_CRITERIA,
				TasConstants.TAG_CRITERIA, 1, 1, XSDCompositor.SEQUENCE_LITERAL);

		XSDUtility.addSimpleTypeElement(criteria, TasConstants.CRITERIA_BUSINESS_PROCESS, "string", 0, -1);
		XSDUtility.addSimpleTypeElement(criteria, TasConstants.CRITERIA_TRANS_ID, "string", 0, -1);
		XSDUtility.addSimpleTypeElement(criteria, TasConstants.CRITERIA_EVENT_SOURCE, "string", 0, -1);
		XSDUtility.addSimpleTypeElement(criteria, TasConstants.CRITERIA_EVENT_DEST, "string", 0, -1);
		XSDUtility.addSimpleTypeElement(criteria, TasConstants.CRITERIA_EVENT_STATUS, "string", 0, -1);
		XSDUtility.addSimpleTypeElement(criteria, TasConstants.CRITERIA_AUDIT_EVENT, "string", 0, -1);
		XSDUtility.addSimpleTypeElement(criteria, TasConstants.CRITERIA_BEGIN, "string", 0, 1);
		XSDUtility.addSimpleTypeElement(criteria, TasConstants.CRITERIA_BEGIN, "string", 0, 1);

		inputSchema = compileSchema(inputSchema);
		inputType = inputSchema.resolveElementDeclaration("ActivityInput");

		return inputType;
	}

}
