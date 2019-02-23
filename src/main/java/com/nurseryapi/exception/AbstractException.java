/*******************************************************************************
 * Copyright ©2017 Winfooz. All rights reserved
 * —————————————————————————————————
 * NOTICE: All information contained herein is a property of Winfooz.
 ******************************************************************************/
package com.nurseryapi.exception;

import java.util.ResourceBundle;

/**
 * 
 * @author Hamza Aljazara
 *
 */
public class AbstractException extends RuntimeException {

	private static final long serialVersionUID = 5096296279658028580L;
	private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("exception");
	private static final String PREFIX = "exception.";
	private static final String MESSAGE_SUFFIX = ".message";
	private static final String CODE_SUFFIX = ".code";

	private String message;
	private String code;

	public AbstractException() {
		message = BUNDLE.getString(PREFIX + getClass().getSimpleName() + MESSAGE_SUFFIX);
		code = BUNDLE.getString(PREFIX + getClass().getSimpleName() + CODE_SUFFIX);
	}

	/*
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return message;
	}

	/**
	 * 
	 * @return
	 */
	public String getCode() {
		return code;
	}

}
