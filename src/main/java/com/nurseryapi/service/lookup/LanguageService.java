package com.nurseryapi.service.lookup;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nurseryapi.entity.lookup.LanguageEntity;

/**
 * 
 * @author Hamza Aljazara
 *
 */
public interface LanguageService {

	/**
	 * 
	 * @param languageId
	 * @return
	 */
	LanguageEntity getLanguage(long languageId);

	/**
	 * 
	 * @param pageable
	 * @return
	 */
	Page<LanguageEntity> getLanguage(Pageable pageable);
}