package com.nurseryapi.repository.lookup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nurseryapi.entity.lookup.CountryEntity;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, Long> {
}