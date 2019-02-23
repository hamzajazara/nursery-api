package com.nurseryapi.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nurseryapi.entity.user.OwnerUserEntity;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Repository
public interface OwnerUserRepository extends JpaRepository<OwnerUserEntity, Long> {
}
