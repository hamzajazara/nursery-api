package com.nurseryapi.service.user;

import com.nurseryapi.entity.user.UserEntity;
import com.nurseryapi.model.constatnt.UserType;
import com.nurseryapi.model.request.user.UserRegistrationRequest;

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
	 * @param userType
	 * @return
	 */
	<R extends UserRegistrationRequest> T create(R userRegistrationRequest, UserType userType);

	/**
	 * 
	 * @param userRegistrationRequest
	 * @param userType
	 * @param createdUser
	 * @return
	 */
	<R extends UserRegistrationRequest> T create(R userRegistrationRequest, UserType userType, UserEntity createdUser);

	/**
	 * 
	 * @param ownerId
	 * @return
	 */
	T getUser(long userId);

	/**
	 * 
	 * @param userRegistrationRequest
	 * @param userType
	 * @param createdByUser
	 * @return
	 */
	<R extends UserRegistrationRequest> UserEntity userFactory(R userRegistrationRequest, UserType userType,
			UserEntity createdByUser);
}