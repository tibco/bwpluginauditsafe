package com.tibco.bw.palette.tas.runtime.fault;

import javax.xml.namespace.QName;

import com.tibco.bw.runtime.ActivityContext;
import com.tibco.bw.runtime.ActivityFault;

public class TasActivityFault extends ActivityFault {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public <N> TasActivityFault(ActivityContext<N> activityContext, int code, String message) {
		super(activityContext, String.valueOf(code), message);
	}

	@Override
	public QName getFaultElementQName() {
		return new QName("http://schemas.tibco.com/bw/plugins/tas/6.0/TASPluginExceptions", "TASPluginExceptions");
	}

}
