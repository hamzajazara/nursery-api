package com.nurseryapi.service.user;

import java.util.Optional;

import com.nurseryapi.entity.user.OwnerUserEntity;

/**
 * 
 * @author Hamza Aljazara
 *
 */
public interface OwnerUserService {

	/**
	 * 
	 * @param ownerId
	 * @return
	 */
	Optional<OwnerUserEntity> getOwnerUser(long ownerUserId);
}