package com.nurseryapi.entity.user;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.nurseryapi.entity.ClassRoomEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Entity(name = "StudentUser")
@Table(name = "student_users")
@DiscriminatorValue("STUDENT")
@Setter
@Getter
public class StudentUserEntity extends UserEntity {

	@ManyToMany(cascade = CascadeType.ALL)
	// // @formatter:off
	@JoinTable(name = "students_class_rooms", 
			   joinColumns = @JoinColumn(name = "student_user_id"), 
	           inverseJoinColumns = @JoinColumn(name = "class_room_id"))
	// @formatter:on
	private List<ClassRoomEntity> classRooms;
}