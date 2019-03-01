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
@RestController("ParentTeacherController")
@RequestMapping("/api/parent/teacher")
@Api(tags = "Parent/Teacher")
@PreAuthorize("hasRole('ROLE_PARENT')")
public class TeacherController {
}