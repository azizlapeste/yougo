/**
 * 
 */
package com.ineatconseil.yougo.client.ui.common;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.ineatconseil.yougo.client.ui.login.LoginPlace;
import com.ineatconseil.yougo.client.ui.planning.PlanningPlace;

/**
 * @author aelamrani
 */
@WithTokenizers({ LoginPlace.Tokenizer.class, PlanningPlace.Tokenizer.class })
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}
