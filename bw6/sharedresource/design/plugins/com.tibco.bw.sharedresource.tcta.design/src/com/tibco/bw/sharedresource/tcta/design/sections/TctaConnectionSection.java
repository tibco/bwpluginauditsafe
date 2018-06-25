/*
 * Copyright2013 TIBCO Software Inc.
 * All rights reserved.
 *
 * This software is confidential and proprietary information of TIBCO Software Inc.
 *
 */

package com.tibco.bw.sharedresource.tcta.design.sections;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.tibco.bw.design.field.BWFieldFactory;
import com.tibco.bw.design.field.PasswordField;
import com.tibco.bw.design.field.SRAttributeBindingField;
import com.tibco.bw.design.util.PropertyTypeQnameConstants;
import com.tibco.bw.sharedresource.common.design.sr.AbstractBWSharedResourceSection;
import com.tibco.bw.sharedresource.tcta.model.helper.Messages;
import com.tibco.bw.sharedresource.tcta.model.helper.TCTAConstants;
import com.tibco.bw.sharedresource.tcta.model.tcta.TctaPackage;

public class TctaConnectionSection extends AbstractBWSharedResourceSection {


	private Text serverUrl;
	private Text username;
	private PasswordField password;

	private SRAttributeBindingField serverUrlAttribute;
	private SRAttributeBindingField usernameAttribute;
	private SRAttributeBindingField passwordAttribute;

    /**
	 * <!-- begin-custom-doc -->
	 *
	 * <!-- end-custom-doc -->
	 * @generated
	 */
	protected void initBindings() {
        getBindingManager().bind(serverUrlAttribute, getInput(), TctaPackage.Literals.TCTA_CONNECTION__SERVERL_URL);
        getBindingManager().bind(usernameAttribute, getInput(), TctaPackage.Literals.TCTA_CONNECTION__USERNAME);
        getBindingManager().bind(passwordAttribute, getInput(), TctaPackage.Literals.TCTA_CONNECTION__PASSWORD);
	    // begin-custom-code
        // end-custom-code
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

        // begin-custom-code
        // end-custom-code
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

}
