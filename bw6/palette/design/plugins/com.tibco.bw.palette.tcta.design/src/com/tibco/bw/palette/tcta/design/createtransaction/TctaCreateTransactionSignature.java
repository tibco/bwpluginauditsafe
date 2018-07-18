package com.tibco.bw.palette.tcta.design.createtransaction;

import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDSchema;

import com.tibco.bw.design.api.BWActivitySignatureUnknown;
import com.tibco.bw.design.util.XSDUtility;
import com.tibco.bw.model.activityconfig.Configuration;
import com.tibco.bw.palette.tcta.design.TctaBasicSignature;
import com.tibco.bw.palette.tcta.design.TctaConstants;
import com.tibco.bw.palette.tcta.model.tcta.TctaCreateTransaction;

public class TctaCreateTransactionSignature extends TctaBasicSignature {
	private static final String SCHEMA_INPUT_ROOT_NAME = "createTransactionInput";

	private static final String SCHEMA_OUTPUT_ROOT_NAME = "createTransactionOutput";

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
		return TctaBasicSignature.BASIC_NS + SCHEMA_INPUT_ROOT_NAME;
	}

	@Override
	public String getoutputTargetNamespace() {

		return TctaBasicSignature.BASIC_NS + SCHEMA_OUTPUT_ROOT_NAME;
	}

	@Override
	public void constructInputType(XSDModelGroup activityInput,
			XSDSchema inputSchema) {
	}

	@Override
	public XSDElementDeclaration getInputType(Configuration config)
			throws BWActivitySignatureUnknown {

		TctaCreateTransaction createTransaction = (TctaCreateTransaction) getDefaultEMFConfigObject(config);

		if (createTransaction != null
				&& !"".equals(createTransaction.getTctaConnection())) {

			String namespace = createNamespace(new Object[] { BASIC_NS,
					SCHEMA_INPUT_ROOT_NAME});
			return super.buildInputType(namespace,
					createTransaction.getTctaConnection(), createTransaction);

		}
		return null;

	}

	@Override
	public void constructOutputType(XSDModelGroup rootOutPut,
			XSDSchema inputSchema) {
		XSDUtility.addSimpleTypeElement(rootOutPut, TctaConstants.RESPONSE,
				"string", 1, 1);
	}

}
