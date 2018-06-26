/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.tibco.bw.palette.tcta.model.tcta.impl;

import com.tibco.bw.palette.tcta.model.tcta.TCTAGetToken;
import com.tibco.bw.palette.tcta.model.tcta.TctaAbstractObject;
import com.tibco.bw.palette.tcta.model.tcta.TctaFactory;
import com.tibco.bw.palette.tcta.model.tcta.TctaPackage;
import com.tibco.bw.palette.tcta.model.tcta.UpsertRow;

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
public class TctaPackageImpl extends EPackageImpl implements TctaPackage
{
  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tctaAbstractObjectEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tctaGetTokenEClass = null;
		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass upsertRowEClass = null;
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
	 * @see com.tibco.bw.palette.tcta.model.tcta.TctaPackage#eNS_URI
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
	public EClass getTctaAbstractObject() {
		return tctaAbstractObjectEClass;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTctaAbstractObject_TctaConnection() {
		return (EAttribute)tctaAbstractObjectEClass.getEStructuralFeatures().get(0);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCTAGetToken() {
		return tctaGetTokenEClass;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUpsertRow() {
		return upsertRowEClass;
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
		tctaAbstractObjectEClass = createEClass(TCTA_ABSTRACT_OBJECT);
		createEAttribute(tctaAbstractObjectEClass, TCTA_ABSTRACT_OBJECT__TCTA_CONNECTION);

		tctaGetTokenEClass = createEClass(TCTA_GET_TOKEN);

		upsertRowEClass = createEClass(UPSERT_ROW);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		tctaGetTokenEClass.getESuperTypes().add(this.getTctaAbstractObject());
		upsertRowEClass.getESuperTypes().add(this.getTctaAbstractObject());

		// Initialize classes and features; add operations and parameters
		initEClass(tctaAbstractObjectEClass, Object.class, "TctaAbstractObject", IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTctaAbstractObject_TctaConnection(), ecorePackage.getEString(), "tctaConnection", null, 0, 1, TctaAbstractObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tctaGetTokenEClass, TCTAGetToken.class, "TCTAGetToken", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(upsertRowEClass, UpsertRow.class, "UpsertRow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

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
  protected void createCbgeneralcontrolAnnotations()
  {
		String source = "cbgeneralcontrol";
		addAnnotation
		  (getTctaAbstractObject_TctaConnection(),
		   source,
		   new String[] {
			 "label", "TCTA Connection:",
			 "type", "text"
		   });
	}

} //TctaPackageImpl
