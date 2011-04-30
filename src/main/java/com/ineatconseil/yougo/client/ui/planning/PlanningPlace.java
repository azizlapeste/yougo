/**
 * 
 */
package com.ineatconseil.yougo.client.ui.planning;

import com.google.gwt.place.shared.Place;
import com.ineatconseil.yougo.client.cto.UserCTO;

/**
 * @author aelamrani
 */
public class PlanningPlace extends Place {
	private final UserCTO user;

	public PlanningPlace(final UserCTO user) {
		this.user = user;
	}

	/**
	 * @return
	 */
	public String getUserId() {
		return String.valueOf(this.user.getId());
	}

	/**
	 * @return
	 */
	public UserCTO getUser() {
		return user;
	}
}
