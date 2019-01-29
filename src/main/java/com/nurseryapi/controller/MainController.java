package com.nurseryapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@RestController
@RequestMapping("/")
@Api(tags = "Main")
public class MainController {

	@GetMapping("api/auth")
	@ApiOperation(value = "Hello", notes = "Test")
	public String auth() {
		return "Hello World";
	}

	@GetMapping("hello")
	@ApiOperation(value = "Hello", notes = "Test")
	public String hello() {
		return "Hello World";
	}
}
