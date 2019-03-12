package com.nurseryapi.service.lookup;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nurseryapi.entity.lookup.CityEntity;

/**
 * 
 * @author Hamza Aljazara
 *
 */
public interface CityService {

	/**
	 * 
	 * @param cityId
	 * @return
	 */
	CityEntity getCity(long cityId);

	/**
	 * 
	 * @param pageable
	 * @return
	 */
	Page<CityEntity> getCity(Pageable pageable);
}