package com.tibco.bw.palette.tas.design.postauditevent;

import org.eclipse.emf.ecore.EObject;

import com.tibco.bw.design.api.BWAbstractModelHelper;
import com.tibco.bw.design.util.ModelHelper;
import com.tibco.bw.design.util.ProcessProperty;
import com.tibco.bw.palette.tas.design.TasConstants;
import com.tibco.bw.palette.tas.model.tas.PostAuditEvent;
import com.tibco.bw.palette.tas.model.tas.TasFactory;

public class PostAuditEventModelHelper extends BWAbstractModelHelper {

	/**
	* <!-- begin-custom-doc -->
	*
	* <!-- end-custom-doc -->
	* @generated
	*/
    @Override
    public EObject createInstance() {
    	PostAuditEvent activity = TasFactory.eINSTANCE.createPostAuditEvent();
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
				((PostAuditEvent) model).setTasConnection(property.getName());
				found = true;
				break;
			}
		}

		if (!found) {
			ProcessProperty property = ModelHelper.INSTANCE.createProperty(container, "tasConnectionProperty", TasConstants.SHAREDRESOURCE_QNAME, "");
			if (property != null) {
				((PostAuditEvent) model).setTasConnection(property.getName());
			}
		}

	}
}
