/*
 * Copyright2013 TIBCO Software Inc.
 * All rights reserved.
 *
 * This software is confidential and proprietary information of TIBCO Software Inc.
 *
 */

package com.tibco.bw.sharedresource.tas.design.sections;

import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.IStatus;
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

public class TasConnectionSection extends AbstractBWSharedResourceSection {

	
	private Text serverUrl;
	private Text username;
	private PasswordField password;
	private Button isEnterprise;
	private Button isSSO;

	private SRAttributeBindingField serverUrlAttribute;
	private SRAttributeBindingField usernameAttribute;
	private SRAttributeBindingField passwordAttribute;
	private SRAttributeBindingField isEnterpriseAttribute;
	private SRAttributeBindingField isSSOAttribute;
	
	private Button useToken;
	private Text accessToken;
//	private Text refreshToken;
	private Text clientId;
	private PasswordField clientSecret;
	
	private Label usernameLabel;
	private Label passwordLabel;
	private Label accessTokenLabel;
	private Label clientIdLabel;
	private Label clientSecretLabel;
	
	private SRAttributeBindingField useTokenAttribute;
	private SRAttributeBindingField accessTokenAttribute;
//	private SRAttributeBindingField refreshTokenAttribute;
	private SRAttributeBindingField clientIdAttribute;
	private SRAttributeBindingField clientSecretAttribute;
	
	private TasConnection tasConnection;

	private TasConnectionPage page;

	public TasConnectionPage getPage() {
		return page;
	}

	public TasConnectionSection(TasConnectionPage page){
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
        getBindingManager().bind(serverUrlAttribute, tasConnection, TasPackage.Literals.TAS_CONNECTION__SERVER_URL);
        getBindingManager().bind(usernameAttribute, tasConnection, TasPackage.Literals.TAS_CONNECTION__USERNAME);
        getBindingManager().bind(passwordAttribute, tasConnection, TasPackage.Literals.TAS_CONNECTION__PASSWORD);
        
        getBindingManager().bind(accessTokenAttribute, tasConnection, TasPackage.Literals.TAS_CONNECTION__ACCESS_TOKEN);
//        getBindingManager().bind(refreshTokenAttribute, tasConnection, TasPackage.Literals.TAS_CONNECTION__REFRESH_TOKEN);
        getBindingManager().bind(clientIdAttribute, tasConnection, TasPackage.Literals.TAS_CONNECTION__CLIENT_ID);
        getBindingManager().bind(clientSecretAttribute, tasConnection, TasPackage.Literals.TAS_CONNECTION__CLIENT_SECRET);
        
        UpdateValueStrategy updateIsEnterpriseValueStrategy = new UpdateValueStrategy() {
			@Override
			protected IStatus doSet(final IObservableValue observableValue, final Object value) {
				
				boolean isSSO = (Boolean)value;
				if (isSSO) {
					usernameLabel.setVisible(!isSSO);
					passwordLabel.setVisible(!isSSO);
					accessTokenLabel.setVisible(!isSSO);
					clientIdLabel.setVisible(!isSSO);
					clientSecretLabel.setVisible(!isSSO);
					
					usernameAttribute.setVisible(!isSSO);
					passwordAttribute.setVisible(!isSSO);
					accessTokenAttribute.setVisible(!isSSO);
//					refreshTokenAttribute.getControl().setEnabled(useToken && !isEnterprise);
					clientIdAttribute.setVisible(!isSSO);
					clientSecretAttribute.setVisible(!isSSO);
					
				}else {
				
					boolean isEnterprise = (Boolean)value;
					boolean useToken = tasConnection.isUseToken();
					usernameLabel.setVisible(!useToken);
					passwordLabel.setVisible(!useToken);
					accessTokenLabel.setVisible(useToken&&isEnterprise);
					clientIdLabel.setVisible(useToken && !isEnterprise);
					clientSecretLabel.setVisible(useToken && !isEnterprise);
				
					usernameAttribute.setVisible(!useToken);
					passwordAttribute.setVisible(!useToken);
					accessTokenAttribute.setVisible(useToken&&isEnterprise);
//					refreshTokenAttribute.getControl().setEnabled(useToken && !isEnterprise);
					clientIdAttribute.setVisible(useToken && !isEnterprise);
					clientSecretAttribute.setVisible(useToken && !isEnterprise);
				}
				return super.doSet(observableValue, value);
			}
		};

		getBindingManager().bind(isEnterpriseAttribute, TasPackage.Literals.TAS_CONNECTION__ENTERPRISE, tasConnection, updateIsEnterpriseValueStrategy, updateIsEnterpriseValueStrategy);
		
		UpdateValueStrategy updateIsSSOValueStrategy = new UpdateValueStrategy() {
			@Override
			protected IStatus doSet(final IObservableValue observableValue, final Object value) {
				boolean isSSO = (Boolean)value;

				if (isSSO) {
					usernameLabel.setVisible(!isSSO);
					passwordLabel.setVisible(!isSSO);
					accessTokenLabel.setVisible(!isSSO);
					clientIdLabel.setVisible(!isSSO);
					clientSecretLabel.setVisible(!isSSO);
					
					usernameAttribute.setVisible(!isSSO);
					passwordAttribute.setVisible(!isSSO);
					accessTokenAttribute.setVisible(!isSSO);
//					refreshTokenAttribute.getControl().setEnabled(useToken && !isEnterprise);
					clientIdAttribute.setVisible(!isSSO);
					clientSecretAttribute.setVisible(!isSSO);
					
				}else {
					boolean isEnterprise = tasConnection.isEnterprise();
					boolean useToken = tasConnection.isUseToken();
				
					usernameLabel.setVisible(!useToken);
					passwordLabel.setVisible(!useToken);
					accessTokenLabel.setVisible(useToken&&isEnterprise);
					clientIdLabel.setVisible(useToken && !isEnterprise);
					clientSecretLabel.setVisible(useToken && !isEnterprise);
				
					usernameAttribute.setVisible(!useToken);
					passwordAttribute.setVisible(!useToken);
					accessTokenAttribute.setVisible(useToken&&isEnterprise);
//					refreshTokenAttribute.getControl().setEnabled(useToken && !isEnterprise);
					clientIdAttribute.setVisible(useToken && !isEnterprise);
					clientSecretAttribute.setVisible(useToken && !isEnterprise);
				}
				return super.doSet(observableValue, value);
			}
		};

		getBindingManager().bind(isSSOAttribute, TasPackage.Literals.TAS_CONNECTION__SSO, tasConnection, updateIsSSOValueStrategy, updateIsSSOValueStrategy);
		
		UpdateValueStrategy updateUseTokenValueStrategy = new UpdateValueStrategy() {
			@Override
			protected IStatus doSet(final IObservableValue observableValue, final Object value) {
				boolean isSSO = (Boolean)value;

				if (isSSO) {
					usernameLabel.setVisible(!isSSO);
					passwordLabel.setVisible(!isSSO);
					accessTokenLabel.setVisible(!isSSO);
					clientIdLabel.setVisible(!isSSO);
					clientSecretLabel.setVisible(!isSSO);
					
					usernameAttribute.setVisible(!isSSO);
					passwordAttribute.setVisible(!isSSO);
					accessTokenAttribute.setVisible(!isSSO);
//					refreshTokenAttribute.getControl().setEnabled(useToken && !isEnterprise);
					clientIdAttribute.setVisible(!isSSO);
					clientSecretAttribute.setVisible(!isSSO);
					
				}else {
				boolean isEnterprise = tasConnection.isEnterprise();
				boolean useToken = (Boolean)value;
				
				usernameLabel.setVisible(!useToken);
				passwordLabel.setVisible(!useToken);
				accessTokenLabel.setVisible(useToken&&isEnterprise);
				clientIdLabel.setVisible(useToken && !isEnterprise);
				clientSecretLabel.setVisible(useToken && !isEnterprise);
				
				usernameAttribute.setVisible(!useToken);
				passwordAttribute.setVisible(!useToken);
				accessTokenAttribute.setVisible(useToken&&isEnterprise);
//				refreshTokenAttribute.getControl().setEnabled(useToken && !isEnterprise);
				clientIdAttribute.setVisible(useToken && !isEnterprise);
				clientSecretAttribute.setVisible(useToken && !isEnterprise);
				}
				return super.doSet(observableValue, value);
			}
		};
        getBindingManager().bind(useTokenAttribute,  TasPackage.Literals.TAS_CONNECTION__USE_TOKEN, tasConnection, updateUseTokenValueStrategy, updateUseTokenValueStrategy);
        
        
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
		serverUrl = BWFieldFactory.getInstance().createTextBox(sectionComposite);
   	    BWFieldFactory.getInstance().createLabel(sectionComposite, Messages.TASCONNECTION_SERVERURL, true);
   	    serverUrlAttribute = BWFieldFactory.getInstance().createSRAttributeBindingField(sectionComposite, serverUrl, PropertyTypeQnameConstants.STRING_PRIMITIVE);

	    isEnterprise = BWFieldFactory.getInstance().createCheckBox(sectionComposite);
	    BWFieldFactory.getInstance().createLabel(sectionComposite, Messages.TASCONNECTION_IS_ENTERPRISE, false);
	    isEnterpriseAttribute  = BWFieldFactory.getInstance().createSRAttributeBindingField(sectionComposite, isEnterprise, PropertyTypeQnameConstants.BOOLEAN_PRIMITIVE);
	    
	    isSSO = BWFieldFactory.getInstance().createCheckBox(sectionComposite);
	    BWFieldFactory.getInstance().createLabel(sectionComposite, Messages.TASCONNECTION_IS_SSO, false);
	    isSSOAttribute  = BWFieldFactory.getInstance().createSRAttributeBindingField(sectionComposite, isSSO, PropertyTypeQnameConstants.BOOLEAN_PRIMITIVE);
	    
	    useToken = BWFieldFactory.getInstance().createCheckBox(sectionComposite);
	    BWFieldFactory.getInstance().createLabel(sectionComposite, Messages.TASCONNECTION_USE_TOKEN, false);
	    useTokenAttribute  = BWFieldFactory.getInstance().createSRAttributeBindingField(sectionComposite, useToken, PropertyTypeQnameConstants.BOOLEAN_PRIMITIVE);
	    
	    username = BWFieldFactory.getInstance().createTextBox(sectionComposite);
   	    usernameLabel =BWFieldFactory.getInstance().createLabel(sectionComposite, Messages.TASCONNECTION_USERNAME, false);
   	    usernameAttribute = BWFieldFactory.getInstance().createSRAttributeBindingField(sectionComposite, username, PropertyTypeQnameConstants.STRING_PRIMITIVE);

   	    password = BWFieldFactory.getInstance().createPasswordField(sectionComposite);
	    passwordLabel = BWFieldFactory.getInstance().createLabel(sectionComposite, Messages.TASCONNECTION_PASSWORD, false);
	    passwordAttribute = BWFieldFactory.getInstance().createSRAttributeBindingField(sectionComposite, password, PropertyTypeQnameConstants.PASSWORD_PRIMITIVE);
	    
	    accessToken = BWFieldFactory.getInstance().createTextBox(sectionComposite);
	    accessTokenLabel = BWFieldFactory.getInstance().createLabel(sectionComposite, Messages.TASCONNECTION_ACCESS_TOKEN, false);
	    accessTokenAttribute = BWFieldFactory.getInstance().createSRAttributeBindingField(sectionComposite, accessToken, PropertyTypeQnameConstants.STRING_PRIMITIVE);
    
//	    refreshToken = BWFieldFactory.getInstance().createTextBox(sectionComposite);
//	    BWFieldFactory.getInstance().createLabel(sectionComposite, Messages.TASCONNECTION_REFRESH_TOKEN, false);
//	    refreshTokenAttribute = BWFieldFactory.getInstance().createSRAttributeBindingField(sectionComposite, refreshToken, PropertyTypeQnameConstants.STRING_PRIMITIVE);

	    clientId = BWFieldFactory.getInstance().createTextBox(sectionComposite);
	    clientIdLabel = BWFieldFactory.getInstance().createLabel(sectionComposite, Messages.TASCONNECTION_CLIENT_ID, false);
	    clientIdAttribute = BWFieldFactory.getInstance().createSRAttributeBindingField(sectionComposite, clientId, PropertyTypeQnameConstants.STRING_PRIMITIVE);

	    
	    clientSecret = BWFieldFactory.getInstance().createPasswordField(sectionComposite);
	    clientSecretLabel =BWFieldFactory.getInstance().createLabel(sectionComposite, Messages.TASCONNECTION_CLIENT_SECRET, false);
	    clientSecretAttribute = BWFieldFactory.getInstance().createSRAttributeBindingField(sectionComposite, clientSecret, PropertyTypeQnameConstants.PASSWORD_PRIMITIVE);

	    
	    Composite buttonComposite = new Composite(sectionComposite, 0);
		buttonComposite.setLocation(0, 0);
		GridLayout gridLayout = new GridLayout(4, false);
		buttonComposite.setLayout(gridLayout);
	 	Label testLabel = paramFormToolkit.createLabel(sectionComposite,"Click test connection");
	 	testLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		TestConnectionButtonHelper testConnectionButton = new TestConnectionButtonHelper(this);
		testConnectionButton.settestLabel(testLabel);
		testConnectionButton.createTestConnectionButton(buttonComposite);
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
		return TasConstants.TASCONNECTION_CONFIGURATION_LABEL;
	}

	public void setFocus() {
		serverUrlAttribute.setFocus();
	}

	public String getServerUrl(TasConnection connection) {
    	String url = connection.getServerUrl();
		EList<SubstitutionBinding> ds_substvars = connection.getSubstitutionBindings();
		for (SubstitutionBinding substitutionBinding : ds_substvars) {
			String propName = substitutionBinding.getPropName();
			String templateName = substitutionBinding.getTemplate();
			if (templateName.equals(TasPackage.Literals.TAS_CONNECTION__SERVER_URL.getName())){
				url = ModelHelper.INSTANCE.getModulePropertyValue(connection, propName);
                break;
			}
		}

		return url;
    }

	public String getUserName(TasConnection connection) {
    	String username = connection.getUsername();
    	EList<SubstitutionBinding> ds_substvars = connection.getSubstitutionBindings();
		for (SubstitutionBinding substitutionBinding : ds_substvars) {
			String propName = substitutionBinding.getPropName();
			String templateName = substitutionBinding.getTemplate();
			if (templateName.equals(TasPackage.Literals.TAS_CONNECTION__USERNAME.getName())){
				username = ModelHelper.INSTANCE.getModulePropertyValue(connection, propName);
                break;
			}
		}
		return username;
    }

	public String getPassword(TasConnection connection) {

    	String password = connection.getPassword();
		EList<SubstitutionBinding> ds_substvars = connection.getSubstitutionBindings();
		for (SubstitutionBinding substitutionBinding : ds_substvars) {
			String propName = substitutionBinding.getPropName();
			String templateName = substitutionBinding.getTemplate();
			if (templateName.equals(TasPackage.Literals.TAS_CONNECTION__PASSWORD.getName())){
				password = ModelHelper.INSTANCE.getModulePropertyValue(connection, propName);
                break;
			}
		}
		return EncryptionService.INSTANCE.getEncryptor().decrypt(password);
    }
	
	public boolean isEnterpise(TasConnection connection) {

    	boolean isEnterprise = connection.isEnterprise();
    	EList<SubstitutionBinding> ds_substvars = connection.getSubstitutionBindings();
		for (SubstitutionBinding substitutionBinding : ds_substvars) {
			String propName = substitutionBinding.getPropName();
			String templateName = substitutionBinding.getTemplate();
			if (templateName.equals(TasPackage.Literals.TAS_CONNECTION__ENTERPRISE.getName())){
				isEnterprise = Boolean.valueOf(ModelHelper.INSTANCE.getModulePropertyValue(connection, propName));
                break;
			}
		}
    	return isEnterprise;
    }
	
	public boolean isSso(TasConnection connection) {

    	boolean isSso = connection.isSso();
    	EList<SubstitutionBinding> ds_substvars = connection.getSubstitutionBindings();
		for (SubstitutionBinding substitutionBinding : ds_substvars) {
			String propName = substitutionBinding.getPropName();
			String templateName = substitutionBinding.getTemplate();
			if (templateName.equals(TasPackage.Literals.TAS_CONNECTION__SSO.getName())){
				isSso = Boolean.valueOf(ModelHelper.INSTANCE.getModulePropertyValue(connection, propName));
                break;
			}
		}
    	return isSso;
    	}
    
	
	public boolean userToken(TasConnection connection) {

    	boolean useToken = connection.isUseToken();
    	EList<SubstitutionBinding> ds_substvars = connection.getSubstitutionBindings();
		for (SubstitutionBinding substitutionBinding : ds_substvars) {
			String propName = substitutionBinding.getPropName();
			String templateName = substitutionBinding.getTemplate();
			if (templateName.equals(TasPackage.Literals.TAS_CONNECTION__USE_TOKEN.getName())){
				useToken = Boolean.valueOf(ModelHelper.INSTANCE.getModulePropertyValue(connection, propName));
                break;
			}
		}
    	return useToken;
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
	
//	public String getRefreshToken(TasConnection connection) {
//    	String refreshToken = connection.getRefreshToken();
//    	EList<SubstitutionBinding> ds_substvars = connection.getSubstitutionBindings();
//		for (SubstitutionBinding substitutionBinding : ds_substvars) {
//			String propName = substitutionBinding.getPropName();
//			String templateName = substitutionBinding.getTemplate();
//			if (templateName.equals(TasPackage.Literals.TAS_CONNECTION__REFRESH_TOKEN.getName())){
//				refreshToken = ModelHelper.INSTANCE.getModulePropertyValue(connection, propName);
//                break;
//			}
//		}
//		return refreshToken;
//    }
	
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
    	String clientSecret = connection.getClientSecret();
    	EList<SubstitutionBinding> ds_substvars = connection.getSubstitutionBindings();
		for (SubstitutionBinding substitutionBinding : ds_substvars) {
			String propName = substitutionBinding.getPropName();
			String templateName = substitutionBinding.getTemplate();
			if (templateName.equals(TasPackage.Literals.TAS_CONNECTION__CLIENT_SECRET.getName())){
				clientSecret = ModelHelper.INSTANCE.getModulePropertyValue(connection, propName);
                break;
			}
		}
		return EncryptionService.INSTANCE.getEncryptor().decrypt(clientSecret);
    }

}
