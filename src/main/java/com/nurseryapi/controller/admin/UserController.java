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
import com.nurseryapi.entity.user.UserEntity;
import com.nurseryapi.model.constatnt.UserType;
import com.nurseryapi.model.request.user.UserRegistrationRequest;
import com.nurseryapi.model.response.user.UserInfoResponse;
import com.nurseryapi.service.user.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@RestController("AdminUserController")
@RequestMapping("/api/admin/user")
@Api(tags = "Admin/User")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class UserController {

	@Autowired
	private UserService<UserEntity> userService;

	/**
	 * 
	 * @param userRegistrationRequest
	 * @return
	 */
	@PostMapping("/register")
	@ApiOperation(value = "Allow to the admin to register owner user")
	public ResponseEntity<UserInfoResponse> registerOwner(
			@Valid @RequestBody UserRegistrationRequest userRegistrationRequest,
			@AuthenticationPrincipal AdminUserEntity adminUser) {
		return new ResponseEntity<>(
				new UserInfoResponse(userService.create(userRegistrationRequest, UserType.OWNER, adminUser)),
				HttpStatus.CREATED);
	}
}
