/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.tibco.bw.palette.tas.model.tas.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.tibco.bw.palette.tas.model.tas.TctaCreateTransaction;
import com.tibco.bw.palette.tas.model.tas.TctaFactory;
import com.tibco.bw.palette.tas.model.tas.TctaGetToken;
import com.tibco.bw.palette.tas.model.tas.TctaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TctaFactoryImpl extends EFactoryImpl implements TctaFactory
{
  /**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static TctaFactory init()
  {
		try {
			TctaFactory theTctaFactory = (TctaFactory)EPackage.Registry.INSTANCE.getEFactory(TctaPackage.eNS_URI);
			if (theTctaFactory != null) {
				return theTctaFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TctaFactoryImpl();
	}

  /**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TctaFactoryImpl()
  {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public EObject create(EClass eClass)
  {
		switch (eClass.getClassifierID()) {
			case TctaPackage.TCTA_GET_TOKEN: return createTctaGetToken();
			case TctaPackage.TCTA_CREATE_TRANSACTION: return createTctaCreateTransaction();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TctaGetToken createTctaGetToken() {
		TctaGetTokenImpl tasGetToken = new TctaGetTokenImpl();
		return tasGetToken;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TctaCreateTransaction createTctaCreateTransaction() {
		TctaCreateTransactionImpl tasCreateTransaction = new TctaCreateTransactionImpl();
		return tasCreateTransaction;
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TctaPackage getTctaPackage()
  {
		return (TctaPackage)getEPackage();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
  @Deprecated
  public static TctaPackage getPackage()
  {
		return TctaPackage.eINSTANCE;
	}

} //TctaFactoryImpl
