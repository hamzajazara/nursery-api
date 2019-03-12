package com.nurseryapi.controller.lookup;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nurseryapi.entity.lookup.MajorEntity;
import com.nurseryapi.model.response.lookup.MajorResponse;
import com.nurseryapi.service.lookup.MajorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@RestController("MajorLookUpController")
@RequestMapping("/api/lookup/major")
@Api(tags = "Lookup")
public class MajorLookupController {

	@Autowired
	private MajorService majorService;

	/**
	 * 
	 * @param pageable
	 * @return
	 */
	@GetMapping
	@ApiOperation(value = "Allow the user to view all majors")
	public PageImpl<MajorResponse> viewMajors(Pageable pageable) {
		Page<MajorEntity> majors = majorService.getMajor(pageable);
		List<MajorResponse> majorResponses = new ArrayList<>();
		majors.forEach(major -> majorResponses.add(new MajorResponse(major)));
		return new PageImpl<>(majorResponses, pageable, majors.getTotalElements());
	}

	/**
	 * 
	 * @param majorId
	 * @return
	 */
	@GetMapping("/{majorId}")
	@ApiOperation(value = "Allow the user to view a specific major")
	public ResponseEntity<MajorResponse> viewMajor(@PathVariable("majorId") long majorId) {
		return new ResponseEntity<>(new MajorResponse(majorService.getMajor(majorId)), HttpStatus.OK);
	}
}
