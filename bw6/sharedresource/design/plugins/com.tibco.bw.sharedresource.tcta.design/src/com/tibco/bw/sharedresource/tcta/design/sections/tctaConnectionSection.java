/*
 * Copyright2013 TIBCO Software Inc.
 * All rights reserved.
 *
 * This software is confidential and proprietary information of TIBCO Software Inc.
 *
 */

package com.tibco.bw.sharedresource.tcta.design.sections;

import org.eclipse.swt.SWT;
import org.eclipse.jface.viewers.ArrayContentProvider;
import com.tibco.bw.design.field.viewer.CustomComboViewer;
import com.tibco.bw.design.util.PropertyTypeQnameConstants;
import org.eclipse.swt.widgets.Spinner;
import com.tibco.bw.design.field.SRAttributeBindingField;
import org.eclipse.swt.widgets.Text;
import com.tibco.bw.sharedresource.tcta.model.tcta.TctaPackage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import com.tibco.bw.sharedresource.common.design.sr.AbstractBWSharedResourceSection;
import com.tibco.bw.design.field.BWFieldFactory;
import com.tibco.bw.sharedresource.tcta.model.helper.Messages;
import com.tibco.bw.sharedresource.tcta.model.helper.TCTAConstants;

public class tctaConnectionSection extends AbstractBWSharedResourceSection {
    /**
	* <!-- begin-custom-doc -->
	* 
	* <!-- end-custom-doc -->
	* @generated
	*/
    private SRAttributeBindingField textBoxSBF;
    /**
	* <!-- begin-custom-doc -->
	* 
	* <!-- end-custom-doc -->
	* @generated
	*/
    private Text textBox;
    /**
	* <!-- begin-custom-doc -->
	* 
	* <!-- end-custom-doc -->
	* @generated
	*/
    private Spinner spinner;
    /**
	* <!-- begin-custom-doc -->
	* 
	* <!-- end-custom-doc -->
	* @generated
	*/
    private SRAttributeBindingField comboViewerSBF;
    /**
	* <!-- begin-custom-doc -->
	* 
	* <!-- end-custom-doc -->
	* @generated
	*/
    private CustomComboViewer comboViewer;

    /**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 */
	protected void initBindings() {
        getBindingManager().bind(textBoxSBF, getInput(), TctaPackage.Literals.TCTA_CONNECTION__TEXT_BOX); 
        getBindingManager().bind(spinner, getInput(), TctaPackage.Literals.TCTA_CONNECTION__SPINNER); 
        getBindingManager().bindCustomViewer(comboViewer, getInput(), TctaPackage.Literals.TCTA_CONNECTION__COMBO_VIEWER, BWFieldFactory.getInstance().getPropertyTargetToModelUpdateValueStrategy(), null); 
        getBindingManager().bind(comboViewerSBF, getInput(), TctaPackage.Literals.TCTA_CONNECTION__COMBO_VIEWER); 
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
   	    textBox = BWFieldFactory.getInstance().createTextBox(sectionComposite);

   	    BWFieldFactory.getInstance().createLabel(sectionComposite, Messages.TCTACONNECTION_TEXTBOX, true);
   	    textBoxSBF = BWFieldFactory.getInstance().createSRAttributeBindingField(sectionComposite, textBox, PropertyTypeQnameConstants.STRING_PRIMITIVE);

   	    BWFieldFactory.getInstance().createLabel(sectionComposite, Messages.TCTACONNECTION_SPINNER, false);
   	    spinner = BWFieldFactory.getInstance().createSpinner(sectionComposite, 2, SWT.BORDER);

   	    comboViewer = BWFieldFactory.getInstance().createComboViewer(sectionComposite);
   	    comboViewer.setContentProvider(new ArrayContentProvider());
   	    comboViewer.setInput(new String[]{"value1","value2"});

   	    BWFieldFactory.getInstance().createLabel(sectionComposite, Messages.TCTACONNECTION_COMBOVIEWER, false);
   	    comboViewerSBF = BWFieldFactory.getInstance().createSRAttributeBindingField(sectionComposite, comboViewer.getControl(), PropertyTypeQnameConstants.STRING_PRIMITIVE);

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
