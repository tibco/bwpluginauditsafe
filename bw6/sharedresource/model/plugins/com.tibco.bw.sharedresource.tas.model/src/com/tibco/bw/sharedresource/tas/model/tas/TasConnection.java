/**
 */
package com.tibco.bw.sharedresource.tas.model.tas;

import com.tibco.neo.svar.svarmodel.SubstitutableObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getServerUrl <em>Server Url</em>}</li>
 *   <li>{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getUsername <em>Username</em>}</li>
 *   <li>{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getPassword <em>Password</em>}</li>
 *   <li>{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getId <em>Id</em>}</li>
 *   <li>{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getSchema <em>Schema</em>}</li>
 *   <li>{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getOutput <em>Output</em>}</li>
 *   <li>{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getQueryOutput <em>Query Output</em>}</li>
 *   <li>{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#isIsEnterprise <em>Is Enterprise</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.tibco.bw.sharedresource.tas.model.tas.TasPackage#getTasConnection()
 * @model
 * @generated
 */
public interface TasConnection extends SubstitutableObject {
	/**
	 * Returns the value of the '<em><b>Server Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Server Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Server Url</em>' attribute.
	 * @see #setServerUrl(String)
	 * @see com.tibco.bw.sharedresource.tas.model.tas.TasPackage#getTasConnection_ServerUrl()
	 * @model
	 * @generated
	 */
	String getServerUrl();

	/**
	 * Sets the value of the '{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getServerUrl <em>Server Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Server Url</em>' attribute.
	 * @see #getServerUrl()
	 * @generated
	 */
	void setServerUrl(String value);

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
	 * @see com.tibco.bw.sharedresource.tas.model.tas.TasPackage#getTasConnection_Username()
	 * @model
	 * @generated
	 */
	String getUsername();

	/**
	 * Sets the value of the '{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getUsername <em>Username</em>}' attribute.
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
	 * @see com.tibco.bw.sharedresource.tas.model.tas.TasPackage#getTasConnection_Password()
	 * @model
	 * @generated
	 */
	String getPassword();

	/**
	 * Sets the value of the '{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getPassword <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password</em>' attribute.
	 * @see #getPassword()
	 * @generated
	 */
	void setPassword(String value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see com.tibco.bw.sharedresource.tas.model.tas.TasPackage#getTasConnection_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Schema</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schema</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schema</em>' attribute.
	 * @see #setSchema(String)
	 * @see com.tibco.bw.sharedresource.tas.model.tas.TasPackage#getTasConnection_Schema()
	 * @model
	 * @generated
	 */
	String getSchema();

	/**
	 * Sets the value of the '{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getSchema <em>Schema</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schema</em>' attribute.
	 * @see #getSchema()
	 * @generated
	 */
	void setSchema(String value);

	/**
	 * Returns the value of the '<em><b>Output</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output</em>' attribute.
	 * @see #setOutput(String)
	 * @see com.tibco.bw.sharedresource.tas.model.tas.TasPackage#getTasConnection_Output()
	 * @model
	 * @generated
	 */
	String getOutput();

	/**
	 * Sets the value of the '{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getOutput <em>Output</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output</em>' attribute.
	 * @see #getOutput()
	 * @generated
	 */
	void setOutput(String value);

	/**
	 * Returns the value of the '<em><b>Query Output</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Query Output</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Query Output</em>' attribute.
	 * @see #setQueryOutput(String)
	 * @see com.tibco.bw.sharedresource.tas.model.tas.TasPackage#getTasConnection_QueryOutput()
	 * @model
	 * @generated
	 */
	String getQueryOutput();

	/**
	 * Sets the value of the '{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getQueryOutput <em>Query Output</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query Output</em>' attribute.
	 * @see #getQueryOutput()
	 * @generated
	 */
	void setQueryOutput(String value);

	/**
	 * Returns the value of the '<em><b>Is Enterprise</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Enterprise</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Enterprise</em>' attribute.
	 * @see #setIsEnterprise(boolean)
	 * @see com.tibco.bw.sharedresource.tas.model.tas.TasPackage#getTasConnection_IsEnterprise()
	 * @model default="false"
	 * @generated
	 */
	boolean isIsEnterprise();

	/**
	 * Sets the value of the '{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#isIsEnterprise <em>Is Enterprise</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Enterprise</em>' attribute.
	 * @see #isIsEnterprise()
	 * @generated
	 */
	void setIsEnterprise(boolean value);

} // TasConnection
