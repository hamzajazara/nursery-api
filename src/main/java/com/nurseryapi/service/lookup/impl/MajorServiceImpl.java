package com.nurseryapi.service.lookup.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nurseryapi.entity.lookup.MajorEntity;
import com.nurseryapi.exception.NoSuchElementFoundException;
import com.nurseryapi.repository.lookup.MajorRepository;
import com.nurseryapi.service.lookup.MajorService;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Service
public class MajorServiceImpl implements MajorService {

	@Autowired
	private MajorRepository MajorRepository;

	/*
	 * @see com.nurseryapi.service.lookup.MajorService#getMajor(long)
	 */
	@Override
	public MajorEntity getMajor(long majorId) {
		return MajorRepository.findById(majorId).orElseThrow(NoSuchElementFoundException::new);
	}

	/*
	 * @see
	 * com.nurseryapi.service.lookup.MajorService#getMajor(org.springframework.data.
	 * domain.Pageable)
	 */
	@Override
	public Page<MajorEntity> getMajor(Pageable pageable) {
		return MajorRepository.findAll(pageable);
	}
}