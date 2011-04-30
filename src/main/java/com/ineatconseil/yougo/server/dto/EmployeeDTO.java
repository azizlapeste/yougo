/**
 * 
 */
package com.ineatconseil.yougo.server.dto;

/**
 * @author aelamrani
 */
public class EmployeeDTO {

	private String firstName;
	private String lastName;

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return this.firstName;
	};

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return this.lastName;
	};

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}
}
