package com.tibco.bw.palette.tcta.design;

import org.eclipse.emf.ecore.EObject;

import com.tibco.amf.model.sharedresource.jndi.NamedResource;
import com.tibco.bw.design.util.ModelHelper;
import com.tibco.bw.design.util.ProcessProperty;
import com.tibco.bw.sharedresource.tcta.model.tcta.TctaConnection;

public class SignatureHelper {

	public static TctaConnection getConnectionFromSharedResource(String connection, EObject model) {
		ProcessProperty pProperty = ModelHelper.INSTANCE.getProperty(model, connection);
		String propertyValue = null;
		if (pProperty != null) {
			propertyValue = pProperty.getDefaultValue();
			if (propertyValue != null && !"".equals(propertyValue)) {
				try {
					EObject eo = ModelHelper.INSTANCE.getNamedResource(model, propertyValue);
					if (eo != null && eo instanceof NamedResource) {
						NamedResource nameResource = (NamedResource) eo;
						EObject objectRef = nameResource.getConfiguration();
						TctaConnection conn = (TctaConnection)objectRef;
						return conn;
					}
				} catch (Exception e) {
					System.out.println("load connection error");
				}
			}
		}
		return null;
	}

}
