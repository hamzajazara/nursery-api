package com.nurseryapi.controller.lookup;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nurseryapi.model.lookup.response.GradeResponse;
import com.nurseryapi.model.request.UserRegistrationRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@RestController("GradeLookUpController")
@RequestMapping("/api/lookup")
@Api(tags = "Lookup")
public class GradeLookupController {

	/**
	 * 
	 * @param userRegistrationRequest
	 * @return
	 */
	@GetMapping("/user/register")
	@ApiOperation(value = "User Registration")
	public ResponseEntity<GradeResponse> register(@Valid @RequestBody UserRegistrationRequest userRegistrationRequest) {
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
