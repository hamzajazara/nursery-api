package com.nurseryapi.repository.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.nurseryapi.entity.user.UserEntity;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@NoRepositoryBean
public interface UserBaseRepository<T extends UserEntity> extends JpaRepository<T, Long> {
	
	/**
	 * 
	 * @param email
	 * @return
	 */
	Optional<T> findByUsername(String email);

	/**
	 * 
	 * @param email
	 * @return
	 */
	Optional<T> findByEmail(String email);
}
