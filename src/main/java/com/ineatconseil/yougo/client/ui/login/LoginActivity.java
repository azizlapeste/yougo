/**
 * 
 */
package com.ineatconseil.yougo.client.ui.login;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.ineatconseil.yougo.client.cto.UserCTO;
import com.ineatconseil.yougo.client.i18n.YougoLabelConstants;
import com.ineatconseil.yougo.client.service.UserClientService;
import com.ineatconseil.yougo.client.ui.common.ClientFactory;
import com.ineatconseil.yougo.client.ui.common.component.AbstractDialogBox.Level;
import com.ineatconseil.yougo.client.ui.common.component.BasicPopup;
import com.ineatconseil.yougo.client.ui.planning.PlanningPlace;

/**
 * @author aelamrani
 */
public class LoginActivity extends AbstractActivity implements ILoginView.Presenter {
	// Used to obtain views, eventBus, placeController
	// Alternatively, could be injected via GIN
	private final ClientFactory clientFactory;
	private final UserClientService userClientService = GWT.create(UserClientService.class);

	private YougoLabelConstants constants;
	private ILoginView loginView;
	private final List<HandlerRegistration> handlerRegistrations = new ArrayList<HandlerRegistration>();

	public LoginActivity(LoginPlace place, ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	/**
	 * Invoked by the ActivityManager to start a new Activity
	 */

	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		constants = clientFactory.getLabelConstants();
		loginView = clientFactory.getWelcomeView();
		loginView.setTitleLabel(constants.welcomeTitleLabel());
		loginView.setLoginBtLabel(constants.loginBtLabel());
		loginView.setLoginLabel(constants.loginLabel());
		loginView.setPasswordLabel(constants.passwordLabel());
		loginView.setPresenter(this);
		handlerRegistrations.add(loginView.addClickHandlerOnLogin(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				fixConnect();
			}
		}));
		final KeyDownHandler keyDownHandler = new KeyDownHandler() {
			@Override
			public void onKeyDown(final KeyDownEvent event) {
				if (KeyCodes.KEY_ENTER == event.getNativeKeyCode()) {
					fixConnect();
				}
			}
		};
		handlerRegistrations.add(loginView.addKeyDownHandlerOnLogin(keyDownHandler));
		handlerRegistrations.add(loginView.addKeyDownHandlerOnPassword(keyDownHandler));
		containerWidget.setWidget(loginView.asWidget());
		loginView.setFocus();
	}

	private void connect() {
		userClientService.connect("1", new AsyncCallback<JsArrayString>() {

			@Override
			public void onFailure(Throwable caught) {
				BasicPopup.showError(caught.getMessage());
			}

			@Override
			public void onSuccess(JsArrayString result) {
				BasicPopup.showConfirm("ok");
			}
		});
	}

	private void fixConnect() {
		userClientService.getUsers(new AsyncCallback<JsArray<UserCTO>>() {
			@Override
			public void onSuccess(JsArray<UserCTO> result) {
				boolean bNotFound = true;
				for (int i = 0; i < result.length(); i++) {
					if ((loginView.getLogin().equals(result.get(i).getEmail()) && loginView.getPassword().equals(
							"password"))
							|| (loginView.getLogin().equals("toto") && loginView.getPassword().equals("toto"))) {
						BasicPopup.show(Level.CONFIRM, "Bienvenue " + result.get(i).getFullName(),
								"Vous êtes maintenant connecté sur YouGO", true);
						goTo(new PlanningPlace(result.get(i)));
						bNotFound = false;
						break;
					}
				}
				if (bNotFound) {
					BasicPopup.showError("Identifiant ou mot de passe incorrect...!");
				}
			}

			@Override
			public void onFailure(Throwable exception) {
				BasicPopup.showError(exception);
			}
		});
	}

	@Override
	public void onStop() {
		if (handlerRegistrations != null) {
			for (int i = 0; i < handlerRegistrations.size(); i++) {
				handlerRegistrations.get(i).removeHandler();
			}
		}
	}

	/**
	 * Navigate to a new Place in the browser
	 */
	@Override
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
	}
}
