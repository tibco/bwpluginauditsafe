package com.tibco.bw.sharedresource.tas.design.sections;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import com.tibco.bw.design.field.BWFieldFactory;
import com.tibco.bw.sharedresource.tas.model.helper.Messages;
import com.tibco.bw.sharedresource.tas.model.helper.TasClient;
import com.tibco.bw.sharedresource.tas.model.helper.TasResponse;
import com.tibco.bw.sharedresource.tas.model.tas.TasConnection;
import com.tibco.xpd.resources.WorkingCopy;

public class TestConnectionButtonHelper {
	private static final int INPUT_TYPE = 1;
	private static final int OUTPUT_TYPE = 2;

	private TasConnectionSection tasConnectionSection;

	private Label testLabel;

	public TestConnectionButtonHelper(
			TasConnectionSection tasConnectionSection) {
		this.tasConnectionSection = tasConnectionSection;
	}

	public void settestLabel(Label inputlabel) {
		testLabel = inputlabel;
	}

	public void createTestConnectionButton(final Composite composite) {
		final Button testConnection;
		testConnection = BWFieldFactory.getInstance().createButton(composite,
				Messages.TEST_CONNECTION_LABEL_TEXT,
				Messages.TEST_CONNECTION_LABEL_TEXT, null);

		final Color red = new Color(composite.getDisplay(), 255, 0, 0);
		final Color black = new Color(composite.getDisplay(), 0, 0, 0);
		testConnection.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				final TasConnection connection = tasConnectionSection
						.getTasConnection();

				String serverUrl = tasConnectionSection.getServerUrl(connection);

				String username = tasConnectionSection.getUserName(connection);

				String password = tasConnectionSection.getPassword(connection);
				
				boolean isEnterprise = tasConnectionSection.isEnterpise(connection);

				if (serverUrl == null || serverUrl.isEmpty()) {
					testLabel.setForeground(red);
					testLabel.setText("Server URL is required");
					return;
				}else if(username == null || username.isEmpty()){
					testLabel.setForeground(red);
					testLabel.setText("Username is required");
					return;
				}else if(password == null || password.isEmpty()){
					testLabel.setForeground(red);
					testLabel.setText("Password is required");
					return;
				}
				testConnection.setText(Messages.CONNECT_BUTTON_TEXT);
				testLabel.setForeground(black);
				testLabel.setText("Testing...");
				
				if(isEnterprise){
					TasResponse taResponse = TasClient.getStatus(serverUrl, username, password);
					if (taResponse.isHasError()) {
						Color red = new Color(composite.getShell().getDisplay(),
								255, 0, 0);
						testLabel.setForeground(red);
						testLabel.setText("Test AuditSafe Connection failed");
					} else {
						//TODO set account id
						String accountId ="";
						String body = "{\"path\": \"/tas/dataserver/transactions\", \"method\": \"POST\"}";
						String queryBody = "{\"path\": \"/tas/dataserver/transactions/query\", \"method\": \"POST\"}";
						TasResponse inputSchemaResponse = TasClient.getSchema(serverUrl, username, password, accountId, body, INPUT_TYPE);
						TasResponse outputSchemaResponse =  TasClient.getSchema(serverUrl, username, password, accountId, body, OUTPUT_TYPE);
						TasResponse queryOutputSchemaResponse =  TasClient.getSchema(serverUrl, username, password, accountId, queryBody, OUTPUT_TYPE);
						if(inputSchemaResponse.isHasError() || outputSchemaResponse.isHasError()){
							Color red = new Color(composite.getShell().getDisplay(),
									255, 0, 0);
							testLabel.setForeground(red);
							testLabel.setText(inputSchemaResponse.isHasError()?inputSchemaResponse.getMessage():outputSchemaResponse.getMessage());
						}else {
							final String schema = inputSchemaResponse.getMessage();
							final String output = outputSchemaResponse.getMessage();
							final String queryOutput = queryOutputSchemaResponse.getMessage();
							final String localAccountId = accountId;
							final WorkingCopy workingCopy = (WorkingCopy)tasConnectionSection.getPage().getEditor().getAdapter(WorkingCopy.class);
			            	TransactionalEditingDomain ed = (TransactionalEditingDomain) workingCopy.getEditingDomain();
							Command cmd = new RecordingCommand(ed) {
								@Override
								protected void doExecute() {
									connection.setId(localAccountId);
									connection.setSchema(schema);
									connection.setOutput(output);
									connection.setQueryOutput(queryOutput);
								}
							};
							ed.getCommandStack().execute(cmd);
							MessageDialog messageDialog = new MessageDialog(composite
									.getShell(), Messages.CONNECTED_TO_TAS, null,
									Messages.CONNECTED_TO_TAS, MessageDialog.NONE,
									new String[] { "Ok" }, 0);
							messageDialog.open();
							Color blue = new Color(composite.getShell().getDisplay(),
									0, 0, 255);
							testLabel.setForeground(blue);
							testLabel.setText("Test AuditSafe Connection successful!");
						}
					}
				} else {
					TasResponse taResponse = TasClient.getToken(serverUrl, username, password);
					HashMap<String,String> accountInfo = null;
					if (!taResponse.isHasError()) {
						try {
							accountInfo = TasClient.getAccountIds(serverUrl, taResponse.getMessage());
						} catch (IOException e1) {
							MessageDialog messageDialog = new MessageDialog(composite
									.getShell(), "Test AuditSafe Connection failed", null,
									e1.getMessage(), MessageDialog.ERROR,
									new String[] { "Ok" }, 0);
							messageDialog.open();
						}
					}
					if (accountInfo != null && accountInfo.size()>0) {
						String accountId ="";

						if(accountInfo.keySet().size() > 1){
							AccountDialog dialog = new AccountDialog(composite.getShell());

							dialog.initData(accountInfo.keySet().toArray(new String[accountInfo.size()]));
							int eventkey = dialog.open();
							if (eventkey == Window.OK) {
								String selectedAccount = dialog.selectedValue;
								accountId = accountInfo.get(selectedAccount);
							}
						}

						String body = "{\"path\": \"/tas/dataserver/transactions\", \"method\": \"POST\"}";
						String queryBody = "{\"path\": \"/tas/dataserver/transactions/query\", \"method\": \"POST\"}";
						TasResponse inputSchemaResponse = TasClient.getSchema(serverUrl, username, password, accountId, body, INPUT_TYPE);
						TasResponse outputSchemaResponse =  TasClient.getSchema(serverUrl, username, password, accountId, body, OUTPUT_TYPE);
						TasResponse queryOutputSchemaResponse =  TasClient.getSchema(serverUrl, username, password, accountId, queryBody, OUTPUT_TYPE);
						if(inputSchemaResponse.isHasError() || outputSchemaResponse.isHasError()){
							Color red = new Color(composite.getShell().getDisplay(),
									255, 0, 0);
							testLabel.setForeground(red);
							testLabel.setText(inputSchemaResponse.isHasError()?inputSchemaResponse.getMessage():outputSchemaResponse.getMessage());
						}else {
							final String schema = inputSchemaResponse.getMessage();
							final String output = outputSchemaResponse.getMessage();
							final String queryOutput = queryOutputSchemaResponse.getMessage();
							final String localAccountId = accountId;
							final WorkingCopy workingCopy = (WorkingCopy)tasConnectionSection.getPage().getEditor().getAdapter(WorkingCopy.class);
			            	TransactionalEditingDomain ed = (TransactionalEditingDomain) workingCopy.getEditingDomain();
							Command cmd = new RecordingCommand(ed) {
								@Override
								protected void doExecute() {
									connection.setId(localAccountId);
									connection.setSchema(schema);
									connection.setOutput(output);
									connection.setQueryOutput(queryOutput);
								}
							};
							ed.getCommandStack().execute(cmd);
							MessageDialog messageDialog = new MessageDialog(composite
									.getShell(), Messages.CONNECTED_TO_TAS, null,
									Messages.CONNECTED_TO_TAS, MessageDialog.NONE,
									new String[] { "Ok" }, 0);
							messageDialog.open();
							Color blue = new Color(composite.getShell().getDisplay(),
									0, 0, 255);
							testLabel.setForeground(blue);
							testLabel.setText("Test AuditSafe Connection successful!");
						}
					} else {
						Color red = new Color(composite.getShell().getDisplay(),
								255, 0, 0);
						testLabel.setForeground(red);
						testLabel.setText("Test AuditSafe Connection failed");
					}
				}

				testConnection.setText(Messages.TEST_CONNECTION_LABEL_TEXT);
			}
			

		});

	}

	private boolean missRequiredFields(String url, String username,
			String password) {

		return ((url == null || "".equals(url))
				|| (username == null || "".equals(username)) || (password == null || ""
				.equals(password)));
	}

	class AccountDialog extends Dialog implements ActionListener {
	    protected org.eclipse.swt.widgets.List list;
	    protected String[] accountList;
	    protected String selectedValue;
		protected AccountDialog(Shell parentShell) {
			super(parentShell);
		}

		@Override
		protected Point getInitialSize() {
		   return new Point(400, 300);
		}

		@Override
		protected void configureShell(Shell newShell) {
		   super.configureShell(newShell);
		   newShell.setText("Account Information");
		}

		@Override
		protected Control createDialogArea(final Composite parent) {
			final Composite composite = (Composite) super.createDialogArea(parent);
			Composite account = new Composite(composite, SWT.None);
			list = new org.eclipse.swt.widgets.List(account,SWT.BORDER|SWT.READ_ONLY|SWT.V_SCROLL);
			list.setItems(accountList);
			list.setVisible(true);
			list.setSize(500, 150);
			list.setSelection(0);
			list.addSelectionListener(new SelectionAdapter(){
				public void widgetSelected(SelectionEvent event) {
					int index = list.getSelectionIndex();
					if(index != -1){
						selectedValue = accountList[index];
					}
				}
			});
			return composite;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

		}

		public void initData(String[] accountList){
			this.accountList = accountList ;
			selectedValue = accountList[0];
		}
	}


}
