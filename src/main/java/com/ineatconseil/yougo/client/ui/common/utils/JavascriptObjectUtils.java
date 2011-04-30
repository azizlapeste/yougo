package com.ineatconseil.yougo.client.ui.common.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.json.client.JSONObject;

public class JavascriptObjectUtils {

	public static JavaScriptObject toJsArray(final Object[] array) {
		if (array == null) {
			return null;
		}
		JavaScriptObject jsArray = JavaScriptObject.createArray();
		for (int i = 0; i < array.length; i++) {
			add(jsArray, array[i]);
		}
		return jsArray;
	}

	@SuppressWarnings("rawtypes")
	public static JavaScriptObject toJsArray(final Collection list) {
		if (list == null) {
			return null;
		}
		JavaScriptObject jsArray = JavaScriptObject.createArray();
		for (Object object : list) {
			add(jsArray, object);
		}
		return jsArray;
	}

	/**
	 * Convert a Javascript array into Array.
	 * @param array
	 *            the array
	 * @return an array
	 */
	public static Object[] toArray(final JsArray<? extends JavaScriptObject> jsArray) {
		if (jsArray == null) {
			return null;
		}
		Object[] array = new Object[jsArray.length()];
		for (int i = 0; i < jsArray.length(); i++) {
			array[i] = jsArray.get(i);
		}
		return array;
	}

	/**
	 * Convert a Javascript array into List.
	 * @param array
	 *            the array
	 * @return a List with array value
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T extends JavaScriptObject> List<T> toList(final JsArray<? extends T> jsArray) {
		if (jsArray == null) {
			return null;
		}
		List list = new ArrayList(jsArray.length());
		for (int i = 0; i < jsArray.length(); i++) {
			list.add(jsArray.get(i));
		}
		return list;
	}

	/**
	 * Convert a Javascript array into Set.
	 * @param array
	 *            the array (Not a JsArray because it can contains other values that JavascriptObject)
	 * @return a set with array value
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> Set<T> toSet(final JavaScriptObject array) {
		if (array == null) {
			return null;
		}
		final Set set = new HashSet();
		final int length = JavascriptObjectUtils.length(array);
		for (int i = 0; i < length; i++) {
			set.add(JavascriptObjectUtils.get(array, i));
		}
		return set;
	}

	/**
	 * @param array
	 *            the array (Not a JsArray because it can contains other values that JavascriptObject)
	 * @return length of a Javascript array
	 */
	public static native int length(final JavaScriptObject array) /*-{
		return array.length;
	}-*/;

	public static native <T> T get(final JavaScriptObject array, int i) /*-{
		return array[i];
	}-*/;

	public static native <T> T get(final JavaScriptObject object, String property) /*-{
		var properties = property.split(".");
		var value = object;
		for ( var i = 0; i < properties.length; i++) {
			if (value != undefined) {
				value = value[properties[i]];
			} else {
				break;
			}
		}
		if (value != null && typeof value == 'number') {
			return @java.lang.Double::valueOf(D)(value);
		}
		return value;
	}-*/;

	public static native <T> void set(final JavaScriptObject object, String property, Object value) /*-{
		object[property] = value;
	}-*/;

	public static native <T> void add(final JavaScriptObject array, T o) /*-{
		array.push(o);
	}-*/;

	public static native <T> void addUnique(final JavaScriptObject array, T o) /*-{
		var found = false;
		for ( var i = 0; i < array.length; i++) {
			if (array[i] == o) {
				found = true;
				break;
			}
		}
		if (!found) {
			array.push(o);
		}
	}-*/;

	/**
	 * @param prop
	 *            the property name
	 * @return return Boolean object
	 */
	public static final native Boolean getBoolean(final JavaScriptObject object, final String prop) /*-{
		var value = object[prop];
		if (value == null) {
			return null;
		}
		return @java.lang.Boolean::valueOf(Z)(value);
	}-*/;

	/**
	 * @param prop
	 *            the property name
	 * @return return Double object
	 */
	public static final native Double getDouble(final JavaScriptObject object, final String prop) /*-{
		var value = object[prop];
		if (value == null) {
			return null;
		}
		return @java.lang.Double::valueOf(D)(value);
	}-*/;

	/**
	 * @param prop
	 *            the property name
	 * @return return Float object
	 */
	public static final native Float getFloat(final JavaScriptObject object, final String prop) /*-{
		var value = object[prop];
		if (value == null) {
			return null;
		}
		return @java.lang.Float::valueOf(F)(value);
	}-*/;

	/**
	 * @param prop
	 *            the property name
	 * @return return Integer object
	 */
	public static final native Integer getInteger(final JavaScriptObject object, final String prop) /*-{
		var value = object[prop];
		if (value == null) {
			return null;
		}
		return @java.lang.Integer::valueOf(I)(value);
	}-*/;

	/**
	 * @param prop
	 *            the property name
	 * @return return Short object
	 */
	public static final native Short getShort(final JavaScriptObject object, final String prop) /*-{
		var value = object[prop];
		if (value == null) {
			return null;
		}
		return @java.lang.Short::valueOf(S)(value);
	}-*/;

	/**
	 * @param prop
	 *            the property name
	 * @return return Byte object
	 */
	public static final native Byte getByte(final JavaScriptObject object, final String prop) /*-{
		var value = object[prop];
		if (value == null) {
			return null;
		}
		return @java.lang.Byte::valueOf(B)(value);
	}-*/;

	/**
	 * @param prop
	 *            the property name
	 * @return the date
	 */
	public static final Date getDate(final JavaScriptObject object, final String prop) {
		final Double value = getDouble(object, prop);
		if (value == null) {
			return null;
		}
		return new Date(value.longValue());
	}

	/**
	 * @param object
	 *            the object
	 * @param prop
	 *            the property name
	 * @param value
	 *            Number object
	 */
	public static final native void setNumber(final JavaScriptObject object, final String prop, final Number value) /*-{
		if (value == null) {
			object[prop] = null;
		} else {
			object[prop] = value.@java.lang.Number::doubleValue()();
		}
	}-*/;

	/**
	 * @param prop
	 *            the property name
	 * @return return String object
	 */
	public static final native String getString(final JavaScriptObject object, final String prop) /*-{
		return object[prop];
	}-*/;

	/**
	 * Helper for {@link #toString()}.
	 */
	public static String reflectionToString(final JavaScriptObject obj) {
		return new JSONObject(obj).toString();
	}
}
