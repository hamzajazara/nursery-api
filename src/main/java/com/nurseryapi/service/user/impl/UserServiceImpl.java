package com.nurseryapi.service.user.impl;

import java.util.Arrays;

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
import com.nurseryapi.exception.NoSuchElementFoundException;
import com.nurseryapi.exception.NotAuthorizedException;
import com.nurseryapi.model.constatnt.UserType;
import com.nurseryapi.model.request.user.UserRegistrationRequest;
import com.nurseryapi.repository.user.UserRepository;
import com.nurseryapi.service.user.RoleService;
import com.nurseryapi.service.user.UserService;
import com.nurseryapi.utils.Mapper;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Service
public class UserServiceImpl<T extends UserEntity> implements UserService<UserEntity>, UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleService roleService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	/*
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return userRepository.findByEmail(email).get();
	}

	/*
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 */
	@Override
	public boolean isUserExist(String email) {
		return userRepository.findByEmail(email).isPresent();
	}

	/*
	 * @see com.nurseryapi.service.user.UserService#save(com.nurseryapi.entity.user.
	 * UserEntity)
	 */
	@Override
	public UserEntity save(UserEntity userEntity) {
		return userRepository.saveAndFlush(userEntity);
	}

	@Override
	public UserEntity getUser(long userId) {
		return userRepository.findById(userId).orElseThrow(NoSuchElementFoundException::new);
	}

	/*
	 * @see
	 * com.nurseryapi.service.user.UserService#create(com.nurseryapi.model.request.
	 * UserRegistrationRequest)
	 */
	@Override
	public UserEntity create(UserRegistrationRequest userRegistrationRequest, UserType userType) {
		UserEntity createdUser = create(userRegistrationRequest, userType, null);
		return save(createdUser);
	}

	/*
	 * @see
	 * com.nurseryapi.service.user.UserService#create(com.nurseryapi.model.request.
	 * UserRegistrationRequest, com.nurseryapi.entity.user.AdminUserEntity)
	 */
	@Override
	public UserEntity create(UserRegistrationRequest userRegistrationRequest, UserType userType,
			UserEntity createdUser) {
		if (isUserExist(userRegistrationRequest.getEmail())) {
			throw new RuntimeException();
		}

		UserEntity userEntity = userFactory(userRegistrationRequest, userType, createdUser);
		userEntity.setPassword(passwordEncoder.encode(userRegistrationRequest.getPassword()));
		userEntity.setEnabled(true);
		userEntity.setVerified(true);

		// user role
		RoleEntity roleEntity = roleService.getRole(userType.getValue());
		userEntity.setRoles(Arrays.asList(roleEntity));

		return userEntity;
	}

	/*
	 * @see
	 * com.nurseryapi.service.user.UserService#userFactory(com.nurseryapi.model.
	 * request.UserRegistrationRequest, com.nurseryapi.entity.user.AdminUserEntity)
	 */
	@Override
	public <R extends UserRegistrationRequest> UserEntity userFactory(R userRegistrationRequest, UserType userType,
			UserEntity createdUser) {
		UserEntity userEntity;
		switch (userType) {
		case ADMIN:
			if (!(createdUser instanceof AdminUserEntity)) {
				throw new NotAuthorizedException();
			}
			userEntity = Mapper.map(userRegistrationRequest, AdminUserEntity.class);
			userEntity.setUserType(UserType.ADMIN);
			break;
		case OWNER:
			if (!(createdUser instanceof AdminUserEntity)) {
				throw new NotAuthorizedException();
			}
			userEntity = Mapper.map(userRegistrationRequest, OwnerUserEntity.class);
			userEntity.setUserType(UserType.OWNER);
			break;
		case PARENT:
			if (!(createdUser instanceof OwnerUserEntity)) {
				throw new NotAuthorizedException();
			}
			userEntity = Mapper.map(userRegistrationRequest, ParentUserEntity.class);
			userEntity.setUserType(UserType.PARENT);
			break;
		case TEACHER:
			if (!(createdUser instanceof OwnerUserEntity)) {
				throw new NotAuthorizedException();
			}
			userEntity = Mapper.map(userRegistrationRequest, TeacherUserEntity.class);
			userEntity.setUserType(UserType.TEACHER);
			break;
		default:
			throw new NoSuchElementFoundException();
		}
		return userEntity;
	}
}