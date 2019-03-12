package com.nurseryapi.repository.lookup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nurseryapi.entity.lookup.MajorEntity;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Repository
public interface MajorRepository extends JpaRepository<MajorEntity, Long> {
}