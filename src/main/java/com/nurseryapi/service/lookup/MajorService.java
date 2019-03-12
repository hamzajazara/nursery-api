package com.nurseryapi.service.lookup;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nurseryapi.entity.lookup.MajorEntity;

/**
 * 
 * @author Hamza Aljazara
 *
 */
public interface MajorService {

	/**
	 * 
	 * @param majorId
	 * @return
	 */
	MajorEntity getMajor(long majorId);

	/**
	 * 
	 * @param pageable
	 * @return
	 */
	Page<MajorEntity> getMajor(Pageable pageable);
}