package com.nurseryapi.repository;

import java.util.Optional;

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
	/**
	 * 
	 * @param email
	 * @return
	 */
	Optional<UserEntity> findByUsername(String email);

	/**
	 * 
	 * @param email
	 * @return
	 */
	Optional<UserEntity> findByEmail(String email);
}
