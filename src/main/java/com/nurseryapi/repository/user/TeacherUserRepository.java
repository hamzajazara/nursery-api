package com.nurseryapi.repository.user;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nurseryapi.entity.SchoolEntity;
import com.nurseryapi.entity.user.TeacherUserEntity;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Transactional
public interface TeacherUserRepository extends UserBaseRepository<TeacherUserEntity> {

	/**
	 * 
	 * @param teacherId
	 * @param school
	 * @return
	 */
	Optional<TeacherUserEntity> findByIdAndSchool(long teacherId, SchoolEntity school);

	/**
	 * 
	 * @param school
	 * @param pageable
	 * @return
	 */
	Page<TeacherUserEntity> findAllBySchool(SchoolEntity school, Pageable pageable);
}
