package com.tibco.bw.palette.tcta.design;


import org.eclipse.emf.ecore.EStructuralFeature;

import com.tibco.bw.design.api.BWAbstractModelHelper;

public abstract class TctaBasicModelHelper extends BWAbstractModelHelper {
	
	
	

	public boolean notifyReferenceUpdate(Object modelObject, String propertyName) {
		return true;
	}
	
	public boolean notifyOnModification(EStructuralFeature feature) {
		return true;
	}

}
