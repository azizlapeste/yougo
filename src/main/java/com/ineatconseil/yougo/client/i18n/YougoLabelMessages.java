/**
 * 
 */
package com.ineatconseil.yougo.client.i18n;

import com.google.gwt.i18n.client.Messages;

/**
 * @author aelamrani
 */
public interface YougoLabelMessages extends Messages {

	/**
	 * @param name
	 *            the name of the current user
	 * @return the hello label followed by the name
	 */
	String helloLabel(String name);

	/**
	 * @param date
	 *            the date to display
	 * @param hour
	 *            the hour to display
	 * @return the date label
	 */
	String dateLabel(String date, String hour);
}
