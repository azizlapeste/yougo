package com.ineatconseil.yougo.client.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.ineatconseil.yougo.client.cto.ErrorCTO;
import com.ineatconseil.yougo.client.cto.ResultCTO;
import com.ineatconseil.yougo.client.i18n.YougoLabelConstants;
import com.ineatconseil.yougo.client.ui.common.component.AbstractDialogBox.Level;
import com.ineatconseil.yougo.client.ui.common.component.BasicPopup;

/**
 * @author aelamrani
 * @param <T>
 *            the data type
 */
public abstract class AsyncCallbackAdapter<T> implements AsyncCallback<ResultCTO<T>> {

	/**
	 * Constants.
	 */
	private final YougoLabelConstants constants = GWT.create(YougoLabelConstants.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void onSuccess(final ResultCTO<T> result) {
		if (result.getSuccess()) {
			onResultSuccess(result);
		} else {
			onResultErrors(result);
		}
	}

	/**
	 * Called when result is successfull.
	 * @param result
	 *            the result
	 */
	public abstract void onResultSuccess(final ResultCTO<T> result);

	/**
	 * Called when result has errors.
	 * @param result
	 */
	public void onResultErrors(final T result) {
		onResultErrors(result);
	}

	/**
	 * Called when result has errors.
	 * @param result
	 */
	protected void onResultErrors(final ResultCTO<T> result) {
		// messages
		String message = "";
		final JsArray<ErrorCTO> errors = result.getErrors();
		for (int i = 0; i < errors.length(); i++) {
			if (i != 0) {
				message += "\n";
			}
			message = errors.get(i).getErrorMessage();
		}
		// log message
		GWT.log(message);
		// show popup
		BasicPopup.showError(message);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onFailure(final Throwable caught) {
		GWT.log(caught.getMessage(), caught);
		BasicPopup.show(Level.ERROR, constants.unexpectedError(), caught.getMessage(), true);
	}

}
