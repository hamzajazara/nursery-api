package com.nurseryapi.model.response.lookup;

import com.nurseryapi.entity.lookup.GradeEntity;
import com.nurseryapi.utils.Mapper;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GradeResponse {

	private Long id;
	private String label;
	private MajorResponse major;

	/**
	 * 
	 * @param gradeEntity
	 */
	public GradeResponse(GradeEntity gradeEntity) {
		Mapper.map(gradeEntity, this);
		major = new MajorResponse(gradeEntity.getMajor());
	}
}
