package com.nurseryapi.service.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nurseryapi.entity.user.OwnerUserEntity;
import com.nurseryapi.entity.user.TeacherUserEntity;

public interface TeacherService {

	/**
	 * 
	 * @param teacherId
	 * @param schoolId
	 * @param ownerUser
	 * @return
	 */
	TeacherUserEntity getTeacherUser(long teacherId, long schoolId, OwnerUserEntity ownerUser);

	/**
	 * 
	 * @param schoolId
	 * @param ownerUser
	 * @param pageable
	 * @return
	 */
	Page<TeacherUserEntity> getTeacherUser(long schoolId, OwnerUserEntity ownerUser, Pageable pageable);
}
