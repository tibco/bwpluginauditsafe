package com.tibco.bw.palette.tcta.design.upsertrow;

import org.eclipse.emf.ecore.EObject;

import com.tibco.bw.design.api.BWAbstractModelHelper;
import com.tibco.bw.palette.tcta.model.tcta.TctaFactory;
import com.tibco.bw.palette.tcta.model.tcta.UpsertRow;

public class UpsertRowModelHelper extends BWAbstractModelHelper {

	/**
	* <!-- begin-custom-doc -->
	*
	* <!-- end-custom-doc -->
	* @generated
	*/
    @Override
    public EObject createInstance() {
        UpsertRow activity = TctaFactory.eINSTANCE.createUpsertRow();
        // begin-custom-code
        // end-custom-code
        return activity;
    }
}
