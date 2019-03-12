package com.nurseryapi.service.lookup.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nurseryapi.entity.lookup.LanguageEntity;
import com.nurseryapi.exception.NoSuchElementFoundException;
import com.nurseryapi.repository.lookup.LanguageRepository;
import com.nurseryapi.service.lookup.LanguageService;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Service
public class LanguageServiceImpl implements LanguageService {

	@Autowired
	private LanguageRepository languageRepository;

	/*
	 * @see com.nurseryapi.service.lookup.LanguageService#getLanguage(long)
	 */
	@Override
	public LanguageEntity getLanguage(long languageId) {
		return languageRepository.findById(languageId).orElseThrow(NoSuchElementFoundException::new);
	}

	/*
	 * @see
	 * com.nurseryapi.service.lookup.LanguageService#getLanguage(org.springframework
	 * .data.domain.Pageable)
	 */
	@Override
	public Page<LanguageEntity> getLanguage(Pageable pageable) {
		return languageRepository.findAll(pageable);
	}
}