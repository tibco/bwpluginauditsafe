/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.tibco.bw.palette.tcta.model.tcta;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Upsert Row</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.tibco.bw.palette.tcta.model.tcta.UpsertRow#getPropertyField <em>Property Field</em>}</li>
 *   <li>{@link com.tibco.bw.palette.tcta.model.tcta.UpsertRow#getCheckBox <em>Check Box</em>}</li>
 *   <li>{@link com.tibco.bw.palette.tcta.model.tcta.UpsertRow#getTextBox <em>Text Box</em>}</li>
 *   <li>{@link com.tibco.bw.palette.tcta.model.tcta.UpsertRow#getSpinner <em>Spinner</em>}</li>
 *   <li>{@link com.tibco.bw.palette.tcta.model.tcta.UpsertRow#getComboViewer <em>Combo Viewer</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.tibco.bw.palette.tcta.model.tcta.TctaPackage#getUpsertRow()
 * @model annotation="cbactivityconfig isgenerate='yes' activitytype='SyncActivity' bw5resourcetype='' inputelementname='' outputelementname=''"
 * @generated
 */
public interface UpsertRow extends EObject
{
  /**
   * Returns the value of the '<em><b>Property Field</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Property Field</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property Field</em>' attribute.
   * @see #setPropertyField(String)
   * @see com.tibco.bw.palette.tcta.model.tcta.TctaPackage#getUpsertRow_PropertyField()
   * @model annotation="cbgeneralcontrol label='PropertyField :' type='PropertyField' qname='{http://ns.tibco.com/bw/sharedresource/tcta}tctaConnection' injectresource='com.tibco.bw.sharedresource.tcta.runtime.tctaConnectionResource'"
   *        annotation="cbfieldmigrateconfig id=''"
   * @generated
   */
  String getPropertyField();

  /**
   * Sets the value of the '{@link com.tibco.bw.palette.tcta.model.tcta.UpsertRow#getPropertyField <em>Property Field</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Property Field</em>' attribute.
   * @see #getPropertyField()
   * @generated
   */
  void setPropertyField(String value);

  /**
   * Returns the value of the '<em><b>Check Box</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Check Box</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Check Box</em>' attribute.
   * @see #setCheckBox(String)
   * @see com.tibco.bw.palette.tcta.model.tcta.TctaPackage#getUpsertRow_CheckBox()
   * @model annotation="cbgeneralcontrol label='CheckBox :' type='AttributeBindingField' control='CheckBox'"
   *        annotation="cbfieldmigrateconfig id=''"
   * @generated
   */
  String getCheckBox();

  /**
   * Sets the value of the '{@link com.tibco.bw.palette.tcta.model.tcta.UpsertRow#getCheckBox <em>Check Box</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Check Box</em>' attribute.
   * @see #getCheckBox()
   * @generated
   */
  void setCheckBox(String value);

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
   * @see com.tibco.bw.palette.tcta.model.tcta.TctaPackage#getUpsertRow_TextBox()
   * @model annotation="cbgeneralcontrol label='TextBox :' type='AttributeBindingField' control='TextBox'"
   *        annotation="cbfieldmigrateconfig id=''"
   * @generated
   */
  String getTextBox();

  /**
   * Sets the value of the '{@link com.tibco.bw.palette.tcta.model.tcta.UpsertRow#getTextBox <em>Text Box</em>}' attribute.
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
   * @see com.tibco.bw.palette.tcta.model.tcta.TctaPackage#getUpsertRow_Spinner()
   * @model annotation="cbgeneralcontrol label='Spinner :' type='Spinner'"
   *        annotation="cbfieldmigrateconfig id=''"
   * @generated
   */
  int getSpinner();

  /**
   * Sets the value of the '{@link com.tibco.bw.palette.tcta.model.tcta.UpsertRow#getSpinner <em>Spinner</em>}' attribute.
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
   * @see com.tibco.bw.palette.tcta.model.tcta.TctaPackage#getUpsertRow_ComboViewer()
   * @model annotation="cbadvancedcontrol label='ComboViewer :' type='AttributeBindingField' control='ComboViewer' value='\"value1\",\"value2\"'"
   *        annotation="cbfieldmigrateconfig id=''"
   * @generated
   */
  String getComboViewer();

  /**
   * Sets the value of the '{@link com.tibco.bw.palette.tcta.model.tcta.UpsertRow#getComboViewer <em>Combo Viewer</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Combo Viewer</em>' attribute.
   * @see #getComboViewer()
   * @generated
   */
  void setComboViewer(String value);

} // UpsertRow
