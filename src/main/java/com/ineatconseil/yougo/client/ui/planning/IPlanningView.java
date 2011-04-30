/**
 * 
 */
package com.ineatconseil.yougo.client.ui.planning;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author aelamrani
 */
public interface IPlanningView extends IsWidget {

	void setPlanningTitleLabel(String label);

	void setPresenter(Presenter presenter);

	void addTabPanel(Widget widget, String title);

	void setDefaultSelectedPanel(int index);

	void setHelloLabel(String label);

	void setChangePasswordLinkLabel(String label);

	void setDisconnectLinkLabel(String label);

	void addClickHandlerOnDisconnectLink(ClickHandler handler);

	void addClickHandlerOnChangePasswordLink(ClickHandler handler);

	public interface Presenter {
		void goTo(Place place);
	}

}
