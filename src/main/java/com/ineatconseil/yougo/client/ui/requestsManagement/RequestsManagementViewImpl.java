/**
 * 
 */
package com.ineatconseil.yougo.client.ui.requestsManagement;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.ineatconseil.yougo.client.cto.RequestCTO;
import com.ineatconseil.yougo.client.ui.common.utils.JavascriptObjectUtils;

/**
 * @author aelamrani
 */
public class RequestsManagementViewImpl extends Composite implements IRequestsManagementView {

	/**
	 * Default column width constant.
	 */
	private static final String DEFAULT_COLUMN_WIDTH = "400px";

	@UiTemplate("RequestsManagementUiBinder.ui.xml")
	interface RequestsManagementUiBinder extends UiBinder<HTMLPanel, RequestsManagementViewImpl> {
	}

	private static RequestsManagementUiBinder uiBinder = GWT.create(RequestsManagementUiBinder.class);

	public RequestsManagementViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	/**
	 * The requests management cell table.
	 */
	@UiField
	CellTable<RequestCTO> requestsManagementTable;

	/**
	 * The pager used to change the range of data.
	 */
	@UiField(provided = true)
	SimplePager requestsManagementPager = getSimplePager();

	@UiFactory
	SimplePager getSimplePager() {
		SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
		return new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
	}

	private Presenter presenter;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void initTable(final int pageSize, final JsArray<RequestCTO> requests) {
		requestsManagementTable.setWidth("100%", false);
		requestsManagementTable.setPageSize(pageSize);
		requestsManagementTable.setRowData(JavascriptObjectUtils.toList(requests));
		requestsManagementPager.setDisplay(requestsManagementTable);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addColumnOnTable(Column<RequestCTO, String> column, String title) {
		requestsManagementTable.addColumn(column, title);
		requestsManagementTable.setColumnWidth(column, DEFAULT_COLUMN_WIDTH);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPresenter(final Presenter presenter) {
		this.presenter = presenter;
	}
}
