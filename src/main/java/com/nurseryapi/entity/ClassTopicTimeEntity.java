package com.nurseryapi.entity;

import java.time.LocalDateTime;

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

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Entity(name = "ClassTopicTime")
@Table(name = "class_topic_times")
@Setter
@Getter
public class ClassTopicTimeEntity extends BaseEntity {

	private static final long serialVersionUID = 5195258441612202390L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "class_topic_time_id")
	private long id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "class_room_id", nullable = false, foreignKey = @ForeignKey(name = "fk_class_topic_time_class_room_id"))
	@NotNull(message = "Class room can't be null")
	private ClassRoomEntity classRoom;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "topic_id", nullable = false, foreignKey = @ForeignKey(name = "fk_class_topic_time_topic_id"))
	@NotNull(message = "Topic can't be null")
	private TopicEntity topic;

	@Column(name = "class_topic_time_from", nullable = false, unique = true)
	@NotNull(message = "Class Topic Time can't be null")
	@NotBlank(message = "Class Topic Time can't be blank")
	private LocalDateTime from;

	@Column(name = "class_topic_time_to", nullable = false, unique = true)
	@NotNull(message = "Class Topic To can't be null")
	@NotBlank(message = "Class Topic To can't be blank")
	private LocalDateTime to;
}