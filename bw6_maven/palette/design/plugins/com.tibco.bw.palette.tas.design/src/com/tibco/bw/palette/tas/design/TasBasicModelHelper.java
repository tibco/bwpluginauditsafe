package com.tibco.bw.palette.tas.design;


import org.eclipse.emf.ecore.EStructuralFeature;

import com.tibco.bw.design.api.BWAbstractModelHelper;

public abstract class TasBasicModelHelper extends BWAbstractModelHelper {
	
	
	

	public boolean notifyReferenceUpdate(Object modelObject, String propertyName) {
		return true;
	}
	
	public boolean notifyOnModification(EStructuralFeature feature) {
		return true;
	}

}
