package com.nurseryapi.service.impl;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nurseryapi.entity.user.AdminUserEntity;
import com.nurseryapi.entity.user.OwnerUserEntity;
import com.nurseryapi.entity.user.ParentUserEntity;
import com.nurseryapi.entity.user.RoleEntity;
import com.nurseryapi.entity.user.TeacherUserEntity;
import com.nurseryapi.entity.user.UserEntity;
import com.nurseryapi.model.constatnt.UserType;
import com.nurseryapi.model.request.UserRegistrationRequest;
import com.nurseryapi.repository.UserRepository;
import com.nurseryapi.service.RoleService;
import com.nurseryapi.service.UserService;
import com.nurseryapi.utils.Mapper;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleService roleService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return userRepository.findByEmail(email).get();
	}

	@Override
	public UserEntity save(UserEntity userEntity) {
		return userRepository.saveAndFlush(userEntity);
	}

	@Override
	public UserEntity create(UserRegistrationRequest userRegistrationRequest) {
		UserEntity userEntity = userFactory(userRegistrationRequest);

		RoleEntity roleEntity = roleService.getRole(userRegistrationRequest.getUserType().getValue());
		ArrayList<RoleEntity> roles = new ArrayList<>();
		roles.add(roleEntity);
		userEntity.setPassword(passwordEncoder.encode(userRegistrationRequest.getPassword()));
		userEntity.setRoles(roles);
		userEntity.setEnabled(true);
		userEntity.setVerified(true);
		return save(userEntity);
	}

	@Override
	public UserEntity userFactory(UserRegistrationRequest userRegistrationRequest) {
		UserEntity userEntity;
		switch (userRegistrationRequest.getUserType()) {
		case ADMIN:
			userEntity = Mapper.map(userRegistrationRequest, AdminUserEntity.class);
			userEntity.setUserType(UserType.ADMIN);
			break;
		case OWNER:
			userEntity = Mapper.map(userRegistrationRequest, OwnerUserEntity.class);
			userEntity.setUserType(UserType.OWNER);
			break;
		case PARENT:
			userEntity = Mapper.map(userRegistrationRequest, ParentUserEntity.class);
			userEntity.setUserType(UserType.PARENT);
			break;
		case TEACHER:
			userEntity = Mapper.map(userRegistrationRequest, TeacherUserEntity.class);
			userEntity.setUserType(UserType.TEACHER);
			break;
		default:
			throw new NoSuchElementException();
		}
		return userEntity;
	}
}
