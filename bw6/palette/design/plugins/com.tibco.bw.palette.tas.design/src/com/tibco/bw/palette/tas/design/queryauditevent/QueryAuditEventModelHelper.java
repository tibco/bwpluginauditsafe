package com.tibco.bw.palette.tas.design.queryauditevent;

import org.eclipse.emf.ecore.EObject;

import com.tibco.bw.design.api.BWAbstractModelHelper;
import com.tibco.bw.design.util.ModelHelper;
import com.tibco.bw.design.util.ProcessProperty;
import com.tibco.bw.palette.tas.design.TasConstants;
import com.tibco.bw.palette.tas.model.tas.QueryAuditEvent;
import com.tibco.bw.palette.tas.model.tas.TasFactory;

public class QueryAuditEventModelHelper extends BWAbstractModelHelper {

	/**
	* <!-- begin-custom-doc -->
	*
	* <!-- end-custom-doc -->
	* @generated
	*/
    @Override
    public EObject createInstance() {
    	QueryAuditEvent activity = TasFactory.eINSTANCE.createQueryAuditEvent();
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
				((QueryAuditEvent) model).setTasConnection(property.getName());
				found = true;
				break;
			}
		}

		if (!found) {
			ProcessProperty property = ModelHelper.INSTANCE.createProperty(container, "tasConnectionProperty", TasConstants.SHAREDRESOURCE_QNAME, "");
			if (property != null) {
				((QueryAuditEvent) model).setTasConnection(property.getName());
			}
		}

	}
}
