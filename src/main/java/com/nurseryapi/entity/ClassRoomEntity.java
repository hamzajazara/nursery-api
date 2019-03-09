package com.nurseryapi.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import com.nurseryapi.entity.user.TeacherUserEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Entity(name = "ClassRoom")
@Table(name = "class_rooms")
@Setter
@Getter
public class ClassRoomEntity extends BaseEntity {

	private static final long serialVersionUID = 5195258441612202390L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "class_room_id")
	private long id;

	@Column(name = "class_room_name", nullable = false)
	@NotNull(message = "Class room name can't be null")
	@NotBlank(message = "Class room name can't be blank")
	private String name;

	@Column(name = "class_room_capacity")
	@PositiveOrZero(message = "Class room capacity must zero or positive")
	private long capacity;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "grade_id", nullable = false, foreignKey = @ForeignKey(name = "fk_class_room_grade_id"))
	@NotNull(message = "Class room grade can't be null")
	private GradeEntity grade;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "school_id", nullable = false, foreignKey = @ForeignKey(name = "fk_class_room_school_id"))
	@NotNull(message = "Class room school can't be null")
	private SchoolEntity school;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = true, foreignKey = @ForeignKey(name = "fk_class_room_user_id"))
	private TeacherUserEntity teacher;
}