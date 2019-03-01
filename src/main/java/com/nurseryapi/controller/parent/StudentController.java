package com.nurseryapi.controller.parent;

import org.springframework.security.access.prepost.PreAuthorize;
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
@Api(tags = "Parent/Student")
@PreAuthorize("hasRole('ROLE_PARENT')")
public class StudentController {
}
