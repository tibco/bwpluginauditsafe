/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.tibco.bw.palette.tcta.model.tcta.impl;

import com.tibco.bw.palette.tcta.model.tcta.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

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
			case TctaPackage.TCTA_GET_TOKEN: return createTCTAGetToken();
			case TctaPackage.UPSERT_ROW: return createUpsertRow();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCTAGetToken createTCTAGetToken() {
		TCTAGetTokenImpl tctaGetToken = new TCTAGetTokenImpl();
		return tctaGetToken;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UpsertRow createUpsertRow() {
		UpsertRowImpl upsertRow = new UpsertRowImpl();
		return upsertRow;
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
