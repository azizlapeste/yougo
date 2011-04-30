/**
 * 
 */
package com.ineatconseil.yougo.client.ui.common;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.ineatconseil.yougo.client.i18n.YougoLabelConstants;
import com.ineatconseil.yougo.client.i18n.YougoLabelMessages;
import com.ineatconseil.yougo.client.ui.login.ILoginView;
import com.ineatconseil.yougo.client.ui.login.LoginViewImpl;
import com.ineatconseil.yougo.client.ui.planning.IPlanningView;
import com.ineatconseil.yougo.client.ui.planning.PlanningViewImpl;
import com.ineatconseil.yougo.client.ui.requestsManagement.IRequestsManagementView;
import com.ineatconseil.yougo.client.ui.requestsManagement.RequestsManagementViewImpl;

/**
 * @author aelamrani
 */
public class ClientFactoryImpl implements ClientFactory {
	private final EventBus eventBus = new SimpleEventBus();
	private final PlaceController placeController = new PlaceController(eventBus);
	private final YougoLabelConstants constants = GWT.create(YougoLabelConstants.class);
	private final YougoLabelMessages messages = GWT.create(YougoLabelMessages.class);
	private final ILoginView loginView = GWT.create(LoginViewImpl.class);
	private final IPlanningView planningView = GWT.create(PlanningViewImpl.class);
	private final IRequestsManagementView requestsManagementView = GWT.create(RequestsManagementViewImpl.class);

	/**
	 * {@inheritDoc}
	 */

	@Override
	public EventBus getEventBus() {
		return eventBus;
	}

	/**
	 * {@inheritDoc}
	 */

	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public YougoLabelConstants getLabelConstants() {
		return constants;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public YougoLabelMessages getLabelMessages() {
		return messages;
	}

	/**
	 * {@inheritDoc}
	 */

	@Override
	public ILoginView getWelcomeView() {
		return loginView;
	}

	/**
	 * {@inheritDoc}
	 */

	@Override
	public IRequestsManagementView getRequestsManagementView() {
		return requestsManagementView;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IPlanningView getPlanningView() {
		return planningView;
	}
}
