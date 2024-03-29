package com.tibco.bw.sharedresource.tas.model.tas;

import com.tibco.bw.validation.sharedresource.SharedResourceConfigurationValidator;
import com.tibco.bw.validation.sharedresource.SharedResourceValidationContext;

public class TasConnectionValidator implements SharedResourceConfigurationValidator {
	/**
	 * <!-- begin-custom-doc -->
	 *
	 * <!-- end-custom-doc -->
	 * @generated
	 */
	public void validateSharedResourceConfiguration(SharedResourceValidationContext context) {
	    TasConnection model =(TasConnection) context.getSharedResourceModel();

//	    String spinnerModul = context.getSubstitutionBindingPropertyName("spinner");
//		if(spinnerModul == null || "".equals(spinnerModul)){
//		    Integer spinner = model.getSpinner();
//		    if(spinner == null || "".equals(spinner)) {
//		        String message = ""; //$NON-NLS-1$
//		        message = NLS.bind(Messages.SHAREDRESOURCE_PARAMETER_VALUE_INVALID, new String[] {"Spinner"});
//		        context.createError(message, null, MessageCode.PARAMETER_NOT_SPECIFIED, TasPackage.Literals.Tas_CONNECTION__SPINNER);
//		    }
//		}
//	    String comboViewerModul = context.getSubstitutionBindingPropertyName("comboViewer");
//		if(comboViewerModul == null || "".equals(comboViewerModul)){
//		    String comboViewer = model.getComboViewer();
//		    if(comboViewer == null || "".equals(comboViewer)) {
//		        String message = ""; //$NON-NLS-1$
//		        message = NLS.bind(Messages.SHAREDRESOURCE_PARAMETER_VALUE_INVALID, new String[] {"ComboViewer"});
//		        context.createError(message, null, MessageCode.PARAMETER_NOT_SPECIFIED, TasPackage.Literals.Tas_CONNECTION__COMBO_VIEWER);
//		    }
//		}
//	    String textBoxModul = context.getSubstitutionBindingPropertyName("textBox");
//		if(textBoxModul == null || "".equals(textBoxModul)){
//		    String textBox = model.getTextBox();
//		    if(textBox == null || "".equals(textBox)) {
//		        String message = ""; //$NON-NLS-1$
//		        message = NLS.bind(Messages.SHAREDRESOURCE_PARAMETER_VALUE_INVALID, new String[] {"TextBox"});
//		        context.createError(message, null, MessageCode.PARAMETER_NOT_SPECIFIED, TasPackage.Literals.Tas_CONNECTION__TEXT_BOX);
//		    }
//		}
		// begin-custom-code
	    // end-custom-code
	}
}
