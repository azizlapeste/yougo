/**
 * 
 */
package com.ineatconseil.yougo.client.ui.common;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.ineatconseil.yougo.client.ui.login.LoginActivity;
import com.ineatconseil.yougo.client.ui.login.LoginPlace;
import com.ineatconseil.yougo.client.ui.planning.PlanningActivity;
import com.ineatconseil.yougo.client.ui.planning.PlanningPlace;

/**
 * @author aelamrani
 */

public class AppActivityMapper implements ActivityMapper {
	private final ClientFactory clientFactory;

	public AppActivityMapper(ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}

	@Override
	public Activity getActivity(Place place) {
		if (place instanceof LoginPlace) {
			return new LoginActivity((LoginPlace) place, clientFactory);
		} else if (place instanceof PlanningPlace) {
			return new PlanningActivity((PlanningPlace) place, clientFactory);
		}
		return null;
	}

}
