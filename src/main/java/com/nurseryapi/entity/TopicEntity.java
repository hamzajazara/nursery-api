package com.nurseryapi.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.nurseryapi.entity.user.TeacherUserEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Entity(name = "TopicTime")
@Table(name = "topics")
@Setter
@Getter
public class TopicEntity extends BaseEntity {

	private static final long serialVersionUID = 5195258441612202390L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "topic_id")
	private long id;

	@Column(name = "topic_name", nullable = false)
	@NotNull(message = "Class name can't be null")
	@NotBlank(message = "Class name can't be blank")
	private String name;

	@ManyToMany(mappedBy = "topics")
	private List<TeacherUserEntity> teachers;
}