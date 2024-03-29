/*
 *(c) Copyright 2008, TIBCO Software Inc.  All rights reserved.
 *
 * LEGAL NOTICE:  This source code is provided to specific authorized end
 * users pursuant to a separate license agreement.  You MAY NOT use this
 * source code if you do not have a separate license from TIBCO Software
 * Inc.  Except as expressly set forth in such license agreement, this
 * source code, or any portion thereof, may not be used, modified,
 * reproduced, transmitted, or distributed in any form or by any means,
 * electronic or mechanical, without written permission from
 * TIBCO Software Inc.
 */
package com.tibco.bw.palette.tas.runtime;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import org.genxdm.Model;
import org.genxdm.ProcessingContext;
import org.genxdm.mutable.MutableModel;
import org.genxdm.mutable.NodeFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tibco.bw.palette.tas.model.tas.PostAuditEvent;
import com.tibco.bw.palette.tas.runtime.fault.TasActivityFault;
import com.tibco.bw.runtime.ActivityFault;
import com.tibco.bw.runtime.ProcessContext;
import com.tibco.bw.runtime.annotation.Property;
import com.tibco.bw.sharedresource.tas.model.helper.JsonReader;
import com.tibco.bw.sharedresource.tas.model.helper.TasClient;
import com.tibco.bw.sharedresource.tas.model.helper.TasResponse;
import com.tibco.bw.sharedresource.tas.runtime.TasConnectionResource;

public class PostAuditEventActivity<N> extends BaseSyncActivity<N> implements TASContants{

	@Property
	public PostAuditEvent activityConfig;

    /**
     * <!-- begin-custom-doc -->
     * Shared Resource injected by framework.
     * <!-- end-custom-doc -->
     * @generated
    */
	@Property(name = "tasConnection")
    public TasConnectionResource sharedResource;

	@Override
	protected N customizeExecute(N input, ProcessContext<N> processContext) throws ActivityFault {
        // add your own business code here
        N result = null;
        // create output data according the output structure
        try {
            result = evalOutput(input, processContext.getXMLProcessingContext());
        } catch (Exception e) {
            throw new TasActivityFault(activityContext, RuntimeMessageBundle.ERROR_POST_EVENT.getErrorCode(), e.getLocalizedMessage());
        }
        return result;
	}

	@Override
    protected <N, A> N evalOutput(N inputData,ProcessingContext<N> processContext) throws Exception {
        // add your own business code here
		N output = getOutputRootElement(processContext);

        MutableModel<N> mutableModel = processContext.getMutableContext().getModel();
        NodeFactory<N> noteFactory = mutableModel.getFactory(output);

        // add your own business code here
        TasResponse result  = new TasResponse();


		ObjectMapper mapper = new ObjectMapper();

		ArrayNode eventArray = mapper.createArrayNode();

		Model<N> model = processContext.getModel();
		Iterable<N> eventIte = model.getChildElements(inputData);
		for (N event : eventIte) {

			ObjectNode eventNode = mapper.createObjectNode();
			ArrayNode extraPropsNode = mapper.createArrayNode();
			Iterable<N> ite = model.getChildElements(event);
			for (N node : ite) {
				String name = model.getLocalName(node);
				if(!"extra_props".equals(name)){
					eventNode.put(name, model.getStringValue(node));
				} else {
					ObjectNode propNode = mapper.createObjectNode();
					N nameNode = model.getFirstChildElementByName(node, null, "prop_name");
					if(nameNode != null && model.getStringValue(nameNode)!=null){
						propNode.put("prop_name", model.getStringValue(nameNode));
						propNode.put("prop_value", model.getStringValue(model.getFirstChildElementByName(node, null, "prop_value")));
						extraPropsNode.add(propNode);
					}
				}
			}
			eventNode.set("extra_props", extraPropsNode);
			eventArray.add(eventNode);
		}
		//send post request
		String body = mapper.writeValueAsString(eventArray);
		boolean isEnterprise = sharedResource.isEnterprise();
		activityLogger.debug("Is enterprise version:" + isEnterprise + ". Request body:" +body);
		
		int retryTimes = 0;

		while(retryTimes < 5){
			
			if(sharedResource.isSso()) {
				result = TasClient.postAuditEventbySso(sharedResource.getServerUrl(), sharedResource.getAccessToken(), sharedResource.getRefreshToken(), body, true);
				
			}else if(sharedResource.isEnterprise()){
				if(sharedResource.isUseToken()){
					//use token
					result = TasClient.tasEEActionWithToken(TasClient.METHOD_POST_EVENT, sharedResource.getServerUrl(), sharedResource.getAccessToken(), "", body);
				}else {
					// use username/password
					result = TasClient.tasEEAction(TasClient.METHOD_POST_EVENT, sharedResource.getServerUrl(), sharedResource.getUsername(),
							sharedResource.getPassword(), "", body);
				}
			} else {
				if(sharedResource.isUseToken()){
					//use token
					result = TasClient.tasActionWithToken(TasClient.METHOD_POST_EVENT, sharedResource.getServerUrl(),
								sharedResource.getClientId(), sharedResource.getClientSecret(), "", body, true);

				}else {
					// use username/password
					result = TasClient.postAuditEvent(sharedResource.getServerUrl(), sharedResource.getUsername(), sharedResource.getPassword(), sharedResource.getId(), body, true);

				}
			}
			
			if(result == null || result.isHasError()){
				retryTimes++;
				String errorMessage = (result == null? "Result is empty": result.getMessage());
				String warnMessage = "Post failed: " + errorMessage + ". Retry time:" + retryTimes;
				activityLogger.error(RuntimeMessageBundle.WARN_FORMAT1, new Object[] {warnMessage});
				Thread.sleep(1000*retryTimes);
			} else {
				break;
			}
		}
		
		if(result == null || result.isHasError()){
			String errorMessage = (result == null? "Result is empty": result.getMessage());
			throw new TasActivityFault(activityContext, RuntimeMessageBundle.ERROR_REQUEST_FAILED.getErrorCode(), errorMessage);
		}

		// get output schema and put properties in a set
		JsonReader requestNode = new JsonReader(sharedResource.getOutput());
		//activityLogger.debug(requestNode.toString());
		JsonNode item = requestNode.getNode("items");
		JsonNode properties = item.get("properties");
		List<String>  fieldSet  = new ArrayList<String>();
		Iterator<String> ite = properties.fieldNames();
		while(ite.hasNext()){
			String key = ite.next();
			fieldSet.add(key);
		}

		ArrayNode resultArray = (ArrayNode)mapper.readTree(result.getMessage());
		for (JsonNode jsonNode : resultArray) {
			N event = noteFactory.createElement("", "Event", "");
			for(String fieldName : fieldSet){
				N fieldNode = noteFactory.createElement("", fieldName,"");
				N valueNode = noteFactory.createText(jsonNode.get(fieldName).asText());
				mutableModel.appendChild(fieldNode, valueNode);
				mutableModel.appendChild(event, fieldNode);
			}
			mutableModel.appendChild(output,event);
		}
        return output;
    }

	@Override
	protected String getActivityOutputType() {
		return ACTIVITY_OUTPUT_ROOT_ELEMENT_NAME;
	}
}
