package com.tibco.bw.palette.tas.design.getauditevent;

import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xsd.XSDCompositor;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDForm;
import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDSchema;

import com.fasterxml.jackson.databind.JsonNode;
import com.tibco.bw.design.api.BWActivitySignatureUnknown;
import com.tibco.bw.design.util.XSDUtility;
import com.tibco.bw.model.activityconfig.Configuration;
import com.tibco.bw.palette.tas.design.SignatureHelper;
import com.tibco.bw.palette.tas.design.TasBasicSignature;
import com.tibco.bw.palette.tas.model.tas.GetAuditEvent;
import com.tibco.bw.palette.tas.model.tas.TasConstants;
import com.tibco.bw.sharedresource.tas.model.helper.JsonReader;
import com.tibco.bw.sharedresource.tas.model.tas.TasConnection;

public class GetAuditEventSignature extends TasBasicSignature {
	private static final String SCHEMA_INPUT_ROOT_NAME = "GetAuditEventInput";

	private static final String SCHEMA_OUTPUT_ROOT_NAME = "GetAuditEventOutput";

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

		GetAuditEvent GetAuditEvent = (GetAuditEvent) getDefaultEMFConfigObject(config);
		String namespace = createNamespace(new Object[] { BASIC_NS,
				SCHEMA_INPUT_ROOT_NAME});
		return buildInputType(namespace,
				GetAuditEvent.getTasConnection(), GetAuditEvent);

	}

	@Override
	public void constructOutputType(XSDModelGroup rootOutPut,
			XSDSchema inputSchema) {
	}

	@Override
	public XSDElementDeclaration getOutputType(Configuration config)
			throws BWActivitySignatureUnknown {

		GetAuditEvent GetAuditEvent = (GetAuditEvent) getDefaultEMFConfigObject(config);

		String namespace = createNamespace(new Object[] { BASIC_NS,
				SCHEMA_OUTPUT_ROOT_NAME});
		return buildOutputType(namespace,
				GetAuditEvent.getTasConnection(), GetAuditEvent);


	}

	private XSDElementDeclaration buildOutputType(String namespace, String connection, EObject obj) {
		XSDElementDeclaration outputType = null;
	    XSDSchema outputSchema = XSDUtility.createSchema(namespace);
	    outputSchema.setElementFormDefault(XSDForm.UNQUALIFIED_LITERAL);


		XSDModelGroup rootOutput = XSDUtility.addComplexTypeElement(outputSchema, TasConstants.TAS_ACTIVITY_OUTPUT, "ActivityOutput", XSDCompositor.SEQUENCE_LITERAL);
		if(rootOutput == null ){
			throw new RuntimeException("Create activity Output schema failure !");
		}

		XSDUtility.addSimpleTypeElement(rootOutput, TasConstants.TAG_TOAL_NUMBER, "string", 1, 1);
		XSDUtility.addSimpleTypeElement(rootOutput, TasConstants.TAG_ERROR_MESSAGE, "string", 1, 1);
		XSDModelGroup data = XSDUtility.addComplexTypeElement(rootOutput, TasConstants.TAG_DATA,
				TasConstants.TAG_DATA, 0, -1, XSDCompositor.SEQUENCE_LITERAL);
		
		TasConnection conn = SignatureHelper.getConnectionFromSharedResource(connection, obj);
		if(conn == null){
			return null;
		}
		
		JsonReader requestNode;
		try {
			XSDUtility.addSimpleTypeElement(data, TasConstants.TAS_EVENT_ID, "string", 1, 1);
			
			requestNode = new JsonReader(conn.getSchema());

			JsonNode item = requestNode.getNode("items");
			JsonNode properties = item.get("properties");
			JsonNode required = item.get("required");
			HashSet<String> requiredSet = new HashSet<String>();
			if (required.isArray()) {
			    for (final JsonNode objNode : required) {
			    	String fieldName = objNode.asText();
			    	requiredSet.add(fieldName);
			    	XSDUtility.addSimpleTypeElement(data, fieldName, "string", 1, 1);
			    }
			}

			Iterator<String> ite = properties.fieldNames();

			while(ite.hasNext()){
				String key = ite.next();
				if(!requiredSet.contains(key)){
					JsonNode field = properties.get(key);
					if("string".equals(field.get("type").textValue())){
						XSDUtility.addSimpleTypeElement(data, key, "string", 0, 1);
					}
				}
			}
			XSDUtility.addSimpleTypeElement(data, TasConstants.EVENT_CREATE_TIMESTAMP, "string", 1, 1);
			
			XSDModelGroup extraGroup = XSDUtility.addComplexTypeElement(data, "extra_props", "extra_props", 0, -1, XSDCompositor.SEQUENCE_LITERAL);
			XSDUtility.addSimpleTypeElement(extraGroup, "prop_name", "string", 1, 1);
			XSDUtility.addSimpleTypeElement(extraGroup, "prop_value", "string", 1, 1);
			
			outputSchema = compileSchema(outputSchema);
			outputType = outputSchema.resolveElementDeclaration("ActivityOutput");

		} catch (Exception e) {
			throw new RuntimeException("Build activity Output schema failure !" + e.getMessage());
		}

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
		

		XSDUtility.addSimpleTypeElement(rootInput, TasConstants.CRITERIA_BUSINESS_PROCESS, "string", 0, -1);
		XSDUtility.addSimpleTypeElement(rootInput, TasConstants.CRITERIA_TRANS_ID, "string", 0, -1);
		XSDUtility.addSimpleTypeElement(rootInput, TasConstants.CRITERIA_EVENT_SOURCE, "string", 0, -1);
		XSDUtility.addSimpleTypeElement(rootInput, TasConstants.CRITERIA_EVENT_DEST, "string", 0, -1);
		XSDUtility.addSimpleTypeElement(rootInput, TasConstants.CRITERIA_EVENT_STATUS, "string", 0, -1);
		XSDUtility.addSimpleTypeElement(rootInput, TasConstants.CRITERIA_AUDIT_EVENT, "string", 0, -1);
		XSDUtility.addSimpleTypeElement(rootInput, TasConstants.CRITERIA_BEGIN, "string", 0, 1);
		XSDUtility.addSimpleTypeElement(rootInput, TasConstants.CRITERIA_END, "string", 0, 1);
		
		
		XSDModelGroup extraGroup = XSDUtility.addComplexTypeElement(rootInput, TasConstants.TAG_EXTRA_PROP,
				TasConstants.TAG_EXTRA_PROP, 0, -1, XSDCompositor.SEQUENCE_LITERAL);
		XSDUtility.addSimpleTypeElement(extraGroup, "prop_name", "string", 1, 1);
		XSDUtility.addSimpleTypeElement(extraGroup, "prop_value", "string", 1, 1);

		inputSchema = compileSchema(inputSchema);
		inputType = inputSchema.resolveElementDeclaration("ActivityInput");

		return inputType;
	}

}
