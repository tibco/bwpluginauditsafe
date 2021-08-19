/*
 * Copyright2013 TIBCO Software Inc.
 * All rights reserved.
 *
 * This software is confidential and proprietary information of TIBCO Software Inc.
 *
 */

package com.tibco.bw.sharedresource.tas.design.sections;

import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.tibco.bw.core.design.resource.util.EncryptionService;
import com.tibco.bw.design.field.BWFieldFactory;
import com.tibco.bw.design.field.PasswordField;
import com.tibco.bw.design.field.SRAttributeBindingField;
import com.tibco.bw.design.util.ModelHelper;
import com.tibco.bw.design.util.PropertyTypeQnameConstants;
import com.tibco.bw.sharedresource.common.design.sr.AbstractBWSharedResourceSection;
import com.tibco.bw.sharedresource.tas.design.wizard.TasConnectionPage;
import com.tibco.bw.sharedresource.tas.model.helper.Messages;
import com.tibco.bw.sharedresource.tas.model.helper.TasConstants;
import com.tibco.bw.sharedresource.tas.model.tas.TasConnection;
import com.tibco.bw.sharedresource.tas.model.tas.TasPackage;
import com.tibco.neo.svar.svarmodel.SubstitutionBinding;

public class TasConnectionTokenSection extends AbstractBWSharedResourceSection {

	
	private Text accessToken;
	private Text refreshToken;
	private Text clientId;
	private Text clientSecret;
	
	private SRAttributeBindingField accessTokenAttribute;
	private SRAttributeBindingField refreshTokenAttribute;
	private SRAttributeBindingField clientIdAttribute;
	private SRAttributeBindingField clientSecretAttribute;
	
	private TasConnection tasConnection;

	private TasConnectionPage page;

	public TasConnectionPage getPage() {
		return page;
	}

	public TasConnectionTokenSection(TasConnectionPage page){
		this.page = page;
	}

    /**
	 * <!-- begin-custom-doc -->
	 *
	 * <!-- end-custom-doc -->
	 * @generated
	 */
	protected void initBindings() {
		tasConnection = (TasConnection)getInput();

        getBindingManager().bind(accessTokenAttribute, tasConnection, TasPackage.Literals.TAS_CONNECTION__ACCESS_TOKEN);
        getBindingManager().bind(refreshTokenAttribute, tasConnection, TasPackage.Literals.TAS_CONNECTION__REFRESH_TOKEN);
        getBindingManager().bind(clientIdAttribute, tasConnection, TasPackage.Literals.TAS_CONNECTION__CLIENT_ID);
        getBindingManager().bind(clientSecretAttribute, tasConnection, TasPackage.Literals.TAS_CONNECTION__CLIENT_SECRET);
	    // begin-custom-code
        // end-custom-code
	}

	public TasConnection getTasConnection() {
		return tasConnection;
	}

	public void setTasConnection(TasConnection tasConnection) {
		this.tasConnection = tasConnection;
	}

	/**
	 * <!-- begin-custom-doc -->
	 *
	 * <!-- end-custom-doc -->
	 * @generated
	 */
	protected void createChildControl(FormToolkit paramFormToolkit, Composite sectionComposite) {

	    accessToken = BWFieldFactory.getInstance().createTextBox(sectionComposite);
	    BWFieldFactory.getInstance().createLabel(sectionComposite, Messages.TASCONNECTION_ACCESS_TOKEN, false);
	    accessTokenAttribute = BWFieldFactory.getInstance().createSRAttributeBindingField(sectionComposite, accessToken, PropertyTypeQnameConstants.STRING_PRIMITIVE);
	    
	    refreshToken = BWFieldFactory.getInstance().createTextBox(sectionComposite);
	    BWFieldFactory.getInstance().createLabel(sectionComposite, Messages.TASCONNECTION_REFRESH_TOKEN, false);
	    refreshTokenAttribute = BWFieldFactory.getInstance().createSRAttributeBindingField(sectionComposite, refreshToken, PropertyTypeQnameConstants.STRING_PRIMITIVE);
	    
	    clientId = BWFieldFactory.getInstance().createTextBox(sectionComposite);
	    BWFieldFactory.getInstance().createLabel(sectionComposite, Messages.TASCONNECTION_CLIENT_ID, false);
	    clientIdAttribute = BWFieldFactory.getInstance().createSRAttributeBindingField(sectionComposite, clientId, PropertyTypeQnameConstants.STRING_PRIMITIVE);
	    
	    clientSecret = BWFieldFactory.getInstance().createTextBox(sectionComposite);
	    BWFieldFactory.getInstance().createLabel(sectionComposite, Messages.TASCONNECTION_CLIENT_SECRET, false);
	    clientSecretAttribute = BWFieldFactory.getInstance().createSRAttributeBindingField(sectionComposite, clientSecret, PropertyTypeQnameConstants.STRING_PRIMITIVE);
	}

	/**
	 * <!-- begin-custom-doc -->
	 *
	 * <!-- end-custom-doc -->
	 * @generated
	 */
	protected String getSectionHeaderLabel() {
	    // begin-custom-code
		// end-custom-code
		return TasConstants.TASCONNECTION_TOKEN_CONFIGURATION_LABEL;
	}

	public void setFocus() {
		accessToken.setFocus();
	}
	
	public String getAccessToken(TasConnection connection) {
    	String token = connection.getAccessToken();
    	EList<SubstitutionBinding> ds_substvars = connection.getSubstitutionBindings();
		for (SubstitutionBinding substitutionBinding : ds_substvars) {
			String propName = substitutionBinding.getPropName();
			String templateName = substitutionBinding.getTemplate();
			if (templateName.equals(TasPackage.Literals.TAS_CONNECTION__ACCESS_TOKEN.getName())){
				token = ModelHelper.INSTANCE.getModulePropertyValue(connection, propName);
                break;
			}
		}
		return token;
    }
	
	public String getRefreshToken(TasConnection connection) {
    	String refreshToken = connection.getRefreshToken();
    	EList<SubstitutionBinding> ds_substvars = connection.getSubstitutionBindings();
		for (SubstitutionBinding substitutionBinding : ds_substvars) {
			String propName = substitutionBinding.getPropName();
			String templateName = substitutionBinding.getTemplate();
			if (templateName.equals(TasPackage.Literals.TAS_CONNECTION__REFRESH_TOKEN.getName())){
				refreshToken = ModelHelper.INSTANCE.getModulePropertyValue(connection, propName);
                break;
			}
		}
		return refreshToken;
    }
	
	public String getClientId(TasConnection connection) {
    	String clientId = connection.getClientId();
    	EList<SubstitutionBinding> ds_substvars = connection.getSubstitutionBindings();
		for (SubstitutionBinding substitutionBinding : ds_substvars) {
			String propName = substitutionBinding.getPropName();
			String templateName = substitutionBinding.getTemplate();
			if (templateName.equals(TasPackage.Literals.TAS_CONNECTION__CLIENT_ID.getName())){
				clientId = ModelHelper.INSTANCE.getModulePropertyValue(connection, propName);
                break;
			}
		}
		return clientId;
    }
	
	public String getClientSecret(TasConnection connection) {
    	String clientSecret = connection.getAccessToken();
    	EList<SubstitutionBinding> ds_substvars = connection.getSubstitutionBindings();
		for (SubstitutionBinding substitutionBinding : ds_substvars) {
			String propName = substitutionBinding.getPropName();
			String templateName = substitutionBinding.getTemplate();
			if (templateName.equals(TasPackage.Literals.TAS_CONNECTION__CLIENT_SECRET.getName())){
				clientSecret = ModelHelper.INSTANCE.getModulePropertyValue(connection, propName);
                break;
			}
		}
		return clientSecret;
    }

}
