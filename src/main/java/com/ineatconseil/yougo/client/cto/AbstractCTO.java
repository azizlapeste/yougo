package com.ineatconseil.yougo.client.cto;

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.ineatconseil.yougo.client.ui.common.utils.JavascriptObjectUtils;

public abstract class AbstractCTO extends JavaScriptObject {

	protected AbstractCTO() {
	}

	/**
	 * @param prop
	 *            the property name
	 * @return return Double object
	 */
	protected final Double getDouble(final String prop) {
		return JavascriptObjectUtils.getDouble(this, prop);
	};

	/**
	 * @param prop
	 *            the property name
	 * @return return Float object
	 */
	protected final Float getFloat(final String prop) {
		return JavascriptObjectUtils.getFloat(this, prop);
	}

	/**
	 * @param prop
	 *            the property name
	 * @return return Integer object
	 */
	protected final Integer getInteger(final String prop) {
		return JavascriptObjectUtils.getInteger(this, prop);
	}

	/**
	 * @param prop
	 *            the property name
	 * @return return Short object
	 */
	protected final Short getShort(final String prop) {
		return JavascriptObjectUtils.getShort(this, prop);
	}

	/**
	 * @param prop
	 *            the property name
	 * @return return Byte object
	 */
	protected final Byte getByte(final String prop) {
		return JavascriptObjectUtils.getByte(this, prop);
	}

	/**
	 * @param prop
	 *            the property name
	 * @return the date
	 */
	protected final Date getDate(final String prop) {
		final Double value = getDouble(prop);
		if (value == null) {
			return null;
		}
		return new Date(value.longValue());
	}

	/**
	 * @param prop
	 *            the property name
	 * @return the formatted date
	 */
	protected final String getFormattedDate(final String prop) {
		return DateTimeFormat.getFormat("dd/MM/yyyy").format(getDate(prop));
	}

	/**
	 * @param prop
	 *            the property name
	 * @return the formatted string date
	 */
	protected final native String getStringDate(final String prop) /*-{
		return this[prop].substring(8, 10) + "/" + this[prop].substring(5, 7)
				+ "/" + this[prop].substring(0, 4);
	}-*/;

	/**
	 * @param prop
	 *            the property name
	 * @return return String object
	 */
	protected final String getString(final String prop) {
		return JavascriptObjectUtils.getString(this, prop);
	}

	/**
	 * @param prop
	 *            the property name
	 * @return return Double object
	 */
	protected final void setNumber(final String prop, final Number value) {
		JavascriptObjectUtils.setNumber(this, prop, value);
	};

	/**
	 * @param prop
	 *            the property name
	 * @return return a JavascriptObject object
	 */
	protected final JavaScriptObject get(final String prop) {
		return JavascriptObjectUtils.get(this, prop);
	}

	/**
	 * @param prop
	 *            the property name
	 * @return return a JavascriptObject object
	 */
	public final String toStringVerbose() {
		return this.getClass() + "(" + JavascriptObjectUtils.reflectionToString(this) + ")";
	}
}
