package com.nurseryapi.controller.lookup;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nurseryapi.entity.lookup.LanguageEntity;
import com.nurseryapi.model.response.lookup.LanguageResponse;
import com.nurseryapi.service.lookup.LanguageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@RestController("LanguageLookUpController")
@RequestMapping("/api/lookup/language")
@Api(tags = "Lookup")
public class LanguageLookupController {

	@Autowired
	private LanguageService languageService;

	/**
	 * 
	 * @param pageable
	 * @return
	 */
	@GetMapping("/")
	@ApiOperation(value = "Allow the user to view all languages")
	public PageImpl<LanguageResponse> viewLanguages(Pageable pageable) {
		Page<LanguageEntity> languages = languageService.getLanguage(pageable);
		List<LanguageResponse> languageResponses = new ArrayList<>();
		languages.forEach(language -> languageResponses.add(new LanguageResponse(language)));
		return new PageImpl<>(languageResponses, pageable, languages.getTotalElements());
	}

	/**
	 * 
	 * @param languageId
	 * @return
	 */
	@GetMapping("/{languageId}")
	@ApiOperation(value = "Allow the user to view a specific language")
	public ResponseEntity<LanguageResponse> viewLanguage(@PathVariable("languageId") long languageId) {
		return new ResponseEntity<>(new LanguageResponse(languageService.getLanguage(languageId)), HttpStatus.OK);
	}
}
