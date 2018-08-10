package com.tibco.bw.sharedresource.tas.design.sections;

import java.io.IOException;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import com.tibco.bw.design.field.BWFieldFactory;
import com.tibco.bw.sharedresource.tas.model.helper.Messages;
import com.tibco.bw.sharedresource.tas.model.helper.TctaClientUtils;
import com.tibco.bw.sharedresource.tas.model.tas.TctaConnection;

public class TestConnectionButtonHelper {
	private TctaConnectionSection tasConnectionSection;

	private Label testLabel;

	public TestConnectionButtonHelper(
			TctaConnectionSection tasConnectionSection) {
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

				TctaConnection connection = tasConnectionSection
						.getTctaConnection();

				String taUrl = "https://sso-awsqa.tibco.com/as/token.oauth2";
				String serverUtl = tasConnectionSection.getServerUrl(connection);

				String username = tasConnectionSection.getUserName(connection);

				String password = tasConnectionSection.getPassword(connection);

				testConnection.setText(Messages.CONNECT_BUTTON_TEXT);

				if (missRequiredFields(taUrl, username, password)) {
					testLabel.setForeground(red);
					testLabel
							.setText("The field of Server Url, User Name and Password is required");
					return;
				}
				testLabel.setForeground(black);
				testLabel.setText("Testing...");

				String token = TctaClientUtils.getToken(username, password);
				boolean testSuccess = false;
				if (token != null) {
					try {
						testSuccess = TctaClientUtils.testConnection(serverUtl, token);
					} catch (IOException e1) {
						MessageDialog messageDialog = new MessageDialog(composite
								.getShell(), "Test AuditSafe Connection failed", null,
								e1.getMessage(), MessageDialog.ERROR,
								new String[] { "Ok" }, 0);
						messageDialog.open();
					}
				}
				if (testSuccess) {
					MessageDialog messageDialog = new MessageDialog(composite
							.getShell(), Messages.CONNECTED_TO_TCTA, null,
							Messages.CONNECTED_TO_TCTA, MessageDialog.NONE,
							new String[] { "Ok" }, 0);
					messageDialog.open();
					Color blue = new Color(composite.getShell().getDisplay(),
							0, 0, 255);
					testLabel.setForeground(blue);
					testLabel.setText("Test AuditSafe Connection successful!");
				} else {
					Color red = new Color(composite.getShell().getDisplay(),
							255, 0, 0);
					testLabel.setForeground(red);
					testLabel.setText("Test AuditSafe Connection failed");
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


}
