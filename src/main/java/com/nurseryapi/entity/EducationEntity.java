package com.nurseryapi.entity;

import java.time.LocalDate;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.nurseryapi.entity.lookup.DegreeEntity;
import com.nurseryapi.entity.lookup.GradeEntity;
import com.nurseryapi.entity.lookup.MajorEntity;
import com.nurseryapi.entity.user.TeacherUserEntity;
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

	@Column(name = "education_graduation_date", nullable = false)
	@FutureOrPresent
	private LocalDate graduationDate;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "grade_id", nullable = false, foreignKey = @ForeignKey(name = "fk_education_grade_id"))
	private GradeEntity grade;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "degree_id", nullable = false, foreignKey = @ForeignKey(name = "fk_education_degree_id"))
	private DegreeEntity degree;

	@OneToOne(mappedBy = "education")
	private TeacherUserEntity teacherUser;
}
