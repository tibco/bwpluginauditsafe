package com.tibco.bw.sharedresource.tas.design.wizard;

import javax.xml.namespace.QName;

import org.eclipse.emf.ecore.EObject;

import com.tibco.bw.sharedresource.common.design.wizard.SharedResourceWizard;
import com.tibco.bw.sharedresource.tas.design.TASUIPlugin;
import com.tibco.bw.sharedresource.tas.model.helper.TasConstants;
import com.tibco.bw.sharedresource.tas.model.tas.TasConnection;
import com.tibco.bw.sharedresource.tas.model.tas.TasFactory;

public class TasConnectionWizard extends SharedResourceWizard {

	@Override
	protected String getDefaultFilename() {
		return TasConstants.TASCONNECTION_FILE_NAME_DEFAULT;
	}

	@Override
	protected String getFileExtension() {
		return TasConstants.TASCONNECTION_FILE_NAME_EXTENSION;
	}

	@Override
	protected EObject createConfigurationModelInstance() {
		TasConnection tasconnection = TasFactory.eINSTANCE.createTasConnection();
		//set default value for the object if need
		return tasconnection;
	}

	@Override
	protected String getFirstPageTitle() {
		return TasConstants.TASCONNECTION_PAGE_TITLE;
	}

	@Override
	protected String getImagePath() {
		return TasConstants.IMAGE_PATH;
	}

	@Override
	protected String getHostPluginID() {
		return TASUIPlugin.PLUGIN_ID;
	}

	@Override
	protected QName getType() {
		return TasConstants.TASCONNECTION_QNAME;
	}

	@Override
	protected String getSRWizardTitle() {
		return TasConstants.TASCONNECTION_PAGE_TITLE;
	}

	protected String getFirstPageDescription() {
		return TasConstants.TASCONNECTION_PAGE_DESCRIPTION;
	}
}
