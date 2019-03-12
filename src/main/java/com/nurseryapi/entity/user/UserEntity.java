package com.nurseryapi.entity.user;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.nurseryapi.entity.BaseEntity;
import com.nurseryapi.model.constatnt.UserType;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Entity(name = "User")
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@Setter
@Getter
public class UserEntity extends BaseEntity implements UserDetails {

	private static final long serialVersionUID = 5195258441612202390L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long id;

	@Column(name = "user_first_name", nullable = false)
	private String firstName;

	@Column(name = "user_last_name", nullable = false)
	private String lastName;

	@Column(name = "user_national_id", nullable = false, unique = true)
	private String nationalId;

	@Column(name = "user_username", nullable = false, unique = true)
	private String username;

	@Column(name = "user_email", nullable = false, unique = true)
	private String email;

	@Column(name = "user_password", nullable = false)
	private String password;

	@Column(name = "user_phone_number")
	private String phoneNumber;

	@Column(name = "user_type", nullable = false)
	@Enumerated(EnumType.STRING)
	private UserType userType;

	@Column(name = "user_verified", nullable = false)
	private boolean verified;

	@Column(name = "user_enabled", nullable = false)
	private boolean enabled;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_user_roles_user_id")), inverseJoinColumns = @JoinColumn(name = "user_role_id", nullable = false, foreignKey = @ForeignKey(name = "fk_user_roles_role_id")))
	private List<RoleEntity> roles;

	@PrePersist
	public void prePersist() {
		this.username = email;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (getRoles() == null) {
			return Collections.emptyList();
		}

		return getRoles().stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
				.collect(Collectors.toList());
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
}
