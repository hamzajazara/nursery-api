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

import com.nurseryapi.entity.lookup.CityEntity;
import com.nurseryapi.model.response.lookup.CityResponse;
import com.nurseryapi.service.lookup.CityService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@RestController("CityLookUpController")
@RequestMapping("/api/lookup/city")
@Api(tags = "Lookup")
public class CityLookupController {

	@Autowired
	private CityService cityService;

	/**
	 * 
	 * @param pageable
	 * @return
	 */
	@GetMapping
	@ApiOperation(value = "Allow the user to view all cities")
	public PageImpl<CityResponse> viewCities(Pageable pageable) {
		Page<CityEntity> cities = cityService.getCity(pageable);
		List<CityResponse> cityResponses = new ArrayList<>();
		cities.forEach(city -> cityResponses.add(new CityResponse(city)));
		return new PageImpl<>(cityResponses, pageable, cities.getTotalElements());
	}

	/**
	 * 
	 * @param cityId
	 * @return
	 */
	@GetMapping("/{cityId}")
	@ApiOperation(value = "Allow the user to view a specific city")
	public ResponseEntity<CityResponse> viewCity(@PathVariable("cityId") long cityId) {
		return new ResponseEntity<>(new CityResponse(cityService.getCity(cityId)), HttpStatus.OK);
	}
}
