package com.nurseryapi.controller.owner;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nurseryapi.entity.SchoolEntity;
import com.nurseryapi.entity.user.OwnerUserEntity;
import com.nurseryapi.model.request.SchoolUpdateRequest;
import com.nurseryapi.model.response.SchoolResponse;
import com.nurseryapi.service.SchoolService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@RestController("OwnerSchoolController")
@RequestMapping("/api/owner/school")
@Api(tags = "Owner/School")
@PreAuthorize("hasRole('ROLE_OWNER')")
public class SchoolController {

	@Autowired
	private SchoolService schoolService;

	/**
	 * 
	 * @param ownerId
	 * @param pageable
	 * @param ownerUser
	 * @return
	 */
	@GetMapping("/")
	@ApiOperation(value = "Allow to the owner to view his schools")
	public PageImpl<SchoolResponse> viewSchool(Pageable pageable, @AuthenticationPrincipal OwnerUserEntity ownerUser) {
		Page<SchoolEntity> schools = schoolService.getSchool(ownerUser, pageable);
		List<SchoolResponse> schoolResponses = new ArrayList<>();
		schools.forEach(school -> schoolResponses.add(new SchoolResponse(school)));
		return new PageImpl<>(schoolResponses, pageable, schools.getTotalElements());
	}

	/**
	 * 
	 * @param schoolId
	 * @param ownerId
	 * @param ownerUser
	 * @return
	 */
	@GetMapping("/{schoolId}")
	@ApiOperation(value = "Allow to the owner to view specific school")
	public ResponseEntity<SchoolResponse> viewOwnerSchool(@PathVariable("schoolId") long schoolId,
			@AuthenticationPrincipal OwnerUserEntity ownerUser) {
		return new ResponseEntity<>(new SchoolResponse(schoolService.getSchool(schoolId, ownerUser)), HttpStatus.OK);
	}

	/**
	 * 
	 * @param schoolId
	 * @param schoolUpdateRequest
	 * @return
	 */
	@PutMapping("/{schoolId}/update")
	@ApiOperation(value = "Allow to the owner to update school info")
	public ResponseEntity<SchoolResponse> updateSchool(@PathVariable("schoolId") long schoolId,
			@Valid @RequestBody SchoolUpdateRequest schoolUpdateRequest,
			@AuthenticationPrincipal OwnerUserEntity ownerUser) {
		return new ResponseEntity<>(new SchoolResponse(schoolService.update(schoolId, schoolUpdateRequest, ownerUser)),
				HttpStatus.CREATED);
	}
}
