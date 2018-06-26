package com.tibco.bw.palette.tcta.design.upsertrow;

import org.eclipse.jface.viewers.ArrayContentProvider;
import com.tibco.bw.design.field.AttributeBindingField;
import com.tibco.bw.design.field.viewer.CustomComboViewer;
import com.tibco.bw.design.util.PropertyTypeQnameConstants;
import com.tibco.bw.palette.tcta.model.tcta.TctaPackage;

import org.eclipse.swt.widgets.Composite;
import com.tibco.bw.design.field.BWFieldFactory;
import com.tibco.bw.design.propertysection.AbstractBWTransactionalSection;
import com.tibco.bw.palette.tcta.model.tcta.UpsertRow;
import com.tibco.bw.palette.tcta.model.utils.Messages;
/**
 * General tab properties for the activity.
 */
public class UpsertRowAdvancedSection extends AbstractBWTransactionalSection {
    /**
	* <!-- begin-custom-doc -->
	*
	* <!-- end-custom-doc -->
	* @generated
	*/
    private AttributeBindingField comboViewerABF;
    /**
	* <!-- begin-custom-doc -->
	*
	* <!-- end-custom-doc -->
	* @generated
	*/
    private CustomComboViewer comboViewer;

    @Override
    protected Class<?> getModelClass() {
       return UpsertRow.class;
    }

    /**
	* <!-- begin-custom-doc -->
    *
	* <!-- end-custom-doc -->
	* @generated
	*/
    @Override
    protected void initBindings() {
   	    // begin-custom-code
        // end-custom-code
    }

	/**
	* <!-- begin-custom-doc -->
	*
	* <!-- end-custom-doc -->
	* @generated
	*/
    @Override
    protected Composite doCreateControl(final Composite root) {
        Composite parent = BWFieldFactory.getInstance().createComposite(root, 2);
   	    comboViewer = BWFieldFactory.getInstance().createComboViewer(parent);
   	    comboViewer.setContentProvider(new ArrayContentProvider());
   	    comboViewer.setInput(new String[]{"value1","value2"});

   	    BWFieldFactory.getInstance().createLabel(parent, Messages.UPSERTROW_COMBOVIEWER, false);
   	    comboViewerABF = BWFieldFactory.getInstance().createAttributeBindingField(parent, comboViewer.getControl(), PropertyTypeQnameConstants.STRING_PRIMITIVE, true);

        // begin-custom-code
        // end-custom-code
        return parent;
    }

}
