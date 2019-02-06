/**
 */
package com.tibco.bw.palette.tas.model.tas.impl;

import com.tibco.bw.palette.tas.model.tas.QueryAuditEvent;
import com.tibco.bw.palette.tas.model.tas.TasPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Query Audit Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.tibco.bw.palette.tas.model.tas.impl.QueryAuditEventImpl#getSort_column <em>Sort column</em>}</li>
 *   <li>{@link com.tibco.bw.palette.tas.model.tas.impl.QueryAuditEventImpl#isDescOrder <em>Desc Order</em>}</li>
 *   <li>{@link com.tibco.bw.palette.tas.model.tas.impl.QueryAuditEventImpl#isExact_search <em>Exact search</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QueryAuditEventImpl extends TasAbstractObjectImpl implements QueryAuditEvent {
	/**
	 * The default value of the '{@link #getSort_column() <em>Sort column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSort_column()
	 * @generated
	 * @ordered
	 */
	protected static final String SORT_COLUMN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSort_column() <em>Sort column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSort_column()
	 * @generated
	 * @ordered
	 */
	protected String sort_column = SORT_COLUMN_EDEFAULT;

	/**
	 * The default value of the '{@link #isDescOrder() <em>Desc Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDescOrder()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DESC_ORDER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDescOrder() <em>Desc Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDescOrder()
	 * @generated
	 * @ordered
	 */
	protected boolean descOrder = DESC_ORDER_EDEFAULT;

	/**
	 * The default value of the '{@link #isExact_search() <em>Exact search</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExact_search()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXACT_SEARCH_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExact_search() <em>Exact search</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExact_search()
	 * @generated
	 * @ordered
	 */
	protected boolean exact_search = EXACT_SEARCH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QueryAuditEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TasPackage.Literals.QUERY_AUDIT_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSort_column() {
		return sort_column;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSort_column(String newSort_column) {
		String oldSort_column = sort_column;
		sort_column = newSort_column;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TasPackage.QUERY_AUDIT_EVENT__SORT_COLUMN, oldSort_column, sort_column));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDescOrder() {
		return descOrder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescOrder(boolean newDescOrder) {
		boolean oldDescOrder = descOrder;
		descOrder = newDescOrder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TasPackage.QUERY_AUDIT_EVENT__DESC_ORDER, oldDescOrder, descOrder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExact_search() {
		return exact_search;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExact_search(boolean newExact_search) {
		boolean oldExact_search = exact_search;
		exact_search = newExact_search;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TasPackage.QUERY_AUDIT_EVENT__EXACT_SEARCH, oldExact_search, exact_search));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TasPackage.QUERY_AUDIT_EVENT__SORT_COLUMN:
				return getSort_column();
			case TasPackage.QUERY_AUDIT_EVENT__DESC_ORDER:
				return isDescOrder();
			case TasPackage.QUERY_AUDIT_EVENT__EXACT_SEARCH:
				return isExact_search();
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
			case TasPackage.QUERY_AUDIT_EVENT__SORT_COLUMN:
				setSort_column((String)newValue);
				return;
			case TasPackage.QUERY_AUDIT_EVENT__DESC_ORDER:
				setDescOrder((Boolean)newValue);
				return;
			case TasPackage.QUERY_AUDIT_EVENT__EXACT_SEARCH:
				setExact_search((Boolean)newValue);
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
			case TasPackage.QUERY_AUDIT_EVENT__SORT_COLUMN:
				setSort_column(SORT_COLUMN_EDEFAULT);
				return;
			case TasPackage.QUERY_AUDIT_EVENT__DESC_ORDER:
				setDescOrder(DESC_ORDER_EDEFAULT);
				return;
			case TasPackage.QUERY_AUDIT_EVENT__EXACT_SEARCH:
				setExact_search(EXACT_SEARCH_EDEFAULT);
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
			case TasPackage.QUERY_AUDIT_EVENT__SORT_COLUMN:
				return SORT_COLUMN_EDEFAULT == null ? sort_column != null : !SORT_COLUMN_EDEFAULT.equals(sort_column);
			case TasPackage.QUERY_AUDIT_EVENT__DESC_ORDER:
				return descOrder != DESC_ORDER_EDEFAULT;
			case TasPackage.QUERY_AUDIT_EVENT__EXACT_SEARCH:
				return exact_search != EXACT_SEARCH_EDEFAULT;
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
		result.append(" (sort_column: ");
		result.append(sort_column);
		result.append(", descOrder: ");
		result.append(descOrder);
		result.append(", exact_search: ");
		result.append(exact_search);
		result.append(')');
		return result.toString();
	}

} //QueryAuditEventImpl
