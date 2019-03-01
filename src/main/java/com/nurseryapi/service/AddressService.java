package com.nurseryapi.service;

import com.nurseryapi.entity.AddressEntity;
import com.nurseryapi.entity.user.AdminUserEntity;
import com.nurseryapi.model.Address;

/**
 * 
 * @author Hamza Aljazara
 *
 */
public interface AddressService {

	/**
	 * 
	 * @param school
	 * @return
	 */
	AddressEntity save(AddressEntity school);

	/**
	 * 
	 * @param schoolRegistrationRequest
	 * @param adminUser
	 * @return
	 */
	AddressEntity create(Address address, AdminUserEntity adminUser);

	/**
	 * 
	 * @param schoolUpdateRequest
	 * @param address
	 * @return
	 */
	AddressEntity update(Address addressUpdateRequest, AddressEntity address);
}