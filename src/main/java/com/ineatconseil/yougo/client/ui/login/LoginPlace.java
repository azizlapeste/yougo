/**
 * 
 */
package com.ineatconseil.yougo.client.ui.login;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * @author aelamrani
 */
public class LoginPlace extends Place {

	final String placeName;

	public LoginPlace(final String placeName) {
		this.placeName = placeName;
	}

	public String getPlaceName() {
		return placeName;
	}

	public static class Tokenizer implements PlaceTokenizer<LoginPlace> {

		@Override
		public LoginPlace getPlace(String token) {
			return new LoginPlace(token);
		}

		/**
		 * {@inheritDoc}
		 */

		@Override
		public String getToken(LoginPlace place) {
			return place.getPlaceName();
		}
	}
}
