package com.nurseryapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nurseryapi.entity.AddressEntity;
import com.nurseryapi.entity.SchoolEntity;
import com.nurseryapi.entity.user.AdminUserEntity;
import com.nurseryapi.model.request.SchoolRegistrationRequest;
import com.nurseryapi.repository.SchoolRepository;
import com.nurseryapi.service.AddressService;
import com.nurseryapi.service.SchoolService;
import com.nurseryapi.utils.Mapper;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Service
public class SchoolServiceImpl implements SchoolService {

	@Autowired
	private SchoolRepository schoolRepository;

	@Autowired
	private AddressService addressService;

	/*
	 * @see
	 * com.nurseryapi.service.SchoolService#save(com.nurseryapi.entity.SchoolEntity)
	 */
	@Override
	public SchoolEntity save(SchoolEntity school) {
		return schoolRepository.saveAndFlush(school);
	}

	/*
	 * @see
	 * com.nurseryapi.service.SchoolService#register(com.nurseryapi.model.request.
	 * SchoolRegistrationRequest, com.nurseryapi.entity.user.AdminUserEntity)
	 */
	@Override
	public SchoolEntity register(SchoolRegistrationRequest schoolRegistrationRequest, AdminUserEntity adminUser) {
		SchoolEntity schoolEntity = Mapper.map(schoolRegistrationRequest, SchoolEntity.class);
		AddressEntity address = addressService.create(schoolRegistrationRequest.getAddress(), adminUser);
		schoolEntity.setAddress(address);
		return schoolEntity;
	}
}