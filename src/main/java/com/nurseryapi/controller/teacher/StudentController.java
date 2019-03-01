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
@RestController("TeacherStudentController")
@RequestMapping("/api/teacher/student")
@Api(tags = "Teacher/Student")
@PreAuthorize("hasRole('ROLE_TEACHER')")
public class StudentController {
}