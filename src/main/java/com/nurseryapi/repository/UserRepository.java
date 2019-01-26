package com.nurseryapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nurseryapi.entity.UserEntity;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
