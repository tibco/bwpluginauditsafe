/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.tibco.bw.sharedresource.tcta.model.tcta.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.tibco.bw.sharedresource.tcta.model.tcta.TctaConnection;
import com.tibco.bw.sharedresource.tcta.model.tcta.TctaPackage;
import com.tibco.neo.svar.svarmodel.impl.SubstitutableObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>tcta Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.tibco.bw.sharedresource.tcta.model.tcta.impl.TctaConnectionImpl#getServerlUrl <em>Serverl Url</em>}</li>
 *   <li>{@link com.tibco.bw.sharedresource.tcta.model.tcta.impl.TctaConnectionImpl#getUsername <em>Username</em>}</li>
 *   <li>{@link com.tibco.bw.sharedresource.tcta.model.tcta.impl.TctaConnectionImpl#getPassword <em>Password</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TctaConnectionImpl extends SubstitutableObjectImpl implements TctaConnection
{
  /**
	 * The default value of the '{@link #getServerlUrl() <em>Serverl Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerlUrl()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVERL_URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getServerlUrl() <em>Serverl Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerlUrl()
	 * @generated
	 * @ordered
	 */
	protected String serverlUrl = SERVERL_URL_EDEFAULT;

	/**
	 * The default value of the '{@link #getUsername() <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsername()
	 * @generated
	 * @ordered
	 */
	protected static final String USERNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUsername() <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsername()
	 * @generated
	 * @ordered
	 */
	protected String username = USERNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected String password = PASSWORD_EDEFAULT;

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected TctaConnectionImpl()
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
	public String getServerlUrl() {
		return serverlUrl;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServerlUrl(String newServerlUrl) {
		String oldServerlUrl = serverlUrl;
		serverlUrl = newServerlUrl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TctaPackage.TCTA_CONNECTION__SERVERL_URL, oldServerlUrl, serverlUrl));
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUsername() {
		return username;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsername(String newUsername) {
		String oldUsername = username;
		username = newUsername;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TctaPackage.TCTA_CONNECTION__USERNAME, oldUsername, username));
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPassword() {
		return password;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPassword(String newPassword) {
		String oldPassword = password;
		password = newPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TctaPackage.TCTA_CONNECTION__PASSWORD, oldPassword, password));
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
		switch (featureID) {
			case TctaPackage.TCTA_CONNECTION__SERVERL_URL:
				return getServerlUrl();
			case TctaPackage.TCTA_CONNECTION__USERNAME:
				return getUsername();
			case TctaPackage.TCTA_CONNECTION__PASSWORD:
				return getPassword();
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
		switch (featureID) {
			case TctaPackage.TCTA_CONNECTION__SERVERL_URL:
				setServerlUrl((String)newValue);
				return;
			case TctaPackage.TCTA_CONNECTION__USERNAME:
				setUsername((String)newValue);
				return;
			case TctaPackage.TCTA_CONNECTION__PASSWORD:
				setPassword((String)newValue);
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
		switch (featureID) {
			case TctaPackage.TCTA_CONNECTION__SERVERL_URL:
				setServerlUrl(SERVERL_URL_EDEFAULT);
				return;
			case TctaPackage.TCTA_CONNECTION__USERNAME:
				setUsername(USERNAME_EDEFAULT);
				return;
			case TctaPackage.TCTA_CONNECTION__PASSWORD:
				setPassword(PASSWORD_EDEFAULT);
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
		switch (featureID) {
			case TctaPackage.TCTA_CONNECTION__SERVERL_URL:
				return SERVERL_URL_EDEFAULT == null ? serverlUrl != null : !SERVERL_URL_EDEFAULT.equals(serverlUrl);
			case TctaPackage.TCTA_CONNECTION__USERNAME:
				return USERNAME_EDEFAULT == null ? username != null : !USERNAME_EDEFAULT.equals(username);
			case TctaPackage.TCTA_CONNECTION__PASSWORD:
				return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
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
		result.append(" (serverlUrl: ");
		result.append(serverlUrl);
		result.append(", username: ");
		result.append(username);
		result.append(", password: ");
		result.append(password);
		result.append(')');
		return result.toString();
	}

} //tctaConnectionImpl
