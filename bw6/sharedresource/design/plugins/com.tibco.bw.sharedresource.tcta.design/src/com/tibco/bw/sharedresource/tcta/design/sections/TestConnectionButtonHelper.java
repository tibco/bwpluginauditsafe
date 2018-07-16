package com.tibco.bw.sharedresource.tcta.design.sections;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import com.tibco.bw.design.field.BWFieldFactory;
import com.tibco.bw.sharedresource.tcta.model.helper.Messages;
import com.tibco.bw.sharedresource.tcta.model.helper.TctaClientUtils;
import com.tibco.bw.sharedresource.tcta.model.tcta.TctaConnection;

public class TestConnectionButtonHelper {
	private TctaConnectionSection tctaConnectionSection;

	private Label testLabel;

	public TestConnectionButtonHelper(
			TctaConnectionSection tctaConnectionSection) {
		this.tctaConnectionSection = tctaConnectionSection;
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

				TctaConnection connection = tctaConnectionSection
						.getTctaConnection();

				String serverUrl = "https://sso-awsqa.tibco.com/as/token.oauth2";

				String username = tctaConnectionSection.getUserName(connection);

				String password = tctaConnectionSection.getPassword(connection);

				testConnection.setText(Messages.CONNECT_BUTTON_TEXT);

				if (missRequiredFields(serverUrl, username, password)) {
					testLabel.setForeground(red);
					testLabel
							.setText("The field of Server Url, User Name and Password is required");
					return;
				}
				testLabel.setForeground(black);
				testLabel.setText("Testing...");

				String token = TctaClientUtils.getToken(username, password);
				if (token != null) {
					MessageDialog messageDialog = new MessageDialog(composite
							.getShell(), Messages.CONNECTED_TO_TCTA, null,
							Messages.CONNECTED_TO_TCTA, MessageDialog.NONE,
							new String[] { "Ok" }, 0);
					messageDialog.open();
					Color blue = new Color(composite.getShell().getDisplay(),
							0, 0, 255);
					testLabel.setForeground(blue);
					testLabel.setText("Test TCTA Connection successful!");
				} else {
					Color red = new Color(composite.getShell().getDisplay(),
							255, 0, 0);
					testLabel.setForeground(red);
					testLabel.setText("Test TCTA Connection failed");
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
