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
package com.tibco.bw.palette.tcta.runtime;

import org.genxdm.ProcessingContext;
import org.genxdm.mutable.MutableModel;
import com.tibco.bw.palette.tcta.runtime.RuntimeMessageBundle;
import org.genxdm.mutable.NodeFactory;
import com.tibco.bw.palette.tcta.model.tcta.UpsertRow;
import com.tibco.bw.runtime.ActivityFault;
import com.tibco.bw.runtime.ProcessContext;
import com.tibco.neo.localized.LocalizedMessage;
import com.tibco.bw.runtime.annotation.Property;
import com.tibco.bw.sharedresource.tcta.runtime.tctaConnectionResource;

public class UpsertRowActivity<N> extends BaseSyncActivity<N> implements TCTAContants{

	@Property
	public UpsertRow activityConfig;
	
    /**
     * <!-- begin-custom-doc -->
     * Shared Resource injected by framework.
     * <!-- end-custom-doc -->
     * @generated
    */
    @Property(name = "propertyField")
    public tctaConnectionResource sharedResource;
    
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

        N output = noteFactory.createElement("", ACTIVITY_OUTPUT_ELEMENT_NAME, "");
        mutableModel.appendChild(outputType, output);
		
        String requireInputData = getInputParameterStringValueByName(inputData, processContext, ACTIVITY_INPUT_REQUIRED_ELEMENT_NAME);
        String optionalInputData = getInputParameterStringValueByName(inputData, processContext, ACTIVITY_INPUT_OPTIONAL_ELEMENT_NAME);
        String outputData = ACTIVITY_INPUT_REQUIRED_ELEMENT_NAME + "= " + requireInputData + "; " + ACTIVITY_INPUT_OPTIONAL_ELEMENT_NAME + " = " + optionalInputData;
        
        N contentValueNode = noteFactory.createText(outputData);
        mutableModel.appendChild(output, contentValueNode);

        return outputType;
    }
    
	@Override
	protected String getActivityOutputType() {
		return ACTIVITY_OUTPUT_ROOT_ELEMENT_NAME;
	}
}
