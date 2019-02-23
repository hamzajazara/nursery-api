package com.nurseryapi.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
