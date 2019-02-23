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
@Entity(name = "ParentUser")
@Table(name = "parent_users")
@DiscriminatorValue("PARENT")
@Setter
@Getter
public class ParentUserEntity extends UserEntity {
}
