package com.tibco.bw.sharedresource.tcta.design.sections;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import com.tibco.bw.core.design.resource.util.EncryptionService;
import com.tibco.bw.design.field.BWFieldFactory;
import com.tibco.bw.sharedresource.tcta.model.helper.Messages;
import com.tibco.bw.sharedresource.tcta.model.tcta.TctaConnection;


public class TestConnectionButtonHelper {
	private TctaConnectionSection tctaConnectionSection;

	private Label testLabel;

	public TestConnectionButtonHelper(TctaConnectionSection tctaConnectionSection) {
		this.tctaConnectionSection = tctaConnectionSection;
	}

	public void settestLabel(Label inputlabel){
		testLabel=inputlabel;
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
				try {
					TctaConnection connection = tctaConnectionSection.getTctaConnection();

					String serverUrl = "https://sso-awsqa.tibco.com/as/token.oauth2";

					String username = tctaConnectionSection.getUserName(connection);

					String password = tctaConnectionSection.getPassword(connection);

					testConnection.setText(Messages.CONNECT_BUTTON_TEXT);

					if (missRequiredFields(serverUrl, username, password)) {
						testLabel.setForeground(red);
						testLabel.setText("The field of Server Url, User Name and Password is required");
						return;
					}
					testLabel.setForeground(black);
					testLabel.setText("Testing...");

					Map<String, String> params = new HashMap<String,String>();
					params.put("username", username);
					params.put("password", decryptPassword(password));
					params.put("grant_type", "password");
					params.put("client_id", "ropc_ipass");

					HttpURLConnection httpConn = buildpostHttpUrlConnection(serverUrl, params, getsettingMap());
					String messagebody = getHttpRequestBody(httpConn);
					int statusCode = httpConn.getResponseCode();

					if(statusCode == HttpURLConnection.HTTP_OK){
						MessageDialog messageDialog = new MessageDialog(composite.getShell(),
								Messages.CONNECTED_TO_TCTA, null, Messages.CONNECTED_TO_TCTA,
								MessageDialog.NONE, new String[] { "Ok" }, 0);
						messageDialog.open();
						Color blue = new Color(composite.getShell().getDisplay(), 0, 0, 255);
			            testLabel.setForeground(blue);
			            testLabel.setText("Test TCTA Connection Success!");
					} else{
						Color red = new Color(composite.getShell().getDisplay(), 255, 0, 0);
			            testLabel.setForeground(red);
			            testLabel.setText("failed");
					}

				} catch (Exception e1) {

					e1.printStackTrace();

				}
				testConnection.setText(Messages.TEST_CONNECTION_LABEL_TEXT);
			}

		});

	}

	private boolean missRequiredFields(String url, String username, String password) {

		return (   ( url == null     || "".equals(url) )
				|| (username == null || "".equals(username))
				|| (password == null || "".equals(password))
				);
	}

	protected Map<String, String> getsettingMap() {
		Map<String, String> params = new HashMap<String,String>();
		params.put("Content-Type", "application/x-www-form-urlencoded");
		params.put("Accept", "application/json");
		return params;
	}

	protected String decryptPassword(String password){
		return EncryptionService.INSTANCE.getEncryptor().decrypt(password);
	}

	protected HttpURLConnection buildpostHttpUrlConnection(String urlstring, Map<String, String> formparams,
			Map<String, String> settingparams) throws IOException {
		HttpURLConnection connection = null;
		URL url = new URL(urlstring);
		connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		addUrlConnectionSetting(connection, settingparams);
		addUrlConnectionParameter(connection, formparams);
		return connection;
	}

	protected void addUrlConnectionSetting(HttpURLConnection connection, Map<String, String> settingparams) {
		for (String key : settingparams.keySet()) {
			connection.setRequestProperty(key, settingparams.get(key));
		}

	}

	protected void addUrlConnectionParameter(HttpURLConnection connection, Map<String, String> formparams)
			throws UnsupportedEncodingException, IOException {
		connection.setDoOutput(true);
		OutputStream os = connection.getOutputStream();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
		writer.write(getPostDataString(formparams));
		writer.flush();
		writer.close();
		os.close();
	}

	protected String getPostDataString(Map<String, String> params) throws UnsupportedEncodingException {
		StringBuilder result = new StringBuilder();
		boolean first = true;
		for (Map.Entry<String, String> entry : params.entrySet()) {
			if (first)
				first = false;
			else
				result.append("&");

			result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
			result.append("=");
			result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
		}

		return result.toString();
	}

	protected String getHttpRequestBody(HttpURLConnection connection) throws IOException {
		BufferedReader br = null;
		if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
			br = new BufferedReader(new InputStreamReader((connection.getInputStream())));
		} else {
			br = new BufferedReader(new InputStreamReader((connection.getErrorStream())));
		}
		StringBuilder sb = new StringBuilder();
		String output;
		while ((output = br.readLine()) != null) {
			sb.append(output);
		}

		return sb.toString();
	}
}
