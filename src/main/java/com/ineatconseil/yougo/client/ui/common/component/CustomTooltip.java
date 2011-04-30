package com.ineatconseil.yougo.client.ui.common.component;

import com.google.gwt.event.dom.client.MouseEvent;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.DecoratedPopupPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

/**
 * Custom tooltip is a helper class that add tooltip to widget.<br /> <br /> The tooltip is simply a
 * {@link DecoratedPopupPanel} in which we set the text.<br /> <br /> There's many option for the tooltip :<br /> <br />
 * You can add a style class name to this panel.<br /> CSS Style Rules is the same as {@link DecoratedPopupPanel}.<br />
 * <br /> You can set the tooltip to a given position (from the top left corner of the widget)<br /> or you can made the
 * tooltip follow the mouse<br /> <br /> You can display tooltip immediatly when you are over the widget<br /> or you
 * can delay tooltip appearance<br /> <br /> You can display the tooltip until you are out the widget<br /> or you can
 * display the tooltip for a duration
 * @author aelamrani
 */
public class CustomTooltip {
	/**
	 * Default offset from the widget top (or mouse position) to display tooltip
	 */
	public static final int DEFAULT_OFFSET_TOP = -40;
	/**
	 * Default offset from the widget left (or mouse position) to display tooltip
	 */
	public static final int DEFAULT_OFFSET_LEFT = 40;

	/**
	 * Inner class that simply store some data.
	 */
	private static class TooltipDefinition {
		/** tooltip */
		private DecoratedPopupPanel tooltip;
		/** tooltip top position */
		private int top;
		/** tooltip left position */
		private int left;

		/**
		 * @param tooltip
		 *            the tooltip to set
		 */
		public void setTooltip(DecoratedPopupPanel tooltip) {
			this.tooltip = tooltip;
		}

		/**
		 * @return the tooltip
		 */
		public DecoratedPopupPanel getTooltip() {
			return tooltip;
		}

		/**
		 * @param top
		 *            the top to set
		 */
		public void setTop(int top) {
			this.top = top;
		}

		/**
		 * @return the top
		 */
		public int getTop() {
			return top;
		}

		/**
		 * @param left
		 *            the left to set
		 */
		public void setLeft(int left) {
			this.left = left;
		}

		/**
		 * @return the left
		 */
		public int getLeft() {
			return left;
		}
	}

	/**
	 * Add a tooltip.<br /> <br /> The tooltip will have the default style, will be at a fixed position from the widget
	 * (at offset ({@link #DEFAULT_OFFSET_TOP}, {@link #DEFAULT_OFFSET_LEFT} from top left corner) and will be displayed
	 * immediatly when the mouse will be over the widget, until the mouse will get out the widget.
	 * @param widget
	 *            the widget we add tooltip for
	 * @param text
	 *            tooltip text
	 */
	public static void add(final Widget widget, final String text) {
		add(widget, text, null, true, DEFAULT_OFFSET_TOP, DEFAULT_OFFSET_LEFT, -1, -1);
	}

	/**
	 * Add a tooltip.<br /> <br /> The tooltip will have the 'style' style, will be at a fixed position from the widget
	 * (at offset ({@link #DEFAULT_OFFSET_TOP}, {@link #DEFAULT_OFFSET_LEFT} from top left corner) and will be displayed
	 * immediatly when the mouse will be over the widget, until the mouse will get out the widget.
	 * @param widget
	 *            the widget we add tooltip for
	 * @param text
	 *            tooltip text
	 * @param style
	 *            style class name to add to the widget
	 */
	public static void add(final Widget widget, final String text, final String style) {
		add(widget, text, style, true, DEFAULT_OFFSET_TOP, DEFAULT_OFFSET_LEFT, -1, -1);
	}

	/**
	 * Add a tooltip.<br /> <br /> The tooltip will have the default style, will be displayed immediatly when the mouse
	 * will be over the widget, until the mouse will get out the widget.<br /> <br /> If 'fixed' is true, tooltip will
	 * be at a fixed position from the top left corner of the widget with an offset of (offsetTop, offsetLeft).<br /> If
	 * not 'fixed', the tooltip will follow the mouse cursor with the given offset (offsetTop, offsetLeft).
	 * @param widget
	 *            the widget we add tooltip for
	 * @param text
	 *            tooltip text
	 * @param fixed
	 *            boolean that define if the tooltip is at a fixed position or follow the mouse.
	 * @param offsetTop
	 *            offset from widget top if fixed mode or mouse position if not fixed
	 * @param offsetLeft
	 *            offset from widget left if fixed or mouse position if notfixed
	 */
	public static void add(final Widget widget, final String text, final boolean fixed, final int offsetTop,
			final int offsetLeft) {
		add(widget, text, null, fixed, offsetTop, offsetLeft, -1, -1);
	}

	/**
	 * Add a tooltip.<br /> <br /> The tooltip will have the style 'style', will be displayed immediatly when the mouse
	 * will be over the widget, until the mouse will get out the widget.<br /> <br /> If 'fixed' is true, tooltip will
	 * be at a fixed position from the top left corner of the widget with an offset of (offsetTop, offsetLeft).<br /> If
	 * not 'fixed', the tooltip will follow the mouse cursor with the given offset (offsetTop, offsetLeft).
	 * @param widget
	 *            the widget we add tooltip for
	 * @param text
	 *            tooltip text
	 * @param style
	 *            style class name to add to the widget
	 * @param fixed
	 *            boolean that define if the tooltip is at a fixed position or follow the mouse.
	 * @param offsetTop
	 *            offset from widget top if fixed mode or mouse position if not fixed
	 * @param offsetLeft
	 *            offset from widget left if fixed or mouse position if notfixed
	 */
	public static void add(final Widget widget, final String text, final String style, final boolean fixed,
			final int offsetTop, final int offsetLeft) {
		add(widget, text, style, fixed, offsetTop, offsetLeft, -1, -1);
	}

	/**
	 * Add a tooltip.<br /> <br /> The tooltip will have the default style, will be at a fixed position from the widget
	 * (at offset ({@link #DEFAULT_OFFSET_TOP}, {@link #DEFAULT_OFFSET_LEFT} from top left corner) and will be displayed
	 * waiting 'waitTime' after the mouse is over the widget, for a 'duringTime' (unless duringTime is -1 => until mouse
	 * over).
	 * @param widget
	 *            the widget we add tooltip for
	 * @param text
	 *            tooltip text
	 * @param waitTime
	 *            time(in ms) to wait before showing tooltip (-1 if immediatly)
	 * @param duringTime
	 *            time(in ms) to show tooltip before closing (-1 to display until mouse over widget)
	 */
	public static void add(final Widget widget, final String text, final int waitTime, final int duringTime) {
		add(widget, text, null, true, DEFAULT_OFFSET_TOP, DEFAULT_OFFSET_LEFT, waitTime, duringTime);
	}

	/**
	 * Add a tooltip.<br /> <br /> The tooltip will have the 'style' style, will be at a fixed position from the widget
	 * (at offset ({@link #DEFAULT_OFFSET_TOP}, {@link #DEFAULT_OFFSET_LEFT} from top left corner) and will be displayed
	 * waiting 'waitTime' after the mouse is over the widget, for a 'duringTime' (unless duringTime is -1 => until mouse
	 * over).<br />
	 * @param widget
	 *            the widget we add tooltip for
	 * @param text
	 *            tooltip text
	 * @param style
	 *            style class name to add to the widget
	 * @param waitTime
	 *            time(in ms) to wait before showing tooltip (-1 if immediatly)
	 * @param duringTime
	 *            time(in ms) to show tooltip before closing (-1 to display until mouse over widget)
	 */
	public static void add(final Widget widget, final String text, final String style, final int waitTime,
			final int duringTime) {
		add(widget, text, style, true, DEFAULT_OFFSET_TOP, DEFAULT_OFFSET_LEFT, waitTime, duringTime);
	}

	/**
	 * Add a tooltip.<br /> <br /> The tooltip will have the default style, will be displayed waiting 'waitTime' after
	 * the mouse is over the widget, for a 'duringTime' (unless duringTime is -1 => until mouse over).<br /> <br /> If
	 * 'fixed' is true, tooltip will be at a fixed position from the top left corner of the widget with an offset of
	 * (offsetTop, offsetLeft).<br /> If not 'fixed', the tooltip will follow the mouse cursor with the given offset
	 * (offsetTop, offsetLeft).
	 * @param widget
	 *            the widget we add tooltip for
	 * @param text
	 *            tooltip text
	 * @param fixed
	 *            boolean that define if the tooltip is at a fixed position or follow the mouse.
	 * @param offsetTop
	 *            offset from widget top if fixed mode or mouse position if not fixed
	 * @param offsetLeft
	 *            offset from widget left if fixed or mouse position if notfixed
	 * @param waitTime
	 *            time(in ms) to wait before showing tooltip (-1 if immediatly)
	 * @param duringTime
	 *            time(in ms) to show tooltip before closing (-1 to display until mouse over widget)
	 */
	public static void add(final Widget widget, final String text, final boolean fixed, final int offsetTop,
			final int offsetLeft, final int waitTime, final int duringTime) {
		add(widget, text, null, fixed, offsetTop, offsetLeft, waitTime, duringTime);
	}

	/**
	 * Add a tooltip.<br /> <br /> The tooltip will have the style 'style', will be displayed waiting 'waitTime' after
	 * the mouse is over the widget, for a 'duringTime' (unless duringTime is -1 => until mouse over).<br /> <br /> If
	 * 'fixed' is true, tooltip will be at a fixed position from the top left corner of the widget with an offset of
	 * (offsetTop, offsetLeft).<br /> If not 'fixed', the tooltip will follow the mouse cursor with the given offset
	 * (offsetTop, offsetLeft).
	 * @param widget
	 *            the widget we add tooltip for
	 * @param text
	 *            tooltip text
	 * @param style
	 *            style class name to add to the widget
	 * @param fixed
	 *            boolean that define if the tooltip is at a fixed position or follow the mouse.
	 * @param offsetTop
	 *            offset from widget top if fixed mode or mouse position if not fixed
	 * @param offsetLeft
	 *            offset from widget left if fixed or mouse position if notfixed
	 * @param waitTime
	 *            time(in ms) to wait before showing tooltip (-1 if immediatly)
	 * @param duringTime
	 *            time(in ms) to show tooltip before closing (-1 to display until mouse over widget)
	 */
	public static void add(final Widget widget, final String text, final String style, final boolean fixed,
			final int offsetTop, final int offsetLeft, final int waitTime, final int duringTime) {
		// Popup creation
		final DecoratedPopupPanel tooltip = new DecoratedPopupPanel();
		// Adding style if given
		if (style != null) {
			tooltip.addStyleName(style);
		}
		tooltip.add(new HTML(text));

		// Creating the definition. This class simplify method calling.
		final TooltipDefinition definition = new TooltipDefinition();
		definition.setTooltip(tooltip);

		// Define a timer that will be used to close tooltip if 'duringTime'>0
		final Timer tearDown = new Timer() {
			@Override
			public void run() {
				if (tooltip.isShowing()) {
					tooltip.hide();
				}
			}
		};

		// Define a timer that will be used to display tooltip after a wait
		// (if 'waitTime'>0)
		final Timer startup = new Timer() {
			@Override
			public void run() {
				displayTooltip(definition);
				if (duringTime > 0) {
					tearDown.schedule(duringTime);
				}
			}
		};

		// If we're not in fixed mode, we listen mouseMove on the widget.
		if (!fixed) {
			widget.addDomHandler(new MouseMoveHandler() {
				@Override
				public void onMouseMove(MouseMoveEvent event) {
					// Tooltip not showed => reset startup timer
					if (!tooltip.isShowing()) {
						if (waitTime > 0) {
							startup.cancel();
							startup.schedule(waitTime);
						}
					} else {
						// Tooltip is displayed => reset tearDown timer
						if (duringTime > 0) {
							tearDown.cancel();
							tearDown.schedule(duringTime);
						}
					}
					// In each case, recalculate the tooltip position
					calcPos(event, definition, fixed, offsetTop, offsetLeft);
				}
			}, MouseMoveEvent.getType());
		}

		// Adding the mouse over event : display or launch the startupTimer
		widget.addDomHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(final MouseOverEvent event) {
				// Calculate tooltip position
				calcPos(event, definition, fixed, offsetTop, offsetLeft);
				// If waitTime => launching startupTimer
				if (waitTime > 0) {
					startup.schedule(waitTime);
				} else {
					// No waitTime => displaying tooltip and launching tearDown
					// timer if needed.
					displayTooltip(definition);
					if (duringTime > 0) {
						tearDown.schedule(duringTime);
					}
				}
			}
		}, MouseOverEvent.getType());

		// On mouse over handler : hide the tooltip and kill the timer
		widget.addDomHandler(new MouseOutHandler() {
			@Override
			public void onMouseOut(final MouseOutEvent event) {
				startup.cancel();
				tearDown.cancel();
				if (tooltip.isShowing()) {
					tooltip.hide();
				}
			}
		}, MouseOutEvent.getType());
	}

	/**
	 * display the given tooltip : This set the tooltip position and show it
	 * @param definition
	 *            tooltip defintion : contains tooltip and position
	 */
	private static final void displayTooltip(TooltipDefinition definition) {
		definition.getTooltip().setPopupPosition(definition.getLeft(), definition.getTop());
		definition.getTooltip().setAnimationEnabled(true);
		definition.getTooltip().show();
	}

	/**
	 * Calculate the new position of the tooltip. (from top/left event source corner if fixed, else mouse position)<br
	 * /> Then update the 'definition'<br/> finally, if the tooltip is already displayed, change the position.
	 * @param event
	 *            mouse envent
	 * @param definition
	 *            tooltip definition (tolltip + position)
	 * @param fixed
	 *            if position is fixed to the widget or the mouse
	 * @param offsetTop
	 *            offset to add to tooltip top position
	 * @param offsetLeft
	 *            offet to add to tooltip left position
	 */
	private static final void calcPos(final MouseEvent<? extends EventHandler> event,
			final TooltipDefinition definition, final boolean fixed, final int offsetTop, final int offsetLeft) {

		int left = event.getClientX() + offsetLeft;
		int top = event.getClientY() + offsetTop;
		if (fixed) {
			final Widget source = (Widget) event.getSource();
			left = source.getAbsoluteLeft() + +offsetLeft;
			top = source.getAbsoluteTop() + offsetTop;
		}
		definition.setLeft(left);
		definition.setTop(top);
		if (definition.getTooltip().isShowing()) {
			definition.getTooltip().setPopupPosition(definition.getLeft(), definition.getTop());
		}
	}
}
