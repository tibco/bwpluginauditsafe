package com.tibco.bw.palette.tas.design;

import javax.xml.namespace.QName;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import com.tibco.bw.design.field.BWFieldFactory;
import com.tibco.bw.design.field.PropertyField;
import com.tibco.bw.design.propertysection.AbstractBWTransactionalSection;
import com.tibco.bw.design.util.BWDesignConstants;
import com.tibco.bw.palette.tas.model.tas.TasPackage;

public abstract class TasBasicGeneralSection extends
		AbstractBWTransactionalSection {
	public  final QName SHAREDRESOURCE_QNAME = new QName(
			"http://ns.tibco.com/bw/sharedresource/tas", "tasConnection");
	protected PropertyField tasConnection;

	@Override
	protected void initBindings() {
		 getBindingManager().bind(tasConnection,
				 TasPackage.Literals.TAS_ABSTRACT_OBJECT__TAS_CONNECTION,
				 getInput(),
				 BWFieldFactory.getInstance().getPropertyTargetToModelUpdateValueStrategy(), null);

	}

	@Override
	protected Composite doCreateControl(Composite root) {
		Composite parent = BWFieldFactory.getInstance().createComposite(root, 2);
		BWFieldFactory.getInstance().createLabel(parent, Messages.TAS_CONNECTION_LABEL, true);
		tasConnection = BWFieldFactory.getInstance().createPropertyField(parent, BWDesignConstants.PROPERTY,
				SHAREDRESOURCE_QNAME);
		tasConnection.setDefaultPropertyPrefix("tasConnection");
		return parent;
	}

	protected void bind(Control control , EAttribute attr){
		getBindingManager().bind(control, getInput(), attr);
	}

	protected Button createCheckboxAttr(Composite parent , String labelName){
		BWFieldFactory.getInstance().createLabel(parent, labelName, false);
		return BWFieldFactory.getInstance().createCheckBox(parent);
	}
}
