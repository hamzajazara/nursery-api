package com.nurseryapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nurseryapi.entity.RoleEntity;
import com.nurseryapi.repository.RoleRepository;
import com.nurseryapi.service.RoleService;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public RoleEntity getRole(long roleId) {
		return roleRepository.findById(roleId).get();
	}
}