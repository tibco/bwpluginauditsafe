package com.tibco.bw.palette.tas.design.getauditevent;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Spinner;
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

	private AttributeBindingField sortColumnAttribute;
	private AttributeBindingField limitAttribute;
	private Text sortColumn;
	private Spinner limit;
	private Button descOrderB;
	private Button exactMatchB;
	private Button includPayloadB;
	private Button onlyGetCountB;

	@Override
	protected Class<?> getModelClass() {
		// TODO Auto-generated method stub
		return GetAuditEvent.class;
	}

	@Override
    protected void initBindings() {
		super.initBindings();
        bind(sortColumnAttribute, TasPackage.Literals.GET_AUDIT_EVENT__SORT_COLUMN);
        bind(limitAttribute, TasPackage.Literals.GET_AUDIT_EVENT__LIMIT);
        bind(descOrderB,  TasPackage.Literals.GET_AUDIT_EVENT__DESC_ORDER);
        bind(exactMatchB,  TasPackage.Literals.GET_AUDIT_EVENT__EXACT_MATCH);
        bind(includPayloadB,  TasPackage.Literals.GET_AUDIT_EVENT__INCLUDE_PAYLOAD);
        bind(onlyGetCountB,  TasPackage.Literals.GET_AUDIT_EVENT__ONLY_GET_COUNT);
    }

	@Override
    protected Composite doCreateControl(final Composite root) {
		Composite parent = BWFieldFactory.getInstance().createComposite(root, 2);
		BWFieldFactory.getInstance().createLabel(parent, Messages.TAS_CONNECTION_LABEL, true);
		tasConnection = BWFieldFactory.getInstance().createPropertyField(parent, BWDesignConstants.PROPERTY,
				SHAREDRESOURCE_QNAME);
		tasConnection.setDefaultPropertyPrefix("tasConnection");
		
		onlyGetCountB = createCheckboxAttr(parent, "Only Get Total Count");
	
		BWFieldFactory.getInstance().createLabel(parent, "Sort by Column", true);

		sortColumn = BWFieldFactory.getInstance().createTextBox(parent);
		sortColumnAttribute = BWFieldFactory.getInstance().createAttributeBindingField(parent,  sortColumn, PropertyTypeQnameConstants.STRING_PRIMITIVE, false);

		descOrderB = createCheckboxAttr(parent, "Descending Order");
		exactMatchB = createCheckboxAttr(parent, "Exact Match");
		
		includPayloadB = createCheckboxAttr(parent, "Include Event Payload");
		
		BWFieldFactory.getInstance().createLabel(parent, "Set Return Limit", true);
		limit = BWFieldFactory.getInstance().createSpinner(parent, 2, SWT.BORDER);
		limit.setMinimum(1);
		limit.setMaximum(Integer.MAX_VALUE);
		limit.setSelection(1000);
		limitAttribute = BWFieldFactory.getInstance().createAttributeBindingField(parent, limit, PropertyTypeQnameConstants.INTEGER_PRIMITIVE, false);
		return parent;
	}

}