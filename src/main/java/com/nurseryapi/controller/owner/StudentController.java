package com.nurseryapi.controller.owner;

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
@Api(tags = "Owner")
public class StudentController {
}
