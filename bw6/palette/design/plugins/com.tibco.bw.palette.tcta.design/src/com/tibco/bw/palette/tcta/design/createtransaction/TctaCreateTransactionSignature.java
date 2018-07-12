package com.tibco.bw.palette.tcta.design.createtransaction;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDSchema;

import com.tibco.bw.design.util.XSDUtility;
import com.tibco.bw.palette.tcta.design.TctaBasicSignature;
import com.tibco.bw.palette.tcta.design.TctaConstants;

public class TctaCreateTransactionSignature extends TctaBasicSignature {
	private static final String SCHEMA_INPUT_ROOT_NAME = "createTransactionInput";

    private static final String SCHEMA_OUTPUT_ROOT_NAME = "createTransactionOutput";


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
		return TctaBasicSignature.BASIC_NS+SCHEMA_INPUT_ROOT_NAME;
	}

	@Override
	public String getoutputTargetNamespace() {

		return TctaBasicSignature.BASIC_NS+SCHEMA_OUTPUT_ROOT_NAME;
	}

	@Override
	public void constructInputType(XSDModelGroup activityInput,
			XSDSchema inputSchema) {
		Client client = ClientBuilder.newClient();

		MultivaluedMap<String, Object> myHeaders = new MultivaluedHashMap<String, Object>();
		myHeaders.add("x-atmosphere-for-user","abc");
		myHeaders.add("tscSubscriptionId","abc");

		Invocation.Builder invocationBuilder = client.target("https://auditsafe.ax-qa.tcie.pro").path("/tcta/dataserver/schema").
				request(MediaType.APPLICATION_JSON_TYPE).headers(myHeaders);
		//Response response = invocationBuilder.post(Entity.)
//		XSDUtility.addSimpleTypeElement(activityInput, TctaConstants.TRANS_SOURCE, "string", 1, 1);
//		XSDUtility.addSimpleTypeElement(activityInput, TctaConstants.TRANS_DESTINATION, "string", 1, 1);

	}

	@Override
	public void constructOutputType(XSDModelGroup rootOutPut,
			XSDSchema inputSchema) {
		XSDUtility.addSimpleTypeElement(rootOutPut, TctaConstants.RESPONSE, "string", 1, 1);
	}
}
