/**
 */
package com.tibco.bw.palette.tas.model.tas;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.tibco.bw.palette.tas.model.tas.TasFactory
 * @model kind="package"
 * @generated
 */
public interface TasPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "tas";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://ns.tibco.com/bw/palette/tas";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "tas";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TasPackage eINSTANCE = com.tibco.bw.palette.tas.model.tas.impl.TasPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.tibco.bw.palette.tas.model.tas.impl.TasAbstractObjectImpl <em>Abstract Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.tibco.bw.palette.tas.model.tas.impl.TasAbstractObjectImpl
	 * @see com.tibco.bw.palette.tas.model.tas.impl.TasPackageImpl#getTasAbstractObject()
	 * @generated
	 */
	int TAS_ABSTRACT_OBJECT = 0;

	/**
	 * The feature id for the '<em><b>Tas Connection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAS_ABSTRACT_OBJECT__TAS_CONNECTION = 0;

	/**
	 * The number of structural features of the '<em>Abstract Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAS_ABSTRACT_OBJECT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.tibco.bw.palette.tas.model.tas.impl.PostAuditEventImpl <em>Post Audit Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.tibco.bw.palette.tas.model.tas.impl.PostAuditEventImpl
	 * @see com.tibco.bw.palette.tas.model.tas.impl.TasPackageImpl#getPostAuditEvent()
	 * @generated
	 */
	int POST_AUDIT_EVENT = 1;

	/**
	 * The feature id for the '<em><b>Tas Connection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_AUDIT_EVENT__TAS_CONNECTION = TAS_ABSTRACT_OBJECT__TAS_CONNECTION;

	/**
	 * The number of structural features of the '<em>Post Audit Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_AUDIT_EVENT_FEATURE_COUNT = TAS_ABSTRACT_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.tibco.bw.palette.tas.model.tas.impl.PutAuditEventImpl <em>Put Audit Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.tibco.bw.palette.tas.model.tas.impl.PutAuditEventImpl
	 * @see com.tibco.bw.palette.tas.model.tas.impl.TasPackageImpl#getPutAuditEvent()
	 * @generated
	 */
	int PUT_AUDIT_EVENT = 2;

	/**
	 * The feature id for the '<em><b>Tas Connection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUT_AUDIT_EVENT__TAS_CONNECTION = TAS_ABSTRACT_OBJECT__TAS_CONNECTION;

	/**
	 * The number of structural features of the '<em>Put Audit Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUT_AUDIT_EVENT_FEATURE_COUNT = TAS_ABSTRACT_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.tibco.bw.palette.tas.model.tas.impl.PostBatchAuditEventsImpl <em>Post Batch Audit Events</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.tibco.bw.palette.tas.model.tas.impl.PostBatchAuditEventsImpl
	 * @see com.tibco.bw.palette.tas.model.tas.impl.TasPackageImpl#getPostBatchAuditEvents()
	 * @generated
	 */
	int POST_BATCH_AUDIT_EVENTS = 3;

	/**
	 * The feature id for the '<em><b>Tas Connection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_BATCH_AUDIT_EVENTS__TAS_CONNECTION = TAS_ABSTRACT_OBJECT__TAS_CONNECTION;

	/**
	 * The number of structural features of the '<em>Post Batch Audit Events</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_BATCH_AUDIT_EVENTS_FEATURE_COUNT = TAS_ABSTRACT_OBJECT_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link com.tibco.bw.palette.tas.model.tas.impl.GetAuditEventImpl <em>Get Audit Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.tibco.bw.palette.tas.model.tas.impl.GetAuditEventImpl
	 * @see com.tibco.bw.palette.tas.model.tas.impl.TasPackageImpl#getGetAuditEvent()
	 * @generated
	 */
	int GET_AUDIT_EVENT = 4;

	/**
	 * The feature id for the '<em><b>Tas Connection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_AUDIT_EVENT__TAS_CONNECTION = TAS_ABSTRACT_OBJECT__TAS_CONNECTION;

	/**
	 * The feature id for the '<em><b>Sort Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_AUDIT_EVENT__SORT_COLUMN = TAS_ABSTRACT_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Desc Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_AUDIT_EVENT__DESC_ORDER = TAS_ABSTRACT_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Exact Match</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_AUDIT_EVENT__EXACT_MATCH = TAS_ABSTRACT_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Include Payload</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_AUDIT_EVENT__INCLUDE_PAYLOAD = TAS_ABSTRACT_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_AUDIT_EVENT__LIMIT = TAS_ABSTRACT_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Only Get Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_AUDIT_EVENT__ONLY_GET_COUNT = TAS_ABSTRACT_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Get Audit Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_AUDIT_EVENT_FEATURE_COUNT = TAS_ABSTRACT_OBJECT_FEATURE_COUNT + 6;

	/**
	 * Returns the meta object for class '{@link com.tibco.bw.palette.tas.model.tas.TasAbstractObject <em>Abstract Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Object</em>'.
	 * @see com.tibco.bw.palette.tas.model.tas.TasAbstractObject
	 * @generated
	 */
	EClass getTasAbstractObject();

	/**
	 * Returns the meta object for the attribute '{@link com.tibco.bw.palette.tas.model.tas.TasAbstractObject#getTasConnection <em>Tas Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tas Connection</em>'.
	 * @see com.tibco.bw.palette.tas.model.tas.TasAbstractObject#getTasConnection()
	 * @see #getTasAbstractObject()
	 * @generated
	 */
	EAttribute getTasAbstractObject_TasConnection();

	/**
	 * Returns the meta object for class '{@link com.tibco.bw.palette.tas.model.tas.PostAuditEvent <em>Post Audit Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Post Audit Event</em>'.
	 * @see com.tibco.bw.palette.tas.model.tas.PostAuditEvent
	 * @generated
	 */
	EClass getPostAuditEvent();

	/**
	 * Returns the meta object for class '{@link com.tibco.bw.palette.tas.model.tas.PutAuditEvent <em>Put Audit Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Put Audit Event</em>'.
	 * @see com.tibco.bw.palette.tas.model.tas.PutAuditEvent
	 * @generated
	 */
	EClass getPutAuditEvent();

	/**
	 * Returns the meta object for class '{@link com.tibco.bw.palette.tas.model.tas.PostBatchAuditEvents <em>Post Batch Audit Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Post Batch Audit Events</em>'.
	 * @see com.tibco.bw.palette.tas.model.tas.PostBatchAuditEvents
	 * @generated
	 */
	EClass getPostBatchAuditEvents();

	/**
	 * Returns the meta object for class '{@link com.tibco.bw.palette.tas.model.tas.GetAuditEvent <em>Get Audit Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Audit Event</em>'.
	 * @see com.tibco.bw.palette.tas.model.tas.GetAuditEvent
	 * @generated
	 */
	EClass getGetAuditEvent();

	/**
	 * Returns the meta object for the attribute '{@link com.tibco.bw.palette.tas.model.tas.GetAuditEvent#getSortColumn <em>Sort Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sort Column</em>'.
	 * @see com.tibco.bw.palette.tas.model.tas.GetAuditEvent#getSortColumn()
	 * @see #getGetAuditEvent()
	 * @generated
	 */
	EAttribute getGetAuditEvent_SortColumn();

	/**
	 * Returns the meta object for the attribute '{@link com.tibco.bw.palette.tas.model.tas.GetAuditEvent#isDescOrder <em>Desc Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Desc Order</em>'.
	 * @see com.tibco.bw.palette.tas.model.tas.GetAuditEvent#isDescOrder()
	 * @see #getGetAuditEvent()
	 * @generated
	 */
	EAttribute getGetAuditEvent_DescOrder();

	/**
	 * Returns the meta object for the attribute '{@link com.tibco.bw.palette.tas.model.tas.GetAuditEvent#isExactMatch <em>Exact Match</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exact Match</em>'.
	 * @see com.tibco.bw.palette.tas.model.tas.GetAuditEvent#isExactMatch()
	 * @see #getGetAuditEvent()
	 * @generated
	 */
	EAttribute getGetAuditEvent_ExactMatch();

	/**
	 * Returns the meta object for the attribute '{@link com.tibco.bw.palette.tas.model.tas.GetAuditEvent#isIncludePayload <em>Include Payload</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Include Payload</em>'.
	 * @see com.tibco.bw.palette.tas.model.tas.GetAuditEvent#isIncludePayload()
	 * @see #getGetAuditEvent()
	 * @generated
	 */
	EAttribute getGetAuditEvent_IncludePayload();

	/**
	 * Returns the meta object for the attribute '{@link com.tibco.bw.palette.tas.model.tas.GetAuditEvent#getLimit <em>Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Limit</em>'.
	 * @see com.tibco.bw.palette.tas.model.tas.GetAuditEvent#getLimit()
	 * @see #getGetAuditEvent()
	 * @generated
	 */
	EAttribute getGetAuditEvent_Limit();

	/**
	 * Returns the meta object for the attribute '{@link com.tibco.bw.palette.tas.model.tas.GetAuditEvent#isOnlyGetCount <em>Only Get Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Only Get Count</em>'.
	 * @see com.tibco.bw.palette.tas.model.tas.GetAuditEvent#isOnlyGetCount()
	 * @see #getGetAuditEvent()
	 * @generated
	 */
	EAttribute getGetAuditEvent_OnlyGetCount();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TasFactory getTasFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.tibco.bw.palette.tas.model.tas.impl.TasAbstractObjectImpl <em>Abstract Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.tibco.bw.palette.tas.model.tas.impl.TasAbstractObjectImpl
		 * @see com.tibco.bw.palette.tas.model.tas.impl.TasPackageImpl#getTasAbstractObject()
		 * @generated
		 */
		EClass TAS_ABSTRACT_OBJECT = eINSTANCE.getTasAbstractObject();

		/**
		 * The meta object literal for the '<em><b>Tas Connection</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAS_ABSTRACT_OBJECT__TAS_CONNECTION = eINSTANCE.getTasAbstractObject_TasConnection();

		/**
		 * The meta object literal for the '{@link com.tibco.bw.palette.tas.model.tas.impl.PostAuditEventImpl <em>Post Audit Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.tibco.bw.palette.tas.model.tas.impl.PostAuditEventImpl
		 * @see com.tibco.bw.palette.tas.model.tas.impl.TasPackageImpl#getPostAuditEvent()
		 * @generated
		 */
		EClass POST_AUDIT_EVENT = eINSTANCE.getPostAuditEvent();

		/**
		 * The meta object literal for the '{@link com.tibco.bw.palette.tas.model.tas.impl.PutAuditEventImpl <em>Put Audit Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.tibco.bw.palette.tas.model.tas.impl.PutAuditEventImpl
		 * @see com.tibco.bw.palette.tas.model.tas.impl.TasPackageImpl#getPutAuditEvent()
		 * @generated
		 */
		EClass PUT_AUDIT_EVENT = eINSTANCE.getPutAuditEvent();

		/**
		 * The meta object literal for the '{@link com.tibco.bw.palette.tas.model.tas.impl.PostBatchAuditEventsImpl <em>Post Batch Audit Events</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.tibco.bw.palette.tas.model.tas.impl.PostBatchAuditEventsImpl
		 * @see com.tibco.bw.palette.tas.model.tas.impl.TasPackageImpl#getPostBatchAuditEvents()
		 * @generated
		 */
		EClass POST_BATCH_AUDIT_EVENTS = eINSTANCE.getPostBatchAuditEvents();

		/**
		 * The meta object literal for the '{@link com.tibco.bw.palette.tas.model.tas.impl.GetAuditEventImpl <em>Get Audit Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.tibco.bw.palette.tas.model.tas.impl.GetAuditEventImpl
		 * @see com.tibco.bw.palette.tas.model.tas.impl.TasPackageImpl#getGetAuditEvent()
		 * @generated
		 */
		EClass GET_AUDIT_EVENT = eINSTANCE.getGetAuditEvent();

		/**
		 * The meta object literal for the '<em><b>Sort Column</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_AUDIT_EVENT__SORT_COLUMN = eINSTANCE.getGetAuditEvent_SortColumn();

		/**
		 * The meta object literal for the '<em><b>Desc Order</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_AUDIT_EVENT__DESC_ORDER = eINSTANCE.getGetAuditEvent_DescOrder();

		/**
		 * The meta object literal for the '<em><b>Exact Match</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_AUDIT_EVENT__EXACT_MATCH = eINSTANCE.getGetAuditEvent_ExactMatch();

		/**
		 * The meta object literal for the '<em><b>Include Payload</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_AUDIT_EVENT__INCLUDE_PAYLOAD = eINSTANCE.getGetAuditEvent_IncludePayload();

		/**
		 * The meta object literal for the '<em><b>Limit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_AUDIT_EVENT__LIMIT = eINSTANCE.getGetAuditEvent_Limit();

		/**
		 * The meta object literal for the '<em><b>Only Get Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_AUDIT_EVENT__ONLY_GET_COUNT = eINSTANCE.getGetAuditEvent_OnlyGetCount();

	}

} //TasPackage
