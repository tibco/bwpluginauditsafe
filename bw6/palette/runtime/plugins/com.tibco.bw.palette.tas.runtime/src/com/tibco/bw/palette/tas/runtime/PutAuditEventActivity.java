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
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tibco.bw.palette.tas.model.tas.PutAuditEvent;
import com.tibco.bw.palette.tas.model.tas.TasConstants;
import com.tibco.bw.palette.tas.runtime.fault.TasActivityFault;
import com.tibco.bw.runtime.ActivityFault;
import com.tibco.bw.runtime.ProcessContext;
import com.tibco.bw.runtime.annotation.Property;
import com.tibco.bw.sharedresource.tas.model.helper.JsonReader;

import com.tibco.bw.sharedresource.tas.model.helper.TasClient;
import com.tibco.bw.sharedresource.tas.model.helper.TasResponse;
import com.tibco.bw.sharedresource.tas.runtime.TasConnectionResource;


public class PutAuditEventActivity<N> extends BaseSyncActivity<N> implements TASContants{

	@Property
	public PutAuditEvent activityConfig;

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
            throw new TasActivityFault(activityContext, RuntimeMessageBundle.ERROR_PUT_EVENT.getErrorCode(), e.getLocalizedMessage());
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
        String tas_event_id = "";

		ObjectMapper mapper = new ObjectMapper();
		ObjectNode requestNode = mapper.createObjectNode();

		Model<N> model = processContext.getModel();
		Iterable<N> criteriaIte = model.getChildElements(inputData);
		for (N node : criteriaIte) {
			String name = model.getLocalName(node);
			if(TasConstants.TAS_EVENT_ID.equals(name)){
				tas_event_id = model.getStringValue(node);
			}else if(!"extra_props".equals(name)){
				requestNode.put(name, model.getStringValue(node));
			} else {
				ObjectNode propNode = mapper.createObjectNode();
				N nameNode = model.getFirstChildElementByName(node, null, "prop_name");
				if(nameNode != null && model.getStringValue(nameNode)!=null){
					propNode.put("prop_name", model.getStringValue(nameNode));
					propNode.put("prop_value", model.getStringValue(model.getFirstChildElementByName(node, null, "prop_value")));
					requestNode.put(name, propNode);
				}
			}
		}
		
		if(tas_event_id == ""){
			String errorMessage = (result == null? "tas_event_id is empty": result.getMessage());
			throw new TasActivityFault(activityContext, RuntimeMessageBundle.ERROR_REQUEST_FAILED.getErrorCode(), errorMessage);
		}
		
		//send post request
		String body = mapper.writeValueAsString(requestNode);
		boolean isEnterprise = sharedResource.isEnterprise();
		activityLogger.debug("Is enterprise version:" + isEnterprise + ". Request body:" +body);
		
		int retryTimes = 0;

		while(retryTimes < 5){
			
			if(sharedResource.isSso()) {
				result = TasClient.putAuditEventbySso(sharedResource.getServerUrl(), sharedResource.getAccessToken(), sharedResource.getRefreshToken(), tas_event_id, body, true);
				
			}else if(sharedResource.isEnterprise()){
				if(sharedResource.isUseToken()){
					//use token
					result = TasClient.tasEEActionWithToken(TasClient.METHOD_PUT_EVENT, sharedResource.getServerUrl(), sharedResource.getAccessToken(),
							tas_event_id, body);
				}else {
					// use username/password
					result = TasClient.tasEEAction(TasClient.METHOD_PUT_EVENT, sharedResource.getServerUrl(), sharedResource.getUsername(),
							sharedResource.getPassword(), tas_event_id, body);
				}
			} else {
				if(sharedResource.isUseToken()){
					//use token
					result = TasClient.tasActionWithToken(TasClient.METHOD_PUT_EVENT, sharedResource.getServerUrl(),
								sharedResource.getClientId(), sharedResource.getClientSecret(), tas_event_id, body, true);

				}else {
					// use username/password
					result = TasClient.putAuditEvent(sharedResource.getServerUrl(), sharedResource.getUsername(), sharedResource.getPassword(), sharedResource.getId(), tas_event_id, body, true);

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
		JsonReader responseNode = new JsonReader(sharedResource.getOutput());
		//activityLogger.debug(requestNode.toString());
		JsonNode item = responseNode.getNode("items");
		JsonNode properties = item.get("properties");
		List<String>  fieldSet  = new ArrayList<String>();
		Iterator<String> ite = properties.fieldNames();
		while(ite.hasNext()){
			String key = ite.next();
			fieldSet.add(key);
		}
		
		JsonNode jsonNode = mapper.readTree(result.getMessage());
		for(String fieldName : fieldSet){
			N fieldNode = noteFactory.createElement("", fieldName,"");
			N valueNode = noteFactory.createText(jsonNode.get(fieldName).asText());
			mutableModel.appendChild(fieldNode, valueNode);
			mutableModel.appendChild(output, fieldNode);
		}

        return output;
    }

	@Override
	protected String getActivityOutputType() {
		return ACTIVITY_OUTPUT_ROOT_ELEMENT_NAME;
	}
}
