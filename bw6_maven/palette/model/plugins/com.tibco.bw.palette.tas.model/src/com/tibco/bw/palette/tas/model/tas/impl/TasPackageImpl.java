/**
 */
package com.tibco.bw.palette.tas.model.tas.impl;

import com.tibco.bw.palette.tas.model.tas.GetAuditEvent;
import com.tibco.bw.palette.tas.model.tas.PostAuditEvent;
import com.tibco.bw.palette.tas.model.tas.PostBatchAuditEvents;
import com.tibco.bw.palette.tas.model.tas.PutAuditEvent;
import com.tibco.bw.palette.tas.model.tas.TasAbstractObject;
import com.tibco.bw.palette.tas.model.tas.TasFactory;
import com.tibco.bw.palette.tas.model.tas.TasPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TasPackageImpl extends EPackageImpl implements TasPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tasAbstractObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass postAuditEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass putAuditEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass postBatchAuditEventsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getAuditEventEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.tibco.bw.palette.tas.model.tas.TasPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TasPackageImpl() {
		super(eNS_URI, TasFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link TasPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TasPackage init() {
		if (isInited) return (TasPackage)EPackage.Registry.INSTANCE.getEPackage(TasPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredTasPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		TasPackageImpl theTasPackage = registeredTasPackage instanceof TasPackageImpl ? (TasPackageImpl)registeredTasPackage : new TasPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theTasPackage.createPackageContents();

		// Initialize created meta-data
		theTasPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTasPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TasPackage.eNS_URI, theTasPackage);
		return theTasPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTasAbstractObject() {
		return tasAbstractObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTasAbstractObject_TasConnection() {
		return (EAttribute)tasAbstractObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPostAuditEvent() {
		return postAuditEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPutAuditEvent() {
		return putAuditEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPostBatchAuditEvents() {
		return postBatchAuditEventsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGetAuditEvent() {
		return getAuditEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGetAuditEvent_SortColumn() {
		return (EAttribute)getAuditEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGetAuditEvent_DescOrder() {
		return (EAttribute)getAuditEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGetAuditEvent_ExactMatch() {
		return (EAttribute)getAuditEventEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGetAuditEvent_IncludePayload() {
		return (EAttribute)getAuditEventEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGetAuditEvent_Limit() {
		return (EAttribute)getAuditEventEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGetAuditEvent_OnlyGetCount() {
		return (EAttribute)getAuditEventEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TasFactory getTasFactory() {
		return (TasFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		tasAbstractObjectEClass = createEClass(TAS_ABSTRACT_OBJECT);
		createEAttribute(tasAbstractObjectEClass, TAS_ABSTRACT_OBJECT__TAS_CONNECTION);

		postAuditEventEClass = createEClass(POST_AUDIT_EVENT);

		putAuditEventEClass = createEClass(PUT_AUDIT_EVENT);

		postBatchAuditEventsEClass = createEClass(POST_BATCH_AUDIT_EVENTS);

		getAuditEventEClass = createEClass(GET_AUDIT_EVENT);
		createEAttribute(getAuditEventEClass, GET_AUDIT_EVENT__SORT_COLUMN);
		createEAttribute(getAuditEventEClass, GET_AUDIT_EVENT__DESC_ORDER);
		createEAttribute(getAuditEventEClass, GET_AUDIT_EVENT__EXACT_MATCH);
		createEAttribute(getAuditEventEClass, GET_AUDIT_EVENT__INCLUDE_PAYLOAD);
		createEAttribute(getAuditEventEClass, GET_AUDIT_EVENT__LIMIT);
		createEAttribute(getAuditEventEClass, GET_AUDIT_EVENT__ONLY_GET_COUNT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		postAuditEventEClass.getESuperTypes().add(this.getTasAbstractObject());
		putAuditEventEClass.getESuperTypes().add(this.getTasAbstractObject());
		postBatchAuditEventsEClass.getESuperTypes().add(this.getTasAbstractObject());
		getAuditEventEClass.getESuperTypes().add(this.getTasAbstractObject());

		// Initialize classes and features; add operations and parameters
		initEClass(tasAbstractObjectEClass, TasAbstractObject.class, "TasAbstractObject", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTasAbstractObject_TasConnection(), ecorePackage.getEString(), "tasConnection", null, 0, 1, TasAbstractObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(postAuditEventEClass, PostAuditEvent.class, "PostAuditEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(putAuditEventEClass, PutAuditEvent.class, "PutAuditEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(postBatchAuditEventsEClass, PostBatchAuditEvents.class, "PostBatchAuditEvents", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(getAuditEventEClass, GetAuditEvent.class, "GetAuditEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGetAuditEvent_SortColumn(), ecorePackage.getEString(), "sortColumn", null, 0, 1, GetAuditEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGetAuditEvent_DescOrder(), ecorePackage.getEBoolean(), "descOrder", null, 0, 1, GetAuditEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGetAuditEvent_ExactMatch(), ecorePackage.getEBoolean(), "exactMatch", null, 0, 1, GetAuditEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGetAuditEvent_IncludePayload(), ecorePackage.getEBoolean(), "includePayload", null, 0, 1, GetAuditEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGetAuditEvent_Limit(), ecorePackage.getEInt(), "limit", null, 0, 1, GetAuditEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGetAuditEvent_OnlyGetCount(), ecorePackage.getEBoolean(), "onlyGetCount", null, 0, 1, GetAuditEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// cbgeneralcontrol
		createCbgeneralcontrolAnnotations();
	}

	/**
	 * Initializes the annotations for <b>cbgeneralcontrol</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createCbgeneralcontrolAnnotations() {
		String source = "cbgeneralcontrol";
		addAnnotation
		  (getTasAbstractObject_TasConnection(),
		   source,
		   new String[] {
		   });
	}

} //TasPackageImpl
