package com.nurseryapi.controller.owner;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RestController("OwnerParentController")
@RequestMapping("/api/owner/parent")
@Api(tags = "Owner")
public class ParentController {

	@GetMapping("/who-am-i")
	@ApiOperation(value = "Who Am I")
	public ResponseEntity<?> whoAmI() {
		return new ResponseEntity<>("Hello World!", HttpStatus.CREATED);
	}
}