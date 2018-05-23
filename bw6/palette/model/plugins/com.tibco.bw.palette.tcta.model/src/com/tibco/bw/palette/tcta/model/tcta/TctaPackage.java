/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.tibco.bw.palette.tcta.model.tcta;

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
 * @see com.tibco.bw.palette.tcta.model.tcta.TctaFactory
 * @model kind="package"
 * @generated
 */
public interface TctaPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "tcta";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://ns.tibco.com/bw/palette/tcta";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "tcta";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TctaPackage eINSTANCE = com.tibco.bw.palette.tcta.model.tcta.impl.TctaPackageImpl.init();

  /**
   * The meta object id for the '{@link com.tibco.bw.palette.tcta.model.tcta.impl.UpsertRowImpl <em>Upsert Row</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.tibco.bw.palette.tcta.model.tcta.impl.UpsertRowImpl
   * @see com.tibco.bw.palette.tcta.model.tcta.impl.TctaPackageImpl#getUpsertRow()
   * @generated
   */
  int UPSERT_ROW = 0;

  /**
   * The feature id for the '<em><b>Property Field</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UPSERT_ROW__PROPERTY_FIELD = 0;

  /**
   * The feature id for the '<em><b>Check Box</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UPSERT_ROW__CHECK_BOX = 1;

  /**
   * The feature id for the '<em><b>Text Box</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UPSERT_ROW__TEXT_BOX = 2;

  /**
   * The feature id for the '<em><b>Spinner</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UPSERT_ROW__SPINNER = 3;

  /**
   * The feature id for the '<em><b>Combo Viewer</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UPSERT_ROW__COMBO_VIEWER = 4;

  /**
   * The number of structural features of the '<em>Upsert Row</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UPSERT_ROW_FEATURE_COUNT = 5;


  /**
   * Returns the meta object for class '{@link com.tibco.bw.palette.tcta.model.tcta.UpsertRow <em>Upsert Row</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Upsert Row</em>'.
   * @see com.tibco.bw.palette.tcta.model.tcta.UpsertRow
   * @generated
   */
  EClass getUpsertRow();

  /**
   * Returns the meta object for the attribute '{@link com.tibco.bw.palette.tcta.model.tcta.UpsertRow#getPropertyField <em>Property Field</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Property Field</em>'.
   * @see com.tibco.bw.palette.tcta.model.tcta.UpsertRow#getPropertyField()
   * @see #getUpsertRow()
   * @generated
   */
  EAttribute getUpsertRow_PropertyField();

  /**
   * Returns the meta object for the attribute '{@link com.tibco.bw.palette.tcta.model.tcta.UpsertRow#getCheckBox <em>Check Box</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Check Box</em>'.
   * @see com.tibco.bw.palette.tcta.model.tcta.UpsertRow#getCheckBox()
   * @see #getUpsertRow()
   * @generated
   */
  EAttribute getUpsertRow_CheckBox();

  /**
   * Returns the meta object for the attribute '{@link com.tibco.bw.palette.tcta.model.tcta.UpsertRow#getTextBox <em>Text Box</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Text Box</em>'.
   * @see com.tibco.bw.palette.tcta.model.tcta.UpsertRow#getTextBox()
   * @see #getUpsertRow()
   * @generated
   */
  EAttribute getUpsertRow_TextBox();

  /**
   * Returns the meta object for the attribute '{@link com.tibco.bw.palette.tcta.model.tcta.UpsertRow#getSpinner <em>Spinner</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Spinner</em>'.
   * @see com.tibco.bw.palette.tcta.model.tcta.UpsertRow#getSpinner()
   * @see #getUpsertRow()
   * @generated
   */
  EAttribute getUpsertRow_Spinner();

  /**
   * Returns the meta object for the attribute '{@link com.tibco.bw.palette.tcta.model.tcta.UpsertRow#getComboViewer <em>Combo Viewer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Combo Viewer</em>'.
   * @see com.tibco.bw.palette.tcta.model.tcta.UpsertRow#getComboViewer()
   * @see #getUpsertRow()
   * @generated
   */
  EAttribute getUpsertRow_ComboViewer();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  TctaFactory getTctaFactory();

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
  interface Literals
  {
    /**
     * The meta object literal for the '{@link com.tibco.bw.palette.tcta.model.tcta.impl.UpsertRowImpl <em>Upsert Row</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.tibco.bw.palette.tcta.model.tcta.impl.UpsertRowImpl
     * @see com.tibco.bw.palette.tcta.model.tcta.impl.TctaPackageImpl#getUpsertRow()
     * @generated
     */
    EClass UPSERT_ROW = eINSTANCE.getUpsertRow();

    /**
     * The meta object literal for the '<em><b>Property Field</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UPSERT_ROW__PROPERTY_FIELD = eINSTANCE.getUpsertRow_PropertyField();

    /**
     * The meta object literal for the '<em><b>Check Box</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UPSERT_ROW__CHECK_BOX = eINSTANCE.getUpsertRow_CheckBox();

    /**
     * The meta object literal for the '<em><b>Text Box</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UPSERT_ROW__TEXT_BOX = eINSTANCE.getUpsertRow_TextBox();

    /**
     * The meta object literal for the '<em><b>Spinner</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UPSERT_ROW__SPINNER = eINSTANCE.getUpsertRow_Spinner();

    /**
     * The meta object literal for the '<em><b>Combo Viewer</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UPSERT_ROW__COMBO_VIEWER = eINSTANCE.getUpsertRow_ComboViewer();

  }

} //TctaPackage
