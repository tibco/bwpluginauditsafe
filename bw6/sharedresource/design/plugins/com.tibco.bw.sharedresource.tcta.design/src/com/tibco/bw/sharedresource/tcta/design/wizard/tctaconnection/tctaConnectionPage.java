/*
 * Copyright2013 TIBCO Software Inc.
 * All rights reserved.
 *
 * This software is confidential and proprietary information of TIBCO Software Inc.
 *
 */

package com.tibco.bw.sharedresource.tcta.design.wizard.tctaconnection;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.editor.FormEditor;

import com.tibco.bw.sharedresource.common.design.sr.AbstractBWSharedResourceFormPage;
import com.tibco.bw.sharedresource.tcta.design.sections.tctaConnectionSection;
import com.tibco.bw.sharedresource.tcta.model.helper.TCTAConstants;

/**
 * @author <a href="mailto:zbin@tibco-support.com">Leslie Zhang</a>
 *
 * @since 1.0.0
 */
public class tctaConnectionPage extends AbstractBWSharedResourceFormPage {

	/**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 */
	public tctaConnectionPage(FormEditor editor) {
	    // begin-custom-code
		super(editor, TCTAConstants.TCTACONNECTION_MAIN, TCTAConstants.TCTACONNECTION_LABEL);
		// end-custom-code
	}

	/**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 */
	protected void addSections(Composite body) {
	    tctaConnectionSection tctaconnectionSection = new tctaConnectionSection();
		addSectionControl(body, tctaconnectionSection);
	    // begin-custom-code
	    // end-custom-code
	}

	/**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 */
	protected String getSharedResourcePageHeader() {
		return TCTAConstants.TCTACONNECTION_PAGE_HEADER;
	}
	
}
