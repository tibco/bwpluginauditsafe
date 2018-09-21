package com.tibco.bw.palette.tas.design;



import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xsd.XSDCompositor;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDForm;
import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDSchema;

import com.fasterxml.jackson.databind.JsonNode;
import com.tibco.bw.core.design.resource.util.EncryptionService;
import com.tibco.bw.design.api.BWActivitySignature;
import com.tibco.bw.design.api.BWActivitySignatureUnknown;
import com.tibco.bw.design.util.XSDUtility;
import com.tibco.bw.model.activityconfig.Configuration;
import com.tibco.bw.sharedresource.tas.model.helper.JsonReader;
import com.tibco.bw.sharedresource.tas.model.helper.TasClient;
import com.tibco.bw.sharedresource.tas.model.tas.TasConnection;


public abstract class TasBasicSignature extends BWActivitySignature {
	protected static final String BASIC_NS = "http://www.tibco.com/namespaces/tnt/plugins/";


	@Override
	public List<XSDElementDeclaration> getFaultTypes(final Configuration config)
			throws BWActivitySignatureUnknown {

		 return TasExceptionsSchema.getTASPluginFaultTypes();
	}


	@Override
	public XSDElementDeclaration getInputType(Configuration config)
			throws BWActivitySignatureUnknown {
        XSDElementDeclaration inPutType = null;
        // begin-custom-code

        String namespace = createNamespace(new Object[] { getInputTargetNamespace(),config, "Input" }); //$NON-NLS-1$
        XSDSchema inPutSchema = XSDUtility.createSchema(namespace);
        XSDModelGroup rootInPut = XSDUtility.addComplexTypeElement(inPutSchema, TasConstants.TAS_ACTIVITY_INPUT, "ActivityInputType", XSDCompositor.SEQUENCE_LITERAL);
        constructInputType(rootInPut,inPutSchema);

        inPutSchema = compileSchema(inPutSchema);
        inPutType = inPutSchema.resolveElementDeclaration(TasConstants.TAS_ACTIVITY_INPUT);

        return inPutType;
	}

	@Override
	public XSDElementDeclaration getOutputType(Configuration config)
			throws BWActivitySignatureUnknown {
        XSDElementDeclaration outPutType = null;
        // begin-custom-code

        String namespace = createNamespace(new Object[] { getoutputTargetNamespace(),config, "Output" }); //$NON-NLS-1$
        XSDSchema outPutSchema = XSDUtility.createSchema(namespace);
        XSDModelGroup rootOutPut = XSDUtility.addComplexTypeElement(outPutSchema, TasConstants.TAS_ACTIVITY_OUTPUT, "ActivityOutputType", XSDCompositor.SEQUENCE_LITERAL);
        constructOutputType(rootOutPut,outPutSchema);
        outPutSchema = compileSchema(outPutSchema);
        outPutType = outPutSchema.resolveElementDeclaration(TasConstants.TAS_ACTIVITY_OUTPUT);

        return outPutType;
	}

    @Override
    public boolean hasInput() {
        return true;
    }

    @Override
    public boolean hasOutput() {
        return true;
    }

	public abstract void constructInputType(XSDModelGroup activityInput, XSDSchema inputSchema);
	public abstract void constructOutputType(XSDModelGroup activityOutput, XSDSchema inputSchema);
	public abstract String getInputTargetNamespace();
	public abstract String getoutputTargetNamespace();


	public XSDElementDeclaration buildInputType(String namespace, String connection, EObject obj) {
		TasConnection conn = SignatureHelper.getConnectionFromSharedResource(connection, obj);
		if(conn == null){
			return null;
		}

		XSDElementDeclaration inputType = null;
	    XSDSchema inputSchema = XSDUtility.createSchema(namespace);
	    inputSchema.setElementFormDefault(XSDForm.UNQUALIFIED_LITERAL);


		XSDModelGroup rootInput = XSDUtility.addComplexTypeElement(inputSchema, TasConstants.TAS_ACTIVITY_INPUT, "ActivityInput", XSDCompositor.SEQUENCE_LITERAL);


		if(rootInput == null ){
			throw new RuntimeException("Create activity Input schema failure !");
		}

	    try {
			createSchema(rootInput , conn ,  obj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		inputSchema = compileSchema(inputSchema);
		inputType = inputSchema.resolveElementDeclaration("ActivityInput");
		return inputType;
	}


	private void createSchema(XSDModelGroup rootInput,
			TasConnection conn, EObject obj) throws IOException {
		XSDModelGroup event = null ;
		event = XSDUtility.addComplexTypeElement(rootInput, TasConstants.TAG_NAME, TasConstants.TAG_NAME, 1, -1, XSDCompositor.SEQUENCE_LITERAL);
		JsonReader requestNode = new JsonReader(conn.getSchema());
		JsonNode properties = requestNode.getNode("properties");
		JsonNode required = requestNode.getNode("required");
		HashSet<String> requiredSet = new HashSet<String>();
		if (required.isArray()) {
		    for (final JsonNode objNode : required) {
		    	String fieldName = objNode.asText();
		    	requiredSet.add(fieldName);
		    	XSDUtility.addSimpleTypeElement(event, fieldName, "string", 1, 1);
		    }
		}

		Iterator<String> ite = properties.fieldNames();

		while(ite.hasNext()){
			String key = ite.next();
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
	}

	protected String decryptPassword(String password){
		return EncryptionService.INSTANCE.getEncryptor().decrypt(password);
	}
}
