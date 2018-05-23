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

import org.genxdm.Model;
import org.genxdm.ProcessingContext;
import org.genxdm.io.FragmentBuilder;

import com.tibco.bw.runtime.ActivityFault;
import com.tibco.bw.runtime.ProcessContext;
import com.tibco.bw.runtime.SyncActivity;
import com.tibco.bw.runtime.util.XMLUtils;

public abstract class BaseSyncActivity<N> extends SyncActivity<N> {

    /**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 */
	@Override
	public N execute(N input, ProcessContext<N> processContext) throws ActivityFault {
        if(getActivityLogger().isDebugEnabled()){
	        String serializedInputNode = XMLUtils.serializeNode(input, processContext.getXMLProcessingContext());
		    activityLogger.debug(RuntimeMessageBundle.DEBUG_PLUGIN_ACTIVITY_INPUT, new Object[] {activityContext.getActivityName(), serializedInputNode});
		}
        
        // begin-custom-code
        // add your own business code here
         N result = customizeExecute(input, processContext);
        // end-custom-code
        if(getActivityLogger().isDebugEnabled()){
	        String serializedOutputNode = XMLUtils.serializeNode(result, processContext.getXMLProcessingContext());
			activityLogger.debug(RuntimeMessageBundle.DEBUG_PLUGIN_ACTIVITY_OUTPUT, new Object[] {activityContext.getActivityName(), serializedOutputNode, activityContext.getActivityName()});
		}
        return result;
	}

	protected abstract N customizeExecute(N input, ProcessContext<N> processContext) throws ActivityFault;
	
	/**
    * Gets the String type parameter from the input by name.
    */
	public <N> String getInputParameterStringValueByName(final N inputData, final ProcessingContext<N> processContext, final String parameterName) {
        Model<N> model = processContext.getMutableContext().getModel();
        N parameter = model.getFirstChildElementByName(inputData, null, parameterName);
        if (parameter == null) {
            return "";
         }
        return model.getStringValue(parameter);
    }
	/**
    * Gets the Boolean type parameter from the input by name.
    */
	public <N> boolean getInputParameterBooleanValueByName(final N inputData, final ProcessingContext<N> processContext, final String parameterName) {
		Model<N> model = processContext.getMutableContext().getModel();
		N parameter = model.getFirstChildElementByName(inputData, null, parameterName);
		if (parameter == null) {
			return false;
		}
		String valueStr = model.getStringValue(parameter);
		return Boolean.parseBoolean(valueStr);
	}

    /**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 */ 
    protected <N> N getOutputRootElement(ProcessingContext<N> processContext) {
        // begin-custom-code
        // add your own business code here
        final FragmentBuilder<N> builder = processContext.newFragmentBuilder();

        Model<N> model = processContext.getModel();
        builder.startDocument(null, "xml");
        try {
            builder.startElement(activityContext.getActivityOutputType().getTargetNamespace(), getActivityOutputType(), "ns0");
        try {
			} finally {
				builder.endElement();
			}
		} finally {
			builder.endDocument();
		}
        N output = builder.getNode();
        N resultList = model.getFirstChild(output);
        return resultList;
        // end-custom-code
    }

    protected abstract String getActivityOutputType();
    
    protected abstract <N, A> N evalOutput(N inputData,ProcessingContext<N> processContext) throws Exception;
}
