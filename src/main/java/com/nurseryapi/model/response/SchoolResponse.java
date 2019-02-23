package com.nurseryapi.model.response;

import com.nurseryapi.entity.SchoolEntity;
import com.nurseryapi.model.Address;

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
		this.schoolName = schoolEntity.getName();
		this.address = new Address(schoolEntity.getAddress());
		this.ownerId = schoolEntity.getOwner().getId();
	}
}
