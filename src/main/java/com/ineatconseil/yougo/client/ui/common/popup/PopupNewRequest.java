/**
 * 
 */
package com.ineatconseil.yougo.client.ui.common.popup;

import java.util.Date;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.ineatconseil.yougo.client.ui.common.callback.PopupCallback;
import com.ineatconseil.yougo.client.ui.common.utils.DateHelperGwt;

/**
 * @author aelamrani
 */
public class PopupNewRequest extends AbstractDialogBox {

	private final static Panel mainPanel = new VerticalPanel();
	private final static Panel beginDatePanel = new HorizontalPanel();
	private final static DateBox beginDateBox = new DateBox(new DatePicker(), new Date(),
			DateHelperGwt.getDefaultFormat());
	private final static Panel endDatePanel = new HorizontalPanel();
	private final static DateBox endDateBox = new DateBox(new DatePicker(), DateHelperGwt.getDateOfTomorrow(),
			DateHelperGwt.getDefaultFormat());
	private final static Panel commentsPanel = new HorizontalPanel();
	private final static TextArea commentsTextArea = new TextArea();
	private final static Panel requestTypePanel = new HorizontalPanel();
	private final static ListBox requestTypeListBox = new ListBox();

	/**
	 * @param beginDateMessage
	 * @param endDateMessage
	 * @param commentsMessage
	 * @param requestTypeMessage
	 * @param title
	 * @param callback
	 */
	public PopupNewRequest(final String beginDateMessage, final String endDateMessage, final String commentsMessage,
			final String requestTypeMessage, final String title, final PopupCallback callback) {
		super(Level.ADD, constructContent(beginDateMessage, endDateMessage, commentsMessage, requestTypeMessage),
				title, true);
		setPopupCallback(callback);
		addCancelButton();
	}

	/**
	 * @param beginDateMessage
	 * @param endDateMessage
	 * @param commentsMessage
	 * @param requestTypeMessage
	 * @return
	 */
	private static Panel constructContent(final String beginDateMessage, final String endDateMessage,
			final String commentsMessage, final String requestTypeMessage) {
		final Label beginDateLabel = new Label(beginDateMessage);
		final Label endDateLabel = new Label(endDateMessage);
		final Label commentsLabel = new Label(commentsMessage);
		final Label requestTypeLabel = new Label(requestTypeMessage);
		beginDatePanel.add(beginDateLabel);
		beginDatePanel.add(beginDateBox);
		endDatePanel.add(endDateLabel);
		endDatePanel.add(endDateBox);
		commentsPanel.add(commentsLabel);
		commentsPanel.add(commentsTextArea);
		requestTypePanel.add(requestTypeLabel);
		requestTypePanel.add(requestTypeListBox);
		mainPanel.add(beginDatePanel);
		mainPanel.add(endDatePanel);
		mainPanel.add(commentsPanel);
		mainPanel.add(requestTypePanel);
		return mainPanel;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void show() {
		super.show();
		// oldPasswordTextBox.setFocus(true);
	}
}
