package com.nurseryapi.entity.lookup;

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

import com.nurseryapi.entity.BaseEntity;

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

	private static final long serialVersionUID = -3960593192315009135L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "grade_id")
	private long id;

	@Column(name = "grade_name", nullable = false)
	private String name;

	@Column(name = "grade_label", nullable = false)
	private String label;
	

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "major_id", nullable = false, foreignKey = @ForeignKey(name = "fk_major_major_id"))
	private MajorEntity major;
}