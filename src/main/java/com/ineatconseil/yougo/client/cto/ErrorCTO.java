package com.ineatconseil.yougo.client.cto;

import com.google.gwt.core.client.JavaScriptObject;

public class ErrorCTO extends JavaScriptObject {

	protected ErrorCTO() {

	}

	public final native String getCode()
	/*-{
		return this.code;
	}-*/;

	public final native String getErrorMessage()
	/*-{
		return this.errorMessage
	}-*/;

}
