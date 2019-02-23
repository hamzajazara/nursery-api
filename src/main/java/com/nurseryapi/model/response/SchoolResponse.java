package com.nurseryapi.model.response;

import com.nurseryapi.entity.SchoolEntity;
import com.nurseryapi.model.Address;
import com.nurseryapi.utils.Mapper;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SchoolResponse {

	private String schoolName;

	private Address address;

	private Long ownerId;

	/**
	 * 
	 * @param schoolEntity
	 */
	public SchoolResponse(SchoolEntity schoolEntity) {
		Mapper.map(schoolEntity, this);
	}
}
