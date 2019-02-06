/**
 */
package com.tibco.bw.palette.tas.model.tas;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Query Audit Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.tibco.bw.palette.tas.model.tas.QueryAuditEvent#getSort_column <em>Sort column</em>}</li>
 *   <li>{@link com.tibco.bw.palette.tas.model.tas.QueryAuditEvent#isDescOrder <em>Desc Order</em>}</li>
 *   <li>{@link com.tibco.bw.palette.tas.model.tas.QueryAuditEvent#isExact_search <em>Exact search</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.tibco.bw.palette.tas.model.tas.TasPackage#getQueryAuditEvent()
 * @model
 * @generated
 */
public interface QueryAuditEvent extends TasAbstractObject {
	/**
	 * Returns the value of the '<em><b>Sort column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sort column</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sort column</em>' attribute.
	 * @see #setSort_column(String)
	 * @see com.tibco.bw.palette.tas.model.tas.TasPackage#getQueryAuditEvent_Sort_column()
	 * @model
	 * @generated
	 */
	String getSort_column();

	/**
	 * Sets the value of the '{@link com.tibco.bw.palette.tas.model.tas.QueryAuditEvent#getSort_column <em>Sort column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sort column</em>' attribute.
	 * @see #getSort_column()
	 * @generated
	 */
	void setSort_column(String value);

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
	 * @see com.tibco.bw.palette.tas.model.tas.TasPackage#getQueryAuditEvent_DescOrder()
	 * @model
	 * @generated
	 */
	boolean isDescOrder();

	/**
	 * Sets the value of the '{@link com.tibco.bw.palette.tas.model.tas.QueryAuditEvent#isDescOrder <em>Desc Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Desc Order</em>' attribute.
	 * @see #isDescOrder()
	 * @generated
	 */
	void setDescOrder(boolean value);

	/**
	 * Returns the value of the '<em><b>Exact search</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exact search</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exact search</em>' attribute.
	 * @see #setExact_search(boolean)
	 * @see com.tibco.bw.palette.tas.model.tas.TasPackage#getQueryAuditEvent_Exact_search()
	 * @model
	 * @generated
	 */
	boolean isExact_search();

	/**
	 * Sets the value of the '{@link com.tibco.bw.palette.tas.model.tas.QueryAuditEvent#isExact_search <em>Exact search</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exact search</em>' attribute.
	 * @see #isExact_search()
	 * @generated
	 */
	void setExact_search(boolean value);

} // QueryAuditEvent
