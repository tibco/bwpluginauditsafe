/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.tibco.bw.sharedresource.tcta.model.tcta;

import com.tibco.neo.svar.svarmodel.SubstitutableObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>tcta Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.tibco.bw.sharedresource.tcta.model.tcta.tctaConnection#getTextBox <em>Text Box</em>}</li>
 *   <li>{@link com.tibco.bw.sharedresource.tcta.model.tcta.tctaConnection#getSpinner <em>Spinner</em>}</li>
 *   <li>{@link com.tibco.bw.sharedresource.tcta.model.tcta.tctaConnection#getComboViewer <em>Combo Viewer</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.tibco.bw.sharedresource.tcta.model.tcta.TctaPackage#gettctaConnection()
 * @model annotation="cbsharedresourceconfig isgenerate='yes' fileExtension=''"
 * @generated
 */
public interface tctaConnection extends SubstitutableObject
{
  /**
   * Returns the value of the '<em><b>Text Box</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Text Box</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Text Box</em>' attribute.
   * @see #setTextBox(String)
   * @see com.tibco.bw.sharedresource.tcta.model.tcta.TctaPackage#gettctaConnection_TextBox()
   * @model annotation="cbgeneralcontrol label='TextBox : ' type='SRAttributeBindingField' control='TextBox'"
   *        annotation="cbfieldmigrateconfig id=''"
   * @generated
   */
  String getTextBox();

  /**
   * Sets the value of the '{@link com.tibco.bw.sharedresource.tcta.model.tcta.tctaConnection#getTextBox <em>Text Box</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Text Box</em>' attribute.
   * @see #getTextBox()
   * @generated
   */
  void setTextBox(String value);

  /**
   * Returns the value of the '<em><b>Spinner</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Spinner</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Spinner</em>' attribute.
   * @see #setSpinner(int)
   * @see com.tibco.bw.sharedresource.tcta.model.tcta.TctaPackage#gettctaConnection_Spinner()
   * @model annotation="cbgeneralcontrol label='Spinner :' type='Spinner'"
   *        annotation="cbfieldmigrateconfig id=''"
   * @generated
   */
  int getSpinner();

  /**
   * Sets the value of the '{@link com.tibco.bw.sharedresource.tcta.model.tcta.tctaConnection#getSpinner <em>Spinner</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Spinner</em>' attribute.
   * @see #getSpinner()
   * @generated
   */
  void setSpinner(int value);

  /**
   * Returns the value of the '<em><b>Combo Viewer</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Combo Viewer</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Combo Viewer</em>' attribute.
   * @see #setComboViewer(String)
   * @see com.tibco.bw.sharedresource.tcta.model.tcta.TctaPackage#gettctaConnection_ComboViewer()
   * @model annotation="cbgeneralcontrol label='ComboViewer :' type='SRAttributeBindingField' control='ComboViewer' value='\"value1\",\"value2\"'"
   *        annotation="cbfieldmigrateconfig id=''"
   * @generated
   */
  String getComboViewer();

  /**
   * Sets the value of the '{@link com.tibco.bw.sharedresource.tcta.model.tcta.tctaConnection#getComboViewer <em>Combo Viewer</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Combo Viewer</em>' attribute.
   * @see #getComboViewer()
   * @generated
   */
  void setComboViewer(String value);

} // tctaConnection
