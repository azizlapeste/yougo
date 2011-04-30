/**
 * 
 */
package com.ineatconseil.yougo.client.ui.login;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * @author aelamrani
 */
public interface ILoginView extends IsWidget {

	public interface Presenter {
		void goTo(Place place);
	}

	void setTitleLabel(String label);

	void setLoginBtLabel(String text);

	void setPresenter(Presenter presenter);

	void setLoginLabel(String label);

	void setPasswordLabel(String label);

	/**
	 * @return the login
	 */
	String getLogin();

	/**
	 * @return the password
	 */
	String getPassword();

	/**
	 * @param handler
	 *            the click handler to set
	 * @return a handler registration
	 */
	HandlerRegistration addClickHandlerOnLogin(ClickHandler handler);

	/**
	 * @param handler
	 *            the keyDown handler to set
	 * @return a handler registration
	 */
	HandlerRegistration addKeyDownHandlerOnLogin(KeyDownHandler handler);

	/**
	 * @param handler
	 *            the keyDown handler to set
	 * @return a handler registration
	 */
	HandlerRegistration addKeyDownHandlerOnPassword(KeyDownHandler handler);

	/**
	 * Allows to set the focus on a widget
	 */
	void setFocus();

}
