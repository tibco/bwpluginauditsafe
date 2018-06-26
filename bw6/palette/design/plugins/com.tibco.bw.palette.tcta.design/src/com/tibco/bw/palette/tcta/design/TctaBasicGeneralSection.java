package com.tibco.bw.palette.tcta.design;

import javax.xml.namespace.QName;

import org.eclipse.swt.widgets.Composite;

import com.tibco.bw.design.field.BWFieldFactory;
import com.tibco.bw.design.field.PropertyField;
import com.tibco.bw.design.propertysection.AbstractBWTransactionalSection;
import com.tibco.bw.design.util.BWDesignConstants;
import com.tibco.bw.palette.tcta.model.tcta.TctaPackage;

public abstract class TctaBasicGeneralSection extends
		AbstractBWTransactionalSection {
	public  final QName SHAREDRESOURCE_QNAME = new QName(
			"http://ns.tibco.com/bw/sharedresource/tcta", "tctaConnection");
	protected PropertyField tctaConnection;

	@Override
	protected void initBindings() {
		 getBindingManager().bind(tctaConnection,
				 TctaPackage.Literals.TCTA_ABSTRACT_OBJECT__TCTA_CONNECTION,
				 getInput(),
				 BWFieldFactory.getInstance().getPropertyTargetToModelUpdateValueStrategy(), null);

	}

	@Override
	protected Composite doCreateControl(Composite root) {
		Composite parent = BWFieldFactory.getInstance().createComposite(root, 2);
		BWFieldFactory.getInstance().createLabel(parent, Messages.TCTA_CONNECTION_LABEL, true);
		tctaConnection = BWFieldFactory.getInstance().createPropertyField(parent, BWDesignConstants.PROPERTY,
				SHAREDRESOURCE_QNAME);
		tctaConnection.setDefaultPropertyPrefix("tctaConnection");
		 return parent;
	}



}
