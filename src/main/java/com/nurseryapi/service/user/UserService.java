package com.nurseryapi.service.user;

import com.nurseryapi.entity.user.AdminUserEntity;
import com.nurseryapi.entity.user.UserEntity;
import com.nurseryapi.model.request.UserRegistrationRequest;

/**
 * 
 * @author Hamza Aljazara
 *
 */
public interface UserService<T extends UserEntity> {

	/**
	 * 
	 * @param userEntity
	 * @return
	 */
	T save(T userEntity);

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
	T create(UserRegistrationRequest userRegistrationRequest);

	/**
	 * 
	 * @param userRegistrationRequest
	 * @param adminUser
	 * @return
	 */
	T create(UserRegistrationRequest userRegistrationRequest, AdminUserEntity adminUser);

	/**
	 * 
	 * @param ownerId
	 * @return
	 */
	T getUser(long userId);

	/**
	 * 
	 * @param userRegistrationRequest
	 * @param adminUser
	 * @return
	 */
	T userFactory(UserRegistrationRequest userRegistrationRequest, AdminUserEntity adminUser);
}