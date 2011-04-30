/**
 * 
 */
package com.ineatconseil.yougo.client.ui.common.utils;

/**
 * @author aelamrani
 */
public class StringHelperGwt {
	/**
	 * Allows to check if a string is empty ("").
	 * @param param
	 *            the string to test
	 * @return true if the string is null or empty, false otherwise
	 */
	public static boolean isEmpty(final String param) {
		if (param == null) {
			return true;
		} else {
			if (param.length() < 1) {
				return true;
			} else {
				return false;
			}
		}
	}

	/**
	 * Allows to check if a string is blank (" ").
	 * @param param
	 *            the string to test
	 * @return true if the string is null, empty or blank, false otherwise
	 */
	public static boolean isBlank(final String param) {
		if (param == null) {
			return true;
		} else {
			if (param.trim().length() < 1) {
				return true;
			} else {
				return false;
			}
		}
	}

	/**
	 * Allows to check a string contains a double.
	 * @param str
	 *            the string to check
	 * @return true if the string is a double, false otherwise
	 */
	public static boolean isDouble(final String str) {
		if (str == null) {
			return false;
		}

		try {
			Double.valueOf(str);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}

	/**
	 * Allows to check a double is negative.
	 * @param str
	 *            the string to check
	 * @return true if the double is negative, false otherwise
	 */
	public static boolean isDoubleNegative(final String str) {
		if (Double.valueOf(str) > 0) {
			return false;
		}
		return true;
	}

}
