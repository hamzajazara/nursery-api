package com.nurseryapi.service;

import com.nurseryapi.entity.SchoolEntity;
import com.nurseryapi.entity.user.AdminUserEntity;
import com.nurseryapi.model.request.SchoolRegistrationRequest;

/**
 * 
 * @author Hamza Aljazara
 *
 */
public interface SchoolService {

	/**
	 * 
	 * @param school
	 * @return
	 */
	SchoolEntity save(SchoolEntity school);

	/**
	 * 
	 * @param schoolRegistrationRequest
	 * @param adminUser
	 * @return
	 */
	SchoolEntity create(SchoolRegistrationRequest schoolRegistrationRequest, AdminUserEntity adminUser);

}