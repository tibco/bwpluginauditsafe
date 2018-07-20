/**
 */
package com.tibco.bw.palette.tas.model.tas.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.tibco.bw.palette.tas.model.tas.TctaAbstractObject;
import com.tibco.bw.palette.tas.model.tas.TctaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.tibco.bw.palette.tas.model.tas.impl.TctaAbstractObjectImpl#getTctaConnection <em>Tcta Connection</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class TctaAbstractObjectImpl extends EObjectImpl implements TctaAbstractObject {
	/**
	 * The default value of the '{@link #getTctaConnection() <em>Tcta Connection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTctaConnection()
	 * @generated
	 * @ordered
	 */
	protected static final String TCTA_CONNECTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTctaConnection() <em>Tcta Connection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTctaConnection()
	 * @generated
	 * @ordered
	 */
	protected String tasConnection = TCTA_CONNECTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TctaAbstractObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TctaPackage.Literals.TCTA_ABSTRACT_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTctaConnection() {
		return tasConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTctaConnection(String newTctaConnection) {
		String oldTctaConnection = tasConnection;
		tasConnection = newTctaConnection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TctaPackage.TCTA_ABSTRACT_OBJECT__TCTA_CONNECTION, oldTctaConnection, tasConnection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TctaPackage.TCTA_ABSTRACT_OBJECT__TCTA_CONNECTION:
				return getTctaConnection();
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
			case TctaPackage.TCTA_ABSTRACT_OBJECT__TCTA_CONNECTION:
				setTctaConnection((String)newValue);
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
			case TctaPackage.TCTA_ABSTRACT_OBJECT__TCTA_CONNECTION:
				setTctaConnection(TCTA_CONNECTION_EDEFAULT);
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
			case TctaPackage.TCTA_ABSTRACT_OBJECT__TCTA_CONNECTION:
				return TCTA_CONNECTION_EDEFAULT == null ? tasConnection != null : !TCTA_CONNECTION_EDEFAULT.equals(tasConnection);
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

} //TctaAbstractObjectImpl
