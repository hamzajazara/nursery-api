package com.nurseryapi.model.response.lookup;

import com.nurseryapi.entity.lookup.DegreeEntity;
import com.nurseryapi.model.Address;
import com.nurseryapi.utils.Mapper;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DegreeResponse {

	private Long id;
	private String label;

	/**
	 * 
	 * @param degreeEntity
	 */
	public DegreeResponse(DegreeEntity degreeEntity) {
		Mapper.map(degreeEntity, this);
	}
}
