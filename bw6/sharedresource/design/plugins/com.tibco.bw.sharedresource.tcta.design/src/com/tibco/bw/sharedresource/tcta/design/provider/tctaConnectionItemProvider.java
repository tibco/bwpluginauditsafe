/*
 *
 * Copyright2011 - 2013 TIBCO Software Inc.
 * All rights reserved.
 *
 * This software is confidential and proprietary information of TIBCO Software Inc.
 * Overridable true
 */
package com.tibco.bw.sharedresource.tcta.design.provider;

import com.tibco.bw.sharedresource.tcta.design.TCTAUIPlugin;
import com.tibco.bw.sharedresource.tcta.model.tcta.tctaConnection;
import com.tibco.bw.sharedresource.tcta.model.tcta.TctaPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import com.tibco.neo.svar.svarmodel.provider.SubstitutableObjectItemProvider;

/**
 * This is the item provider adapter for a {@link com.tibco.bw.sharedresource.TCTA.model.tcta.tctaConnection} object.
 */
public class tctaConnectionItemProvider
    extends SubstitutableObjectItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
    /**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 */
	public tctaConnectionItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

    /**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);
			
			addTextBoxPropertyDescriptor(object);
			addSpinnerPropertyDescriptor(object);
			addComboViewerPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}
	
    /**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 */
	protected void addTextBoxPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_tctaConnection_textBox_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_tctaConnection_textBox_feature", "_UI_tctaConnection_type"),
				 TctaPackage.Literals.TCTA_CONNECTION__TEXT_BOX,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}
	
    /**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 */
	protected void addSpinnerPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_tctaConnection_spinner_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_tctaConnection_spinner_feature", "_UI_tctaConnection_type"),
				 TctaPackage.Literals.TCTA_CONNECTION__SPINNER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}
	
    /**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 */
	protected void addComboViewerPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_tctaConnection_comboViewer_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_tctaConnection_comboViewer_feature", "_UI_tctaConnection_type"),
				 TctaPackage.Literals.TCTA_CONNECTION__COMBO_VIEWER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}
	
    /**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/tctaConnection"));
	}

    /**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = null;
		return label == null || label.length() == 0 ?
			getString("_UI_tctaConnection_type") :
			getString("_UI_tctaConnection_type") + " " + label;
	}

    /**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);
		switch (notification.getFeatureID(tctaConnection.class)) {
			
			case TctaPackage.TCTA_CONNECTION__TEXT_BOX:
			case TctaPackage.TCTA_CONNECTION__SPINNER:
			case TctaPackage.TCTA_CONNECTION__COMBO_VIEWER:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
	}

    /**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

    /**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return TCTAUIPlugin.getDefault();
	}

}
