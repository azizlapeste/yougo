package com.ineatconseil.yougo.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.ineatconseil.yougo.client.ui.common.AppActivityMapper;
import com.ineatconseil.yougo.client.ui.common.AppPlaceHistoryMapper;
import com.ineatconseil.yougo.client.ui.common.ClientFactory;
import com.ineatconseil.yougo.client.ui.login.LoginPlace;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Yougo implements EntryPoint {

	private final Place defaultPlace = new LoginPlace("WelcomePlace");
	private final SimplePanel appWidget = new SimplePanel();

	/**
	 * This is the entry point method.
	 */

	@Override
	public void onModuleLoad() {

		final ClientFactory clientFactory = GWT.create(ClientFactory.class);
		final EventBus eventBus = clientFactory.getEventBus();
		final PlaceController placeController = clientFactory.getPlaceController();

		// Start ActivityManager for the main widget with our ActivityMapper
		final ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
		ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
		activityManager.setDisplay(appWidget);

		// Start PlaceHistoryHandler with our PlaceHistoryMapper
		final AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
		final PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		historyHandler.register(placeController, eventBus, defaultPlace);

		RootPanel.get("header_content").add(appWidget);
		// RootPanel.get("content").add(appWidget);
		// Goes to the place represented on URL else default place
		historyHandler.handleCurrentHistory();

	}
}
