package com.tibco.bw.palette.tas.design.createtransaction;

import org.eclipse.emf.ecore.EObject;

import com.tibco.bw.design.api.BWAbstractModelHelper;
import com.tibco.bw.design.util.ModelHelper;
import com.tibco.bw.design.util.ProcessProperty;
import com.tibco.bw.palette.tas.design.TctaConstants;
import com.tibco.bw.palette.tas.model.tas.TctaCreateTransaction;
import com.tibco.bw.palette.tas.model.tas.TctaFactory;

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

    public void postCreate(EObject model, Object container) {
		if (model == null)     {  return;  }
		if (container == null) {  return; }
		boolean found = false;
		for (ProcessProperty property : ModelHelper.INSTANCE.getProperties(container)) {
			if (ModelHelper.INSTANCE.isEqual(property.getType(), TctaConstants.SHAREDRESOURCE_QNAME)) {
				((TctaCreateTransaction) model).setTctaConnection(property.getName());
				found = true;
				break;
			}
		}

		if (!found) {
			ProcessProperty property = ModelHelper.INSTANCE.createProperty(container, "tasConnectionProperty", TctaConstants.SHAREDRESOURCE_QNAME, "");
			if (property != null) {
				((TctaCreateTransaction) model).setTctaConnection(property.getName());
			}
		}

	}
}
