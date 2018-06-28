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

import java.util.Map;

import com.tibco.bw.sharedresource.runtime.ResourceDependencyHandler;
import com.tibco.bw.sharedresource.runtime.ResourceReferenceDescriptor;
import com.tibco.bw.sharedresource.runtime.builder.ResourceReferenceDescriptorBuilder;
import com.tibco.bw.sharedresource.runtime.configuration.SharedResourceContext;
import com.tibco.bw.sharedresource.runtime.configuration.SharedResourceLifeCycleFault;
import com.tibco.bw.sharedresource.runtime.exception.ResourceException;
import com.tibco.bw.sharedresource.tcta.model.helper.TCTAConstants;
import com.tibco.neo.localized.LocalizedMessage;

public class TctaConnectionResourceFactory extends BaseSharedResourceFactory
{
    @Override
    protected String getCustomizeName() {
        return "ManagedServiceFactory for TCTA ResourceManager";
    }

    private ResourceReferenceDescriptor buildResourceReference(SharedResourceContext context) throws ResourceException {
        TctaConnectionResource resource = new TctaConnectionResource();
		Map<String, ?> properties = context.getSharedResourceConfiguration();
		setProperties(context, properties, resource);
		@SuppressWarnings("unchecked")
        ResourceReferenceDescriptor reference = ResourceReferenceDescriptorBuilder.builder()
            .withName((String) properties.get(".name"))
            .withType(TCTAConstants.TCTACONNECTION_QNAME.toString())
            .withResource(resource)
            .withConfiguration((Map<String, Object>) properties)
            .withBusinessInterface(TctaConnectionResource.class.getName())
            .build();
        return reference;
    }

	@Override
	protected ResourceDependencyHandler customizeCreate(SharedResourceContext context)
			throws SharedResourceLifeCycleFault {
        try {
            ResourceReferenceDescriptor reference = buildResourceReference(context);
            ResourceDependencyHandler handler = new ResourceDependencyHandler(reference);
            return handler;
        } catch (ResourceException e) {
        	LocalizedMessage message = new LocalizedMessage(RuntimeMessageBundle.ERROR_CREATE_SHAREDRESOURCE_FAILED, new String[] {context.getSharedResourceName()});
            throw new TCTAPluginSRException(message, e);
        }
	}

	@Override
	protected void customizeDelete(SharedResourceContext context)
			throws SharedResourceLifeCycleFault {
		if(context.getSharedResourceLogger().isDebugEnabled()) {
		    context.getSharedResourceLogger().debug(RuntimeMessageBundle.DEBUG_DELETE_SHAREDRESOURCE, new String[] {TCTAConstants.TCTACONNECTION_QNAME.toString()});
	    }
	}

	@Override
	protected void customizeStart(SharedResourceContext context)
			throws SharedResourceLifeCycleFault {
		if(context.getSharedResourceLogger().isDebugEnabled()) {
			context.getSharedResourceLogger().debug(RuntimeMessageBundle.DEBUG_START_SHAREDRESOURCE, new String[] {TCTAConstants.TCTACONNECTION_QNAME.toString()});
		}
	}

	@Override
	protected void customizeStop(SharedResourceContext context)
			throws SharedResourceLifeCycleFault {
		if(context.getSharedResourceLogger().isDebugEnabled()) {
		    context.getSharedResourceLogger().debug(RuntimeMessageBundle.DEBUG_START_SHAREDRESOURCE, new String[] {TCTAConstants.TCTACONNECTION_QNAME.toString()});
	    }
	}

	@Override
	protected ResourceDependencyHandler customizeUpdate(SharedResourceContext context)
			throws SharedResourceLifeCycleFault {
		if(context.getSharedResourceLogger().isDebugEnabled()) {
		    context.getSharedResourceLogger().debug(RuntimeMessageBundle.DEBUG_UPDATE_SHAREDRESOURCE, new String[] {TCTAConstants.TCTACONNECTION_QNAME.toString()});
		}
		return create(context);
	}

	/**
     * <!-- begin-custom-doc -->
     *
     * <!-- end-custom-doc -->
     * @generated
     */
	private void setProperties(SharedResourceContext context ,final Map<String, ?> toSet, final TctaConnectionResource resource) {
	    resource.setServerUrl((String) toSet.get("serverUrl"));
	    resource.setUsername((String)toSet.get("username"));
	    resource.setPassword(context.getDecryptedPasswordValue((String) toSet.get("password")));
	    // begin-custom-code
        // end-custom-code
	}
}
