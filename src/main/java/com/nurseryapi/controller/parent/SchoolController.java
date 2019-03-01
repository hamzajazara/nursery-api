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
@RestController("ParentSchoolController")
@RequestMapping("/api/parent/school")
@Api(tags = "Parent/School")
@PreAuthorize("hasRole('ROLE_PARENT')")
public class SchoolController {
}