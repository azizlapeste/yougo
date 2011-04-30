/**
 * 
 */
package com.ineatconseil.yougo.client.ui.common;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.ineatconseil.yougo.client.ui.login.LoginPlace;

/**
 * @author aelamrani
 */
@WithTokenizers({ LoginPlace.Tokenizer.class })
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}
