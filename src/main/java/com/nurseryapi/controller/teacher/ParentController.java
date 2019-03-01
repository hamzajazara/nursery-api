package com.nurseryapi.controller.teacher;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@RestController("TeacherParentController")
@RequestMapping("/api/teacher/parent")
@Api(tags = "Teacher/Parent")
@PreAuthorize("hasRole('ROLE_TEACHER')")
public class ParentController {
}