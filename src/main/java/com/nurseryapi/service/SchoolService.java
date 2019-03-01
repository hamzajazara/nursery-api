package com.nurseryapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nurseryapi.entity.SchoolEntity;
import com.nurseryapi.entity.user.AdminUserEntity;
import com.nurseryapi.entity.user.OwnerUserEntity;
import com.nurseryapi.model.request.SchoolRegistrationRequest;
import com.nurseryapi.model.request.SchoolUpdateRequest;

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
	 * @param school
	 * @return
	 */
	Page<SchoolEntity> getSchool(long ownerId, Pageable pageable);

	/**
	 * 
	 * @param ownerUser
	 * @param pageable
	 * @return
	 */
	Page<SchoolEntity> getSchool(OwnerUserEntity ownerUser, Pageable pageable);

	/**
	 * 
	 * @param schoolId
	 * @return
	 */
	SchoolEntity getSchool(long schoolId);

	/**
	 * 
	 * @param ownerId
	 * @param schoolId
	 * @return
	 */
	SchoolEntity getSchool(long schoolId, long ownerId);

	/**
	 * 
	 * @param schoolId
	 * @param ownerUser
	 * @return
	 */
	SchoolEntity getSchool(long schoolId, OwnerUserEntity ownerUser);

	/**
	 * 
	 * @param schoolRegistrationRequest
	 * @param adminUser
	 * @return
	 */
	SchoolEntity register(SchoolRegistrationRequest schoolRegistrationRequest, AdminUserEntity adminUser);

	/**
	 * 
	 * @param schoolId
	 * @param schoolUpdateRequest
	 * @param adminUser
	 * @return
	 */
	SchoolEntity update(long schoolId, SchoolUpdateRequest schoolUpdateRequest, AdminUserEntity adminUser);

	/**
	 * 
	 * @param schoolId
	 * @param schoolUpdateRequest
	 * @param ownerUser
	 * @return
	 */
	SchoolEntity update(long schoolId, SchoolUpdateRequest schoolUpdateRequest, OwnerUserEntity ownerUser);

	/**
	 * 
	 * @param school
	 * @param schoolUpdateRequest
	 * @return
	 */
	SchoolEntity update(SchoolEntity school, SchoolUpdateRequest schoolUpdateRequest);
}