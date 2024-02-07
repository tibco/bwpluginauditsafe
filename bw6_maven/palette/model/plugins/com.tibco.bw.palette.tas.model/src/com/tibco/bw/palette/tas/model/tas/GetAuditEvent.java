/**
 */
package com.tibco.bw.palette.tas.model.tas;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Get Audit Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.tibco.bw.palette.tas.model.tas.GetAuditEvent#getSortColumn <em>Sort Column</em>}</li>
 *   <li>{@link com.tibco.bw.palette.tas.model.tas.GetAuditEvent#isDescOrder <em>Desc Order</em>}</li>
 *   <li>{@link com.tibco.bw.palette.tas.model.tas.GetAuditEvent#isExactMatch <em>Exact Match</em>}</li>
 *   <li>{@link com.tibco.bw.palette.tas.model.tas.GetAuditEvent#isIncludePayload <em>Include Payload</em>}</li>
 *   <li>{@link com.tibco.bw.palette.tas.model.tas.GetAuditEvent#getLimit <em>Limit</em>}</li>
 *   <li>{@link com.tibco.bw.palette.tas.model.tas.GetAuditEvent#isOnlyGetCount <em>Only Get Count</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.tibco.bw.palette.tas.model.tas.TasPackage#getGetAuditEvent()
 * @model
 * @generated
 */
public interface GetAuditEvent extends TasAbstractObject {
	/**
	 * Returns the value of the '<em><b>Sort Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sort Column</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sort Column</em>' attribute.
	 * @see #setSortColumn(String)
	 * @see com.tibco.bw.palette.tas.model.tas.TasPackage#getGetAuditEvent_SortColumn()
	 * @model
	 * @generated
	 */
	String getSortColumn();

	/**
	 * Sets the value of the '{@link com.tibco.bw.palette.tas.model.tas.GetAuditEvent#getSortColumn <em>Sort Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sort Column</em>' attribute.
	 * @see #getSortColumn()
	 * @generated
	 */
	void setSortColumn(String value);

	/**
	 * Returns the value of the '<em><b>Desc Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Desc Order</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Desc Order</em>' attribute.
	 * @see #setDescOrder(boolean)
	 * @see com.tibco.bw.palette.tas.model.tas.TasPackage#getGetAuditEvent_DescOrder()
	 * @model
	 * @generated
	 */
	boolean isDescOrder();

	/**
	 * Sets the value of the '{@link com.tibco.bw.palette.tas.model.tas.GetAuditEvent#isDescOrder <em>Desc Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Desc Order</em>' attribute.
	 * @see #isDescOrder()
	 * @generated
	 */
	void setDescOrder(boolean value);

	/**
	 * Returns the value of the '<em><b>Exact Match</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exact Match</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exact Match</em>' attribute.
	 * @see #setExactMatch(boolean)
	 * @see com.tibco.bw.palette.tas.model.tas.TasPackage#getGetAuditEvent_ExactMatch()
	 * @model
	 * @generated
	 */
	boolean isExactMatch();

	/**
	 * Sets the value of the '{@link com.tibco.bw.palette.tas.model.tas.GetAuditEvent#isExactMatch <em>Exact Match</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exact Match</em>' attribute.
	 * @see #isExactMatch()
	 * @generated
	 */
	void setExactMatch(boolean value);

	/**
	 * Returns the value of the '<em><b>Include Payload</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Include Payload</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Include Payload</em>' attribute.
	 * @see #setIncludePayload(boolean)
	 * @see com.tibco.bw.palette.tas.model.tas.TasPackage#getGetAuditEvent_IncludePayload()
	 * @model
	 * @generated
	 */
	boolean isIncludePayload();

	/**
	 * Sets the value of the '{@link com.tibco.bw.palette.tas.model.tas.GetAuditEvent#isIncludePayload <em>Include Payload</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Include Payload</em>' attribute.
	 * @see #isIncludePayload()
	 * @generated
	 */
	void setIncludePayload(boolean value);

	/**
	 * Returns the value of the '<em><b>Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Limit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Limit</em>' attribute.
	 * @see #setLimit(int)
	 * @see com.tibco.bw.palette.tas.model.tas.TasPackage#getGetAuditEvent_Limit()
	 * @model
	 * @generated
	 */
	int getLimit();

	/**
	 * Sets the value of the '{@link com.tibco.bw.palette.tas.model.tas.GetAuditEvent#getLimit <em>Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Limit</em>' attribute.
	 * @see #getLimit()
	 * @generated
	 */
	void setLimit(int value);

	/**
	 * Returns the value of the '<em><b>Only Get Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Only Get Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Only Get Count</em>' attribute.
	 * @see #setOnlyGetCount(boolean)
	 * @see com.tibco.bw.palette.tas.model.tas.TasPackage#getGetAuditEvent_OnlyGetCount()
	 * @model
	 * @generated
	 */
	boolean isOnlyGetCount();

	/**
	 * Sets the value of the '{@link com.tibco.bw.palette.tas.model.tas.GetAuditEvent#isOnlyGetCount <em>Only Get Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Only Get Count</em>' attribute.
	 * @see #isOnlyGetCount()
	 * @generated
	 */
	void setOnlyGetCount(boolean value);

} // GetAuditEvent
