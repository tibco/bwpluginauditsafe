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
package com.tibco.bw.sharedresource.tcta.runtime;

import com.tibco.bw.sharedresource.runtime.ResourceDependencyHandler;
import com.tibco.bw.sharedresource.runtime.configuration.SharedResourceContext;
import com.tibco.bw.sharedresource.runtime.configuration.SharedResourceFactory;
import com.tibco.bw.sharedresource.runtime.configuration.SharedResourceLifeCycleFault;

public abstract class BaseSharedResourceFactory implements SharedResourceFactory 
{
	/**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 */
    @Override
    public String getName() {
    	// begin-custom-code
        return getCustomizeName();
        // end-custom-code
    }
    
    protected abstract String getCustomizeName();
    
    /**
     * <!-- begin-custom-doc -->
     * 
     * <!-- end-custom-doc -->
     * @generated
     */
	@Override
	public ResourceDependencyHandler create(SharedResourceContext context)
			throws SharedResourceLifeCycleFault {
    	// begin-custom-code
		return customizeCreate(context);
        // end-custom-code
	}
	
	protected abstract ResourceDependencyHandler customizeCreate(SharedResourceContext context) throws SharedResourceLifeCycleFault;
	/**
     * <!-- begin-custom-doc -->
     * 
     * <!-- end-custom-doc -->
     * @generated
     */
	@Override
	public void delete(SharedResourceContext context)
			throws SharedResourceLifeCycleFault {
		// begin-custom-code
		customizeDelete(context);
		// end-custom-code
	}

	protected abstract void customizeDelete(SharedResourceContext context) throws SharedResourceLifeCycleFault;
	
	/**
     * <!-- begin-custom-doc -->
     * 
     * <!-- end-custom-doc -->
     * @generated
     */
	@Override
	public void start(SharedResourceContext context)
			throws SharedResourceLifeCycleFault {
		// begin-custom-code
		customizeStart(context);
		// end-custom-code
	}

	protected abstract void customizeStart(SharedResourceContext context) throws SharedResourceLifeCycleFault;
	
	/**
     * <!-- begin-custom-doc -->
     * 
     * <!-- end-custom-doc -->
     * @generated
     */
	@Override
	public void stop(SharedResourceContext context)
			throws SharedResourceLifeCycleFault {
		// begin-custom-code
		customizeStop(context);		
		// end-custom-code
	}
	
	protected abstract void customizeStop(SharedResourceContext context) throws SharedResourceLifeCycleFault;
	
	/**
     * <!-- begin-custom-doc -->
     * 
     * <!-- end-custom-doc -->
     * @generated
     */
	@Override
	public ResourceDependencyHandler update(SharedResourceContext context)
			throws SharedResourceLifeCycleFault {
		// begin-custom-code
		return customizeUpdate(context);
		// end-custom-code
	}

	protected abstract ResourceDependencyHandler customizeUpdate(SharedResourceContext context) throws SharedResourceLifeCycleFault;
	
}
