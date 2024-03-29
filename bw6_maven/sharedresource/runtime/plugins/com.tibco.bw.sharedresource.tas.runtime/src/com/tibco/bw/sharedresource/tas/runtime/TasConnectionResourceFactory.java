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
package com.tibco.bw.sharedresource.tas.runtime;

import java.util.Map;

import com.tibco.bw.sharedresource.runtime.ResourceDependencyHandler;
import com.tibco.bw.sharedresource.runtime.ResourceReferenceDescriptor;
import com.tibco.bw.sharedresource.runtime.builder.ResourceReferenceDescriptorBuilder;
import com.tibco.bw.sharedresource.runtime.configuration.SharedResourceContext;
import com.tibco.bw.sharedresource.runtime.configuration.SharedResourceLifeCycleFault;
import com.tibco.bw.sharedresource.runtime.exception.ResourceException;
import com.tibco.neo.localized.LocalizedMessage;

import com.tibco.bw.sharedresource.tas.model.helper.TasConstants;

public class TasConnectionResourceFactory extends BaseSharedResourceFactory
{
    @Override
    protected String getCustomizeName() {
        return "ManagedServiceFactory for TAS ResourceManager";
    }

    private ResourceReferenceDescriptor buildResourceReference(SharedResourceContext context) throws ResourceException {
        TasConnectionResource resource = new TasConnectionResource();
		Map<String, ?> properties = context.getSharedResourceConfiguration();
		setProperties(context, properties, resource);
		@SuppressWarnings("unchecked")
        ResourceReferenceDescriptor reference = ResourceReferenceDescriptorBuilder.builder()
            .withName((String) properties.get(".name"))
            .withType(TasConstants.TASCONNECTION_QNAME.toString())
            .withResource(resource)
            .withConfiguration((Map<String, Object>) properties)
            .withBusinessInterface(TasConnectionResource.class.getName())
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
            throw new TASPluginSRException(message, e);
        }
	}

	@Override
	protected void customizeDelete(SharedResourceContext context)
			throws SharedResourceLifeCycleFault {
		if(context.getSharedResourceLogger().isDebugEnabled()) {
		    context.getSharedResourceLogger().debug(RuntimeMessageBundle.DEBUG_DELETE_SHAREDRESOURCE, new String[] {TasConstants.TASCONNECTION_QNAME.toString()});
	    }
	}

	@Override
	protected void customizeStart(SharedResourceContext context)
			throws SharedResourceLifeCycleFault {
		if(context.getSharedResourceLogger().isDebugEnabled()) {
			context.getSharedResourceLogger().debug(RuntimeMessageBundle.DEBUG_START_SHAREDRESOURCE, new String[] {TasConstants.TASCONNECTION_QNAME.toString()});
		}
	}

	@Override
	protected void customizeStop(SharedResourceContext context)
			throws SharedResourceLifeCycleFault {
		if(context.getSharedResourceLogger().isDebugEnabled()) {
		    context.getSharedResourceLogger().debug(RuntimeMessageBundle.DEBUG_START_SHAREDRESOURCE, new String[] {TasConstants.TASCONNECTION_QNAME.toString()});
	    }
	}

	@Override
	protected ResourceDependencyHandler customizeUpdate(SharedResourceContext context)
			throws SharedResourceLifeCycleFault {
		if(context.getSharedResourceLogger().isDebugEnabled()) {
		    context.getSharedResourceLogger().debug(RuntimeMessageBundle.DEBUG_UPDATE_SHAREDRESOURCE, new String[] {TasConstants.TASCONNECTION_QNAME.toString()});
		}
		return create(context);
	}

	/**
     * <!-- begin-custom-doc -->
     *
     * <!-- end-custom-doc -->
     * @generated
     */
	private void setProperties(SharedResourceContext context ,final Map<String, ?> toSet, final TasConnectionResource resource) {
		resource.setEnterprise((Boolean)toSet.get("enterprise"));
	    resource.setServerUrl((String) toSet.get("serverUrl"));
	    resource.setUsername((String)toSet.get("username"));
	    resource.setPassword(context.getDecryptedPasswordValue((String) toSet.get("password")));
	    resource.setId((String)toSet.get("id"));
	    resource.setSso((Boolean)toSet.get("sso"));
	    resource.setUseToken((Boolean)toSet.get("useToken"));
	    resource.setAccessToken((String) toSet.get("accessToken"));
	    resource.setRefreshToken((String) toSet.get("refreshToken"));
	    resource.setClientId((String) toSet.get("clientId"));
	    resource.setClientSecret(context.getDecryptedPasswordValue((String) toSet.get("clientSecret")));
	    

	    if(toSet.get("schema") != null){
	    	String schema = (String)toSet.get("schema");
	    	if(!schema.isEmpty()){
	    		resource.setSchema(schema);
	    		context.getSharedResourceLogger().debug(RuntimeMessageBundle.DEBUG_SHAREDRESOURCE_INPUT_SCHEMA, new String[] {schema});
		    }else{
		    	context.getSharedResourceLogger().error(RuntimeMessageBundle.ERROR_EMPTY_INPUT_SCHEMA);
		    }
		} else {
			context.getSharedResourceLogger().error(RuntimeMessageBundle.ERROR_EMPTY_INPUT_SCHEMA);
		}

	    if(toSet.get("output")!=null){
	    	String output = (String)toSet.get("output");
	    	if(!output.isEmpty()){
	    		resource.setOutput(output);
	    		context.getSharedResourceLogger().debug(RuntimeMessageBundle.DEBUG_SHAREDRESOURCE_OUTPUT_SCHEMA, new String[] {output});
	    	} else {
		    	context.getSharedResourceLogger().error(RuntimeMessageBundle.ERROR_EMPTY_OUTPUT_SCHEMA);
		    }
	    } else {
	    	context.getSharedResourceLogger().error(RuntimeMessageBundle.ERROR_EMPTY_INPUT_SCHEMA);
	    }

	    // begin-custom-code
	    if(context.getSharedResourceLogger().isDebugEnabled()) {
	    	context.getSharedResourceLogger().debug(RuntimeMessageBundle.MESSAGE_FORMAT1, new String[]{resource.getId(),resource.getSchema()});
	    }
        // end-custom-code
	}
}
