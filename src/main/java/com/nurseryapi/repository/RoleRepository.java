package com.nurseryapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nurseryapi.entity.RoleEntity;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}
