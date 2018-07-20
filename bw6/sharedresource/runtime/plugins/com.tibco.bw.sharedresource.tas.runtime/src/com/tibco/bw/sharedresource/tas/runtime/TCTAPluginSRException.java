package com.tibco.bw.sharedresource.tas.runtime;

import com.tibco.bw.sharedresource.runtime.configuration.SharedResourceLifeCycleFault;
import com.tibco.neo.localized.LocalizedMessage;

public class TCTAPluginSRException extends SharedResourceLifeCycleFault {
	
	private static final long serialVersionUID = 2636520260592532723L;

	public TCTAPluginSRException(LocalizedMessage message, Throwable e) {
        super(message, e);
    }
    
    public TCTAPluginSRException(LocalizedMessage message) {
        super(message);
    }
}
