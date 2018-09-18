/*
 * Copyright2013 TIBCO Software Inc.
 * All rights reserved.
 *
 * This software is confidential and proprietary information of TIBCO Software Inc.
 *
 */

package com.tibco.bw.sharedresource.tas.design.wizard;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.editor.FormEditor;

import com.tibco.bw.sharedresource.common.design.sr.AbstractBWSharedResourceFormPage;
import com.tibco.bw.sharedresource.tas.design.sections.TasConnectionSection;
import com.tibco.bw.sharedresource.tas.model.helper.TasConstants;

/**
 * @author <a href="mailto:zbin@tibco-support.com">Leslie Zhang</a>
 *
 * @since 1.0.0
 */
public class TasConnectionPage extends AbstractBWSharedResourceFormPage {

	/**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 */
	public TasConnectionPage(FormEditor editor) {
	    // begin-custom-code
		super(editor, TasConstants.TASCONNECTION_MAIN, TasConstants.TASCONNECTION_LABEL);
		// end-custom-code
	}

	/**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 */
	protected void addSections(Composite body) {
	    TasConnectionSection tasconnectionSection = new TasConnectionSection();
		addSectionControl(body, tasconnectionSection);
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
		return TasConstants.TASCONNECTION_PAGE_HEADER;
	}
	
}
