package com.nurseryapi.controller.parent;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@RestController("ParentStudentController")
@RequestMapping("/api/parent/student")
@Api(tags = "Parent")
public class StudentController {
}
