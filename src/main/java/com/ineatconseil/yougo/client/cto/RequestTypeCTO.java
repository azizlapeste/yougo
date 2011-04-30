/**
 * 
 */
package com.ineatconseil.yougo.client.cto;


/**
 * @author aelamrani
 */
public class RequestTypeCTO extends AbstractCTO {

	/**
	 * Default constructor.
	 */
	protected RequestTypeCTO() {
	}

	public final native int getId() /*-{
		return this.id;
	}-*/;

	public final native String getDescription() /*-{
		return this.description;
	}-*/;
}
