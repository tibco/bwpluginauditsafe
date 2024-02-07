/**
 */
package com.tibco.bw.palette.tas.model.tas;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.tibco.bw.palette.tas.model.tas.TasPackage
 * @generated
 */
public interface TasFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TasFactory eINSTANCE = com.tibco.bw.palette.tas.model.tas.impl.TasFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Post Audit Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Post Audit Event</em>'.
	 * @generated
	 */
	PostAuditEvent createPostAuditEvent();

	/**
	 * Returns a new object of class '<em>Put Audit Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Put Audit Event</em>'.
	 * @generated
	 */
	PutAuditEvent createPutAuditEvent();

	/**
	 * Returns a new object of class '<em>Post Batch Audit Events</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Post Batch Audit Events</em>'.
	 * @generated
	 */
	PostBatchAuditEvents createPostBatchAuditEvents();

	/**
	 * Returns a new object of class '<em>Get Audit Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Audit Event</em>'.
	 * @generated
	 */
	GetAuditEvent createGetAuditEvent();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TasPackage getTasPackage();

} //TasFactory
