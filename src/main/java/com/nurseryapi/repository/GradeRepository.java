package com.nurseryapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nurseryapi.entity.GradeEntity;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Repository
public interface GradeRepository extends JpaRepository<GradeEntity, Long> {
}