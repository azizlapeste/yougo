/**
 * 
 */
package com.ineatconseil.yougo.client.ui.common.component;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.Button;

/**
 * @author aelamrani
 */
public class CustomButton extends Button {

	/**
	 * Default constructor.
	 */
	@UiConstructor
	public CustomButton() {
		super();
	}

	/**
	 * Constructor with the button label.
	 * @param label
	 *            the label of the button
	 */
	public CustomButton(final String label) {
		super(label);
	}

	/**
	 * Constructor with the label and a click handler.
	 * @param label
	 *            the label of the button
	 * @param handler
	 *            the handler
	 */
	public CustomButton(final String label, final ClickHandler handler) {
		super(label, handler);
	}
}
