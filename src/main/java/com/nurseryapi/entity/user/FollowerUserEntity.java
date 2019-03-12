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
@Entity(name = "FollowerUser")
@Table(name = "follower_users")
@DiscriminatorValue("FOLLOWER")
@Setter
@Getter
public class FollowerUserEntity extends UserEntity {
}
