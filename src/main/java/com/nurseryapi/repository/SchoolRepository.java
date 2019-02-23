package com.nurseryapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nurseryapi.entity.SchoolEntity;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Repository
public interface SchoolRepository extends JpaRepository<SchoolEntity, Long> {
}