/**
 */
package com.tibco.bw.sharedresource.tas.model.tas.impl;

import com.tibco.bw.sharedresource.tas.model.tas.TasConnection;
import com.tibco.bw.sharedresource.tas.model.tas.TasPackage;

import com.tibco.neo.svar.svarmodel.impl.SubstitutableObjectImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.tibco.bw.sharedresource.tas.model.tas.impl.TasConnectionImpl#getServerUrl <em>Server Url</em>}</li>
 *   <li>{@link com.tibco.bw.sharedresource.tas.model.tas.impl.TasConnectionImpl#getUsername <em>Username</em>}</li>
 *   <li>{@link com.tibco.bw.sharedresource.tas.model.tas.impl.TasConnectionImpl#getPassword <em>Password</em>}</li>
 *   <li>{@link com.tibco.bw.sharedresource.tas.model.tas.impl.TasConnectionImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.tibco.bw.sharedresource.tas.model.tas.impl.TasConnectionImpl#getSchema <em>Schema</em>}</li>
 *   <li>{@link com.tibco.bw.sharedresource.tas.model.tas.impl.TasConnectionImpl#getOutput <em>Output</em>}</li>
 *   <li>{@link com.tibco.bw.sharedresource.tas.model.tas.impl.TasConnectionImpl#getQueryOutput <em>Query Output</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TasConnectionImpl extends SubstitutableObjectImpl implements TasConnection {
	/**
	 * The default value of the '{@link #getServerUrl() <em>Server Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerUrl()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVER_URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getServerUrl() <em>Server Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerUrl()
	 * @generated
	 * @ordered
	 */
	protected String serverUrl = SERVER_URL_EDEFAULT;

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
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getSchema() <em>Schema</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchema()
	 * @generated
	 * @ordered
	 */
	protected static final String SCHEMA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSchema() <em>Schema</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchema()
	 * @generated
	 * @ordered
	 */
	protected String schema = SCHEMA_EDEFAULT;

	/**
	 * The default value of the '{@link #getOutput() <em>Output</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutput()
	 * @generated
	 * @ordered
	 */
	protected static final String OUTPUT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOutput() <em>Output</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutput()
	 * @generated
	 * @ordered
	 */
	protected String output = OUTPUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getQueryOutput() <em>Query Output</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueryOutput()
	 * @generated
	 * @ordered
	 */
	protected static final String QUERY_OUTPUT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQueryOutput() <em>Query Output</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueryOutput()
	 * @generated
	 * @ordered
	 */
	protected String queryOutput = QUERY_OUTPUT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TasConnectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TasPackage.Literals.TAS_CONNECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getServerUrl() {
		return serverUrl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServerUrl(String newServerUrl) {
		String oldServerUrl = serverUrl;
		serverUrl = newServerUrl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TasPackage.TAS_CONNECTION__SERVER_URL, oldServerUrl, serverUrl));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TasPackage.TAS_CONNECTION__USERNAME, oldUsername, username));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TasPackage.TAS_CONNECTION__PASSWORD, oldPassword, password));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TasPackage.TAS_CONNECTION__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSchema() {
		return schema;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSchema(String newSchema) {
		String oldSchema = schema;
		schema = newSchema;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TasPackage.TAS_CONNECTION__SCHEMA, oldSchema, schema));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOutput() {
		return output;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutput(String newOutput) {
		String oldOutput = output;
		output = newOutput;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TasPackage.TAS_CONNECTION__OUTPUT, oldOutput, output));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQueryOutput() {
		return queryOutput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueryOutput(String newQueryOutput) {
		String oldQueryOutput = queryOutput;
		queryOutput = newQueryOutput;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TasPackage.TAS_CONNECTION__QUERY_OUTPUT, oldQueryOutput, queryOutput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TasPackage.TAS_CONNECTION__SERVER_URL:
				return getServerUrl();
			case TasPackage.TAS_CONNECTION__USERNAME:
				return getUsername();
			case TasPackage.TAS_CONNECTION__PASSWORD:
				return getPassword();
			case TasPackage.TAS_CONNECTION__ID:
				return getId();
			case TasPackage.TAS_CONNECTION__SCHEMA:
				return getSchema();
			case TasPackage.TAS_CONNECTION__OUTPUT:
				return getOutput();
			case TasPackage.TAS_CONNECTION__QUERY_OUTPUT:
				return getQueryOutput();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TasPackage.TAS_CONNECTION__SERVER_URL:
				setServerUrl((String)newValue);
				return;
			case TasPackage.TAS_CONNECTION__USERNAME:
				setUsername((String)newValue);
				return;
			case TasPackage.TAS_CONNECTION__PASSWORD:
				setPassword((String)newValue);
				return;
			case TasPackage.TAS_CONNECTION__ID:
				setId((String)newValue);
				return;
			case TasPackage.TAS_CONNECTION__SCHEMA:
				setSchema((String)newValue);
				return;
			case TasPackage.TAS_CONNECTION__OUTPUT:
				setOutput((String)newValue);
				return;
			case TasPackage.TAS_CONNECTION__QUERY_OUTPUT:
				setQueryOutput((String)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case TasPackage.TAS_CONNECTION__SERVER_URL:
				setServerUrl(SERVER_URL_EDEFAULT);
				return;
			case TasPackage.TAS_CONNECTION__USERNAME:
				setUsername(USERNAME_EDEFAULT);
				return;
			case TasPackage.TAS_CONNECTION__PASSWORD:
				setPassword(PASSWORD_EDEFAULT);
				return;
			case TasPackage.TAS_CONNECTION__ID:
				setId(ID_EDEFAULT);
				return;
			case TasPackage.TAS_CONNECTION__SCHEMA:
				setSchema(SCHEMA_EDEFAULT);
				return;
			case TasPackage.TAS_CONNECTION__OUTPUT:
				setOutput(OUTPUT_EDEFAULT);
				return;
			case TasPackage.TAS_CONNECTION__QUERY_OUTPUT:
				setQueryOutput(QUERY_OUTPUT_EDEFAULT);
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TasPackage.TAS_CONNECTION__SERVER_URL:
				return SERVER_URL_EDEFAULT == null ? serverUrl != null : !SERVER_URL_EDEFAULT.equals(serverUrl);
			case TasPackage.TAS_CONNECTION__USERNAME:
				return USERNAME_EDEFAULT == null ? username != null : !USERNAME_EDEFAULT.equals(username);
			case TasPackage.TAS_CONNECTION__PASSWORD:
				return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
			case TasPackage.TAS_CONNECTION__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case TasPackage.TAS_CONNECTION__SCHEMA:
				return SCHEMA_EDEFAULT == null ? schema != null : !SCHEMA_EDEFAULT.equals(schema);
			case TasPackage.TAS_CONNECTION__OUTPUT:
				return OUTPUT_EDEFAULT == null ? output != null : !OUTPUT_EDEFAULT.equals(output);
			case TasPackage.TAS_CONNECTION__QUERY_OUTPUT:
				return QUERY_OUTPUT_EDEFAULT == null ? queryOutput != null : !QUERY_OUTPUT_EDEFAULT.equals(queryOutput);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (serverUrl: ");
		result.append(serverUrl);
		result.append(", username: ");
		result.append(username);
		result.append(", password: ");
		result.append(password);
		result.append(", id: ");
		result.append(id);
		result.append(", schema: ");
		result.append(schema);
		result.append(", output: ");
		result.append(output);
		result.append(", queryOutput: ");
		result.append(queryOutput);
		result.append(')');
		return result.toString();
	}

} //TasConnectionImpl
