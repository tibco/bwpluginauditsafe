package com.tibco.bw.sharedresource.tas.design.wizard;

import javax.xml.namespace.QName;

import org.eclipse.emf.ecore.EObject;

import com.tibco.bw.sharedresource.common.design.wizard.SharedResourceWizard;
import com.tibco.bw.sharedresource.tas.design.TCTAUIPlugin;
import com.tibco.bw.sharedresource.tas.model.helper.TCTAConstants;
import com.tibco.bw.sharedresource.tas.model.tas.TctaConnection;
import com.tibco.bw.sharedresource.tas.model.tas.TctaFactory;

public class TctaConnectionWizard extends SharedResourceWizard {

	@Override
	protected String getDefaultFilename() {
		return TCTAConstants.TCTACONNECTION_FILE_NAME_DEFAULT;
	}

	@Override
	protected String getFileExtension() {
		return TCTAConstants.TCTACONNECTION_FILE_NAME_EXTENSION;
	}

	@Override
	protected EObject createConfigurationModelInstance() {
		TctaConnection tasconnection = TctaFactory.eINSTANCE.createTctaConnection();
		//set default value for the object if need
		return tasconnection;
	}

	@Override
	protected String getFirstPageTitle() {
		return TCTAConstants.TCTACONNECTION_PAGE_TITLE;
	}

	@Override
	protected String getImagePath() {
		return TCTAConstants.IMAGE_PATH;
	}

	@Override
	protected String getHostPluginID() {
		return TCTAUIPlugin.PLUGIN_ID;
	}

	@Override
	protected QName getType() {
		return TCTAConstants.TCTACONNECTION_QNAME;
	}

	@Override
	protected String getSRWizardTitle() {
		return TCTAConstants.TCTACONNECTION_PAGE_TITLE;
	}

	protected String getFirstPageDescription() {
		return TCTAConstants.TCTACONNECTION_PAGE_DESCRIPTION;
	}
}
