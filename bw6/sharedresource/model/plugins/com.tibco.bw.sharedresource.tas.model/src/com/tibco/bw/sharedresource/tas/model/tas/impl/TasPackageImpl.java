/**
 */
package com.tibco.bw.sharedresource.tas.model.tas.impl;

import com.tibco.bw.sharedresource.tas.model.tas.TasConnection;
import com.tibco.bw.sharedresource.tas.model.tas.TasFactory;
import com.tibco.bw.sharedresource.tas.model.tas.TasPackage;

import com.tibco.neo.model.componentjar.ComponentjarPackage;
import com.tibco.neo.svar.svarmodel.SvarmodelPackage;

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
	private EClass tasConnectionEClass = null;

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
	 * @see com.tibco.bw.sharedresource.tas.model.tas.TasPackage#eNS_URI
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

		// Initialize simple dependencies
		SvarmodelPackage.eINSTANCE.eClass();
		ComponentjarPackage.eINSTANCE.eClass();

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
	public EClass getTasConnection() {
		return tasConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTasConnection_ServerUrl() {
		return (EAttribute)tasConnectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTasConnection_Username() {
		return (EAttribute)tasConnectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTasConnection_Password() {
		return (EAttribute)tasConnectionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTasConnection_Id() {
		return (EAttribute)tasConnectionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTasConnection_Schema() {
		return (EAttribute)tasConnectionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTasConnection_Output() {
		return (EAttribute)tasConnectionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTasConnection_QueryOutput() {
		return (EAttribute)tasConnectionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTasConnection_Enterprise() {
		return (EAttribute)tasConnectionEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTasConnection_UseToken() {
		return (EAttribute)tasConnectionEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTasConnection_AccessToken() {
		return (EAttribute)tasConnectionEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTasConnection_RefreshToken() {
		return (EAttribute)tasConnectionEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTasConnection_ClientId() {
		return (EAttribute)tasConnectionEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTasConnection_ClientSecret() {
		return (EAttribute)tasConnectionEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTasConnection_Sso() {
		return (EAttribute)tasConnectionEClass.getEStructuralFeatures().get(13);
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
		tasConnectionEClass = createEClass(TAS_CONNECTION);
		createEAttribute(tasConnectionEClass, TAS_CONNECTION__SERVER_URL);
		createEAttribute(tasConnectionEClass, TAS_CONNECTION__USERNAME);
		createEAttribute(tasConnectionEClass, TAS_CONNECTION__PASSWORD);
		createEAttribute(tasConnectionEClass, TAS_CONNECTION__ID);
		createEAttribute(tasConnectionEClass, TAS_CONNECTION__SCHEMA);
		createEAttribute(tasConnectionEClass, TAS_CONNECTION__OUTPUT);
		createEAttribute(tasConnectionEClass, TAS_CONNECTION__QUERY_OUTPUT);
		createEAttribute(tasConnectionEClass, TAS_CONNECTION__ENTERPRISE);
		createEAttribute(tasConnectionEClass, TAS_CONNECTION__USE_TOKEN);
		createEAttribute(tasConnectionEClass, TAS_CONNECTION__ACCESS_TOKEN);
		createEAttribute(tasConnectionEClass, TAS_CONNECTION__REFRESH_TOKEN);
		createEAttribute(tasConnectionEClass, TAS_CONNECTION__CLIENT_ID);
		createEAttribute(tasConnectionEClass, TAS_CONNECTION__CLIENT_SECRET);
		createEAttribute(tasConnectionEClass, TAS_CONNECTION__SSO);
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

		// Obtain other dependent packages
		SvarmodelPackage theSvarmodelPackage = (SvarmodelPackage)EPackage.Registry.INSTANCE.getEPackage(SvarmodelPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		tasConnectionEClass.getESuperTypes().add(theSvarmodelPackage.getSubstitutableObject());

		// Initialize classes and features; add operations and parameters
		initEClass(tasConnectionEClass, TasConnection.class, "TasConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTasConnection_ServerUrl(), ecorePackage.getEString(), "serverUrl", null, 0, 1, TasConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTasConnection_Username(), ecorePackage.getEString(), "username", null, 0, 1, TasConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTasConnection_Password(), ecorePackage.getEString(), "password", null, 0, 1, TasConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTasConnection_Id(), ecorePackage.getEString(), "id", null, 0, 1, TasConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTasConnection_Schema(), ecorePackage.getEString(), "schema", null, 0, 1, TasConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTasConnection_Output(), ecorePackage.getEString(), "output", null, 0, 1, TasConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTasConnection_QueryOutput(), ecorePackage.getEString(), "queryOutput", null, 0, 1, TasConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTasConnection_Enterprise(), ecorePackage.getEBoolean(), "enterprise", "false", 0, 1, TasConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTasConnection_UseToken(), ecorePackage.getEBoolean(), "useToken", "false", 0, 1, TasConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTasConnection_AccessToken(), ecorePackage.getEString(), "accessToken", null, 0, 1, TasConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTasConnection_RefreshToken(), ecorePackage.getEString(), "refreshToken", null, 0, 1, TasConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTasConnection_ClientId(), ecorePackage.getEString(), "clientId", null, 0, 1, TasConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTasConnection_ClientSecret(), ecorePackage.getEString(), "clientSecret", null, 0, 1, TasConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTasConnection_Sso(), ecorePackage.getEBoolean(), "sso", null, 0, 1, TasConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://tns.tibco.com/bw/annotations/configuration
		createConfigurationAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://tns.tibco.com/bw/annotations/configuration</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createConfigurationAnnotations() {
		String source = "http://tns.tibco.com/bw/annotations/configuration";
		addAnnotation
		  (tasConnectionEClass,
		   source,
		   new String[] {
		   });
	}

} //TasPackageImpl
