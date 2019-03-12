package com.nurseryapi.service.lookup;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nurseryapi.entity.lookup.CountryEntity;

/**
 * 
 * @author Hamza Aljazara
 *
 */
public interface CountryService {

	/**
	 * 
	 * @param countryId
	 * @return
	 */
	CountryEntity getCountry(long countryId);

	/**
	 * 
	 * @param pageable
	 * @return
	 */
	Page<CountryEntity> getCountry(Pageable pageable);
}