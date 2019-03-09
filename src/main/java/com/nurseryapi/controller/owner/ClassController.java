package com.nurseryapi.controller.owner;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nurseryapi.entity.user.OwnerUserEntity;
import com.nurseryapi.model.request.ClassCreationRequest;
import com.nurseryapi.model.response.SchoolResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@RestController("OwnerClassController")
@RequestMapping("/api/owner/class")
@Api(tags = "Owner/Class")
@PreAuthorize("hasRole('ROLE_OWNER')")
public class ClassController {
	/**
	 * 
	 * @param userRegistrationRequest
	 * @return
	 */
	@PostMapping("/")
	@ApiOperation(value = "Allow to the owner to register class")
	public ResponseEntity<SchoolResponse> register(@Valid @RequestBody ClassCreationRequest classCreationRequest,
			@AuthenticationPrincipal OwnerUserEntity adminUser) {

		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}