package com.tibco.bw.sharedresource.tas.design.wizard;

import org.eclipse.core.runtime.Status;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.IFormPage;

import com.tibco.bw.sharedresource.common.design.forms.AbstractSREditor;
import com.tibco.bw.sharedresource.tas.design.TCTAUIPlugin;

public class TctaConnectionSharedResourceEditor extends AbstractSREditor {

	public TctaConnectionSharedResourceEditor() {
		super();
	}

	/**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 */
	@Override
	protected void addPages() {
		try {
			IFormPage mainPage = new TctaConnectionPage(this);
			addPage(mainPage);
		} catch (PartInitException e) {
			TCTAUIPlugin.getDefault().getLog().log(new Status(Status.ERROR, TCTAUIPlugin.PLUGIN_ID, e.getMessage(), e));
			throw new IllegalStateException(e);
		}
		// begin-custom-code
		// end-custom-code
	}

}
