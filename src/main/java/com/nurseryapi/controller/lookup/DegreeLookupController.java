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

import com.nurseryapi.entity.lookup.DegreeEntity;
import com.nurseryapi.model.response.lookup.DegreeResponse;
import com.nurseryapi.service.lookup.DegreeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@RestController("DegreeLookUpController")
@RequestMapping("/api/lookup/degree")
@Api(tags = "Lookup")
public class DegreeLookupController {

	@Autowired
	private DegreeService degreeService;

	/**
	 * 
	 * @param pageable
	 * @return
	 */
	@GetMapping
	@ApiOperation(value = "Allow the user to view all degrees")
	public PageImpl<DegreeResponse> viewDegrees(Pageable pageable) {
		Page<DegreeEntity> degrees = degreeService.getDegree(pageable);
		List<DegreeResponse> degreeResponses = new ArrayList<>();
		degrees.forEach(degree -> degreeResponses.add(new DegreeResponse(degree)));
		return new PageImpl<>(degreeResponses, pageable, degrees.getTotalElements());
	}

	/**
	 * 
	 * @param degreeId
	 * @return
	 */
	@GetMapping("/{degreeId}")
	@ApiOperation(value = "Allow the user to view a specific degree")
	public ResponseEntity<DegreeResponse> viewDegree(@PathVariable("degreeId") long degreeId) {
		return new ResponseEntity<>(new DegreeResponse(degreeService.getDegree(degreeId)), HttpStatus.OK);
	}
}
