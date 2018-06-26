/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.tibco.bw.palette.tcta.model.tcta;

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
 * @see com.tibco.bw.palette.tcta.model.tcta.TctaFactory
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
  String eNS_URI = "http://ns.tibco.com/bw/palette/tcta";

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
  TctaPackage eINSTANCE = com.tibco.bw.palette.tcta.model.tcta.impl.TctaPackageImpl.init();

  /**
	 * The meta object id for the '{@link com.tibco.bw.palette.tcta.model.tcta.impl.TctaAbstractObjectImpl <em>Abstract Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.tibco.bw.palette.tcta.model.tcta.impl.TctaAbstractObjectImpl
	 * @see com.tibco.bw.palette.tcta.model.tcta.impl.TctaPackageImpl#getTctaAbstractObject()
	 * @generated
	 */
	int TCTA_ABSTRACT_OBJECT = 0;

		/**
	 * The feature id for the '<em><b>Tcta Connection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCTA_ABSTRACT_OBJECT__TCTA_CONNECTION = 0;

		/**
	 * The number of structural features of the '<em>Abstract Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCTA_ABSTRACT_OBJECT_FEATURE_COUNT = 1;

		/**
	 * The meta object id for the '{@link com.tibco.bw.palette.tcta.model.tcta.impl.TctaGetTokenImpl <em>Get Token</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.tibco.bw.palette.tcta.model.tcta.impl.TctaGetTokenImpl
	 * @see com.tibco.bw.palette.tcta.model.tcta.impl.TctaPackageImpl#getTctaGetToken()
	 * @generated
	 */
	int TCTA_GET_TOKEN = 1;

		/**
	 * The feature id for the '<em><b>Tcta Connection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCTA_GET_TOKEN__TCTA_CONNECTION = TCTA_ABSTRACT_OBJECT__TCTA_CONNECTION;

		/**
	 * The number of structural features of the '<em>Get Token</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCTA_GET_TOKEN_FEATURE_COUNT = TCTA_ABSTRACT_OBJECT_FEATURE_COUNT + 0;


		/**
	 * The meta object id for the '{@link com.tibco.bw.palette.tcta.model.tcta.impl.UpsertRowImpl <em>Upsert Row</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.tibco.bw.palette.tcta.model.tcta.impl.UpsertRowImpl
	 * @see com.tibco.bw.palette.tcta.model.tcta.impl.TctaPackageImpl#getUpsertRow()
	 * @generated
	 */
	int UPSERT_ROW = 2;

		/**
	 * The feature id for the '<em><b>Tcta Connection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPSERT_ROW__TCTA_CONNECTION = TCTA_ABSTRACT_OBJECT__TCTA_CONNECTION;

		/**
	 * The number of structural features of the '<em>Upsert Row</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPSERT_ROW_FEATURE_COUNT = TCTA_ABSTRACT_OBJECT_FEATURE_COUNT + 0;

		/**
	 * Returns the meta object for class '{@link TctaAbstractObject <em>Abstract Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Object</em>'.
	 * @see TctaAbstractObject
	 * @model instanceClass="TctaAbstractObject"
	 * @generated
	 */
	EClass getTctaAbstractObject();

		/**
	 * Returns the meta object for the attribute '{@link TctaAbstractObject#getTctaConnection <em>Tcta Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tcta Connection</em>'.
	 * @see TctaAbstractObject#getTctaConnection()
	 * @see #getTctaAbstractObject()
	 * @generated
	 */
	EAttribute getTctaAbstractObject_TctaConnection();

		/**
	 * Returns the meta object for class '{@link com.tibco.bw.palette.tcta.model.tcta.TctaGetToken <em>Get Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Token</em>'.
	 * @see com.tibco.bw.palette.tcta.model.tcta.TctaGetToken
	 * @generated
	 */
	EClass getTctaGetToken();

		/**
	 * Returns the meta object for class '{@link com.tibco.bw.palette.tcta.model.tcta.UpsertRow <em>Upsert Row</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Upsert Row</em>'.
	 * @see com.tibco.bw.palette.tcta.model.tcta.UpsertRow
	 * @generated
	 */
	EClass getUpsertRow();

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
		 * The meta object literal for the '{@link com.tibco.bw.palette.tcta.model.tcta.impl.TctaAbstractObjectImpl <em>Abstract Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.tibco.bw.palette.tcta.model.tcta.impl.TctaAbstractObjectImpl
		 * @see com.tibco.bw.palette.tcta.model.tcta.impl.TctaPackageImpl#getTctaAbstractObject()
		 * @generated
		 */
		EClass TCTA_ABSTRACT_OBJECT = eINSTANCE.getTctaAbstractObject();

			/**
		 * The meta object literal for the '<em><b>Tcta Connection</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCTA_ABSTRACT_OBJECT__TCTA_CONNECTION = eINSTANCE.getTctaAbstractObject_TctaConnection();

			/**
		 * The meta object literal for the '{@link com.tibco.bw.palette.tcta.model.tcta.impl.TctaGetTokenImpl <em>Get Token</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.tibco.bw.palette.tcta.model.tcta.impl.TctaGetTokenImpl
		 * @see com.tibco.bw.palette.tcta.model.tcta.impl.TctaPackageImpl#getTctaGetToken()
		 * @generated
		 */
		EClass TCTA_GET_TOKEN = eINSTANCE.getTctaGetToken();

			/**
		 * The meta object literal for the '{@link com.tibco.bw.palette.tcta.model.tcta.impl.UpsertRowImpl <em>Upsert Row</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.tibco.bw.palette.tcta.model.tcta.impl.UpsertRowImpl
		 * @see com.tibco.bw.palette.tcta.model.tcta.impl.TctaPackageImpl#getUpsertRow()
		 * @generated
		 */
		EClass UPSERT_ROW = eINSTANCE.getUpsertRow();

  }

} //TctaPackage
