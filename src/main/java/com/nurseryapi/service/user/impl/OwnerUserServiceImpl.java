package com.nurseryapi.service.user.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nurseryapi.entity.user.OwnerUserEntity;
import com.nurseryapi.repository.user.OwnerUserRepository;
import com.nurseryapi.service.user.OwnerUserService;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Service
public class OwnerUserServiceImpl implements OwnerUserService {

	@Autowired
	private OwnerUserRepository ownerUserRepository;

	@Override
	public Optional<OwnerUserEntity> getOwnerUser(long ownerUserId) {
		return ownerUserRepository.findById(ownerUserId);
	}
}
