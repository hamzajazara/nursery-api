package com.nurseryapi.service.user;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nurseryapi.entity.user.OwnerUserEntity;
import com.nurseryapi.entity.user.TeacherUserEntity;
import com.nurseryapi.model.request.user.TeacherUserRegistrationRequest;

public interface TeacherService {

	/**
	 * @param teacherUser
	 * @return
	 */
	TeacherUserEntity save(TeacherUserEntity teacherUser);

	/**
	 * @param teacherUserRegistrationRequest
	 * @param ownerUser
	 * @return
	 */
	TeacherUserEntity createTeacher(TeacherUserRegistrationRequest teacherUserRegistrationRequest,
			OwnerUserEntity ownerUser);

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
