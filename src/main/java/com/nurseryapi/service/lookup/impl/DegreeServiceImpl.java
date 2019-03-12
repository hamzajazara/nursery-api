package com.nurseryapi.service.lookup.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nurseryapi.entity.lookup.DegreeEntity;
import com.nurseryapi.exception.NoSuchElementFoundException;
import com.nurseryapi.repository.lookup.DegreeRepository;
import com.nurseryapi.service.lookup.DegreeService;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Service
public class DegreeServiceImpl implements DegreeService {

	@Autowired
	private DegreeRepository DegreeRepository;

	/*
	 * @see com.nurseryapi.service.lookup.DegreeService#getDegree(long)
	 */
	@Override
	public DegreeEntity getDegree(long degreeId) {
		return DegreeRepository.findById(degreeId).orElseThrow(NoSuchElementFoundException::new);
	}

	/*
	 * @see
	 * com.nurseryapi.service.lookup.DegreeService#getDegree(org.springframework.
	 * data.domain.Pageable)
	 */
	@Override
	public Page<DegreeEntity> getDegree(Pageable pageable) {
		return DegreeRepository.findAll(pageable);
	}
}