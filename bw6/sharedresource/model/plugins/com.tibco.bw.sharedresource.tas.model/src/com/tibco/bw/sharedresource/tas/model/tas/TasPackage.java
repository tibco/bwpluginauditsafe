/**
 */
package com.tibco.bw.sharedresource.tas.model.tas;

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
 * @see com.tibco.bw.sharedresource.tas.model.tas.TasFactory
 * @model kind="package"
 * @generated
 */
public interface TasPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "tas";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://ns.tibco.com/bw/sharedresource/tas";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "tas";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TasPackage eINSTANCE = com.tibco.bw.sharedresource.tas.model.tas.impl.TasPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.tibco.bw.sharedresource.tas.model.tas.impl.TasConnectionImpl <em>Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.tibco.bw.sharedresource.tas.model.tas.impl.TasConnectionImpl
	 * @see com.tibco.bw.sharedresource.tas.model.tas.impl.TasPackageImpl#getTasConnection()
	 * @generated
	 */
	int TAS_CONNECTION = 0;

	/**
	 * The feature id for the '<em><b>Substitution Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAS_CONNECTION__SUBSTITUTION_BINDINGS = SvarmodelPackage.SUBSTITUTABLE_OBJECT__SUBSTITUTION_BINDINGS;

	/**
	 * The feature id for the '<em><b>Server Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAS_CONNECTION__SERVER_URL = SvarmodelPackage.SUBSTITUTABLE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAS_CONNECTION__USERNAME = SvarmodelPackage.SUBSTITUTABLE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAS_CONNECTION__PASSWORD = SvarmodelPackage.SUBSTITUTABLE_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAS_CONNECTION__ID = SvarmodelPackage.SUBSTITUTABLE_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Schema</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAS_CONNECTION__SCHEMA = SvarmodelPackage.SUBSTITUTABLE_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Output</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAS_CONNECTION__OUTPUT = SvarmodelPackage.SUBSTITUTABLE_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Query Output</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAS_CONNECTION__QUERY_OUTPUT = SvarmodelPackage.SUBSTITUTABLE_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAS_CONNECTION_FEATURE_COUNT = SvarmodelPackage.SUBSTITUTABLE_OBJECT_FEATURE_COUNT + 7;


	/**
	 * Returns the meta object for class '{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection</em>'.
	 * @see com.tibco.bw.sharedresource.tas.model.tas.TasConnection
	 * @generated
	 */
	EClass getTasConnection();

	/**
	 * Returns the meta object for the attribute '{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getServerUrl <em>Server Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Server Url</em>'.
	 * @see com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getServerUrl()
	 * @see #getTasConnection()
	 * @generated
	 */
	EAttribute getTasConnection_ServerUrl();

	/**
	 * Returns the meta object for the attribute '{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getUsername <em>Username</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Username</em>'.
	 * @see com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getUsername()
	 * @see #getTasConnection()
	 * @generated
	 */
	EAttribute getTasConnection_Username();

	/**
	 * Returns the meta object for the attribute '{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getPassword <em>Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password</em>'.
	 * @see com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getPassword()
	 * @see #getTasConnection()
	 * @generated
	 */
	EAttribute getTasConnection_Password();

	/**
	 * Returns the meta object for the attribute '{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getId()
	 * @see #getTasConnection()
	 * @generated
	 */
	EAttribute getTasConnection_Id();

	/**
	 * Returns the meta object for the attribute '{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getSchema <em>Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Schema</em>'.
	 * @see com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getSchema()
	 * @see #getTasConnection()
	 * @generated
	 */
	EAttribute getTasConnection_Schema();

	/**
	 * Returns the meta object for the attribute '{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Output</em>'.
	 * @see com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getOutput()
	 * @see #getTasConnection()
	 * @generated
	 */
	EAttribute getTasConnection_Output();

	/**
	 * Returns the meta object for the attribute '{@link com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getQueryOutput <em>Query Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Query Output</em>'.
	 * @see com.tibco.bw.sharedresource.tas.model.tas.TasConnection#getQueryOutput()
	 * @see #getTasConnection()
	 * @generated
	 */
	EAttribute getTasConnection_QueryOutput();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TasFactory getTasFactory();

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
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.tibco.bw.sharedresource.tas.model.tas.impl.TasConnectionImpl <em>Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.tibco.bw.sharedresource.tas.model.tas.impl.TasConnectionImpl
		 * @see com.tibco.bw.sharedresource.tas.model.tas.impl.TasPackageImpl#getTasConnection()
		 * @generated
		 */
		EClass TAS_CONNECTION = eINSTANCE.getTasConnection();

		/**
		 * The meta object literal for the '<em><b>Server Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAS_CONNECTION__SERVER_URL = eINSTANCE.getTasConnection_ServerUrl();

		/**
		 * The meta object literal for the '<em><b>Username</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAS_CONNECTION__USERNAME = eINSTANCE.getTasConnection_Username();

		/**
		 * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAS_CONNECTION__PASSWORD = eINSTANCE.getTasConnection_Password();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAS_CONNECTION__ID = eINSTANCE.getTasConnection_Id();

		/**
		 * The meta object literal for the '<em><b>Schema</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAS_CONNECTION__SCHEMA = eINSTANCE.getTasConnection_Schema();

		/**
		 * The meta object literal for the '<em><b>Output</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAS_CONNECTION__OUTPUT = eINSTANCE.getTasConnection_Output();

		/**
		 * The meta object literal for the '<em><b>Query Output</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAS_CONNECTION__QUERY_OUTPUT = eINSTANCE.getTasConnection_QueryOutput();

	}

} //TasPackage
