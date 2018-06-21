/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.tibco.bw.sharedresource.tcta.model.tcta;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.tibco.bw.sharedresource.tcta.model.tcta.TctaPackage
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
  TctaFactory eINSTANCE = com.tibco.bw.sharedresource.tcta.model.tcta.impl.TctaFactoryImpl.init();

  /**
	 * Returns a new object of class '<em>tcta Connection</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>tcta Connection</em>'.
	 * @generated
	 */
  TctaConnection createtctaConnection();

  /**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
  TctaPackage getTctaPackage();

} //TctaFactory
