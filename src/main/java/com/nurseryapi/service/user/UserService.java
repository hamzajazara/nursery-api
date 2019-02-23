package com.nurseryapi.service.user;

import com.nurseryapi.entity.user.AdminUserEntity;
import com.nurseryapi.entity.user.UserEntity;
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
	 * @param email
	 * @return
	 */
	boolean isUserExist(String email);

	/**
	 * 
	 * @param userRegistrationRequest
	 * @return
	 */
	UserEntity create(UserRegistrationRequest userRegistrationRequest);

	/**
	 * 
	 * @param userRegistrationRequest
	 * @param adminUser
	 * @return
	 */
	UserEntity create(UserRegistrationRequest userRegistrationRequest, AdminUserEntity adminUser);

	/**
	 * 
	 * @param userRegistrationRequest
	 * @param adminUser
	 * @return
	 */
	UserEntity userFactory(UserRegistrationRequest userRegistrationRequest, AdminUserEntity adminUser);
}