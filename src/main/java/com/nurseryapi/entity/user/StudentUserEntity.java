package com.nurseryapi.entity.user;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
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
	// @formatter:off
	@JoinTable(name = "parents_followers", 
			   joinColumns = @JoinColumn(name = "student_user_id"), 
	           inverseJoinColumns = @JoinColumn(name = "parent_user_id"))
	// @formatter:on
	private List<ParentUserEntity> parentUsers;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "class_id", nullable = false, foreignKey = @ForeignKey(name = "fk_student_class_id"))
	private ClassRoomEntity classRoom;
}