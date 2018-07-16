package com.tibco.bw.palette.tcta.design.gettoken;

import org.eclipse.emf.ecore.EObject;

import com.tibco.bw.design.api.BWAbstractModelHelper;
import com.tibco.bw.design.util.ModelHelper;
import com.tibco.bw.design.util.ProcessProperty;
import com.tibco.bw.palette.tcta.design.TctaConstants;
import com.tibco.bw.palette.tcta.model.tcta.TctaFactory;
import com.tibco.bw.palette.tcta.model.tcta.TctaGetToken;



public class TctaGetTokenModelHelper extends BWAbstractModelHelper {

	@Override
	public EObject createInstance() {
        TctaGetToken activity = TctaFactory.eINSTANCE.createTctaGetToken();
        return activity;
	}


	public void postCreate(EObject model, Object container) {
		if (model == null)     {  return;  }
		if (container == null) {  return; }
		boolean found = false;
		for (ProcessProperty property : ModelHelper.INSTANCE.getProperties(container)) {
			if (ModelHelper.INSTANCE.isEqual(property.getType(), TctaConstants.SHAREDRESOURCE_QNAME)) {
				((TctaGetToken) model).setTctaConnection(property.getName());
				found = true;
				break;
			}
		}

		if (!found) {
			ProcessProperty property = ModelHelper.INSTANCE.createProperty(container, "tctaConnectionProperty", TctaConstants.SHAREDRESOURCE_QNAME, "");
			if (property != null) {
				((TctaGetToken) model).setTctaConnection(property.getName());
			}
		}

	}



}
