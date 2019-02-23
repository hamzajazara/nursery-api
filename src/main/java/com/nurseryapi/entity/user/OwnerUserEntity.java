package com.nurseryapi.entity.user;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.nurseryapi.entity.SchoolEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Entity(name = "OwnerUser")
@Table(name = "owner_users")
@DiscriminatorValue("OWNER")
@Setter
@Getter
public class OwnerUserEntity extends UserEntity {

	@OneToMany(mappedBy = "owner")
	private List<SchoolEntity> schools;
}
