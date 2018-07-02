package com.tibco.bw.palette.tcta.design.gettoken;

import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDSchema;

import com.tibco.bw.design.util.XSDUtility;
import com.tibco.bw.palette.tcta.design.TctaConstants;
import com.tibco.bw.palette.tcta.design.TctaBasicSignature;




public class TctaGetTokenSignature extends TctaBasicSignature {
  //  private static final String CREATE_INPUT_TYPE_ELEMENT_NAME = "gettoken"; //$NON-NLS-1$

    private static final String SCHEMA_INPUT_ROOT_NAME = "gettokenInput";

    private   final String SCHEMA_OUTPUT_ROOT_NAME = "gettokenOutput";


    @Override
    public boolean hasInput() {
        return false;
    }

    @Override
    public boolean hasOutput() {
        return true;
    }

	@Override
	public String getInputTargetNamespace() {
		return TctaBasicSignature.BASIC_NS+SCHEMA_INPUT_ROOT_NAME;
	}

	@Override
	public String getoutputTargetNamespace() {

		return TctaBasicSignature.BASIC_NS+SCHEMA_OUTPUT_ROOT_NAME;
	}



	@Override
	public void constructInputType(XSDModelGroup activityInput,
			XSDSchema inputSchema) {

	}

	@Override
	public void constructOutputType(XSDModelGroup rootOutPut,
			XSDSchema inputSchema) {
		XSDUtility.addSimpleTypeElement(rootOutPut, TctaConstants.TOKEN, "string", 1, 1);
	}



}
