package com.nurseryapi.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nurseryapi.entity.SchoolEntity;
import com.nurseryapi.entity.user.OwnerUserEntity;
import com.nurseryapi.entity.user.TeacherUserEntity;
import com.nurseryapi.exception.NoSuchElementFoundException;
import com.nurseryapi.repository.user.TeacherUserRepository;
import com.nurseryapi.service.SchoolService;
import com.nurseryapi.service.user.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherUserRepository teacherUserRepository;

	@Autowired
	private SchoolService schoolService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nurseryapi.service.user.TeacherService#getTeacherUser(long,
	 * com.nurseryapi.entity.user.OwnerUserEntity)
	 */
	@Override
	public TeacherUserEntity getTeacherUser(long teacherId, long schoolId, OwnerUserEntity ownerUser) {
		SchoolEntity school = schoolService.getSchool(schoolId);
		return teacherUserRepository.findByIdAndSchool(teacherId, school).orElseThrow(NoSuchElementFoundException::new);
	}

	/*
	 * @see com.nurseryapi.service.user.TeacherService#getTeacherUser(long,
	 * org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<TeacherUserEntity> getTeacherUser(long schoolId, OwnerUserEntity ownerUser, Pageable pageable) {
		SchoolEntity school = schoolService.getSchool(schoolId);
		return teacherUserRepository.findAllBySchool(school, pageable);
	}

	/* (non-Javadoc)
	 * @see com.nurseryapi.service.user.TeacherService#registerTeacherUser(long, com.nurseryapi.entity.user.OwnerUserEntity)
	 */
	@Override
	public TeacherUserEntity registerTeacherUser(long schoolId, OwnerUserEntity ownerUser) {
		return null;
	}
}