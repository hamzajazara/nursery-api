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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.nurseryapi.entity.SchoolEntity;
import com.nurseryapi.entity.TopicEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Entity(name = "TeacherUser")
@Table(name = "teacher_users")
@DiscriminatorValue("TEACHER")
@Setter
@Getter
public class TeacherUserEntity extends UserEntity {

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "school_id", nullable = false, foreignKey = @ForeignKey(name = "fk_teacher_user_school_id"))
	@NotNull(message = "School can't be null")
	private SchoolEntity school;

	@ManyToMany(cascade = CascadeType.ALL)
	// // @formatter:off
	@JoinTable(name = "teachers_topics", 
			   joinColumns = @JoinColumn(name = "teacher_user_id"), 
	           inverseJoinColumns = @JoinColumn(name = "topic_id"))
	// @formatter:on
	private List<TopicEntity> topics;
}