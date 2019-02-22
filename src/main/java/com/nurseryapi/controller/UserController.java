package com.nurseryapi.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nurseryapi.entity.user.UserEntity;
import com.nurseryapi.model.request.UserRegistrationRequest;
import com.nurseryapi.model.response.user.UserInfoResponse;
import com.nurseryapi.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@RestController
@RequestMapping("/")
@Api(tags = "User")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private ConsumerTokenServices consumerTokenServices;

	/**
	 *
	 * @param principal
	 * @return
	 * @throws IOException
	 */
	@ApiOperation(value = "Logout")
	@DeleteMapping("logout")
	public ResponseEntity<HttpStatus> logout() throws IOException {
		OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) SecurityContextHolder.getContext()
				.getAuthentication().getDetails();
		consumerTokenServices.revokeToken(details.getTokenValue());
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * 
	 * @param userRegistrationRequest
	 * @return
	 */
	@PostMapping("register")
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
	@GetMapping("/api/who-am-i")
	@ApiOperation(value = "Who Am I")
	public ResponseEntity<UserInfoResponse> whoAmI(@AuthenticationPrincipal UserEntity user) {
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}

		return new ResponseEntity<>(new UserInfoResponse(user), HttpStatus.CREATED);
	}
}
