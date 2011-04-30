/**
 * 
 */
package com.ineatconseil.yougo.client.ui.common.component;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.ineatconseil.yougo.client.ui.common.callback.PopupCallback;

/**
 * @author aelamrani
 */
public class PopupChangePassword extends AbstractDialogBox {

	private final static Panel mainPanel = new VerticalPanel();
	private final static Panel oldPasswordPanel = new HorizontalPanel();
	private final static Panel newPasswordPanel = new HorizontalPanel();
	private final static Panel confirmNewPasswordPanel = new HorizontalPanel();
	private final static TextBox oldPasswordTextBox = new PasswordTextBox();
	private final static TextBox newPasswordTextBox = new PasswordTextBox();
	private final static TextBox confirmNewPasswordTextBox = new PasswordTextBox();

	/**
	 * @param oldPasswordMessage
	 * @param newPasswordMessage
	 * @param confirmNewPasswordMessage
	 * @param title
	 */
	public PopupChangePassword(final String oldPasswordMessage, final String newPasswordMessage,
			final String confirmNewPasswordMessage, final String title, final PopupCallback callback) {
		super(Level.CONFIRM, constructContent(oldPasswordMessage, newPasswordMessage, confirmNewPasswordMessage), title);
		setPopupCallback(callback);
		addCancelButton();
	}

	/**
	 * @param oldPasswordMessage
	 * @param newPasswordMessage
	 * @param confirmNewPasswordMessage
	 * @return
	 */
	private static Panel constructContent(final String oldPasswordMessage, final String newPasswordMessage,
			final String confirmNewPasswordMessage) {
		final Label oldPasswordLabel = new Label(oldPasswordMessage);
		final Label newPasswordLabel = new Label(newPasswordMessage);
		final Label confirmNewPasswordLabel = new Label(confirmNewPasswordMessage);
		oldPasswordPanel.add(oldPasswordLabel);
		oldPasswordPanel.add(oldPasswordTextBox);
		newPasswordPanel.add(newPasswordLabel);
		newPasswordPanel.add(newPasswordTextBox);
		confirmNewPasswordPanel.add(confirmNewPasswordLabel);
		confirmNewPasswordPanel.add(confirmNewPasswordTextBox);
		mainPanel.add(oldPasswordPanel);
		mainPanel.add(newPasswordPanel);
		mainPanel.add(confirmNewPasswordPanel);
		return mainPanel;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void show() {
		super.show();
		oldPasswordTextBox.setFocus(true);
	}

}
