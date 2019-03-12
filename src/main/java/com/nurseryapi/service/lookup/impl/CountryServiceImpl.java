package com.nurseryapi.service.lookup.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nurseryapi.entity.lookup.CountryEntity;
import com.nurseryapi.exception.NoSuchElementFoundException;
import com.nurseryapi.repository.lookup.CountryRepository;
import com.nurseryapi.service.lookup.CountryService;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository countryRepository;

	/*
	 * @see com.nurseryapi.service.lookup.CountryService#getCountry(long)
	 */
	@Override
	public CountryEntity getCountry(long countryId) {
		return countryRepository.findById(countryId).orElseThrow(NoSuchElementFoundException::new);
	}

	/*
	 * @see
	 * com.nurseryapi.service.lookup.CountryService#getCountry(org.springframework.
	 * data.domain.Pageable)
	 */
	@Override
	public Page<CountryEntity> getCountry(Pageable pageable) {
		return countryRepository.findAll(pageable);
	}
}