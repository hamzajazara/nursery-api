package com.nurseryapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nurseryapi.entity.AddressEntity;
import com.nurseryapi.entity.SchoolEntity;
import com.nurseryapi.entity.user.AdminUserEntity;
import com.nurseryapi.entity.user.OwnerUserEntity;
import com.nurseryapi.exception.NoSuchElementFoundException;
import com.nurseryapi.model.request.SchoolRegistrationRequest;
import com.nurseryapi.repository.SchoolRepository;
import com.nurseryapi.service.AddressService;
import com.nurseryapi.service.SchoolService;
import com.nurseryapi.service.user.OwnerUserService;

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

	@Autowired
	private OwnerUserService ownerUserService;

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
	@Transactional
	public SchoolEntity register(SchoolRegistrationRequest schoolRegistrationRequest, AdminUserEntity adminUser) {
		SchoolEntity schoolEntity = new SchoolEntity();
		AddressEntity address = addressService.create(schoolRegistrationRequest.getAddress(), adminUser);
		OwnerUserEntity userEntity = ownerUserService.getOwnerUser(schoolRegistrationRequest.getOwnerId())
				.orElseThrow(NoSuchElementFoundException::new);
		schoolEntity.setOwner(userEntity);
		schoolEntity.setAddress(address);
		schoolEntity.setName(schoolRegistrationRequest.getSchoolName());
		return save(schoolEntity);
	}
}