/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.tibco.bw.sharedresource.tas.model.tas;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import com.tibco.neo.svar.svarmodel.SvarmodelPackage;

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
 * @see com.tibco.bw.sharedresource.tas.model.tas.TctaFactory
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
  TctaPackage eINSTANCE = com.tibco.bw.sharedresource.tas.model.tas.impl.TctaPackageImpl.init();

  /**
	 * The meta object id for the '{@link com.tibco.bw.sharedresource.tas.model.tas.impl.TctaConnectionImpl <em>tas Connection</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.tibco.bw.sharedresource.tas.model.tas.impl.TctaConnectionImpl
	 * @see com.tibco.bw.sharedresource.tas.model.tas.impl.TctaPackageImpl#gettasConnection()
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
	 * The feature id for the '<em><b>Server Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCTA_CONNECTION__SERVER_URL = SvarmodelPackage.SUBSTITUTABLE_OBJECT_FEATURE_COUNT + 0;

		/**
	 * The feature id for the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCTA_CONNECTION__USERNAME = SvarmodelPackage.SUBSTITUTABLE_OBJECT_FEATURE_COUNT + 1;

		/**
	 * The feature id for the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCTA_CONNECTION__PASSWORD = SvarmodelPackage.SUBSTITUTABLE_OBJECT_FEATURE_COUNT + 2;

		/**
	 * The number of structural features of the '<em>tas Connection</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TCTA_CONNECTION_FEATURE_COUNT = SvarmodelPackage.SUBSTITUTABLE_OBJECT_FEATURE_COUNT + 3;


  /**
	 * Returns the meta object for class '{@link com.tibco.bw.sharedresource.tas.model.tas.TctaConnection <em>tas Connection</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>tas Connection</em>'.
	 * @see com.tibco.bw.sharedresource.tas.model.tas.TctaConnection
	 * @generated
	 */
  EClass gettasConnection();

  /**
	 * Returns the meta object for the attribute '{@link com.tibco.bw.sharedresource.tas.model.tas.TctaConnection#getServerUrl <em>Server Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Server Url</em>'.
	 * @see com.tibco.bw.sharedresource.tas.model.tas.TctaConnection#getServerUrl()
	 * @see #gettasConnection()
	 * @generated
	 */
	EAttribute gettasConnection_ServerUrl();

		/**
	 * Returns the meta object for the attribute '{@link com.tibco.bw.sharedresource.tas.model.tas.TctaConnection#getUsername <em>Username</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Username</em>'.
	 * @see com.tibco.bw.sharedresource.tas.model.tas.TctaConnection#getUsername()
	 * @see #gettasConnection()
	 * @generated
	 */
	EAttribute gettasConnection_Username();

		/**
	 * Returns the meta object for the attribute '{@link com.tibco.bw.sharedresource.tas.model.tas.TctaConnection#getPassword <em>Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password</em>'.
	 * @see com.tibco.bw.sharedresource.tas.model.tas.TctaConnection#getPassword()
	 * @see #gettasConnection()
	 * @generated
	 */
	EAttribute gettasConnection_Password();

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
		 * The meta object literal for the '{@link com.tibco.bw.sharedresource.tas.model.tas.impl.TctaConnectionImpl <em>tas Connection</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see com.tibco.bw.sharedresource.tas.model.tas.impl.TctaConnectionImpl
		 * @see com.tibco.bw.sharedresource.tas.model.tas.impl.TctaPackageImpl#gettasConnection()
		 * @generated
		 */
    EClass TCTA_CONNECTION = eINSTANCE.gettasConnection();

    /**
		 * The meta object literal for the '<em><b>Server Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCTA_CONNECTION__SERVER_URL = eINSTANCE.gettasConnection_ServerUrl();

				/**
		 * The meta object literal for the '<em><b>Username</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCTA_CONNECTION__USERNAME = eINSTANCE.gettasConnection_Username();

				/**
		 * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCTA_CONNECTION__PASSWORD = eINSTANCE.gettasConnection_Password();

  }

} //TctaPackage
