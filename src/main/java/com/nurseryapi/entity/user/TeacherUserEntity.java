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
@Entity(name = "TeacherUser")
@Table(name = "teacher_user")
@DiscriminatorValue("TEACHER")
@Setter
@Getter
public class TeacherUserEntity extends UserEntity {
}
