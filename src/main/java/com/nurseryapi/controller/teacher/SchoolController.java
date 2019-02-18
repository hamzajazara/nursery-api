package com.nurseryapi.controller.teacher;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@RestController("TeacherSchoolController")
@RequestMapping("/api/teacher/school")
@Api(tags = "Teacher")
public class SchoolController {

	@GetMapping("/who-am-i/jkkj")
	@ApiOperation(value = "Who Am I")
	public ResponseEntity<?> whoAmI() {
		return new ResponseEntity<>("Hello World!", HttpStatus.CREATED);
	}
}