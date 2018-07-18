package com.tibco.bw.palette.tcta.design;



import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xsd.XSDCompositor;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDForm;
import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDSchema;

import com.fasterxml.jackson.databind.JsonNode;
import com.tibco.bw.design.api.BWActivitySignature;
import com.tibco.bw.design.api.BWActivitySignatureUnknown;
import com.tibco.bw.design.util.XSDUtility;
import com.tibco.bw.model.activityconfig.Configuration;
import com.tibco.bw.sharedresource.tcta.model.helper.TctaClientUtils;
import com.tibco.bw.sharedresource.tcta.model.tcta.TctaConnection;


public abstract class TctaBasicSignature extends BWActivitySignature {
	protected static final String BASIC_NS = "http://www.tibco.com/namespaces/tnt/plugins/";


	@Override
	public List<XSDElementDeclaration> getFaultTypes(final Configuration config)
			throws BWActivitySignatureUnknown {

		 return TctaExceptionsSchema.getTCTAPluginFaultTypes();
	}


	@Override
	public XSDElementDeclaration getInputType(Configuration config)
			throws BWActivitySignatureUnknown {
        XSDElementDeclaration inPutType = null;
        // begin-custom-code

        String namespace = createNamespace(new Object[] { getInputTargetNamespace(),config, "Input" }); //$NON-NLS-1$
        XSDSchema inPutSchema = XSDUtility.createSchema(namespace);
        XSDModelGroup rootInPut = XSDUtility.addComplexTypeElement(inPutSchema, TctaConstants.TCTA_ACTIVITY_INPUT, "ActivityInputType", XSDCompositor.SEQUENCE_LITERAL);
        constructInputType(rootInPut,inPutSchema);

        inPutSchema = compileSchema(inPutSchema);
        inPutType = inPutSchema.resolveElementDeclaration(TctaConstants.TCTA_ACTIVITY_INPUT);

        return inPutType;
	}

	@Override
	public XSDElementDeclaration getOutputType(Configuration config)
			throws BWActivitySignatureUnknown {
        XSDElementDeclaration outPutType = null;
        // begin-custom-code

        String namespace = createNamespace(new Object[] { getoutputTargetNamespace(),config, "Output" }); //$NON-NLS-1$
        XSDSchema outPutSchema = XSDUtility.createSchema(namespace);
        XSDModelGroup rootOutPut = XSDUtility.addComplexTypeElement(outPutSchema, TctaConstants.TCTA_ACTIVITY_OUTPUT, "ActivityOutputType", XSDCompositor.SEQUENCE_LITERAL);
        constructOutputType(rootOutPut,outPutSchema);
        outPutSchema = compileSchema(outPutSchema);
        outPutType = outPutSchema.resolveElementDeclaration(TctaConstants.TCTA_ACTIVITY_OUTPUT);

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
		TctaConnection conn = SignatureHelper.getConnectionFromSharedResource(connection, obj);
		if(conn == null){
			return null;
		}

		XSDElementDeclaration inputType = null;
	    XSDSchema inputSchema = XSDUtility.createSchema(namespace);
	    inputSchema.setElementFormDefault(XSDForm.UNQUALIFIED_LITERAL);
		XSDModelGroup rootInput = XSDUtility.addComplexTypeElement(inputSchema, TctaConstants.TCTA_ACTIVITY_INPUT, "ActivityInput", XSDCompositor.SEQUENCE_LITERAL);


		if(rootInput == null ){
			throw new RuntimeException("Create activity Input schema failure !");
		}

	    createSchema(rootInput , conn ,  obj);

		inputSchema = compileSchema(inputSchema);
		inputType = inputSchema.resolveElementDeclaration("ActivityInput");
		return inputType;
	}


	private void createSchema(XSDModelGroup rootInput,
			TctaConnection conn, EObject obj) {
		//String token = TctaClientUtils.getToken(conn.getUsername(), conn.getPassword());
		String body = "{\"path\": \"/tcta/dataserver/transactions/intercom\", \"method\": \"POST\"}";
		JsonNode  requestNode = TctaClientUtils.getSchema(conn.getServerUrl(), body, 1);
		JsonNode properties = requestNode.get("properties");

		Iterator<String> ite = properties.fieldNames();
		while(ite.hasNext()){
			String key = ite.next();
			JsonNode field = properties.get(key);
			if("string".equals(field.get("type").textValue())){
				XSDUtility.addSimpleTypeElement(rootInput, key, "string", 1, 1);
			} else {
				JsonNode extra_props = properties.get("extra_props").get("items").get("properties");
			    XSDModelGroup extraGroup = XSDUtility.addComplexTypeElement(rootInput, "extra_props", "extra_props", 0, -1, XSDCompositor.SEQUENCE_LITERAL);
			    Iterator<String> extraIte = extra_props.fieldNames();
			    while(extraIte.hasNext()){
			    	String extraKey = extraIte.next();
			    	XSDUtility.addSimpleTypeElement(extraGroup, extraKey, "string", 1, 1);
			    }
			}
		}

	}
}
