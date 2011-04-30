/**
 * 
 */
package com.ineatconseil.yougo.client.ui.common;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.ineatconseil.yougo.client.i18n.YougoLabelConstants;
import com.ineatconseil.yougo.client.i18n.YougoLabelMessages;
import com.ineatconseil.yougo.client.ui.login.ILoginView;
import com.ineatconseil.yougo.client.ui.planning.IPlanningView;
import com.ineatconseil.yougo.client.ui.requestsManagement.IRequestsManagementView;

/**
 * @author aelamrani
 */

public interface ClientFactory {
	EventBus getEventBus();

	PlaceController getPlaceController();

	ILoginView getWelcomeView();

	IRequestsManagementView getRequestsManagementView();

	IPlanningView getPlanningView();

	YougoLabelConstants getLabelConstants();

	YougoLabelMessages getLabelMessages();
}
