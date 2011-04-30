package com.ineatconseil.yougo.client.cto;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class ResultCTO<T> extends JavaScriptObject {

	protected ResultCTO() {
	}

	public final static native <T> ResultCTO<T> create(T data)
	/*-{
		return {
			success : true,
			data : data,
			errors : []
		};
	}-*/;

	/**
	 * Get data.
	 * @param <T>
	 *            expected data type
	 * @return data
	 */
	public final native T getData()
	/*-{
		return this.data;
	}-*/;

	/**
	 * Get success.
	 * @return true if success
	 */
	public final native boolean getSuccess()
	/*-{
		return this.success;
	}-*/;

	/**
	 * Get errors.
	 * @return the errors
	 */
	public final native JsArray<ErrorCTO> getErrors()
	/*-{
		return this.errors;
	}-*/;
}
