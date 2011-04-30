/**
 * 
 */
package com.ineatconseil.yougo.client.cto;

/**
 * @author aelamrani
 */
public class RequestCTO extends AbstractCTO {

	/**
	 * Default constructor.
	 */
	protected RequestCTO() {
	}

	public final native String getId() /*-{
		return this.id;
	}-*/;

	public final native int getTypeId() /*-{
		return this.typeId;
	}-*/;

	public final String getFrom() {
		return getStringDate("from");
	};

	public final String getTo() {
		return getStringDate("to");
	};

	public final native String getAskComment() /*-{
		return this.askComment;
	}-*/;

	public final native String getAnswerComment() /*-{
		return this.answerComment;
	}-*/;

	public final native String getStatus() /*-{
		return this.status;
	}-*/;

}
