package com.nurseryapi.controller.owner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nurseryapi.entity.user.OwnerUserEntity;
import com.nurseryapi.entity.user.TeacherUserEntity;
import com.nurseryapi.model.response.user.TeacherUserResponse;
import com.nurseryapi.service.user.TeacherService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@RestController("OwnerTeacherController")
@RequestMapping("/api/owner/teacher")
@Api(tags = "Owner/Teacher")
@PreAuthorize("hasRole('ROLE_OWNER')")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;

	/**
	 * 
	 * @param schoolId
	 * @param pageable
	 * @param ownerUser
	 * @return
	 */
	@PostMapping("/school/{schoolId}")
	@ApiOperation(value = "Allow to the owner to view school teachers")
	public PageImpl<TeacherUserResponse> registerTeacher(long schoolId, Pageable pageable,
			@AuthenticationPrincipal OwnerUserEntity ownerUser) {
		Page<TeacherUserEntity> teachers = teacherService.getTeacherUser(schoolId, ownerUser, pageable);
		List<TeacherUserResponse> teacherResponses = new ArrayList<>();
		teachers.forEach(teacher -> teacherResponses.add(new TeacherUserResponse(teacher)));
		return new PageImpl<>(teacherResponses, pageable, teachers.getTotalElements());
	}

	/**
	 * 
	 * @param schoolId
	 * @param pageable
	 * @param ownerUser
	 * @return
	 */
	@GetMapping("/school/{schoolId}")
	@ApiOperation(value = "Allow to the owner to view school teachers")
	public PageImpl<TeacherUserResponse> viewSchoolTeachers(long schoolId, Pageable pageable,
			@AuthenticationPrincipal OwnerUserEntity ownerUser) {
		Page<TeacherUserEntity> teachers = teacherService.getTeacherUser(schoolId, ownerUser, pageable);
		List<TeacherUserResponse> teacherResponses = new ArrayList<>();
		teachers.forEach(teacher -> teacherResponses.add(new TeacherUserResponse(teacher)));
		return new PageImpl<>(teacherResponses, pageable, teachers.getTotalElements());
	}

	/**
	 * 
	 * @param schoolId
	 * @param teacherId
	 * @param ownerUser
	 * @return
	 */
	@GetMapping("{teacherId}/school/{schoolId}")
	@ApiOperation(value = "Allow to the owner to view specific school teacher")
	public ResponseEntity<TeacherUserResponse> viewSchoolTeacher(@PathVariable("schoolId") long schoolId,
			@PathVariable("teacherId") long teacherId, @AuthenticationPrincipal OwnerUserEntity ownerUser) {
		return new ResponseEntity<>(
				new TeacherUserResponse(teacherService.getTeacherUser(schoolId, teacherId, ownerUser)), HttpStatus.OK);
	}
}