/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.tibco.bw.palette.tcta.model.tcta.impl;

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
  public EClass getUpsertRow()
  {
    return upsertRowEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUpsertRow_PropertyField()
  {
    return (EAttribute)upsertRowEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUpsertRow_CheckBox()
  {
    return (EAttribute)upsertRowEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUpsertRow_TextBox()
  {
    return (EAttribute)upsertRowEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUpsertRow_Spinner()
  {
    return (EAttribute)upsertRowEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUpsertRow_ComboViewer()
  {
    return (EAttribute)upsertRowEClass.getEStructuralFeatures().get(4);
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
    upsertRowEClass = createEClass(UPSERT_ROW);
    createEAttribute(upsertRowEClass, UPSERT_ROW__PROPERTY_FIELD);
    createEAttribute(upsertRowEClass, UPSERT_ROW__CHECK_BOX);
    createEAttribute(upsertRowEClass, UPSERT_ROW__TEXT_BOX);
    createEAttribute(upsertRowEClass, UPSERT_ROW__SPINNER);
    createEAttribute(upsertRowEClass, UPSERT_ROW__COMBO_VIEWER);
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

    // Initialize classes and features; add operations and parameters
    initEClass(upsertRowEClass, UpsertRow.class, "UpsertRow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUpsertRow_PropertyField(), ecorePackage.getEString(), "propertyField", null, 0, 1, UpsertRow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUpsertRow_CheckBox(), ecorePackage.getEString(), "checkBox", null, 0, 1, UpsertRow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUpsertRow_TextBox(), ecorePackage.getEString(), "textBox", null, 0, 1, UpsertRow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUpsertRow_Spinner(), ecorePackage.getEInt(), "spinner", null, 0, 1, UpsertRow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUpsertRow_ComboViewer(), ecorePackage.getEString(), "comboViewer", null, 0, 1, UpsertRow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);

    // Create annotations
    // cbactivityconfig
    createCbactivityconfigAnnotations();
    // cbgeneralcontrol
    createCbgeneralcontrolAnnotations();
    // cbfieldmigrateconfig
    createCbfieldmigrateconfigAnnotations();
    // cbadvancedcontrol
    createCbadvancedcontrolAnnotations();
  }

  /**
   * Initializes the annotations for <b>cbactivityconfig</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createCbactivityconfigAnnotations()
  {
    String source = "cbactivityconfig";		
    addAnnotation
      (upsertRowEClass, 
       source, 
       new String[] 
       {
       "isgenerate", "yes",
       "activitytype", "SyncActivity",
       "bw5resourcetype", "",
       "inputelementname", "",
       "outputelementname", ""
       });										
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
      (getUpsertRow_PropertyField(), 
       source, 
       new String[] 
       {
       "label", "PropertyField :",
       "type", "PropertyField",
       "qname", "{http://ns.tibco.com/bw/sharedresource/tcta}tctaConnection",
       "injectresource", "com.tibco.bw.sharedresource.tcta.runtime.tctaConnectionResource"
       });			
    addAnnotation
      (getUpsertRow_CheckBox(), 
       source, 
       new String[] 
       {
       "label", "CheckBox :",
       "type", "AttributeBindingField",
       "control", "CheckBox"
       });			
    addAnnotation
      (getUpsertRow_TextBox(), 
       source, 
       new String[] 
       {
       "label", "TextBox :",
       "type", "AttributeBindingField",
       "control", "TextBox"
       });			
    addAnnotation
      (getUpsertRow_Spinner(), 
       source, 
       new String[] 
       {
       "label", "Spinner :",
       "type", "Spinner"
       });			
  }

  /**
   * Initializes the annotations for <b>cbfieldmigrateconfig</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createCbfieldmigrateconfigAnnotations()
  {
    String source = "cbfieldmigrateconfig";				
    addAnnotation
      (getUpsertRow_PropertyField(), 
       source, 
       new String[] 
       {
       "id", ""
       });			
    addAnnotation
      (getUpsertRow_CheckBox(), 
       source, 
       new String[] 
       {
       "id", ""
       });			
    addAnnotation
      (getUpsertRow_TextBox(), 
       source, 
       new String[] 
       {
       "id", ""
       });			
    addAnnotation
      (getUpsertRow_Spinner(), 
       source, 
       new String[] 
       {
       "id", ""
       });			
    addAnnotation
      (getUpsertRow_ComboViewer(), 
       source, 
       new String[] 
       {
       "id", ""
       });
  }

  /**
   * Initializes the annotations for <b>cbadvancedcontrol</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createCbadvancedcontrolAnnotations()
  {
    String source = "cbadvancedcontrol";											
    addAnnotation
      (getUpsertRow_ComboViewer(), 
       source, 
       new String[] 
       {
       "label", "ComboViewer :",
       "type", "AttributeBindingField",
       "control", "ComboViewer",
       "value", "\"value1\",\"value2\""
       });	
  }

} //TctaPackageImpl
