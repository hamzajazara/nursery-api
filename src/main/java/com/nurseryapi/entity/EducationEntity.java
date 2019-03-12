package com.nurseryapi.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.nurseryapi.entity.lookup.DegreeEntity;
import com.nurseryapi.entity.lookup.MajorEntity;
import com.vividsolutions.jts.geom.Point;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Entity(name = "Education")
@Table(name = "educations")
@Setter
@Getter
public class EducationEntity extends BaseEntity {

	private static final long serialVersionUID = 5195258441612202390L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "education_id")
	private long id;

	@Column(name = "education_institution_name", nullable = false)
	private String institutionName;

	@Column(name = "education_degree", nullable = false, unique = true)
	private DegreeEntity degree;

	@Column(name = "education_major", nullable = false)
	private MajorEntity major;

	@Column(name = "education_graduation_date", columnDefinition = "POINT", nullable = false)
	@FutureOrPresent
	private LocalDate graduationDate;
}
