package com.nurseryapi.model.response.lookup;

import com.nurseryapi.entity.lookup.LanguageEntity;
import com.nurseryapi.utils.Mapper;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LanguageResponse {

	private Long id;
	private String label;

	/**
	 * 
	 * @param languageEntity
	 */
	public LanguageResponse(LanguageEntity languageEntity) {
		Mapper.map(languageEntity, this);
	}
}
