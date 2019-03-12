package com.nurseryapi.repository.lookup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nurseryapi.entity.lookup.DegreeEntity;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Repository
public interface DegreeRepository extends JpaRepository<DegreeEntity, Long> {
}