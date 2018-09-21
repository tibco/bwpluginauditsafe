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

import org.genxdm.Model;
import org.genxdm.ProcessingContext;
import org.genxdm.mutable.MutableModel;
import org.genxdm.mutable.NodeFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tibco.bw.palette.tas.model.tas.PostAuditEvent;
import com.tibco.bw.runtime.ActivityFault;
import com.tibco.bw.runtime.ProcessContext;
import com.tibco.bw.runtime.annotation.Property;
import com.tibco.bw.sharedresource.tas.model.helper.TasClient;
import com.tibco.bw.sharedresource.tas.runtime.TasConnectionResource;
import com.tibco.neo.localized.LocalizedMessage;

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
            throw new ActivityFault(activityContext, new LocalizedMessage(
						RuntimeMessageBundle.ERROR_OCCURED_RETRIEVE_RESULT, new Object[] {activityContext.getActivityName()}));
        }
        return result;
	}

	@Override
    protected <N, A> N evalOutput(N inputData,ProcessingContext<N> processContext) throws Exception {
        // add your own business code here
		N outputType = getOutputRootElement(processContext);

        MutableModel<N> mutableModel = processContext.getMutableContext().getModel();
        NodeFactory<N> noteFactory = mutableModel.getFactory(outputType);

        N output = noteFactory.createElement("", "Response", "");
        mutableModel.appendChild(outputType, output);

        // add your own business code here
		String result  = "";


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

		String body = mapper.writeValueAsString(eventArray);
		result = TasClient.postAuditEvent(sharedResource.getServerUrl(), sharedResource.getUsername(), sharedResource.getPassword(), sharedResource.getId(), body, true);


		mutableModel.appendChild(output,noteFactory.createText(result));


        return outputType;
    }

	@Override
	protected String getActivityOutputType() {
		return ACTIVITY_OUTPUT_ROOT_ELEMENT_NAME;
	}
}
