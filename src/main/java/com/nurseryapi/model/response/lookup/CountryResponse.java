package com.nurseryapi.model.response.lookup;

import com.nurseryapi.entity.lookup.CountryEntity;
import com.nurseryapi.utils.Mapper;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CountryResponse {

	private Long id;
	private String label;

	/**
	 * 
	 * @param countryEntity
	 */
	public CountryResponse(CountryEntity countryEntity) {
		Mapper.map(countryEntity, this);
	}
}
