/**
 * 
 */
package com.ineatconseil.yougo.client.service;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.StatusCodeException;

/**
 * @author aelamrani
 */
public class AbstractClientService {

	/**
	 * Constants.
	 */
	private static final String DEFAULT_PASSWORD = "password";
	private static final String DEFAULT_USER = "kristina.chung@company.com";

	protected <T extends JavaScriptObject> void requestObject(final RequestBuilder builder,
			final AsyncCallback<T> callback) {

		builder.setUser(DEFAULT_USER);
		builder.setPassword(DEFAULT_PASSWORD);
		builder.setCallback(new RequestCallback() {
			@SuppressWarnings("unchecked")
			@Override
			public void onResponseReceived(Request request, Response response) {
				if (200 == response.getStatusCode()) {
					callback.onSuccess((T) JsonUtils.safeEval(response.getText()));
				} else {
					final StatusCodeException exception = new StatusCodeException(response.getStatusCode(), response
							.getStatusText());
					callback.onFailure(exception);
				}
			}

			@Override
			public void onError(Request request, Throwable exception) {
				callback.onFailure(exception);
			}
		});
		try {
			builder.send();
		} catch (RequestException exception) {
			callback.onFailure(exception);
		}

	}

}
