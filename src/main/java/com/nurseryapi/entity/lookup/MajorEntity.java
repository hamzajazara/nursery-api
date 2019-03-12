package com.nurseryapi.entity.lookup;

import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.nurseryapi.entity.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Entity(name = "Major")
@Table(name = "majors")
@Setter
@Getter
public class MajorEntity extends BaseEntity {

	private static final long serialVersionUID = 2179872874030612768L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "major_id")
	private long id;

	@Column(name = "major_name", nullable = false)
	private String name;

	@Column(name = "major_label", nullable = false)
	private String label;

	@OneToMany(mappedBy = "major")
	private List<GradeEntity> grades;
}
