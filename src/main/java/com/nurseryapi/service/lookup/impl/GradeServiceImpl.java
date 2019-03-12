package com.nurseryapi.service.lookup.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nurseryapi.entity.lookup.GradeEntity;
import com.nurseryapi.exception.NoSuchElementFoundException;
import com.nurseryapi.repository.lookup.GradeRepository;
import com.nurseryapi.service.lookup.GradeService;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Service
public class GradeServiceImpl implements GradeService {

	@Autowired
	private GradeRepository gradeRepository;

	/*
	 * @see com.nurseryapi.service.GradeService#getGrade(long)
	 */
	@Override
	public GradeEntity getGrade(long gradeId) {
		return gradeRepository.findById(gradeId).orElseThrow(NoSuchElementFoundException::new);
	}

	/*
	 * @see
	 * com.nurseryapi.service.GradeService#getGrade(org.springframework.data.domain.
	 * Pageable)
	 */
	@Override
	public Page<GradeEntity> getGrade(Pageable pageable) {
		return gradeRepository.findAll(pageable);
	}
}