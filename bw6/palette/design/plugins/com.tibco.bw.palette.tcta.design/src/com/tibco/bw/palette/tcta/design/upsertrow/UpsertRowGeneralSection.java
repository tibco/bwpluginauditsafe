package com.tibco.bw.palette.tcta.design.upsertrow;

import org.eclipse.swt.SWT;
import com.tibco.bw.design.field.AttributeBindingField;
import javax.xml.namespace.QName;
import com.tibco.bw.design.util.BWDesignConstants;
import com.tibco.bw.design.util.PropertyTypeQnameConstants;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import com.tibco.bw.palette.tcta.model.tcta.TctaPackage;
import com.tibco.bw.design.field.PropertyField;
import org.eclipse.swt.widgets.Button;

import org.eclipse.swt.widgets.Composite;
import com.tibco.bw.design.field.BWFieldFactory;
import com.tibco.bw.design.propertysection.AbstractBWTransactionalSection;
import com.tibco.bw.palette.tcta.model.tcta.UpsertRow;
import com.tibco.bw.palette.tcta.model.utils.Messages;
/**
 * General tab properties for the activity.
 */
public class UpsertRowGeneralSection extends AbstractBWTransactionalSection {
    /**
	* <!-- begin-custom-doc -->
	*
	* <!-- end-custom-doc -->
	* @generated
	*/
    public static final QName SHAREDRESOURCE_QNAME = new QName("http://ns.tibco.com/bw/sharedresource/tcta", "tctaConnection");
    /**
	* <!-- begin-custom-doc -->
	*
	* <!-- end-custom-doc -->
	* @generated
	*/
    private PropertyField propertyField;
    /**
	* <!-- begin-custom-doc -->
	*
	* <!-- end-custom-doc -->
	* @generated
	*/
    private AttributeBindingField checkBoxABF;
    /**
	* <!-- begin-custom-doc -->
	*
	* <!-- end-custom-doc -->
	* @generated
	*/
    private Button checkBox;
    /**
	* <!-- begin-custom-doc -->
	*
	* <!-- end-custom-doc -->
	* @generated
	*/
    private AttributeBindingField textBoxABF;
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
   	    BWFieldFactory.getInstance().createLabel(parent, Messages.UPSERTROW_PROPERTYFIELD, false);
   	    propertyField = BWFieldFactory.getInstance().createPropertyField(parent, BWDesignConstants.PROPERTY, SHAREDRESOURCE_QNAME);
   	    checkBox = BWFieldFactory.getInstance().createCheckBox(parent);

   	    BWFieldFactory.getInstance().createLabel(parent, Messages.UPSERTROW_CHECKBOX, false);
   	    checkBoxABF = BWFieldFactory.getInstance().createAttributeBindingField(parent, checkBox, PropertyTypeQnameConstants.BOOLEAN_PRIMITIVE, true);

   	    textBox = BWFieldFactory.getInstance().createTextBox(parent);

   	    BWFieldFactory.getInstance().createLabel(parent, Messages.UPSERTROW_TEXTBOX, true);
   	    textBoxABF = BWFieldFactory.getInstance().createAttributeBindingField(parent, textBox, PropertyTypeQnameConstants.STRING_PRIMITIVE, true);

   	    BWFieldFactory.getInstance().createLabel(parent, Messages.UPSERTROW_SPINNER, false);
   	    spinner = BWFieldFactory.getInstance().createSpinner(parent, 2, SWT.BORDER);

        // begin-custom-code
        // end-custom-code
        return parent;
    }

}
