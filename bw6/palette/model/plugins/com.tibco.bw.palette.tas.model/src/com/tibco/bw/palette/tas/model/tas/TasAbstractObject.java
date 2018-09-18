/**
 */
package com.tibco.bw.palette.tas.model.tas;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.tibco.bw.palette.tas.model.tas.TasAbstractObject#getTasConnection <em>Tas Connection</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.tibco.bw.palette.tas.model.tas.TasPackage#getTasAbstractObject()
 * @model abstract="true"
 * @generated
 */
public interface TasAbstractObject extends EObject {
	/**
	 * Returns the value of the '<em><b>Tas Connection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tas Connection</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tas Connection</em>' attribute.
	 * @see #setTasConnection(String)
	 * @see com.tibco.bw.palette.tas.model.tas.TasPackage#getTasAbstractObject_TasConnection()
	 * @model
	 * @generated
	 */
	String getTasConnection();

	/**
	 * Sets the value of the '{@link com.tibco.bw.palette.tas.model.tas.TasAbstractObject#getTasConnection <em>Tas Connection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tas Connection</em>' attribute.
	 * @see #getTasConnection()
	 * @generated
	 */
	void setTasConnection(String value);

} // TasAbstractObject
