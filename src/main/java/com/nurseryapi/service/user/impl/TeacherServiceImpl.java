package com.nurseryapi.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.nurseryapi.entity.EducationEntity;
import com.nurseryapi.entity.SchoolEntity;
import com.nurseryapi.entity.user.OwnerUserEntity;
import com.nurseryapi.entity.user.TeacherUserEntity;
import com.nurseryapi.exception.NoSuchElementFoundException;
import com.nurseryapi.model.constatnt.UserType;
import com.nurseryapi.model.request.user.TeacherUserRegistrationRequest;
import com.nurseryapi.repository.user.TeacherUserRepository;
import com.nurseryapi.service.SchoolService;
import com.nurseryapi.service.TopicService;
import com.nurseryapi.service.lookup.DegreeService;
import com.nurseryapi.service.lookup.GradeService;
import com.nurseryapi.service.user.TeacherService;
import com.nurseryapi.service.user.UserService;
import com.nurseryapi.utils.Mapper;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherUserRepository teacherUserRepository;

	@Autowired
	private SchoolService schoolService;

	@Autowired
	private GradeService gradeService;

	@Autowired
	private DegreeService degreeService;

	@Autowired
	private TopicService topicService;

	@Autowired
	private UserService<TeacherUserEntity> userService;

	/*
	 * @see
	 * com.nurseryapi.service.user.TeacherService#save(com.nurseryapi.entity.user.
	 * TeacherUserEntity)
	 */
	@Override
	public TeacherUserEntity save(TeacherUserEntity teacherUser) {
		return teacherUserRepository.save(teacherUser);
	}

	/*
	 * @see
	 * com.nurseryapi.service.user.TeacherService#createTeacher(com.nurseryapi.model
	 * .request.user.TeacherUserRegistrationRequest,
	 * com.nurseryapi.entity.user.OwnerUserEntity)
	 */
	@Override
	public TeacherUserEntity createTeacher(TeacherUserRegistrationRequest teacherUserRegistrationRequest,
			OwnerUserEntity ownerUser) {

		// Create teacher from users factory
		TeacherUserEntity teacherUser = userService.create(teacherUserRegistrationRequest, UserType.TEACHER, ownerUser);

		// Get and set teacher school
		teacherUser.setSchool(schoolService.getSchool(teacherUserRegistrationRequest.getSchoolId()));

		// Set education
		EducationEntity education = Mapper.map(teacherUserRegistrationRequest.getEducation(), EducationEntity.class);
		education.setGrade(gradeService.getGrade(teacherUserRegistrationRequest.getDegreeId()));
		education.setDegree(degreeService.getDegree(teacherUserRegistrationRequest.getDegreeId()));

		// Set teacher education
		teacherUser.setEducation(education);

		// Set teacher topics
		List<Long> topicIds = teacherUserRegistrationRequest.getTopicIds();
		if (!CollectionUtils.isEmpty(topicIds)) {
			teacherUser.setTopics(topicService.getTopic(topicIds));
		}
		return save(teacherUser);
	}

	/*
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
}