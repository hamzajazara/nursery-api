package com.nurseryapi.repository.lookup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nurseryapi.entity.lookup.LanguageEntity;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Repository
public interface LanguageRepository extends JpaRepository<LanguageEntity, Long> {
}