package com.nurseryapi.controller.parent;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@RestController("ParentSchoolController")
@RequestMapping("/api/parent")
@Api(tags = "Parent/School")
public class SchoolController {
}