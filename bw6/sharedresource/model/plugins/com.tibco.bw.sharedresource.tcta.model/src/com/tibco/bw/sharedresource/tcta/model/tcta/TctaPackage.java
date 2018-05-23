/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.tibco.bw.sharedresource.tcta.model.tcta;

import com.tibco.neo.svar.svarmodel.SvarmodelPackage;

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
 * @see com.tibco.bw.sharedresource.tcta.model.tcta.TctaFactory
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
  String eNS_URI = "http://ns.tibco.com/bw/sharedresource/tcta";

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
  TctaPackage eINSTANCE = com.tibco.bw.sharedresource.tcta.model.tcta.impl.TctaPackageImpl.init();

  /**
   * The meta object id for the '{@link com.tibco.bw.sharedresource.tcta.model.tcta.impl.tctaConnectionImpl <em>tcta Connection</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.tibco.bw.sharedresource.tcta.model.tcta.impl.tctaConnectionImpl
   * @see com.tibco.bw.sharedresource.tcta.model.tcta.impl.TctaPackageImpl#gettctaConnection()
   * @generated
   */
  int TCTA_CONNECTION = 0;

  /**
   * The feature id for the '<em><b>Substitution Bindings</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCTA_CONNECTION__SUBSTITUTION_BINDINGS = SvarmodelPackage.SUBSTITUTABLE_OBJECT__SUBSTITUTION_BINDINGS;

  /**
   * The feature id for the '<em><b>Text Box</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCTA_CONNECTION__TEXT_BOX = SvarmodelPackage.SUBSTITUTABLE_OBJECT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Spinner</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCTA_CONNECTION__SPINNER = SvarmodelPackage.SUBSTITUTABLE_OBJECT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Combo Viewer</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCTA_CONNECTION__COMBO_VIEWER = SvarmodelPackage.SUBSTITUTABLE_OBJECT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>tcta Connection</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCTA_CONNECTION_FEATURE_COUNT = SvarmodelPackage.SUBSTITUTABLE_OBJECT_FEATURE_COUNT + 3;


  /**
   * Returns the meta object for class '{@link com.tibco.bw.sharedresource.tcta.model.tcta.tctaConnection <em>tcta Connection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>tcta Connection</em>'.
   * @see com.tibco.bw.sharedresource.tcta.model.tcta.tctaConnection
   * @generated
   */
  EClass gettctaConnection();

  /**
   * Returns the meta object for the attribute '{@link com.tibco.bw.sharedresource.tcta.model.tcta.tctaConnection#getTextBox <em>Text Box</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Text Box</em>'.
   * @see com.tibco.bw.sharedresource.tcta.model.tcta.tctaConnection#getTextBox()
   * @see #gettctaConnection()
   * @generated
   */
  EAttribute gettctaConnection_TextBox();

  /**
   * Returns the meta object for the attribute '{@link com.tibco.bw.sharedresource.tcta.model.tcta.tctaConnection#getSpinner <em>Spinner</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Spinner</em>'.
   * @see com.tibco.bw.sharedresource.tcta.model.tcta.tctaConnection#getSpinner()
   * @see #gettctaConnection()
   * @generated
   */
  EAttribute gettctaConnection_Spinner();

  /**
   * Returns the meta object for the attribute '{@link com.tibco.bw.sharedresource.tcta.model.tcta.tctaConnection#getComboViewer <em>Combo Viewer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Combo Viewer</em>'.
   * @see com.tibco.bw.sharedresource.tcta.model.tcta.tctaConnection#getComboViewer()
   * @see #gettctaConnection()
   * @generated
   */
  EAttribute gettctaConnection_ComboViewer();

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
     * The meta object literal for the '{@link com.tibco.bw.sharedresource.tcta.model.tcta.impl.tctaConnectionImpl <em>tcta Connection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.tibco.bw.sharedresource.tcta.model.tcta.impl.tctaConnectionImpl
     * @see com.tibco.bw.sharedresource.tcta.model.tcta.impl.TctaPackageImpl#gettctaConnection()
     * @generated
     */
    EClass TCTA_CONNECTION = eINSTANCE.gettctaConnection();

    /**
     * The meta object literal for the '<em><b>Text Box</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TCTA_CONNECTION__TEXT_BOX = eINSTANCE.gettctaConnection_TextBox();

    /**
     * The meta object literal for the '<em><b>Spinner</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TCTA_CONNECTION__SPINNER = eINSTANCE.gettctaConnection_Spinner();

    /**
     * The meta object literal for the '<em><b>Combo Viewer</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TCTA_CONNECTION__COMBO_VIEWER = eINSTANCE.gettctaConnection_ComboViewer();

  }

} //TctaPackage
