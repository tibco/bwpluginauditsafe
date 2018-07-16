package com.tibco.bw.palette.tcta.design.createtransaction;

import com.tibco.bw.design.util.XSDUtility;
import com.tibco.bw.palette.tcta.design.TctaBasicSignature;
import com.tibco.bw.palette.tcta.design.TctaConstants;

import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDSchema;

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
		XSDUtility.addSimpleTypeElement(activityInput, "body", "string", 1, 1);
//		Client client = ClientBuilder.newClient();
//
//		MultivaluedMap<String, Object> myHeaders = new MultivaluedHashMap<String, Object>();
//		myHeaders.add("x-atmosphere-for-user","abc");
//		myHeaders.add("tscSubscriptionId","abc");
//
//		Invocation.Builder invocationBuilder = client.target("https://auditsafe.ax-qa.tcie.pro").path("/tcta/dataserver/schema").
//				request(MediaType.APPLICATION_JSON_TYPE).headers(myHeaders);
//		String json = "{ \"path\": \"/tcta/dataserver/transactions/intercom\",  \"method\": \"POST\"}";
//		Response response = invocationBuilder.post(Entity.entity(json, MediaType.APPLICATION_JSON));
//		int status = response.getStatus();
//		String replyString = response.readEntity(String.class);
//		JsonReader jsonReader = Json.createReader(new StringReader(replyString));
//		JsonObject reply = jsonReader.readObject();
//		JsonObject requestSchema = reply.getJsonObject("requestSchema");
//		String type = requestSchema.getString("type");
//		JsonObject properties = requestSchema.getJsonObject("properties");
//		Set<Entry<String, JsonValue>> valueSet = properties.entrySet();
//		for (Entry<String, JsonValue> entry : valueSet) {
//			String name = entry.getKey();
//			JsonValue value = entry.getValue();
//			JsonObject obj = (JsonObject)value;
//			String prop_type = obj.getString("type");
//			if("string".equalsIgnoreCase(prop_type)){
//				XSDUtility.addSimpleTypeElement(activityInput, TctaConstants.TRANS_SOURCE, "string", 1, 1);
//			}
//		}
	}

	@Override
	public void constructOutputType(XSDModelGroup rootOutPut,
			XSDSchema inputSchema) {
		XSDUtility.addSimpleTypeElement(rootOutPut, TctaConstants.RESPONSE, "string", 1, 1);
	}

}
