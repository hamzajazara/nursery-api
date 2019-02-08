package com.nurseryapi.service;

import com.nurseryapi.entity.UserEntity;
import com.nurseryapi.model.request.UserRegistrationRequest;

/**
 * 
 * @author Hamza Aljazara
 *
 */
public interface UserService {

	/**
	 * 
	 * @param userEntity
	 * @return
	 */
	UserEntity save(UserEntity userEntity);

	/**
	 * 
	 * @param userRegistrationRequest
	 * @return
	 */
	UserEntity create(UserRegistrationRequest userRegistrationRequest);
}