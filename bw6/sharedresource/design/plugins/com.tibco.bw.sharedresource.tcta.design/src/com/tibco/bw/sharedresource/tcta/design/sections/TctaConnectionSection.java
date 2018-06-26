/*
 * Copyright2013 TIBCO Software Inc.
 * All rights reserved.
 *
 * This software is confidential and proprietary information of TIBCO Software Inc.
 *
 */

package com.tibco.bw.sharedresource.tcta.design.sections;

import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
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
import com.tibco.bw.sharedresource.tcta.model.helper.Messages;
import com.tibco.bw.sharedresource.tcta.model.helper.TCTAConstants;
import com.tibco.bw.sharedresource.tcta.model.tcta.TctaConnection;
import com.tibco.bw.sharedresource.tcta.model.tcta.TctaPackage;
import com.tibco.neo.svar.svarmodel.SubstitutionBinding;

public class TctaConnectionSection extends AbstractBWSharedResourceSection {


	private Text serverUrl;
	private Text username;
	private PasswordField password;

	private SRAttributeBindingField serverUrlAttribute;
	private SRAttributeBindingField usernameAttribute;
	private SRAttributeBindingField passwordAttribute;

	private TctaConnection tctaConnection;

    /**
	 * <!-- begin-custom-doc -->
	 *
	 * <!-- end-custom-doc -->
	 * @generated
	 */
	protected void initBindings() {
		tctaConnection = (TctaConnection)getInput();
        getBindingManager().bind(serverUrlAttribute, tctaConnection, TctaPackage.Literals.TCTA_CONNECTION__SERVER_URL);
        getBindingManager().bind(usernameAttribute, tctaConnection, TctaPackage.Literals.TCTA_CONNECTION__USERNAME);
        getBindingManager().bind(passwordAttribute, tctaConnection, TctaPackage.Literals.TCTA_CONNECTION__PASSWORD);
	    // begin-custom-code
        // end-custom-code
	}

	public TctaConnection getTctaConnection() {
		return tctaConnection;
	}

	public void setTctaConnection(TctaConnection tctaConnection) {
		this.tctaConnection = tctaConnection;
	}

	/**
	 * <!-- begin-custom-doc -->
	 *
	 * <!-- end-custom-doc -->
	 * @generated
	 */
	protected void createChildControl(FormToolkit paramFormToolkit, Composite sectionComposite) {
		serverUrl = BWFieldFactory.getInstance().createTextBox(sectionComposite);
   	    BWFieldFactory.getInstance().createLabel(sectionComposite, Messages.TCTACONNECTION_SERVERURL, true);
   	    serverUrlAttribute = BWFieldFactory.getInstance().createSRAttributeBindingField(sectionComposite, serverUrl, PropertyTypeQnameConstants.STRING_PRIMITIVE);

   	    username = BWFieldFactory.getInstance().createTextBox(sectionComposite);
   	    BWFieldFactory.getInstance().createLabel(sectionComposite, Messages.TCTACONNECTION_USERNAME, false);
   	    usernameAttribute = BWFieldFactory.getInstance().createSRAttributeBindingField(sectionComposite, username, PropertyTypeQnameConstants.STRING_PRIMITIVE);

   	    password = BWFieldFactory.getInstance().createPasswordField(sectionComposite);
	    BWFieldFactory.getInstance().createLabel(sectionComposite, Messages.TCTACONNECTION_PASSWORD, false);
	    passwordAttribute = BWFieldFactory.getInstance().createSRAttributeBindingField(sectionComposite, password, PropertyTypeQnameConstants.STRING_PRIMITIVE);

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
		return TCTAConstants.TCTACONNECTION_CONFIGURATION_LABEL;
	}

	public void setFocus() {
		serverUrlAttribute.setFocus();
	}

	public String getServerUrl(TctaConnection connection) {
    	String url = connection.getServerUrl();
		EList<SubstitutionBinding> ds_substvars = connection.getSubstitutionBindings();
		for (SubstitutionBinding substitutionBinding : ds_substvars) {
			String propName = substitutionBinding.getPropName();
			String templateName = substitutionBinding.getTemplate();
			if (templateName.equals(TctaPackage.Literals.TCTA_CONNECTION__SERVER_URL.getName())){
				url = ModelHelper.INSTANCE.getModulePropertyValue(connection, propName);
                break;
			}
		}

		return url;
    }

	public String getUserName(TctaConnection connection) {
    	String username = connection.getUsername();
    	EList<SubstitutionBinding> ds_substvars = connection.getSubstitutionBindings();
		for (SubstitutionBinding substitutionBinding : ds_substvars) {
			String propName = substitutionBinding.getPropName();
			String templateName = substitutionBinding.getTemplate();
			if (templateName.equals(TctaPackage.Literals.TCTA_CONNECTION__USERNAME.getName())){
				username = ModelHelper.INSTANCE.getModulePropertyValue(connection, propName);
                break;
			}
		}
		return username;
    }

	public String getPassword(TctaConnection connection) {

    	String password = connection.getPassword();
		EList<SubstitutionBinding> ds_substvars = connection.getSubstitutionBindings();
		for (SubstitutionBinding substitutionBinding : ds_substvars) {
			String propName = substitutionBinding.getPropName();
			String templateName = substitutionBinding.getTemplate();
			if (templateName.equals(TctaPackage.Literals.TCTA_CONNECTION__PASSWORD.getName())){
				password = ModelHelper.INSTANCE.getModulePropertyValue(connection, propName);
                break;
			}
		}
		return EncryptionService.INSTANCE.getEncryptor().decrypt(password);
    }

}
