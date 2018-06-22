/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.tibco.bw.sharedresource.tcta.model.tcta.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import com.tibco.bw.sharedresource.tcta.model.tcta.TctaConnection;
import com.tibco.bw.sharedresource.tcta.model.tcta.TctaFactory;
import com.tibco.bw.sharedresource.tcta.model.tcta.TctaPackage;
import com.tibco.neo.svar.svarmodel.SvarmodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TctaPackageImpl extends EPackageImpl implements TctaPackage
{
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass tctaConnectionEClass = null;

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
	 * @see com.tibco.bw.sharedresource.tcta.model.tcta.TctaPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
  private TctaPackageImpl()
  {
		super(eNS_URI, TctaFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link TctaPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
  public static TctaPackage init()
  {
		if (isInited) return (TctaPackage)EPackage.Registry.INSTANCE.getEPackage(TctaPackage.eNS_URI);

		// Obtain or create and register package
		TctaPackageImpl theTctaPackage = (TctaPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TctaPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TctaPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		SvarmodelPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theTctaPackage.createPackageContents();

		// Initialize created meta-data
		theTctaPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTctaPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TctaPackage.eNS_URI, theTctaPackage);
		return theTctaPackage;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass gettctaConnection()
  {
		return tctaConnectionEClass;
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute gettctaConnection_ServerlUrl() {
		return (EAttribute)tctaConnectionEClass.getEStructuralFeatures().get(0);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute gettctaConnection_Username() {
		return (EAttribute)tctaConnectionEClass.getEStructuralFeatures().get(1);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute gettctaConnection_Password() {
		return (EAttribute)tctaConnectionEClass.getEStructuralFeatures().get(2);
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TctaFactory getTctaFactory()
  {
		return (TctaFactory)getEFactoryInstance();
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
  public void createPackageContents()
  {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		tctaConnectionEClass = createEClass(TCTA_CONNECTION);
		createEAttribute(tctaConnectionEClass, TCTA_CONNECTION__SERVERL_URL);
		createEAttribute(tctaConnectionEClass, TCTA_CONNECTION__USERNAME);
		createEAttribute(tctaConnectionEClass, TCTA_CONNECTION__PASSWORD);
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
  public void initializePackageContents()
  {
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
		tctaConnectionEClass.getESuperTypes().add(theSvarmodelPackage.getSubstitutableObject());

		// Initialize classes and features; add operations and parameters
		initEClass(tctaConnectionEClass, TctaConnection.class, "tctaConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(gettctaConnection_ServerlUrl(), ecorePackage.getEString(), "serverlUrl", null, 0, 1, TctaConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(gettctaConnection_Username(), ecorePackage.getEString(), "username", null, 0, 1, TctaConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(gettctaConnection_Password(), ecorePackage.getEString(), "password", null, 0, 1, TctaConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
  protected void createConfigurationAnnotations()
  {
		String source = "http://tns.tibco.com/bw/annotations/configuration";	
		addAnnotation
		  (tctaConnectionEClass, 
		   source, 
		   new String[] {
		   });
	}

} //TctaPackageImpl
