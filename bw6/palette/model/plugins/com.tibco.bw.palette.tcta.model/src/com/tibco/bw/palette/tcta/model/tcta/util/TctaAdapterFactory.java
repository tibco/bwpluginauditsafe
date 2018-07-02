/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.tibco.bw.palette.tcta.model.tcta.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.tibco.bw.palette.tcta.model.tcta.TctaAbstractObject;
import com.tibco.bw.palette.tcta.model.tcta.TctaCreateTransaction;
import com.tibco.bw.palette.tcta.model.tcta.TctaGetToken;
import com.tibco.bw.palette.tcta.model.tcta.TctaPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.tibco.bw.palette.tcta.model.tcta.TctaPackage
 * @generated
 */
public class TctaAdapterFactory extends AdapterFactoryImpl
{
  /**
	 * The cached model package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected static TctaPackage modelPackage;

  /**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TctaAdapterFactory()
  {
		if (modelPackage == null) {
			modelPackage = TctaPackage.eINSTANCE;
		}
	}

  /**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
  @Override
  public boolean isFactoryForType(Object object)
  {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

  /**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected TctaSwitch<Adapter> modelSwitch =
    new TctaSwitch<Adapter>() {
			@Override
			public Adapter caseTctaAbstractObject(TctaAbstractObject object) {
				return createTctaAbstractObjectAdapter();
			}
			@Override
			public Adapter caseTctaGetToken(TctaGetToken object) {
				return createTctaGetTokenAdapter();
			}
			@Override
			public Adapter caseTctaCreateTransaction(TctaCreateTransaction object) {
				return createTctaCreateTransactionAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

  /**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
  @Override
  public Adapter createAdapter(Notifier target)
  {
		return modelSwitch.doSwitch((EObject)target);
	}


  /**
	 * Creates a new adapter for an object of class '{@link TctaAbstractObject <em>Abstract Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TctaAbstractObject
	 * @generated
	 */
	public Adapter createTctaAbstractObjectAdapter() {
		return null;
	}

		/**
	 * Creates a new adapter for an object of class '{@link com.tibco.bw.palette.tcta.model.tcta.TctaGetToken <em>Get Token</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.tibco.bw.palette.tcta.model.tcta.TctaGetToken
	 * @generated
	 */
	public Adapter createTctaGetTokenAdapter() {
		return null;
	}

		/**
	 * Creates a new adapter for an object of class '{@link com.tibco.bw.palette.tcta.model.tcta.TctaCreateTransaction <em>Create Transaction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.tibco.bw.palette.tcta.model.tcta.TctaCreateTransaction
	 * @generated
	 */
	public Adapter createTctaCreateTransactionAdapter() {
		return null;
	}

		/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
  public Adapter createEObjectAdapter()
  {
		return null;
	}

} //TctaAdapterFactory
