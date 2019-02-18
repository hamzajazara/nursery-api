package com.nurseryapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nurseryapi.entity.user.UserEntity;
import com.nurseryapi.model.request.UserRegistrationRequest;
import com.nurseryapi.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@RestController
@RequestMapping("/api/users")
@Api(tags = "User")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 
	 * @param userRegistrationRequest
	 * @return
	 */
	@PostMapping("/register")
	@ApiOperation(value = "User Registration")
	public ResponseEntity<?> register(@Valid @RequestBody UserRegistrationRequest userRegistrationRequest) {
		userService.create(userRegistrationRequest);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	/**
	 * 
	 * @param user
	 * @return
	 */
	@GetMapping("/who-am-i")
	@ApiOperation(value = "Who Am I")
	public ResponseEntity<?> whoAmI(@AuthenticationPrincipal UserEntity user) {
		return new ResponseEntity<>(user.getFirstName(), HttpStatus.CREATED);
	}
}
