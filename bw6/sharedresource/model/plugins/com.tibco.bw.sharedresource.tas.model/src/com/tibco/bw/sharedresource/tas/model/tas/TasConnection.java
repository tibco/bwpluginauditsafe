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
 * </p>
 * <ul>
 *   <li>{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getServerUrl <em>Server Url</em>}</li>
 *   <li>{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getUsername <em>Username</em>}</li>
 *   <li>{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getPassword <em>Password</em>}</li>
 *   <li>{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getId <em>Id</em>}</li>
 *   <li>{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getSchema <em>Schema</em>}</li>
 *   <li>{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getOutput <em>Output</em>}</li>
 *   <li>{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getQueryOutput <em>Query Output</em>}</li>
 *   <li>{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#isEnterprise <em>Enterprise</em>}</li>
 *   <li>{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#isUseToken <em>Use Token</em>}</li>
 *   <li>{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getAccessToken <em>Access Token</em>}</li>
 *   <li>{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getRefreshToken <em>Refresh Token</em>}</li>
 *   <li>{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getClientId <em>Client Id</em>}</li>
 *   <li>{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getClientSecret <em>Client Secret</em>}</li>
 *   <li>{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#isSso <em>Sso</em>}</li>
 * </ul>
 *
 * @see com.tibco.bw.sharedresource.tas.model.tas.TasPackage#getTasConnection()
 * @model annotation="http://tns.tibco.com/bw/annotations/configuration"
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
	 * Returns the value of the '<em><b>Enterprise</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enterprise</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enterprise</em>' attribute.
	 * @see #setEnterprise(boolean)
	 * @see com.tibco.bw.sharedresource.tas.model.tas.TasPackage#getTasConnection_Enterprise()
	 * @model default="false"
	 * @generated
	 */
	boolean isEnterprise();

	/**
	 * Sets the value of the '{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#isEnterprise <em>Enterprise</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enterprise</em>' attribute.
	 * @see #isEnterprise()
	 * @generated
	 */
	void setEnterprise(boolean value);

	/**
	 * Returns the value of the '<em><b>Use Token</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Token</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Token</em>' attribute.
	 * @see #setUseToken(boolean)
	 * @see com.tibco.bw.sharedresource.tas.model.tas.TasPackage#getTasConnection_UseToken()
	 * @model default="false"
	 * @generated
	 */
	boolean isUseToken();

	/**
	 * Sets the value of the '{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#isUseToken <em>Use Token</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Token</em>' attribute.
	 * @see #isUseToken()
	 * @generated
	 */
	void setUseToken(boolean value);

	/**
	 * Returns the value of the '<em><b>Access Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Access Token</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Access Token</em>' attribute.
	 * @see #setAccessToken(String)
	 * @see com.tibco.bw.sharedresource.tas.model.tas.TasPackage#getTasConnection_AccessToken()
	 * @model
	 * @generated
	 */
	String getAccessToken();

	/**
	 * Sets the value of the '{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getAccessToken <em>Access Token</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Access Token</em>' attribute.
	 * @see #getAccessToken()
	 * @generated
	 */
	void setAccessToken(String value);

	/**
	 * Returns the value of the '<em><b>Refresh Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refresh Token</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refresh Token</em>' attribute.
	 * @see #setRefreshToken(String)
	 * @see com.tibco.bw.sharedresource.tas.model.tas.TasPackage#getTasConnection_RefreshToken()
	 * @model
	 * @generated
	 */
	String getRefreshToken();

	/**
	 * Sets the value of the '{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getRefreshToken <em>Refresh Token</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Refresh Token</em>' attribute.
	 * @see #getRefreshToken()
	 * @generated
	 */
	void setRefreshToken(String value);

	/**
	 * Returns the value of the '<em><b>Client Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Client Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Client Id</em>' attribute.
	 * @see #setClientId(String)
	 * @see com.tibco.bw.sharedresource.tas.model.tas.TasPackage#getTasConnection_ClientId()
	 * @model
	 * @generated
	 */
	String getClientId();

	/**
	 * Sets the value of the '{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getClientId <em>Client Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Client Id</em>' attribute.
	 * @see #getClientId()
	 * @generated
	 */
	void setClientId(String value);

	/**
	 * Returns the value of the '<em><b>Client Secret</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Client Secret</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Client Secret</em>' attribute.
	 * @see #setClientSecret(String)
	 * @see com.tibco.bw.sharedresource.tas.model.tas.TasPackage#getTasConnection_ClientSecret()
	 * @model
	 * @generated
	 */
	String getClientSecret();

	/**
	 * Sets the value of the '{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getClientSecret <em>Client Secret</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Client Secret</em>' attribute.
	 * @see #getClientSecret()
	 * @generated
	 */
	void setClientSecret(String value);

	/**
	 * Returns the value of the '<em><b>Sso</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sso</em>' attribute.
	 * @see #setSso(boolean)
	 * @see com.tibco.bw.sharedresource.tas.model.tas.TasPackage#getTasConnection_Sso()
	 * @model
	 * @generated
	 */
	boolean isSso();

	/**
	 * Sets the value of the '{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#isSso <em>Sso</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sso</em>' attribute.
	 * @see #isSso()
	 * @generated
	 */
	void setSso(boolean value);

} // TasConnection
