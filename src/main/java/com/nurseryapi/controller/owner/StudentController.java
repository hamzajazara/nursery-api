package com.nurseryapi.controller.owner;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@RestController("OwnerStudentController")
@RequestMapping("/api/owner/student")
@Api(tags = "Owner/Student")
@PreAuthorize("hasRole('ROLE_OWNER')")
public class StudentController {
}
