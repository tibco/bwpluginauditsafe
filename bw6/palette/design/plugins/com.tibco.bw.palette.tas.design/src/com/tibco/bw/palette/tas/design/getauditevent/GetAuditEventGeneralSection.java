package com.tibco.bw.palette.tas.design.getauditevent;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import com.tibco.bw.design.field.AttributeBindingField;
import com.tibco.bw.design.field.BWFieldFactory;
import com.tibco.bw.design.util.BWDesignConstants;
import com.tibco.bw.design.util.PropertyTypeQnameConstants;
import com.tibco.bw.palette.tas.design.Messages;
import com.tibco.bw.palette.tas.design.TasBasicGeneralSection;
import com.tibco.bw.palette.tas.model.tas.GetAuditEvent;
import com.tibco.bw.palette.tas.model.tas.TasPackage;
/**
 * General tab properties for the activity.
 */
public class GetAuditEventGeneralSection extends TasBasicGeneralSection{

	private AttributeBindingField sortColumnAttribute ;
	private Text sortColumn;
	private Button descOrderB;
	private Button exactMatchB;

	@Override
	protected Class<?> getModelClass() {
		// TODO Auto-generated method stub
		return GetAuditEvent.class;
	}

	@Override
    protected void initBindings() {
		super.initBindings();
        bind(sortColumnAttribute, TasPackage.Literals.GET_AUDIT_EVENT__SORT_COLUMN);
        bind(descOrderB,  TasPackage.Literals.GET_AUDIT_EVENT__DESC_ORDER);
        bind(exactMatchB,  TasPackage.Literals.GET_AUDIT_EVENT__EXACT_MATCH);
    }

	@Override
    protected Composite doCreateControl(final Composite root) {
		Composite parent = BWFieldFactory.getInstance().createComposite(root, 2);
		BWFieldFactory.getInstance().createLabel(parent, Messages.TAS_CONNECTION_LABEL, true);
		tasConnection = BWFieldFactory.getInstance().createPropertyField(parent, BWDesignConstants.PROPERTY,
				SHAREDRESOURCE_QNAME);
		tasConnection.setDefaultPropertyPrefix("tasConnection");

		BWFieldFactory.getInstance().createLabel(parent, "Sort by Column", true);

		sortColumn = BWFieldFactory.getInstance().createTextBox(parent);
		sortColumnAttribute = BWFieldFactory.getInstance().createAttributeBindingField(parent,  sortColumn, PropertyTypeQnameConstants.STRING_PRIMITIVE, false);

		descOrderB = createCheckboxAttr(parent, "Descending Order");
		exactMatchB = createCheckboxAttr(parent, "Exact Match");
		return parent;
	}

}