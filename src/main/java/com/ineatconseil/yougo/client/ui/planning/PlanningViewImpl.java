/**
 * 
 */
package com.ineatconseil.yougo.client.ui.planning;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author aelamrani
 */
public class PlanningViewImpl extends Composite implements IPlanningView {

	@UiTemplate("PlanningUiBinder.ui.xml")
	interface PlanningUiBinder extends UiBinder<HTMLPanel, PlanningViewImpl> {
	}

	private static PlanningUiBinder uiBinder = GWT.create(PlanningUiBinder.class);

	public PlanningViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	Label planningTitleLabel;

	@UiField
	TabPanel planningTabPanel;

	@UiField
	Label helloLabel;

	@UiField
	Anchor changePasswordLink;

	@UiField
	Anchor disconnectLink;

	private Presenter presenter;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPlanningTitleLabel(final String text) {
		planningTitleLabel.setText(text);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addTabPanel(final Widget widget, final String title) {
		planningTabPanel.add(widget, title);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setDefaultSelectedPanel(final int index) {
		planningTabPanel.selectTab(index);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setHelloLabel(final String label) {
		helloLabel.setText(label);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setChangePasswordLinkLabel(final String label) {
		changePasswordLink.setText(label);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setDisconnectLinkLabel(final String label) {
		disconnectLink.setText(label);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addClickHandlerOnChangePasswordLink(final ClickHandler handler) {
		changePasswordLink.addClickHandler(handler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addClickHandlerOnDisconnectLink(final ClickHandler handler) {
		disconnectLink.addClickHandler(handler);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPresenter(final Presenter presenter) {
		this.presenter = presenter;
	}
}
