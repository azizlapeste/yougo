/**
 * 
 */
package com.ineatconseil.yougo.client.ui.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.ineatconseil.yougo.client.ui.common.component.CustomButton;
import com.ineatconseil.yougo.client.ui.common.utils.FocusManager;

/**
 * @author aelamrani
 */
public class LoginViewImpl extends Composite implements ILoginView {

	@UiTemplate("LoginUiBinder.ui.xml")
	interface WelcomeUiBinder extends UiBinder<HTMLPanel, LoginViewImpl> {
	}

	private static WelcomeUiBinder uiBinder = GWT.create(WelcomeUiBinder.class);

	public LoginViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	Label titleLabel;

	@UiField
	CustomButton loginBt;

	@UiField
	Label loginLabel;

	@UiField
	Label passwordLabel;

	@UiField
	TextBox loginText;

	@UiField
	PasswordTextBox passwordText;

	private Presenter presenter;

	/**
	 * {@inheritDoc}
	 */

	@Override
	public void setTitleLabel(final String text) {
		titleLabel.setText(text);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLoginBtLabel(final String text) {
		loginBt.setText(text);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLoginLabel(final String label) {
		loginLabel.setText(label);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPasswordLabel(final String label) {
		passwordLabel.setText(label);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPresenter(final Presenter presenter) {
		this.presenter = presenter;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getLogin() {
		return loginText.getText();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getPassword() {
		return passwordText.getText();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public HandlerRegistration addClickHandlerOnLogin(final ClickHandler handler) {
		return loginBt.addClickHandler(handler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public HandlerRegistration addKeyDownHandlerOnLogin(final KeyDownHandler handler) {
		return loginText.addKeyDownHandler(handler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public HandlerRegistration addKeyDownHandlerOnPassword(final KeyDownHandler handler) {
		return passwordText.addKeyDownHandler(handler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFocus() {
		FocusManager.setWidgetFocused(loginText);
	}
}
