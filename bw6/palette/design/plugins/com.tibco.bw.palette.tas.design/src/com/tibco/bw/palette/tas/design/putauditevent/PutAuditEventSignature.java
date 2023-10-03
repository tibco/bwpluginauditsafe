package com.tibco.bw.palette.tas.design.putauditevent;

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
import com.tibco.bw.palette.tas.model.tas.PutAuditEvent;
import com.tibco.bw.palette.tas.model.tas.TasConstants;
import com.tibco.bw.sharedresource.tas.model.helper.JsonReader;
import com.tibco.bw.sharedresource.tas.model.tas.TasConnection;

public class PutAuditEventSignature extends TasBasicSignature {
	private static final String SCHEMA_INPUT_ROOT_NAME = "putAuditEventInput";

	private static final String SCHEMA_OUTPUT_ROOT_NAME = "putAuditEventOutput";

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

		PutAuditEvent putAuditEvent = (PutAuditEvent) getDefaultEMFConfigObject(config);

		if (putAuditEvent != null
				&& !"".equals(putAuditEvent.getTasConnection())) {

			String namespace = createNamespace(new Object[] { BASIC_NS,
					SCHEMA_INPUT_ROOT_NAME});
			return buildInputType(namespace,
					putAuditEvent.getTasConnection(), putAuditEvent);

		}
		return null;

	}

	@Override
	public void constructOutputType(XSDModelGroup rootOutPut,
			XSDSchema inputSchema) {
	}

	@Override
	public XSDElementDeclaration getOutputType(Configuration config)
			throws BWActivitySignatureUnknown {

		PutAuditEvent putAuditEvent = (PutAuditEvent) getDefaultEMFConfigObject(config);

		if (putAuditEvent != null
				&& !"".equals(putAuditEvent.getTasConnection())) {

			String namespace = createNamespace(new Object[] { BASIC_NS,
					SCHEMA_OUTPUT_ROOT_NAME});
			return buildOutputType(namespace,
					putAuditEvent.getTasConnection(), putAuditEvent);

		}
		return null;

	}

	private XSDElementDeclaration buildOutputType(String namespace, String connection, EObject obj) {
		TasConnection conn = SignatureHelper.getConnectionFromSharedResource(connection, obj);
		if(conn == null){
			return null;
		}

		XSDElementDeclaration outputType = null;
	    XSDSchema outputSchema = XSDUtility.createSchema(namespace);
	    outputSchema.setElementFormDefault(XSDForm.UNQUALIFIED_LITERAL);


		XSDModelGroup rootOutput = XSDUtility.addComplexTypeElement(outputSchema, TasConstants.TAS_ACTIVITY_OUTPUT, "ActivityOutput", XSDCompositor.SEQUENCE_LITERAL);


		if(rootOutput == null ){
			throw new RuntimeException("Create activity Output schema failure !");
		}

		JsonReader requestNode;
		try {
			requestNode = new JsonReader(conn.getOutput());
			XSDModelGroup event = null ;
			event = XSDUtility.addComplexTypeElement(rootOutput, TasConstants.TAG_NAME,
					TasConstants.TAG_NAME, 1, -1, XSDCompositor.SEQUENCE_LITERAL);

			JsonNode item = requestNode.getNode("items");
			JsonNode properties = item.get("properties");
			Iterator<String> ite = properties.fieldNames();

			while(ite.hasNext()){
				String key = ite.next();
				XSDUtility.addSimpleTypeElement(event, key, "string", 0, 1);
			}

			outputSchema = compileSchema(outputSchema);
			outputType = outputSchema.resolveElementDeclaration("ActivityOutput");
		} catch (Exception e) {
			throw new RuntimeException("Build activity Output schema failure !" + e.getMessage());
		}


		return outputType;
	}


	private XSDElementDeclaration buildInputType(String namespace, String connection, EObject obj) {
		TasConnection conn = SignatureHelper.getConnectionFromSharedResource(connection, obj);
		if(conn == null){
			return null;
		}

		XSDElementDeclaration inputType = null;
	    XSDSchema inputSchema = XSDUtility.createSchema(namespace);
	    inputSchema.setElementFormDefault(XSDForm.UNQUALIFIED_LITERAL);


		XSDModelGroup rootInput = XSDUtility.addComplexTypeElement(inputSchema, TasConstants.TAS_ACTIVITY_INPUT, "ActivityInput", XSDCompositor.SEQUENCE_LITERAL);


		if(rootInput == null ){
			throw new RuntimeException("Put activity Input schema failure !");
		}

    	JsonReader requestNode;
		try {
			requestNode = new JsonReader(conn.getSchema());
			int maxItem = requestNode.getNode("maxItems").asInt();
			if(maxItem <1) maxItem =100;

			XSDModelGroup event = null ;
			event = XSDUtility.addComplexTypeElement(rootInput, TasConstants.TAG_NAME,
					TasConstants.TAG_NAME, 1, maxItem, XSDCompositor.SEQUENCE_LITERAL);
			
			XSDUtility.addSimpleTypeElement(event, "tas_event_id", "string", 1, 1);

			JsonNode item = requestNode.getNode("items");
			JsonNode properties = item.get("properties");
			HashSet<String> requiredSet = new HashSet<String>();

			HashSet<String> removedSet = new HashSet<String>();
			removedSet.add("payload");
			removedSet.add("id");
			removedSet.add("index");

			Iterator<String> ite = properties.fieldNames();

			while(ite.hasNext()){
				String key = ite.next();
				if(removedSet.contains(key)) {
					continue;				
				}
				if(!requiredSet.contains(key)){
					JsonNode field = properties.get(key);
					if("string".equals(field.get("type").textValue())){
						XSDUtility.addSimpleTypeElement(event, key, "string", 0, 1);
					}
				}
			}

			XSDModelGroup extraGroup = XSDUtility.addComplexTypeElement(event, "extra_props", "extra_props", 0, -1, XSDCompositor.SEQUENCE_LITERAL);
			XSDUtility.addSimpleTypeElement(extraGroup, "prop_name", "string", 1, 1);
			XSDUtility.addSimpleTypeElement(extraGroup, "prop_value", "string", 1, 1);

			inputSchema = compileSchema(inputSchema);
			inputType = inputSchema.resolveElementDeclaration("ActivityInput");
		} catch (Exception e) {
			throw new RuntimeException("Build activity Output schema failure !" + e.getMessage());
		}

		return inputType;
	}

}
