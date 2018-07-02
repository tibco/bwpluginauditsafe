package com.tibco.bw.palette.tcta.design.createtransaction;

import org.eclipse.emf.ecore.EObject;

import com.tibco.bw.design.api.BWAbstractModelHelper;
import com.tibco.bw.palette.tcta.model.tcta.TctaFactory;
import com.tibco.bw.palette.tcta.model.tcta.TctaCreateTransaction;

public class TctaCreateTransactionModelHelper extends BWAbstractModelHelper {

	/**
	* <!-- begin-custom-doc -->
	*
	* <!-- end-custom-doc -->
	* @generated
	*/
    @Override
    public EObject createInstance() {
        TctaCreateTransaction activity = TctaFactory.eINSTANCE.createTctaCreateTransaction();
        // begin-custom-code
        // end-custom-code
        return activity;
    }
}
