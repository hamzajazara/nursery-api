package com.nurseryapi.repository.user;

import javax.transaction.Transactional;

import com.nurseryapi.entity.user.UserEntity;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Transactional
public interface UserRepository extends UserBaseRepository<UserEntity> {
}
