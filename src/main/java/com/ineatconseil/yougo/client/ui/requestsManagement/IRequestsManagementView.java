/**
 * 
 */
package com.ineatconseil.yougo.client.ui.requestsManagement;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.ui.IsWidget;
import com.ineatconseil.yougo.client.cto.RequestCTO;

/**
 * @author aelamrani
 */
public interface IRequestsManagementView extends IsWidget {

	void initTable(int pageSize, JsArray<RequestCTO> requests);

	void addColumnOnTable(Column<RequestCTO, ?> column, String title);

	void addColumnOnTable(Column<RequestCTO, ?> column, String title, String columnWidth);

	void setPresenter(Presenter presenter);

	public interface Presenter {
		void goTo(Place place);
	}

}
