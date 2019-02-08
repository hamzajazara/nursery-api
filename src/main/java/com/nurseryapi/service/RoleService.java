package com.nurseryapi.service;

import com.nurseryapi.entity.RoleEntity;

/**
 * 
 * @author Hamza Aljazara
 *
 */
public interface RoleService {

	/**
	 * 
	 * @param roleId
	 * @return
	 */
	RoleEntity getRole(long roleId);
}