package com.tibco.bw.sharedresource.tas.runtime;

import com.tibco.bw.sharedresource.runtime.configuration.SharedResourceLifeCycleFault;
import com.tibco.neo.localized.LocalizedMessage;

public class TASPluginSRException extends SharedResourceLifeCycleFault {

	private static final long serialVersionUID = 2636520260592532723L;

	public TASPluginSRException(LocalizedMessage message, Throwable e) {
        super(message, e);
    }

    public TASPluginSRException(LocalizedMessage message) {
        super(message);
    }
}
