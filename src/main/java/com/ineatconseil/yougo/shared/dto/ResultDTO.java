package com.ineatconseil.yougo.shared.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResultDTO<T> {

	/**
	 * The errors attribute.
	 */
	public static final String ERRORS_ATT = "errors";
	/**
	 * The success attribute.
	 */
	public static final String SUCCESS_ATT = "success";
	/**
	 * The data attribute.
	 */
	public static final String DATA_ATT = "data";

	/**
	 * Get data.
	 * @param <T>
	 *            expected data type
	 * @return data
	 */
	private T data = null;

	/**
	 * Get success.
	 * @return true if success
	 */
	private Boolean success = null;

	/**
	 * Get errors.
	 * @return the errors
	 */
	private List<ErrorDTO> errors = new ArrayList<ErrorDTO>();

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		if (success == null) {
			return getErrors().isEmpty();
		}
		return success;
	}

	/**
	 * @param success
	 *            the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * @return the errors
	 */
	public List<ErrorDTO> getErrors() {
		return errors;
	}

	/**
	 * @param errors
	 *            the errors to set
	 */
	public void setErrors(List<ErrorDTO> errors) {
		this.errors = errors;
	}

	/**
	 * Add an error.
	 * @param code
	 *            the code error
	 * @param errorMessage
	 *            the error message
	 * @see java.util.List#add(java.lang.Object)
	 */
	public void addError(String code, String errorMessage) {
		ErrorDTO error = new ErrorDTO(code, errorMessage);
		errors.add(error);
	}

	/**
	 * Set dto atributes into map.
	 * @param mapModel
	 *            the mapModel
	 */
	@SuppressWarnings("unchecked")
	public void putInto(@SuppressWarnings("rawtypes") Map mapModel) {
		mapModel.put(DATA_ATT, getData());
		mapModel.put(SUCCESS_ATT, isSuccess());
		mapModel.put(ERRORS_ATT, getErrors());
	}

}
