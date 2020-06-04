package com.tibco.bw.palette.tas.design.getauditevent;

import org.eclipse.emf.ecore.EObject;

import com.tibco.bw.design.api.BWAbstractModelHelper;
import com.tibco.bw.design.util.ModelHelper;
import com.tibco.bw.design.util.ProcessProperty;
import com.tibco.bw.palette.tas.model.tas.GetAuditEvent;
import com.tibco.bw.palette.tas.model.tas.TasConstants;
import com.tibco.bw.palette.tas.model.tas.TasFactory;

public class GetAuditEventModelHelper extends BWAbstractModelHelper {

	/**
	* <!-- begin-custom-doc -->
	*
	* <!-- end-custom-doc -->
	* @generated
	*/
    @Override
    public EObject createInstance() {
    	GetAuditEvent activity = TasFactory.eINSTANCE.createGetAuditEvent();
    	//set default limit for 1000, the old activity will have the default value 0.
    	activity.setLimit(1000);
        // begin-custom-code
        // end-custom-code
        return activity;
    }

    public void postCreate(EObject model, Object container) {
		if (model == null)     {  return;  }
		if (container == null) {  return; }
		boolean found = false;
		for (ProcessProperty property : ModelHelper.INSTANCE.getProperties(container)) {
			if (ModelHelper.INSTANCE.isEqual(property.getType(), TasConstants.SHAREDRESOURCE_QNAME)) {
				((GetAuditEvent) model).setTasConnection(property.getName());
				found = true;
				break;
			}
		}

		if (!found) {
			ProcessProperty property = ModelHelper.INSTANCE.createProperty(container, "tasConnectionProperty", TasConstants.SHAREDRESOURCE_QNAME, "");
			if (property != null) {
				((GetAuditEvent) model).setTasConnection(property.getName());
			}
		}

	}
}
