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

import com.nurseryapi.entity.lookup.GradeEntity;
import com.nurseryapi.model.response.lookup.GradeResponse;
import com.nurseryapi.service.lookup.GradeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@RestController("GradeLookUpController")
@RequestMapping("/api/lookup/grade")
@Api(tags = "Lookup")
public class GradeLookupController {

	@Autowired
	private GradeService gradeService;

	/**
	 * 
	 * @param pageable
	 * @return
	 */
	@GetMapping
	@ApiOperation(value = "Allow the user to view all grades")
	public PageImpl<GradeResponse> viewGrades(Pageable pageable) {
		Page<GradeEntity> grades = gradeService.getGrade(pageable);
		List<GradeResponse> gradeResponses = new ArrayList<>();
		grades.forEach(grade -> gradeResponses.add(new GradeResponse(grade)));
		return new PageImpl<>(gradeResponses, pageable, grades.getTotalElements());
	}

	/**
	 * 
	 * @param gradeId
	 * @return
	 */
	@GetMapping("/{gradeId}")
	@ApiOperation(value = "Allow the user to view a specific grade")
	public ResponseEntity<GradeResponse> viewGrade(@PathVariable("gradeId") long gradeId) {
		return new ResponseEntity<>(new GradeResponse(gradeService.getGrade(gradeId)), HttpStatus.OK);
	}
}
