/**
 * 
 */
package com.ineatconseil.yougo.client.ui.planning;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * @author aelamrani
 */
public class PlanningPlace extends Place {
	private final String userId;

	public PlanningPlace(final String userId) {
		this.userId = userId;
	}

	/**
	 * @return
	 */
	public String getUserId() {
		return this.userId;
	}

	public static class Tokenizer implements PlaceTokenizer<PlanningPlace> {
		@Override
		public String getToken(PlanningPlace place) {
			return place.getUserId();
		}

		@Override
		public PlanningPlace getPlace(String token) {
			return new PlanningPlace(token);
		}
	}
}
