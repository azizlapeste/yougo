/**
 * 
 */
package com.ineatconseil.yougo.client.ui.common.utils;

import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author aelamrani
 */

public class FocusManager {

	private static Widget widgetFocused;

	/**
	 * @return the widgetFocused
	 */
	public static Widget getWidgetFocused() {
		return widgetFocused;
	}

	/**
	 * @param widgetFocused
	 *            the widgetFocused to set
	 */
	public static void setWidgetFocused(final Widget widget) {
		widgetFocused = widget;
		widget.getElement().focus();
	}

	public static void applyFocus() {
		getWidgetFocused().getElement().focus();
		if (getWidgetFocused() instanceof TextBox) {
			((TextBox) getWidgetFocused()).selectAll();
		}
	}
}
