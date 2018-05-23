/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.tibco.bw.sharedresource.tcta.model.tcta.impl;

import com.tibco.bw.sharedresource.tcta.model.tcta.TctaPackage;
import com.tibco.bw.sharedresource.tcta.model.tcta.tctaConnection;

import com.tibco.neo.svar.svarmodel.impl.SubstitutableObjectImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>tcta Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.tibco.bw.sharedresource.tcta.model.tcta.impl.tctaConnectionImpl#getTextBox <em>Text Box</em>}</li>
 *   <li>{@link com.tibco.bw.sharedresource.tcta.model.tcta.impl.tctaConnectionImpl#getSpinner <em>Spinner</em>}</li>
 *   <li>{@link com.tibco.bw.sharedresource.tcta.model.tcta.impl.tctaConnectionImpl#getComboViewer <em>Combo Viewer</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class tctaConnectionImpl extends SubstitutableObjectImpl implements tctaConnection
{
  /**
   * The default value of the '{@link #getTextBox() <em>Text Box</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTextBox()
   * @generated
   * @ordered
   */
  protected static final String TEXT_BOX_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTextBox() <em>Text Box</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTextBox()
   * @generated
   * @ordered
   */
  protected String textBox = TEXT_BOX_EDEFAULT;

  /**
   * The default value of the '{@link #getSpinner() <em>Spinner</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSpinner()
   * @generated
   * @ordered
   */
  protected static final int SPINNER_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getSpinner() <em>Spinner</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSpinner()
   * @generated
   * @ordered
   */
  protected int spinner = SPINNER_EDEFAULT;

  /**
   * The default value of the '{@link #getComboViewer() <em>Combo Viewer</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComboViewer()
   * @generated
   * @ordered
   */
  protected static final String COMBO_VIEWER_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getComboViewer() <em>Combo Viewer</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComboViewer()
   * @generated
   * @ordered
   */
  protected String comboViewer = COMBO_VIEWER_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected tctaConnectionImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return TctaPackage.Literals.TCTA_CONNECTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTextBox()
  {
    return textBox;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTextBox(String newTextBox)
  {
    String oldTextBox = textBox;
    textBox = newTextBox;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TctaPackage.TCTA_CONNECTION__TEXT_BOX, oldTextBox, textBox));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getSpinner()
  {
    return spinner;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSpinner(int newSpinner)
  {
    int oldSpinner = spinner;
    spinner = newSpinner;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TctaPackage.TCTA_CONNECTION__SPINNER, oldSpinner, spinner));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getComboViewer()
  {
    return comboViewer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setComboViewer(String newComboViewer)
  {
    String oldComboViewer = comboViewer;
    comboViewer = newComboViewer;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TctaPackage.TCTA_CONNECTION__COMBO_VIEWER, oldComboViewer, comboViewer));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case TctaPackage.TCTA_CONNECTION__TEXT_BOX:
        return getTextBox();
      case TctaPackage.TCTA_CONNECTION__SPINNER:
        return getSpinner();
      case TctaPackage.TCTA_CONNECTION__COMBO_VIEWER:
        return getComboViewer();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case TctaPackage.TCTA_CONNECTION__TEXT_BOX:
        setTextBox((String)newValue);
        return;
      case TctaPackage.TCTA_CONNECTION__SPINNER:
        setSpinner((Integer)newValue);
        return;
      case TctaPackage.TCTA_CONNECTION__COMBO_VIEWER:
        setComboViewer((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case TctaPackage.TCTA_CONNECTION__TEXT_BOX:
        setTextBox(TEXT_BOX_EDEFAULT);
        return;
      case TctaPackage.TCTA_CONNECTION__SPINNER:
        setSpinner(SPINNER_EDEFAULT);
        return;
      case TctaPackage.TCTA_CONNECTION__COMBO_VIEWER:
        setComboViewer(COMBO_VIEWER_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case TctaPackage.TCTA_CONNECTION__TEXT_BOX:
        return TEXT_BOX_EDEFAULT == null ? textBox != null : !TEXT_BOX_EDEFAULT.equals(textBox);
      case TctaPackage.TCTA_CONNECTION__SPINNER:
        return spinner != SPINNER_EDEFAULT;
      case TctaPackage.TCTA_CONNECTION__COMBO_VIEWER:
        return COMBO_VIEWER_EDEFAULT == null ? comboViewer != null : !COMBO_VIEWER_EDEFAULT.equals(comboViewer);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (textBox: ");
    result.append(textBox);
    result.append(", spinner: ");
    result.append(spinner);
    result.append(", comboViewer: ");
    result.append(comboViewer);
    result.append(')');
    return result.toString();
  }

} //tctaConnectionImpl
