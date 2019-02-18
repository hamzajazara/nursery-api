package com.nurseryapi.entity.user;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Entity(name = "AdminUser")
@Table(name = "admin_user")
@DiscriminatorValue("ADMIN")
@Setter
@Getter
public class AdminUserEntity extends UserEntity {
}
