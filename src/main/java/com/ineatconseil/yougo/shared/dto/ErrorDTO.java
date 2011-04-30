package com.ineatconseil.yougo.shared.dto;

/**
 * Error class that combines the error code with his message.
 * @author z25flavi
 */
public class ErrorDTO {

	/** code */
	private String code;

	/** error */
	private String errorMessage;

	public ErrorDTO(String code, String errorMessage) {
		this.code = code;
		this.errorMessage = errorMessage;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String message) {
		this.errorMessage = message;
	}

}
