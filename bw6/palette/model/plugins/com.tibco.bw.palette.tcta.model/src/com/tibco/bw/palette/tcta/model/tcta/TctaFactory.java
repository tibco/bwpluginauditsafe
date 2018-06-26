/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.tibco.bw.palette.tcta.model.tcta;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.tibco.bw.palette.tcta.model.tcta.TctaPackage
 * @generated
 */
public interface TctaFactory extends EFactory
{
  /**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  TctaFactory eINSTANCE = com.tibco.bw.palette.tcta.model.tcta.impl.TctaFactoryImpl.init();

  /**
	 * Returns a new object of class '<em>TCTA Get Token</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TCTA Get Token</em>'.
	 * @generated
	 */
	TCTAGetToken createTCTAGetToken();

		/**
	 * Returns a new object of class '<em>Upsert Row</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Upsert Row</em>'.
	 * @generated
	 */
	UpsertRow createUpsertRow();

		/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
  TctaPackage getTctaPackage();

} //TctaFactory
