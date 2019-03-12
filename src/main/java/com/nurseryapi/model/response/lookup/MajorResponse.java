package com.nurseryapi.model.response.lookup;

import com.nurseryapi.entity.lookup.MajorEntity;
import com.nurseryapi.utils.Mapper;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MajorResponse {

	private Long id;
	private String label;

	/**
	 * 
	 * @param majorEntity
	 */
	public MajorResponse(MajorEntity majorEntity) {
		Mapper.map(majorEntity, this);
	}
}
