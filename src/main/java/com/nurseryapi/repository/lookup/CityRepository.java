package com.nurseryapi.repository.lookup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nurseryapi.entity.lookup.CityEntity;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long> {
}