/**
 */
package com.tibco.bw.palette.tas.model.tas.impl;

import com.tibco.bw.palette.tas.model.tas.GetAuditEvent;
import com.tibco.bw.palette.tas.model.tas.TasPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Get Audit Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.tibco.bw.palette.tas.model.tas.impl.GetAuditEventImpl#getSortColumn <em>Sort Column</em>}</li>
 *   <li>{@link com.tibco.bw.palette.tas.model.tas.impl.GetAuditEventImpl#isDescOrder <em>Desc Order</em>}</li>
 *   <li>{@link com.tibco.bw.palette.tas.model.tas.impl.GetAuditEventImpl#isExactMatch <em>Exact Match</em>}</li>
 *   <li>{@link com.tibco.bw.palette.tas.model.tas.impl.GetAuditEventImpl#isIncludePayload <em>Include Payload</em>}</li>
 *   <li>{@link com.tibco.bw.palette.tas.model.tas.impl.GetAuditEventImpl#getLimit <em>Limit</em>}</li>
 *   <li>{@link com.tibco.bw.palette.tas.model.tas.impl.GetAuditEventImpl#isOnlyGetCount <em>Only Get Count</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GetAuditEventImpl extends TasAbstractObjectImpl implements GetAuditEvent {
	/**
	 * The default value of the '{@link #getSortColumn() <em>Sort Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSortColumn()
	 * @generated
	 * @ordered
	 */
	protected static final String SORT_COLUMN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSortColumn() <em>Sort Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSortColumn()
	 * @generated
	 * @ordered
	 */
	protected String sortColumn = SORT_COLUMN_EDEFAULT;

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
	 * The default value of the '{@link #isExactMatch() <em>Exact Match</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExactMatch()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXACT_MATCH_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExactMatch() <em>Exact Match</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExactMatch()
	 * @generated
	 * @ordered
	 */
	protected boolean exactMatch = EXACT_MATCH_EDEFAULT;

	/**
	 * The default value of the '{@link #isIncludePayload() <em>Include Payload</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIncludePayload()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INCLUDE_PAYLOAD_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIncludePayload() <em>Include Payload</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIncludePayload()
	 * @generated
	 * @ordered
	 */
	protected boolean includePayload = INCLUDE_PAYLOAD_EDEFAULT;

	/**
	 * The default value of the '{@link #getLimit() <em>Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLimit()
	 * @generated
	 * @ordered
	 */
	protected static final int LIMIT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLimit() <em>Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLimit()
	 * @generated
	 * @ordered
	 */
	protected int limit = LIMIT_EDEFAULT;

	/**
	 * The default value of the '{@link #isOnlyGetCount() <em>Only Get Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOnlyGetCount()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ONLY_GET_COUNT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOnlyGetCount() <em>Only Get Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOnlyGetCount()
	 * @generated
	 * @ordered
	 */
	protected boolean onlyGetCount = ONLY_GET_COUNT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GetAuditEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TasPackage.Literals.GET_AUDIT_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSortColumn() {
		return sortColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSortColumn(String newSortColumn) {
		String oldSortColumn = sortColumn;
		sortColumn = newSortColumn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TasPackage.GET_AUDIT_EVENT__SORT_COLUMN, oldSortColumn, sortColumn));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TasPackage.GET_AUDIT_EVENT__DESC_ORDER, oldDescOrder, descOrder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExactMatch() {
		return exactMatch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExactMatch(boolean newExactMatch) {
		boolean oldExactMatch = exactMatch;
		exactMatch = newExactMatch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TasPackage.GET_AUDIT_EVENT__EXACT_MATCH, oldExactMatch, exactMatch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIncludePayload() {
		return includePayload;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncludePayload(boolean newIncludePayload) {
		boolean oldIncludePayload = includePayload;
		includePayload = newIncludePayload;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TasPackage.GET_AUDIT_EVENT__INCLUDE_PAYLOAD, oldIncludePayload, includePayload));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLimit() {
		return limit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLimit(int newLimit) {
		int oldLimit = limit;
		limit = newLimit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TasPackage.GET_AUDIT_EVENT__LIMIT, oldLimit, limit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOnlyGetCount() {
		return onlyGetCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnlyGetCount(boolean newOnlyGetCount) {
		boolean oldOnlyGetCount = onlyGetCount;
		onlyGetCount = newOnlyGetCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TasPackage.GET_AUDIT_EVENT__ONLY_GET_COUNT, oldOnlyGetCount, onlyGetCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TasPackage.GET_AUDIT_EVENT__SORT_COLUMN:
				return getSortColumn();
			case TasPackage.GET_AUDIT_EVENT__DESC_ORDER:
				return isDescOrder();
			case TasPackage.GET_AUDIT_EVENT__EXACT_MATCH:
				return isExactMatch();
			case TasPackage.GET_AUDIT_EVENT__INCLUDE_PAYLOAD:
				return isIncludePayload();
			case TasPackage.GET_AUDIT_EVENT__LIMIT:
				return getLimit();
			case TasPackage.GET_AUDIT_EVENT__ONLY_GET_COUNT:
				return isOnlyGetCount();
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
			case TasPackage.GET_AUDIT_EVENT__SORT_COLUMN:
				setSortColumn((String)newValue);
				return;
			case TasPackage.GET_AUDIT_EVENT__DESC_ORDER:
				setDescOrder((Boolean)newValue);
				return;
			case TasPackage.GET_AUDIT_EVENT__EXACT_MATCH:
				setExactMatch((Boolean)newValue);
				return;
			case TasPackage.GET_AUDIT_EVENT__INCLUDE_PAYLOAD:
				setIncludePayload((Boolean)newValue);
				return;
			case TasPackage.GET_AUDIT_EVENT__LIMIT:
				setLimit((Integer)newValue);
				return;
			case TasPackage.GET_AUDIT_EVENT__ONLY_GET_COUNT:
				setOnlyGetCount((Boolean)newValue);
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
			case TasPackage.GET_AUDIT_EVENT__SORT_COLUMN:
				setSortColumn(SORT_COLUMN_EDEFAULT);
				return;
			case TasPackage.GET_AUDIT_EVENT__DESC_ORDER:
				setDescOrder(DESC_ORDER_EDEFAULT);
				return;
			case TasPackage.GET_AUDIT_EVENT__EXACT_MATCH:
				setExactMatch(EXACT_MATCH_EDEFAULT);
				return;
			case TasPackage.GET_AUDIT_EVENT__INCLUDE_PAYLOAD:
				setIncludePayload(INCLUDE_PAYLOAD_EDEFAULT);
				return;
			case TasPackage.GET_AUDIT_EVENT__LIMIT:
				setLimit(LIMIT_EDEFAULT);
				return;
			case TasPackage.GET_AUDIT_EVENT__ONLY_GET_COUNT:
				setOnlyGetCount(ONLY_GET_COUNT_EDEFAULT);
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
			case TasPackage.GET_AUDIT_EVENT__SORT_COLUMN:
				return SORT_COLUMN_EDEFAULT == null ? sortColumn != null : !SORT_COLUMN_EDEFAULT.equals(sortColumn);
			case TasPackage.GET_AUDIT_EVENT__DESC_ORDER:
				return descOrder != DESC_ORDER_EDEFAULT;
			case TasPackage.GET_AUDIT_EVENT__EXACT_MATCH:
				return exactMatch != EXACT_MATCH_EDEFAULT;
			case TasPackage.GET_AUDIT_EVENT__INCLUDE_PAYLOAD:
				return includePayload != INCLUDE_PAYLOAD_EDEFAULT;
			case TasPackage.GET_AUDIT_EVENT__LIMIT:
				return limit != LIMIT_EDEFAULT;
			case TasPackage.GET_AUDIT_EVENT__ONLY_GET_COUNT:
				return onlyGetCount != ONLY_GET_COUNT_EDEFAULT;
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
		result.append(" (sortColumn: ");
		result.append(sortColumn);
		result.append(", descOrder: ");
		result.append(descOrder);
		result.append(", exactMatch: ");
		result.append(exactMatch);
		result.append(", includePayload: ");
		result.append(includePayload);
		result.append(", limit: ");
		result.append(limit);
		result.append(", onlyGetCount: ");
		result.append(onlyGetCount);
		result.append(')');
		return result.toString();
	}

} //GetAuditEventImpl
