package com.nurseryapi.service.lookup;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nurseryapi.entity.lookup.DegreeEntity;

/**
 * 
 * @author Hamza Aljazara
 *
 */
public interface DegreeService {

	/**
	 * 
	 * @param degreeId
	 * @return
	 */
	DegreeEntity getDegree(long degreeId);

	/**
	 * 
	 * @param pageable
	 * @return
	 */
	Page<DegreeEntity> getDegree(Pageable pageable);
}