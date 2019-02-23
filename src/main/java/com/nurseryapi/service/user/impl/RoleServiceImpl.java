package com.nurseryapi.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nurseryapi.entity.user.RoleEntity;
import com.nurseryapi.repository.RoleRepository;
import com.nurseryapi.service.user.RoleService;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	/*
	 * @see com.nurseryapi.service.user.RoleService#getRole(long)
	 */
	@Override
	public RoleEntity getRole(long roleId) {
		return roleRepository.findById(roleId).get();
	}
}