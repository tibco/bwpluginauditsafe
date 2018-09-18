package com.tibco.bw.palette.tas.design.postauditevent;

import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDSchema;

import com.tibco.bw.design.api.BWActivitySignatureUnknown;
import com.tibco.bw.design.util.XSDUtility;
import com.tibco.bw.model.activityconfig.Configuration;
import com.tibco.bw.palette.tas.design.TasBasicSignature;
import com.tibco.bw.palette.tas.design.TasConstants;
import com.tibco.bw.palette.tas.model.tas.PostAuditEvent;

public class PostAuditEventSignature extends TasBasicSignature {
	private static final String SCHEMA_INPUT_ROOT_NAME = "postAuditEventInput";

	private static final String SCHEMA_OUTPUT_ROOT_NAME = "postAuditEventOutput";

	@Override
	public boolean hasInput() {
		return true;
	}

	@Override
	public boolean hasOutput() {
		return true;
	}

	@Override
	public String getInputTargetNamespace() {
		return TasBasicSignature.BASIC_NS + SCHEMA_INPUT_ROOT_NAME;
	}

	@Override
	public String getoutputTargetNamespace() {

		return TasBasicSignature.BASIC_NS + SCHEMA_OUTPUT_ROOT_NAME;
	}

	@Override
	public void constructInputType(XSDModelGroup activityInput,
			XSDSchema inputSchema) {
	}

	@Override
	public XSDElementDeclaration getInputType(Configuration config)
			throws BWActivitySignatureUnknown {

		PostAuditEvent postAuditEvent = (PostAuditEvent) getDefaultEMFConfigObject(config);

		if (postAuditEvent != null
				&& !"".equals(postAuditEvent.getTasConnection())) {

			String namespace = createNamespace(new Object[] { BASIC_NS,
					SCHEMA_INPUT_ROOT_NAME});
			return super.buildInputType(namespace,
					postAuditEvent.getTasConnection(), postAuditEvent);

		}
		return null;

	}

	@Override
	public void constructOutputType(XSDModelGroup rootOutPut,
			XSDSchema inputSchema) {
		XSDUtility.addSimpleTypeElement(rootOutPut, TasConstants.RESPONSE,
				"string", 1, 1);
	}

}
