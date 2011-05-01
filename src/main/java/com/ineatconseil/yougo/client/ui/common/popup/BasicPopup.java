/**
 * 
 */
package com.ineatconseil.yougo.client.ui.common.popup;

import com.google.gwt.user.client.ui.HTML;

/**
 * @author aelamrani
 */
public class BasicPopup extends AbstractDialogBox {

	/**
	 * Constructor of a basic popup with the level (used for the displayed image) and the message content.
	 * @param level
	 *            the level of the popup
	 * @param content
	 *            the popup content
	 */
	public BasicPopup(final Level level, final String content) {
		super(level, new HTML(content));
	}

	/**
	 * Constructor of a basic popup with the level (used for the displayed image), the message content and the title.
	 * @param level
	 *            the level of the popup
	 * @param content
	 *            the popup content
	 * @param title
	 *            the popup title (null for a default title)
	 */
	public BasicPopup(final Level level, final String content, final String title) {
		super(level, new HTML(content), title);
	}

	/**
	 * Constructor of a basic popup with the level (used for the displayed image), the message content, the title.<br />
	 * <br /> The enableHide is used to know if the popup should be automatically hidden when the user clicks outside of
	 * it or on escape key press.
	 * @param level
	 *            the level of the popup
	 * @param content
	 *            the popup content
	 * @param title
	 *            the popup title (null for a default title)
	 * @param enableHide
	 *            if we allow the popup to hide
	 */
	public BasicPopup(final Level level, final String content, final String title, final boolean enableHide) {
		super(level, new HTML(content), title, enableHide);
	}

	/**
	 * Allows to show a basic popup with the level (used for the displayed image), the message content and the default
	 * title.
	 * @param level
	 *            the level of the popup
	 * @param content
	 *            the popup content
	 */
	public static void show(final Level level, final String content) {
		final BasicPopup popup = new BasicPopup(level, content);
		popup.show();
	}

	/**
	 * Allows to show a basic popup with the level (used for the displayed image), the message content and the title.
	 * @param level
	 *            the level of the popup
	 * @param content
	 *            the popup content
	 * @param title
	 *            the popup title (null for a default title)
	 */
	public static void show(final Level level, final String title, final String content) {
		final BasicPopup popup = new BasicPopup(level, content, title);
		popup.show();
	}

	/**
	 * Allows to show a basic popup with the level (used for the displayed image), the message content and the title.<br
	 * /> <br /> The enableHide is used to know if the popup should be automatically hidden when the user clicks outside
	 * of it or on escape key press.
	 * @param level
	 *            the level of the popup
	 * @param content
	 *            the popup content
	 * @param title
	 *            the popup title (null for a default title)
	 * @param enableHide
	 *            if we allow the popup to hide
	 */
	public static void show(final Level level, final String title, final String content, final boolean enableHide) {
		final BasicPopup popup = new BasicPopup(level, content, title, enableHide);
		popup.show();
	}

	/**
	 * Allows to show an error popup with the message content and a default title. It can be hidden by pressing escape
	 * key or clicking anywhere out of it.
	 * @param content
	 *            the popup content
	 */
	public static void showError(final String content) {
		final BasicPopup popup = new BasicPopup(Level.ERROR, content);
		popup.setAutoHideEnabled(true);
		popup.show();
	}

	/**
	 * Allows to show an error popup with the message exception and a default title. It can be hidden by pressing escape
	 * key or clicking anywhere out of it.
	 * @param exception
	 *            the exception to print
	 */
	public static void showError(final Throwable exception) {
		final BasicPopup popup = new BasicPopup(Level.ERROR, exception.getMessage());
		popup.setAutoHideEnabled(true);
		popup.show();
	}

	/**
	 * Allows to show a warning popup with the message content and a default title. It <strong>can't</strong> be hidden
	 * pressing escape key or clicking anywhere out of it.
	 * @param content
	 *            the popup content
	 */
	public static void showWarning(final String content) {
		final BasicPopup popup = new BasicPopup(Level.WARNING, content);
		popup.show();
	}

	/**
	 * Allows to show a confirm popup with the message content and a default title. It <strong>can't</strong> be hidden
	 * pressing escape key or clicking anywhere out of it.
	 * @param content
	 *            the popup content
	 */
	public static void showConfirm(final String content) {
		final BasicPopup popup = new BasicPopup(Level.CONFIRM, content);
		popup.show();
	}
}
