/**
 */
package com.tibco.bw.palette.tas.model.tas.impl;

import com.tibco.bw.palette.tas.model.tas.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TasFactoryImpl extends EFactoryImpl implements TasFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TasFactory init() {
		try {
			TasFactory theTasFactory = (TasFactory)EPackage.Registry.INSTANCE.getEFactory(TasPackage.eNS_URI);
			if (theTasFactory != null) {
				return theTasFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TasFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TasFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case TasPackage.POST_AUDIT_EVENT: return createPostAuditEvent();
			case TasPackage.PUT_AUDIT_EVENT: return createPutAuditEvent();
			case TasPackage.POST_BATCH_AUDIT_EVENTS: return createPostBatchAuditEvents();
			case TasPackage.GET_AUDIT_EVENT: return createGetAuditEvent();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PostAuditEvent createPostAuditEvent() {
		PostAuditEventImpl postAuditEvent = new PostAuditEventImpl();
		return postAuditEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PutAuditEvent createPutAuditEvent() {
		PutAuditEventImpl putAuditEvent = new PutAuditEventImpl();
		return putAuditEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PostBatchAuditEvents createPostBatchAuditEvents() {
		PostBatchAuditEventsImpl postBatchAuditEvents = new PostBatchAuditEventsImpl();
		return postBatchAuditEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GetAuditEvent createGetAuditEvent() {
		GetAuditEventImpl getAuditEvent = new GetAuditEventImpl();
		return getAuditEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TasPackage getTasPackage() {
		return (TasPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TasPackage getPackage() {
		return TasPackage.eINSTANCE;
	}

} //TasFactoryImpl
