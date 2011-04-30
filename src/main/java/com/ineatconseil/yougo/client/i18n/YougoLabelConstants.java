/**
 * 
 */
package com.ineatconseil.yougo.client.i18n;

import com.google.gwt.i18n.client.ConstantsWithLookup;

/**
 * @author aelamrani
 */
public interface YougoLabelConstants extends ConstantsWithLookup {

	/**
	 * @return the title label for the welcome screen
	 */
	String welcomeTitleLabel();

	/**
	 * @return the login label
	 */
	String loginLabel();

	/**
	 * @return the password label
	 */
	String passwordLabel();

	/**
	 * @return the title label for the planning screen
	 */
	String planningTitleLabel();

	/**
	 * @return the title for the confirm popup
	 */
	String confirmTitle();

	/**
	 * @return the title for the error popup
	 */
	String errorTitle();

	/**
	 * @return the title for the warning popup
	 */
	String warningTitle();

	/**
	 * @return the ok label
	 */
	String ok();

	/**
	 * @return the cancel label
	 */
	String cancel();

	/**
	 * @return the unexpected error label
	 */
	String unexpectedError();

	/**
	 * @return the login button label
	 */
	String loginBtLabel();

	/**
	 * @return the type title of the table
	 */
	String typeTableTitle();

	/**
	 * @return the from title of the table
	 */
	String fromTableTitle();

	/**
	 * @return the to title of the table
	 */
	String toTableTitle();

	/**
	 * @return the observation title of the table
	 */
	String observationTableTitle();

	/**
	 * @return the reply title of the table
	 */
	String replyTableTitle();

	/**
	 * @return the state title of the table
	 */
	String stateTableTitle();

	/**
	 * @return the action title of the table
	 */
	String actionTableTitle();

	/**
	 * @return the "my requests" title of the tab panel
	 */
	String myRequestsTitle();

	/**
	 * @return the "new request" title of the tab panel
	 */
	String newRequestTitle();

	/**
	 * @return the "validate requests" title of the tab panel
	 */
	String validateRequestsTitle();

	/**
	 * @return the "manage users" title of the tab panel
	 */
	String manageUsersTitle();

	/**
	 * @return the "manage users types" title of the tab panel
	 */
	String manageUsersTypesTitle();

	/**
	 * @return the "manage requests types" title of the tab panel
	 */
	String manageRequestsTypesTitle();

	/**
	 * @return the number of line to display in pagination
	 */
	String pageSize();

	/**
	 * @return the requests state for pending
	 */
	String requestsStatePending();

	/**
	 * @return the requests state for accepted
	 */
	String requestsStateAccepted();

	/**
	 * @return the requests state for refused
	 */
	String requestsStateRefused();

	/**
	 * @return the requests state for canceled
	 */
	String requestsStateCanceled();

	/**
	 * @return the change password label
	 */
	String changePasswordLabel();

	/**
	 * @return the disconnect label
	 */
	String disconnectLabel();
}
