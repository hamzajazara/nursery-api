package com.nurseryapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Entity(name = "Grade")
@Table(name = "grades")
@Setter
@Getter
public class GradeEntity extends BaseEntity {

	private static final long serialVersionUID = 5195258441612202390L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "grade_id")
	private long id;

	@Column(name = "grade_name", nullable = false)
	@NotNull(message = "Class name can't be null")
	@NotBlank(message = "Class name can't be blank")
	private String name;
}