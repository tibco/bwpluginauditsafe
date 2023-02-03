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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.genxdm.Model;
import org.genxdm.ProcessingContext;
import org.genxdm.mutable.MutableModel;
import org.genxdm.mutable.NodeFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tibco.bw.palette.tas.model.tas.GetAuditEvent;
import com.tibco.bw.palette.tas.model.tas.TasConstants;
import com.tibco.bw.palette.tas.runtime.fault.TasActivityFault;
import com.tibco.bw.runtime.ActivityFault;
import com.tibco.bw.runtime.ProcessContext;
import com.tibco.bw.runtime.annotation.Property;
import com.tibco.bw.sharedresource.tas.model.helper.OAuthToken;
import com.tibco.bw.sharedresource.tas.model.helper.TasClient;
import com.tibco.bw.sharedresource.tas.model.helper.TasResponse;
import com.tibco.bw.sharedresource.tas.runtime.TasConnectionResource;

public class GetAuditEventActivity<N> extends BaseSyncActivity<N> implements TASContants{

	@Property
	public GetAuditEvent activityConfig;

    /**O
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
            throw new TasActivityFault(activityContext, RuntimeMessageBundle.ERROR_GET_EVENT.getErrorCode(), e.getLocalizedMessage());
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
        HashMap<String, ArrayList<String>> criteriaMap = new HashMap<String, ArrayList<String>>();
        ArrayList<String> biz_proc = new ArrayList<String>();
        ArrayList<String> transaction_id = new ArrayList<String>();
        ArrayList<String> event_source = new ArrayList<String>();
        ArrayList<String> event_destination = new ArrayList<String>();
        ArrayList<String> event_status = new ArrayList<String>();
        ArrayList<String> audit_event = new ArrayList<String>();

        //init begin time and end time
      	String beginTime = "1970-01-01";
      	String endTime = "2999-12-31";

        criteriaMap.put(TasConstants.CRITERIA_BUSINESS_PROCESS, biz_proc);
        criteriaMap.put(TasConstants.CRITERIA_TRANS_ID, transaction_id);
        criteriaMap.put(TasConstants.CRITERIA_EVENT_SOURCE, event_source);
        criteriaMap.put(TasConstants.CRITERIA_EVENT_DEST, event_destination);
        criteriaMap.put(TasConstants.CRITERIA_EVENT_STATUS, event_status);
        criteriaMap.put(TasConstants.CRITERIA_AUDIT_EVENT, audit_event);

        TasResponse result  = new TasResponse();
		ObjectMapper mapper = new ObjectMapper();


		ObjectNode requestNode = mapper.createObjectNode();
		int limit = (int)activityConfig.getLimit();
		boolean isOldProject = false;
		// if limit not 0, we will use new api. limit=0 means it was old activity
		if(limit == 0 && !activityConfig.isOnlyGetCount() && !activityConfig.isIncludePayload()){
			isOldProject = true;
		} else{
			requestNode.put("newApi", true);
			requestNode.put("onlyGetCount", activityConfig.isOnlyGetCount());
			requestNode.put("includePayload", activityConfig.isIncludePayload());
			requestNode.put("limit", activityConfig.getLimit());
		}
		
		
		String sortColumn  = activityConfig.getSortColumn();
		requestNode.put("sort_column", sortColumn);
		requestNode.put("descOrder", activityConfig.isDescOrder());
		String operator = activityConfig.isExactMatch()? "=" : "~";

		ArrayNode criteriaNode = mapper.createArrayNode();
		Model<N> model = processContext.getModel();
		Iterable<N> criteriaIte = model.getChildElements(inputData);
		for (N node : criteriaIte) {
			String name = model.getLocalName(node);
			if(TasConstants.CRITERIA_BUSINESS_PROCESS.equals(name)){
				biz_proc.add(model.getStringValue(node));
			} else if(TasConstants.CRITERIA_TRANS_ID.equals(name)){
				transaction_id.add(model.getStringValue(node));
			} else if(TasConstants.CRITERIA_EVENT_SOURCE.equals(name)){
				event_source.add(model.getStringValue(node));
			} else if(TasConstants.CRITERIA_EVENT_DEST.equals(name)){
				event_destination.add(model.getStringValue(node));
			} else if(TasConstants.CRITERIA_EVENT_STATUS.equals(name)){
				event_status.add(model.getStringValue(node));
			} else if(TasConstants.CRITERIA_AUDIT_EVENT.equals(name)){
				audit_event.add(model.getStringValue(node));
			} else if(TasConstants.CRITERIA_BEGIN.equals(name) && model.getStringValue(node)!=null){
				beginTime = model.getStringValue(node);
			} else if(TasConstants.CRITERIA_END.equals(name) && model.getStringValue(node)!= null){
				endTime = model.getStringValue(node);
			} else if(TasConstants.TAG_EXTRA_PROP.equals(name)){

					N propNameNode = model.getFirstChildElement(node);
					String p_name = model.getStringValue(propNameNode);
					if(!criteriaMap.containsKey(p_name)){
						criteriaMap.put(p_name, new ArrayList<String>());
					}
					N propValueNode = model.getNextSiblingElement(propNameNode);
					criteriaMap.get(p_name).add(model.getStringValue(propValueNode));

			}
		}

		Set<String> keys = criteriaMap.keySet();
		for (String key : keys) {
			ArrayList<String> list = criteriaMap.get(key);
			if(list.size()>0) {
				ArrayNode ops = mapper.createArrayNode();
				ArrayNode values = mapper.createArrayNode();
				for (String value : list) {
					ops.add(operator);
					values.add(value);
				}

				ObjectNode columnNode = mapper.createObjectNode();
				columnNode.put("col_name", key);
				columnNode.set("operation", ops);
				columnNode.set("col_value", values);

				criteriaNode.add(columnNode);
			}
		}
		// set timestamp node
		ObjectNode timeNode = mapper.createObjectNode();
		timeNode.put("col_name", "event_timestamp");
		ArrayNode values = mapper.createArrayNode();
		values.add(beginTime);
		values.add(endTime);
		timeNode.set("col_value", values);
		criteriaNode.add(timeNode);

		requestNode.set("criteria", criteriaNode);

		//send query request
		String body = mapper.writeValueAsString(requestNode);
		boolean isEnterprise = sharedResource.isEnterprise();
		activityLogger.debug("Is enterprise version:" + isEnterprise + ". Request body:" +body);
		if(sharedResource.isSso()) {
			result = TasClient.getAuditEventSso(sharedResource.getServerUrl(), sharedResource.getId(), body, true);	
		}else if(sharedResource.isEnterprise()){
			if(sharedResource.isUseToken()){
				//use token
				result = TasClient.tasEEActionWithToken(TasClient.METHOD_GET_EVENT, sharedResource.getServerUrl(), sharedResource.getAccessToken(), body);
			}else {
				// use username/password
				result = TasClient.tasEEAction(TasClient.METHOD_GET_EVENT, sharedResource.getServerUrl(), sharedResource.getUsername(),
						sharedResource.getPassword(), body);
			}
		} else {
			if(sharedResource.isUseToken()){
				//use token
				result = TasClient.tasActionWithToken(TasClient.METHOD_GET_EVENT, sharedResource.getServerUrl(),
						sharedResource.getClientId(), sharedResource.getClientSecret(), body, true);
				
			}else {
				// use username/password
				result = TasClient.getAuditEvent(sharedResource.getServerUrl(), sharedResource.getUsername(),
						sharedResource.getPassword(), sharedResource.getId(), body, true);
			}
		}
		
		if(result == null || result.isHasError()){
			String errorMessage = (result == null? "Result is empty": result.getMessage());
			throw new TasActivityFault(activityContext, RuntimeMessageBundle.ERROR_REQUEST_FAILED.getErrorCode(), errorMessage);
		}

		JsonNode resultNode = mapper.readTree(result.getMessage());
		N totalN = noteFactory.createElement("", TasConstants.TAG_TOAL_NUMBER, "");
		N totalValue = noteFactory.createText(resultNode.get(TasConstants.TAG_TOAL_NUMBER).asText());
		mutableModel.appendChild(totalN, totalValue);
		mutableModel.appendChild(output,totalN);

		N messageN = noteFactory.createElement("", TasConstants.TAG_ERROR_MESSAGE, "");
		N messageValue = noteFactory.createText(resultNode.get(TasConstants.TAG_ERROR_MESSAGE).asText());
		mutableModel.appendChild(messageN, messageValue);
		mutableModel.appendChild(output,messageN);
		
		
		Set<String> oldFieldSet = new HashSet<String>();
		oldFieldSet.add(TasConstants.TAS_EVENT_ID);
		oldFieldSet.add(TasConstants.CRITERIA_EVENT_SOURCE);
		oldFieldSet.add(TasConstants.CRITERIA_EVENT_DEST);
		oldFieldSet.add(TasConstants.CRITERIA_BUSINESS_PROCESS);
		oldFieldSet.add(TasConstants.EVENT_TIMESTAMP);
		oldFieldSet.add(TasConstants.CRITERIA_TRANS_ID);
		oldFieldSet.add(TasConstants.CRITERIA_EVENT_STATUS);
		oldFieldSet.add(TasConstants.CRITERIA_AUDIT_EVENT);
		oldFieldSet.add(TasConstants.EVENT_DESCRIPTION);

		if(resultNode.get(TasConstants.TAG_DATA)!=null && resultNode.get(TasConstants.TAG_DATA).size()>0){
			ArrayNode dataArray = (ArrayNode)resultNode.get(TasConstants.TAG_DATA);

			for (JsonNode event : dataArray) {
				N data = noteFactory.createElement("", TasConstants.TAG_DATA, "");
				Iterator<String> filedIte  = event.fieldNames();
				while(filedIte.hasNext()){
					String fieldName = filedIte.next();
					if(isOldProject && !oldFieldSet.contains(fieldName)){
						continue;
					}
					
					
					
					if(fieldName.equals(TasConstants.TAG_EXTRA_PROP)){
						JsonNode extra = event.get(TasConstants.TAG_EXTRA_PROP);
						
						if(extra != null && extra.size()>0){
							
							ArrayNode extraArray = (ArrayNode)extra;
							for(JsonNode extraProp: extraArray){
								N extraNode = noteFactory.createElement("", fieldName,"");

								N extra_props_name = noteFactory.createElement("", TasConstants.TAG_EXTRA_PROP_NAME,"");
								N extra_props_name_v = noteFactory.createText(extraProp.get(TasConstants.TAG_EXTRA_PROP_NAME).asText());
								mutableModel.appendChild(extra_props_name, extra_props_name_v);
								N extra_props_value = noteFactory.createElement("", TasConstants.TAG_EXTRA_PROP_VALUE,"");
								N extra_props_value_v = noteFactory.createText(extraProp.get(TasConstants.TAG_EXTRA_PROP_VALUE).asText());
								mutableModel.appendChild(extra_props_value, extra_props_value_v);
								
								mutableModel.appendChild(extraNode, extra_props_name);
								mutableModel.appendChild(extraNode, extra_props_value);
								
								mutableModel.appendChild(data, extraNode);
							}
						}
						
					} else {
						N fieldNode = noteFactory.createElement("", fieldName,"");
						N valueNode = noteFactory.createText(event.get(fieldName).asText());
						mutableModel.appendChild(fieldNode, valueNode);
						mutableModel.appendChild(data, fieldNode);
					}
					
					
				}
				mutableModel.appendChild(output,data);
			}
		}
		
        return output;
    }

	@Override
	protected String getActivityOutputType() {
		return ACTIVITY_OUTPUT_ROOT_ELEMENT_NAME;
	}
}
