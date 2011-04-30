/**
 * 
 */
package com.ineatconseil.yougo.client.ui.planning;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.ineatconseil.yougo.client.cto.RequestCTO;
import com.ineatconseil.yougo.client.cto.RequestTypeCTO;
import com.ineatconseil.yougo.client.i18n.YougoLabelConstants;
import com.ineatconseil.yougo.client.i18n.YougoLabelMessages;
import com.ineatconseil.yougo.client.service.UserClientService;
import com.ineatconseil.yougo.client.ui.common.ClientFactory;
import com.ineatconseil.yougo.client.ui.common.component.BasicPopup;
import com.ineatconseil.yougo.client.ui.common.component.PopupChangePassword;
import com.ineatconseil.yougo.client.ui.login.LoginPlace;
import com.ineatconseil.yougo.client.ui.requestsManagement.IRequestsManagementView;

/**
 * @author aelamrani
 */
public class PlanningActivity extends AbstractActivity implements IPlanningView.Presenter {
	private final ClientFactory clientFactory;
	private IPlanningView planningView;
	private IRequestsManagementView requestsManagementView;
	private YougoLabelConstants constants;
	private YougoLabelMessages messages;
	private final PlanningPlace planningPlace;
	private final UserClientService userClientService = GWT.create(UserClientService.class);

	private JsArray<RequestTypeCTO> requestTypes;

	public PlanningActivity(PlanningPlace place, ClientFactory clientFactory) {
		planningPlace = place;
		this.clientFactory = clientFactory;
	}

	/**
	 * Invoked by the ActivityManager to start a new Activity
	 */
	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		constants = clientFactory.getLabelConstants();
		messages = clientFactory.getLabelMessages();
		planningView = clientFactory.getPlanningView();
		planningView.setPlanningTitleLabel(constants.planningTitleLabel());
		planningView.setPresenter(this);
		planningView.setHelloLabel(messages.helloLabel(planningPlace.getUserId()));
		planningView.setChangePasswordLinkLabel(constants.changePasswordLabel());
		planningView.setDisconnectLinkLabel(constants.disconnectLabel());

		planningView.addClickHandlerOnDisconnectLink(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				goTo(new LoginPlace("LoginPlace"));
			}
		});

		final PopupChangePassword popup = new PopupChangePassword("Ancien mot de passe : ", "Nouveau mot de passe : ",
				"Confirmation nouveau mot de passe : ", "Changement mot de passe");
		planningView.addClickHandlerOnChangePasswordLink(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				popup.show();
			}
		});

		requestsManagementView = clientFactory.getRequestsManagementView();
		planningView.addTabPanel(requestsManagementView.asWidget(), constants.myRequestsTitle());
		planningView.setDefaultSelectedPanel(0);
		containerWidget.setWidget(planningView.asWidget());
		getRequestTypes();
		addColumnsOnRequestsManagementTable();
	}

	/**
	 * 
	 */
	private void getRequestTypes() {
		userClientService.getRequestTypes(new AsyncCallback<JsArray<RequestTypeCTO>>() {

			@Override
			public void onFailure(Throwable caught) {
			}

			@Override
			public void onSuccess(JsArray<RequestTypeCTO> result) {
				requestTypes = result;
				getRequests();
			}
		});
	}

	private void addColumnsOnRequestsManagementTable() {
		final Column<RequestCTO, String> typeColumn = new Column<RequestCTO, String>(new TextCell()) {
			@Override
			public String getValue(RequestCTO request) {
				for (int i = 0; i < requestTypes.length(); i++) {
					if (request.getTypeId() == requestTypes.get(i).getId()) {
						return requestTypes.get(i).getDescription();
					}
				}
				return "";
			}
		};
		typeColumn.setSortable(true);

		final Column<RequestCTO, String> fromColumn = new Column<RequestCTO, String>(new TextCell()) {
			@Override
			public String getValue(RequestCTO request) {
				return request.getFrom();
			}
		};
		fromColumn.setSortable(true);

		final Column<RequestCTO, String> toColumn = new Column<RequestCTO, String>(new TextCell()) {
			@Override
			public String getValue(RequestCTO request) {
				return request.getTo();
			}
		};
		toColumn.setSortable(true);

		final Column<RequestCTO, String> observationColumn = new Column<RequestCTO, String>(new TextCell()) {
			@Override
			public String getValue(RequestCTO request) {
				return request.getAskComment();
			}
		};
		observationColumn.setSortable(true);

		final Column<RequestCTO, String> replyColumn = new Column<RequestCTO, String>(new TextCell()) {
			@Override
			public String getValue(RequestCTO request) {
				return request.getAnswerComment();
			}
		};
		replyColumn.setSortable(true);

		final Column<RequestCTO, String> stateColumn = new Column<RequestCTO, String>(new TextCell()) {
			@Override
			public String getValue(RequestCTO request) {
				return constants.getString("requestsState" + request.getStatus().substring(0, 1)
						+ request.getStatus().substring(1).toLowerCase());
			}
		};
		stateColumn.setSortable(true);

		requestsManagementView.addColumnOnTable(typeColumn, constants.typeTableTitle());
		requestsManagementView.addColumnOnTable(fromColumn, constants.fromTableTitle());
		requestsManagementView.addColumnOnTable(toColumn, constants.toTableTitle());
		requestsManagementView.addColumnOnTable(observationColumn, constants.observationTableTitle());
		requestsManagementView.addColumnOnTable(replyColumn, constants.replyTableTitle());
		requestsManagementView.addColumnOnTable(stateColumn, constants.stateTableTitle());
	}

	private void getRequests() {
		userClientService.getRequests(planningPlace.getUserId(), new AsyncCallback<JsArray<RequestCTO>>() {
			@Override
			public void onSuccess(final JsArray<RequestCTO> result) {
				requestsManagementView.initTable(Integer.parseInt(constants.pageSize()), result);
			}

			@Override
			public void onFailure(Throwable exception) {
				BasicPopup.showError(exception);
			}
		});
	}

	/**
	 * Navigate to a new Place in the browser
	 */
	@Override
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
	}
}
