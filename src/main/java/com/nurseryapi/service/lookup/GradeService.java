package com.nurseryapi.service.lookup;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nurseryapi.entity.lookup.GradeEntity;

/**
 * 
 * @author Hamza Aljazara
 *
 */
public interface GradeService {

	/**
	 * 
	 * @param gradeId
	 * @return
	 */
	GradeEntity getGrade(long gradeId);

	/**
	 * 
	 * @param gradeId
	 * @return
	 */
	Page<GradeEntity> getGrade(Pageable pageable);
}