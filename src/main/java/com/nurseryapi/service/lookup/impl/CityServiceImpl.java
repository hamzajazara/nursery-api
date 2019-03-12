package com.nurseryapi.service.lookup.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nurseryapi.entity.lookup.CityEntity;
import com.nurseryapi.exception.NoSuchElementFoundException;
import com.nurseryapi.repository.lookup.CityRepository;
import com.nurseryapi.service.lookup.CityService;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepository cityRepository;

	/*
	 * @see com.nurseryapi.service.lookup.CityService#getCity(long)
	 */
	@Override
	public CityEntity getCity(long cityId) {
		return cityRepository.findById(cityId).orElseThrow(NoSuchElementFoundException::new);
	}

	/*
	 * @see
	 * com.nurseryapi.service.lookup.CityService#getCity(org.springframework.data.
	 * domain.Pageable)
	 */
	@Override
	public Page<CityEntity> getCity(Pageable pageable) {
		return cityRepository.findAll(pageable);
	}
}