package com.nurseryapi.controller.owner;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@RestController("OwnerParentController")
@RequestMapping("/api/owner/parent")
@Api(tags = "Owner/Parent")
@PreAuthorize("hasRole('ROLE_OWNER')")
public class ParentController {
}