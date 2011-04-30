package com.ineatconseil.yougo.client.ui.common.component;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.Event.NativePreviewHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.ineatconseil.yougo.client.i18n.YougoLabelConstants;
import com.ineatconseil.yougo.client.ui.common.callback.PopupCallback;
import com.ineatconseil.yougo.client.ui.common.utils.FocusManager;
import com.ineatconseil.yougo.client.ui.common.utils.StringHelperGwt;

/**
 * @author aelamrani
 */
public abstract class AbstractDialogBox extends DialogBox {

	private HandlerRegistration handlerRegistration;
	private final YougoLabelConstants constants = GWT.create(YougoLabelConstants.class);
	final Button okButton;
	final Button cancelButton;
	final HorizontalPanel buttonContainer;

	/** Count the number of modal box open. */
	private static int nbDialogBox = 0;

	public enum Level {
		/**
		 * The error type is used when an unexpected error is caught.
		 */
		ERROR("error"),
		/**
		 * The alert type is used when the user must pay attention.
		 */
		WARNING("warning"),
		/**
		 * The confirm type is used when a confirmation is needed to continue.
		 */
		CONFIRM("confirm");

		private String styleName;

		/**
		 * @return the styleName
		 */
		public String getStyleName() {
			return styleName;
		}

		private Level(final String styleName) {
			this.styleName = styleName;
		}
	}

	/**
	 * Allows to create a modal box with a title and fill it with HTML content as string.
	 * @param level
	 *            the level of the popup
	 * @param content
	 *            the HTML content as string
	 */
	public AbstractDialogBox(final Level level, final Widget content) {
		this(level, content, null, false);
	}

	/**
	 * Allows to create a modal box with a title and fill it with HTML content as string.
	 * @param level
	 *            the level of the popup
	 * @param content
	 *            the HTML content as string
	 * @param title
	 *            the title
	 */
	public AbstractDialogBox(final Level level, final Widget content, final String title) {
		this(level, content, title, false);
	}

	/**
	 * Allows to create a modal box with a title and fill it with HTML content as string.
	 * @param level
	 *            the level of the popup
	 * @param content
	 *            the HTML content as string
	 * @param title
	 *            the title
	 * @param enableHide
	 *            true if the popup can be hidden
	 */
	public AbstractDialogBox(final Level level, final Widget content, final String title, final boolean enableHide) {
		super();

		setAutoHideEnabled(enableHide);
		setGlassEnabled(true);
		setAnimationEnabled(true);

		final HorizontalPanel imageAndTextContent = new HorizontalPanel();
		final HTML image = new HTML();
		image.setStylePrimaryName(level.getStyleName());
		image.getElement().getStyle().setPaddingBottom(80, Unit.PX);
		imageAndTextContent.add(image);

		imageAndTextContent.add(content);
		content.getElement().getStyle().setPaddingLeft(115, Unit.PX);

		final VerticalPanel dialogContent = new VerticalPanel();
		dialogContent.setSpacing(30);
		setWidget(dialogContent);
		dialogContent.getParent().setStylePrimaryName("dialogBox");
		dialogContent.addStyleName(level.getStyleName());
		dialogContent.getElement().getStyle().setMargin(10, Unit.PX);

		dialogContent.add(imageAndTextContent);
		dialogContent.setCellHorizontalAlignment(content, HasHorizontalAlignment.ALIGN_CENTER);

		okButton = new CustomButton(constants.ok(), new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				hide();
			}
		});

		cancelButton = new CustomButton(constants.cancel(), new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				hide();
			}
		});

		buttonContainer = new HorizontalPanel();
		buttonContainer.add(okButton);
		buttonContainer.setWidth("305px");
		dialogContent.add(buttonContainer);
		dialogContent.setCellHorizontalAlignment(buttonContainer, HasHorizontalAlignment.ALIGN_CENTER);
		buttonContainer.setCellHorizontalAlignment(okButton, HasHorizontalAlignment.ALIGN_CENTER);
		// if title is blank, we set a default title depending on level
		if (StringHelperGwt.isBlank(title)) {
			switch (level) {
			case CONFIRM:
				setText(constants.confirmTitle());
				addCancelButton();
				break;
			case ERROR:
				setText(constants.errorTitle());
				break;
			case WARNING:
				setText(constants.warningTitle());
				addCancelButton();
				break;
			default:
				break;
			}
		} else {
			setText(title);
		}
	}

	/**
	 * 
	 */
	public void addCancelButton() {
		buttonContainer.add(cancelButton);
		buttonContainer.setCellHorizontalAlignment(cancelButton, HasHorizontalAlignment.ALIGN_CENTER);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void show() {
		if (isShowing()) {
			return;
		}
		super.show();
		this.center();
		if (isAutoHideEnabled()) {
			enableCloseOnEscape();
		}
		okButton.setFocus(true);
		nbDialogBox++;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void hide() {
		if (!isShowing()) {
			return;
		}
		if (handlerRegistration != null) {
			handlerRegistration.removeHandler();
		}
		if (FocusManager.getWidgetFocused() != null) {
			FocusManager.applyFocus();
		}
		super.hide();
		nbDialogBox--;
	}

	/**
	 * Allows to enable close on pressure of the escape button.
	 */
	public void enableCloseOnEscape() {
		handlerRegistration = Event.addNativePreviewHandler(new NativePreviewHandler() {
			@Override
			public void onPreviewNativeEvent(NativePreviewEvent event) {
				if (isShowing() && KeyCodes.KEY_ESCAPE == event.getNativeEvent().getKeyCode()) {
					hide();
				}
			}
		});
	}

	/**
	 * @return true if a dialog box is opened.
	 */
	public static boolean isADialogBoxOpened() {
		return nbDialogBox > 0;
	};

	public void setPopupCallback(final PopupCallback callback) {
		okButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				callback.onConfirm();
			}
		});
		cancelButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				callback.onCancel();
			}
		});
	}
}