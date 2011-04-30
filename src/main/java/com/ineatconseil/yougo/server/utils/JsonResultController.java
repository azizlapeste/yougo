/**
 * 
 */
package com.ineatconseil.yougo.server.utils;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.ineatconseil.yougo.shared.dto.ResultDTO;

/**
 * @author aelamrani
 */
public class JsonResultController {

	private final static Log LOGGER = LogFactory.getLog(JsonResultController.class);

	private final ResourceBundleMessageSource message = new ResourceBundleMessageSource();

	/**
	 * Json default view name.
	 */
	public static final String JSON_VIEW = "json";

	@ExceptionHandler(Throwable.class)
	public ModelAndView handleException(final Throwable ex) {
		LOGGER.error("Uncaught error", ex);
		return toErrorModelAndView("unexpected.error");
	}

	/**
	 * @param ex
	 *            the exception
	 * @param messageKey
	 *            the message key
	 * @param messageArgs
	 *            the message arguments
	 * @return the ModelAndView
	 */
	@SuppressWarnings("unchecked")
	private ModelAndView toErrorModelAndView(final String messageKey, final Object... messageArgs) {
		final ResultDTO<Void> result = new ResultDTO<Void>();
		result.addError(messageKey, message.getMessage(messageKey, messageArgs, LocaleContextHolder.getLocale()));
		final Map mapModel = new HashMap();
		result.putInto(mapModel);
		return new ModelAndView(JSON_VIEW, mapModel);
	}

	/**
	 * Add all errors into result
	 * @param <T>
	 *            the result data type
	 * @param resultDTO
	 *            the result DTO
	 * @param errors
	 *            the errors
	 */
	protected <T> void addAllErrors(final ResultDTO<T> resultDTO, final Errors errors) {
		final Locale locale = LocaleContextHolder.getLocale();
		for (ObjectError objectError : errors.getAllErrors()) {
			resultDTO.addError(objectError.getCode(),
					message.getMessage(objectError.getCode(), objectError.getArguments(), locale));
		}
	}

}
