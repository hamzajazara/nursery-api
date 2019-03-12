package com.nurseryapi.model.response.lookup;

import com.nurseryapi.entity.lookup.CityEntity;
import com.nurseryapi.utils.Mapper;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CityResponse {

	private Long id;
	private String label;
	private CountryResponse country;

	/**
	 * 
	 * @param cityEntity
	 */
	public CityResponse(CityEntity cityEntity) {
		Mapper.map(cityEntity, this);
		country = new CountryResponse(cityEntity.getCountry());
	}
}
