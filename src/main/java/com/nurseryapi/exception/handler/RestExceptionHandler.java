/*******************************************************************************
 * Copyright ©2017 Winfooz. All rights reserved
 * —————————————————————————————————
 * NOTICE: All information contained herein is a property of Winfooz.
 ******************************************************************************/
package com.nurseryapi.exception.handler;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nurseryapi.exception.AbstractException;
import com.nurseryapi.exception.NoSuchElementFoundException;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@RestControllerAdvice
public class RestExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);

	/**
	 * Handle general exception
	 *
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<ApiError> handleGeneralException(Exception exception) {
		log.error(exception.getMessage(), exception);
		return new ResponseEntity<>(new ApiError(exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 *
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(AccessDeniedException.class)
	protected ResponseEntity<ApiError> handleAccessDeniedException(Exception exception) {
		log.error(exception.getMessage(), exception);
		return new ResponseEntity<>(new ApiError(exception.getMessage()), HttpStatus.UNAUTHORIZED);
	}

	/**
	 * Handle general exception
	 *
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(AbstractException.class)
	protected ResponseEntity<ApiError> handleGeneralManagedException(AbstractException exception) {
		log.error(exception.getMessage(), exception);
		return new ResponseEntity<>(new ApiError(exception.getMessage()), HttpStatus.BAD_REQUEST);
	}

	/**
	 * Handle jpa not found element exception
	 *
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(NoSuchElementException.class)
	protected ResponseEntity<ApiError> handleNoSuchElementException(Exception exception) {
		log.error(exception.getMessage(), exception);
		NoSuchElementFoundException ex = new NoSuchElementFoundException();
		return new ResponseEntity<>(new ApiError(exception.getMessage()), HttpStatus.BAD_REQUEST);
	}

	/**
	 * Handle entity validation
	 *
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<ApiError> invalidInput(ConstraintViolationException exception) {

		Map<String, String> errors = new HashMap<>();
		for (ConstraintViolation<?> error : exception.getConstraintViolations()) {
			errors.put(error.getPropertyPath().toString(), error.getMessage());
		}
		return new ResponseEntity<>(new ApiError(errors), HttpStatus.BAD_REQUEST);
	}

	/**
	 * Handle model request validation
	 *
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiError> processValidationError(MethodArgumentNotValidException exception) {

		Map<String, String> errors = new HashMap<>();
		for (FieldError error : exception.getBindingResult().getFieldErrors()) {
			errors.put(error.getField(), error.getDefaultMessage());
		}

		return new ResponseEntity<>(new ApiError(errors), HttpStatus.BAD_REQUEST);
	}
}