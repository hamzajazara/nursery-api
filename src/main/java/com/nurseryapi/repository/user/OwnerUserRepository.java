package com.nurseryapi.repository.user;

import javax.transaction.Transactional;

import com.nurseryapi.entity.user.OwnerUserEntity;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Transactional
public interface OwnerUserRepository extends UserBaseRepository<OwnerUserEntity> {
}
