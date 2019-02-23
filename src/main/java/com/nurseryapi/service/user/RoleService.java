package com.nurseryapi.service.user;

import com.nurseryapi.entity.user.RoleEntity;

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