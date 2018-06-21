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
 *   <li>{@link com.tibco.bw.sharedresource.tcta.model.tcta.TctaConnection#getServerlUrl <em>Serverl Url</em>}</li>
 *   <li>{@link com.tibco.bw.sharedresource.tcta.model.tcta.TctaConnection#getUsername <em>Username</em>}</li>
 *   <li>{@link com.tibco.bw.sharedresource.tcta.model.tcta.TctaConnection#getPassword <em>Password</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.tibco.bw.sharedresource.tcta.model.tcta.TctaPackage#gettctaConnection()
 * @model
 * @generated
 */
public interface TctaConnection extends SubstitutableObject
{
  /**
	 * Returns the value of the '<em><b>Serverl Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Serverl Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Serverl Url</em>' attribute.
	 * @see #setServerlUrl(String)
	 * @see com.tibco.bw.sharedresource.tcta.model.tcta.TctaPackage#gettctaConnection_ServerlUrl()
	 * @model
	 * @generated
	 */
	String getServerlUrl();

	/**
	 * Sets the value of the '{@link com.tibco.bw.sharedresource.tcta.model.tcta.TctaConnection#getServerlUrl <em>Serverl Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Serverl Url</em>' attribute.
	 * @see #getServerlUrl()
	 * @generated
	 */
	void setServerlUrl(String value);

	/**
	 * Returns the value of the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Username</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Username</em>' attribute.
	 * @see #setUsername(String)
	 * @see com.tibco.bw.sharedresource.tcta.model.tcta.TctaPackage#gettctaConnection_Username()
	 * @model
	 * @generated
	 */
	String getUsername();

	/**
	 * Sets the value of the '{@link com.tibco.bw.sharedresource.tcta.model.tcta.TctaConnection#getUsername <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Username</em>' attribute.
	 * @see #getUsername()
	 * @generated
	 */
	void setUsername(String value);

	/**
	 * Returns the value of the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Password</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Password</em>' attribute.
	 * @see #setPassword(String)
	 * @see com.tibco.bw.sharedresource.tcta.model.tcta.TctaPackage#gettctaConnection_Password()
	 * @model
	 * @generated
	 */
	String getPassword();

	/**
	 * Sets the value of the '{@link com.tibco.bw.sharedresource.tcta.model.tcta.TctaConnection#getPassword <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password</em>' attribute.
	 * @see #getPassword()
	 * @generated
	 */
	void setPassword(String value);

} // tctaConnection
