package com.nurseryapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nurseryapi.entity.AddressEntity;
import com.nurseryapi.entity.user.AdminUserEntity;
import com.nurseryapi.model.Address;
import com.nurseryapi.repository.AddressRepository;
import com.nurseryapi.service.AddressService;
import com.nurseryapi.utils.Mapper;
import com.nurseryapi.utils.PointUtils;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;

	/*
	 * @see com.nurseryapi.service.SchoolService#save(com.nurseryapi.entity.
	 * AddressEntity)
	 */
	@Override
	public AddressEntity save(AddressEntity school) {
		return addressRepository.saveAndFlush(school);
	}

	/*
	 * @see
	 * com.nurseryapi.service.SchoolService#register(com.nurseryapi.model.request.
	 * SchoolRegistrationRequest, com.nurseryapi.entity.user.AdminUserEntity)
	 */
	@Override
	public AddressEntity create(Address address, AdminUserEntity adminUser) {
		AddressEntity addressEntity = Mapper.map(address, AddressEntity.class);
		addressEntity.setLocation(PointUtils.create(address.getPoint()));
		return save(addressEntity);
	}
}