/**
 * 
 */
package com.ineatconseil.yougo.client.ui.common.cell;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.ActionCell;
import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

/**
 * @author aelamrani
 */
public class ImageActionCell<C> extends AbstractCell<C> {

	/**
	 * The delegate that will handle events from the cell.
	 * @param <T>
	 *            the type that this delegate acts on
	 */
	public static interface Delegate<T> {
		/**
		 * Perform the desired action on the given object.
		 * @param object
		 *            the object to be acted upon
		 */
		void execute(T object);
	}

	private final SafeHtml html;
	private final Delegate<C> delegate;

	/**
	 * Construct a new {@link ActionCell} with a text String that does not contain HTML markup.
	 * @param path
	 *            the path of the image to display
	 * @param delegate
	 *            the delegate that will handle events
	 */
	public ImageActionCell(final String path, final Delegate<C> delegate) {
		super("click", "keydown");
		this.delegate = delegate;
		this.html = new SafeHtmlBuilder().appendHtmlConstant(
				new StringBuilder("<img src=\"").append(path).append("\" style=\"cursor:pointer;\" />").toString())
				.toSafeHtml();
	}

	@Override
	public void onBrowserEvent(Context context, Element parent, C value, NativeEvent event, ValueUpdater<C> valueUpdater) {
		super.onBrowserEvent(context, parent, value, event, valueUpdater);
		if ("click".equals(event.getType())) {
			onEnterKeyDown(context, parent, value, event, valueUpdater);
		}
	}

	@Override
	public void render(Context context, C value, SafeHtmlBuilder sb) {
		sb.append(html);
	}

	@Override
	protected void onEnterKeyDown(Context context, Element parent, C value, NativeEvent event,
			ValueUpdater<C> valueUpdater) {
		delegate.execute(value);
	}
}
