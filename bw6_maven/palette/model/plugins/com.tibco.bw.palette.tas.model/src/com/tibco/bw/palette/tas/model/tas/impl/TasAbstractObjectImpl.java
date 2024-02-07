/**
 */
package com.tibco.bw.palette.tas.model.tas.impl;

import com.tibco.bw.palette.tas.model.tas.TasAbstractObject;
import com.tibco.bw.palette.tas.model.tas.TasPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.tibco.bw.palette.tas.model.tas.impl.TasAbstractObjectImpl#getTasConnection <em>Tas Connection</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class TasAbstractObjectImpl extends EObjectImpl implements TasAbstractObject {
	/**
	 * The default value of the '{@link #getTasConnection() <em>Tas Connection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTasConnection()
	 * @generated
	 * @ordered
	 */
	protected static final String TAS_CONNECTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTasConnection() <em>Tas Connection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTasConnection()
	 * @generated
	 * @ordered
	 */
	protected String tasConnection = TAS_CONNECTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TasAbstractObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TasPackage.Literals.TAS_ABSTRACT_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTasConnection() {
		return tasConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTasConnection(String newTasConnection) {
		String oldTasConnection = tasConnection;
		tasConnection = newTasConnection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TasPackage.TAS_ABSTRACT_OBJECT__TAS_CONNECTION, oldTasConnection, tasConnection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TasPackage.TAS_ABSTRACT_OBJECT__TAS_CONNECTION:
				return getTasConnection();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TasPackage.TAS_ABSTRACT_OBJECT__TAS_CONNECTION:
				setTasConnection((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TasPackage.TAS_ABSTRACT_OBJECT__TAS_CONNECTION:
				setTasConnection(TAS_CONNECTION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TasPackage.TAS_ABSTRACT_OBJECT__TAS_CONNECTION:
				return TAS_CONNECTION_EDEFAULT == null ? tasConnection != null : !TAS_CONNECTION_EDEFAULT.equals(tasConnection);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (tasConnection: ");
		result.append(tasConnection);
		result.append(')');
		return result.toString();
	}

} //TasAbstractObjectImpl
