package com.nurseryapi.controller.owner;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@RestController("OwnerParentController")
@RequestMapping("/api/owner")
@Api(tags = "Owner/Parent")
public class ParentController {
}