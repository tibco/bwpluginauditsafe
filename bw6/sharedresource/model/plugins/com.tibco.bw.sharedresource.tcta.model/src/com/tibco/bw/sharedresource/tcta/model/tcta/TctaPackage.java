/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.tibco.bw.sharedresource.tcta.model.tcta;

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
 * @see com.tibco.bw.sharedresource.tcta.model.tcta.TctaFactory
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
  String eNAME = "tcta";

  /**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_URI = "http://ns.tibco.com/bw/sharedresource/tcta";

  /**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_PREFIX = "tcta";

  /**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  TctaPackage eINSTANCE = com.tibco.bw.sharedresource.tcta.model.tcta.impl.TctaPackageImpl.init();

  /**
	 * The meta object id for the '{@link com.tibco.bw.sharedresource.tcta.model.tcta.impl.TctaConnectionImpl <em>tcta Connection</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.tibco.bw.sharedresource.tcta.model.tcta.impl.TctaConnectionImpl
	 * @see com.tibco.bw.sharedresource.tcta.model.tcta.impl.TctaPackageImpl#gettctaConnection()
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
	 * The feature id for the '<em><b>Serverl Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCTA_CONNECTION__SERVERL_URL = SvarmodelPackage.SUBSTITUTABLE_OBJECT_FEATURE_COUNT + 0;

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
	 * The number of structural features of the '<em>tcta Connection</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TCTA_CONNECTION_FEATURE_COUNT = SvarmodelPackage.SUBSTITUTABLE_OBJECT_FEATURE_COUNT + 3;


  /**
	 * Returns the meta object for class '{@link com.tibco.bw.sharedresource.tcta.model.tcta.TctaConnection <em>tcta Connection</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>tcta Connection</em>'.
	 * @see com.tibco.bw.sharedresource.tcta.model.tcta.TctaConnection
	 * @generated
	 */
  EClass gettctaConnection();

  /**
	 * Returns the meta object for the attribute '{@link com.tibco.bw.sharedresource.tcta.model.tcta.TctaConnection#getServerlUrl <em>Serverl Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Serverl Url</em>'.
	 * @see com.tibco.bw.sharedresource.tcta.model.tcta.TctaConnection#getServerlUrl()
	 * @see #gettctaConnection()
	 * @generated
	 */
	EAttribute gettctaConnection_ServerlUrl();

		/**
	 * Returns the meta object for the attribute '{@link com.tibco.bw.sharedresource.tcta.model.tcta.TctaConnection#getUsername <em>Username</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Username</em>'.
	 * @see com.tibco.bw.sharedresource.tcta.model.tcta.TctaConnection#getUsername()
	 * @see #gettctaConnection()
	 * @generated
	 */
	EAttribute gettctaConnection_Username();

		/**
	 * Returns the meta object for the attribute '{@link com.tibco.bw.sharedresource.tcta.model.tcta.TctaConnection#getPassword <em>Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password</em>'.
	 * @see com.tibco.bw.sharedresource.tcta.model.tcta.TctaConnection#getPassword()
	 * @see #gettctaConnection()
	 * @generated
	 */
	EAttribute gettctaConnection_Password();

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
		 * The meta object literal for the '{@link com.tibco.bw.sharedresource.tcta.model.tcta.impl.TctaConnectionImpl <em>tcta Connection</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see com.tibco.bw.sharedresource.tcta.model.tcta.impl.TctaConnectionImpl
		 * @see com.tibco.bw.sharedresource.tcta.model.tcta.impl.TctaPackageImpl#gettctaConnection()
		 * @generated
		 */
    EClass TCTA_CONNECTION = eINSTANCE.gettctaConnection();

    /**
		 * The meta object literal for the '<em><b>Serverl Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCTA_CONNECTION__SERVERL_URL = eINSTANCE.gettctaConnection_ServerlUrl();

				/**
		 * The meta object literal for the '<em><b>Username</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCTA_CONNECTION__USERNAME = eINSTANCE.gettctaConnection_Username();

				/**
		 * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCTA_CONNECTION__PASSWORD = eINSTANCE.gettctaConnection_Password();

  }

} //TctaPackage
