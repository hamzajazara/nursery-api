package com.nurseryapi.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nurseryapi.entity.SchoolEntity;
import com.nurseryapi.entity.user.AdminUserEntity;
import com.nurseryapi.model.request.SchoolRegistrationRequest;
import com.nurseryapi.model.response.SchoolResponse;
import com.nurseryapi.service.SchoolService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@RestController("AdminSchoolController")
@RequestMapping("/api/admin/school")
@Api(tags = "Admin/School")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class SchoolController {

	@Autowired
	private SchoolService schoolService;

	/**
	 * 
	 * @param userRegistrationRequest
	 * @return
	 */
	@PostMapping("/register")
	@ApiOperation(value = "Allow to the admin to register owner school")
	public ResponseEntity<SchoolResponse> register(
			@Valid @RequestBody SchoolRegistrationRequest schoolRegistrationRequest,
			@AuthenticationPrincipal AdminUserEntity adminUser) {
		return new ResponseEntity<>(new SchoolResponse(schoolService.register(schoolRegistrationRequest, adminUser)),
				HttpStatus.CREATED);
	}

	/**
	 * 
	 * @param ownerId
	 * @param pageable
	 * @param adminUser
	 * @return
	 */
	@GetMapping("owner/{ownerId}")
	@ApiOperation(value = "Allow to the admin to view owner schools")
	public PageImpl<SchoolResponse> viewSchool(@PathVariable("ownerId") long ownerId, Pageable pageable,
			@AuthenticationPrincipal AdminUserEntity adminUser) {
		Page<SchoolEntity> schools = schoolService.getSchool(ownerId, pageable);
		List<SchoolResponse> schoolResponses = new ArrayList<>();
		schools.forEach(school -> schoolResponses.add(new SchoolResponse(school)));
		return new PageImpl<>(schoolResponses, pageable, schools.getTotalElements());
	}

	/**
	 * 
	 * @param ownerId
	 * @param pageable
	 * @param adminUser
	 * @return
	 */
	@GetMapping("owner/{ownerId}/{schoolId}")
	@ApiOperation(value = "Allow to the admin to view owner school")
	public ResponseEntity<SchoolResponse> viewOwnerSchool(@PathVariable("schoolId") long schoolId,
			@PathVariable("ownerId") long ownerId, @AuthenticationPrincipal AdminUserEntity adminUser) {
		return new ResponseEntity<>(new SchoolResponse(schoolService.getSchool(schoolId, ownerId)), HttpStatus.OK);
	}
}
