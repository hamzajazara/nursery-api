package com.nurseryapi.controller.teacher;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@RestController("TeacherParentController")
@RequestMapping("/api/teacher")
@Api(tags = "Teacher")
public class ParentController {
}