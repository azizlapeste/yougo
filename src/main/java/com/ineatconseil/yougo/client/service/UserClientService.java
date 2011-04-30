/**
 * 
 */
package com.ineatconseil.yougo.client.service;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.ineatconseil.yougo.client.cto.RequestCTO;
import com.ineatconseil.yougo.client.cto.RequestTypeCTO;
import com.ineatconseil.yougo.client.cto.UserCTO;

/**
 * @author aelamrani
 */
public class UserClientService extends AbstractClientService {

	// private static final String CONTEXT_ROOT = GWT.getHostPageBaseURL() + "api";
	private static final String CONTEXT_ROOT = "/yougo-rest/api";
	private static final String URL_SERVICE_GET_USERS = CONTEXT_ROOT + "/users";
	private static final String URL_SERVICE_LOGIN = CONTEXT_ROOT + "/users/validation";
	private static final String URL_SERVICE_GET_REQUESTS = "/requests";
	private static final String URL_SERVICE_GET_REQUEST_TYPE = CONTEXT_ROOT + "/request-types/";
	private static final String URL_SERVICE_CONNECT = "/password/";

	public void login(final AsyncCallback<JsArrayString> callback) {
		final RequestBuilder builder = new RequestBuilder(RequestBuilder.POST, URL_SERVICE_LOGIN);
		requestObject(builder, callback);
	}

	public void connect(final String userId, final AsyncCallback<JsArrayString> callback) {
		final RequestBuilder builder = new RequestBuilder(RequestBuilder.POST, URL_SERVICE_GET_USERS + "/" + userId
				+ URL_SERVICE_CONNECT);
		requestObject(builder, callback);
	}

	/**
	 * Allows to retrieve all the users.
	 * @param callback
	 *            the callback
	 */
	public void getUsers(final AsyncCallback<JsArray<UserCTO>> callback) {
		final RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL_SERVICE_GET_USERS);
		requestObject(builder, callback);
	}

	/**
	 * Allows to retrieve all the requests of a given user.
	 * @param userId
	 *            the user id
	 * @param callback
	 *            the callback
	 */
	public void getRequests(final String userId, final AsyncCallback<JsArray<RequestCTO>> callback) {
		final RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL_SERVICE_GET_USERS + "/" + userId
				+ URL_SERVICE_GET_REQUESTS);
		requestObject(builder, callback);
	}

	/**
	 * Allows to retrieve all the request types
	 * @param callback
	 *            the callback
	 */
	public void getRequestTypes(final AsyncCallback<JsArray<RequestTypeCTO>> callback) {
		final RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL_SERVICE_GET_REQUEST_TYPE);
		requestObject(builder, callback);
	}

	/**
	 * Allows to retrieve the request type by id.
	 * @param requestTypeId
	 *            the request type id
	 * @param callback
	 *            the callback
	 */
	public void getRequestTypeById(final int requestTypeId, final AsyncCallback<RequestTypeCTO> callback) {
		final RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL_SERVICE_GET_REQUEST_TYPE
				+ requestTypeId);
		requestObject(builder, callback);
	}
}
