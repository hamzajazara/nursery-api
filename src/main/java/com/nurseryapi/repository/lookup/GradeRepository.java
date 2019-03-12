package com.nurseryapi.repository.lookup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nurseryapi.entity.lookup.GradeEntity;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Repository
public interface GradeRepository extends JpaRepository<GradeEntity, Long> {
}