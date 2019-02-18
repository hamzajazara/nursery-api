package com.nurseryapi.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.nurseryapi.entity.user.UserEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Entity(name = "Role")
@Table(name = "role")
@Setter
@Getter
public class RoleEntity extends BaseEntity {

	private static final long serialVersionUID = 1165609123874387404L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private long id;

	@Column(name = "role_name", nullable = false, unique = true)
	@NotNull(message = "Role name can't be null")
	@NotBlank(message = "Role name can't be blank")
	private String name;

	@ManyToMany(mappedBy = "roles")
	private List<UserEntity> users;
}
