/**
 * 
 */
package com.ineatconseil.yougo.client.cto;

/**
 * @author aelamrani
 */
public class UserCTO extends AbstractCTO {

	/**
	 * Default constructor.
	 */
	protected UserCTO() {
	}

	public final native int getId() /*-{
									return this.id;
									}-*/;

	public final native String getFullName() /*-{
												return this.fullName;
												}-*/;

	public final native String getEmail() /*-{
											return this.email;
											}-*/;

	public final native boolean isAdmin() /*-{
											return this.admin;
											}-*/;

	public final native boolean isActive() /*-{
											return this.active;
											}-*/;

	public final native void setId(final int id) /*-{
													return this.id = id;
													}-*/;

}
