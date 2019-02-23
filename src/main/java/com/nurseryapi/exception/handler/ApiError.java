/*******************************************************************************
 * Copyright ©2017 Winfooz. All rights reserved
 * —————————————————————————————————
 * NOTICE: All information contained herein is a property of Winfooz.
 ******************************************************************************/
package com.nurseryapi.exception.handler;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Getter
public class ApiError {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;

	private Object reason;

	/**
	 *
	 * @param code
	 * @param reason
	 */
	public ApiError(String code, Object reason) {
		this.reason = reason;
		timestamp = LocalDateTime.now();
	}

	/**
	 *
	 * @param reason
	 */
	public ApiError(Object reason) {
		this.reason = reason;
		timestamp = LocalDateTime.now();
	}

}
