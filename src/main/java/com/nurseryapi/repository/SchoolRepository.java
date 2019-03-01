package com.nurseryapi.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nurseryapi.entity.SchoolEntity;
import com.nurseryapi.entity.user.OwnerUserEntity;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Repository
public interface SchoolRepository extends JpaRepository<SchoolEntity, Long> {

	/**
	 * 
	 * @param ownerId
	 * @return
	 */
	Page<SchoolEntity> findByOwnerId(long ownerId, Pageable pageable);

	/**
	 * 
	 * @param schoolId
	 * @param ownerId
	 * @return
	 */
	Optional<SchoolEntity> findByIdAndOwnerId(long schoolId, long ownerId);

	/**
	 * 
	 * @param ownerId
	 * @return
	 */
	Page<SchoolEntity> findByOwner(OwnerUserEntity ownerUser, Pageable pageable);

	/**
	 * 
	 * @param schoolId
	 * @param ownerId
	 * @return
	 */
	Optional<SchoolEntity> findByIdAndOwner(long schoolId, OwnerUserEntity ownerUser);
}