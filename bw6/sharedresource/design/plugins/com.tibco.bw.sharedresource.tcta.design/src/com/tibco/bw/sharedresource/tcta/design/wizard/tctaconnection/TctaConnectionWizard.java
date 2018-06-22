package com.tibco.bw.sharedresource.tcta.design.wizard.tctaconnection;

import javax.xml.namespace.QName;

import org.eclipse.emf.ecore.EObject;

import com.tibco.bw.sharedresource.common.design.wizard.SharedResourceWizard;
import com.tibco.bw.sharedresource.tcta.design.TCTAUIPlugin;
import com.tibco.bw.sharedresource.tcta.model.helper.TCTAConstants;
import com.tibco.bw.sharedresource.tcta.model.tcta.TctaConnection;
import com.tibco.bw.sharedresource.tcta.model.tcta.TctaFactory;

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
		TctaConnection tctaconnection = TctaFactory.eINSTANCE.createtctaConnection();
		//set default value for the object if need
		return tctaconnection;
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
