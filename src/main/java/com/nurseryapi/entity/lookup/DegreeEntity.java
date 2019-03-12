package com.nurseryapi.entity.lookup;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.nurseryapi.entity.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Entity(name = "Degree")
@Table(name = "degrees")
@Setter
@Getter
public class DegreeEntity extends BaseEntity {

	private static final long serialVersionUID = 4786700544861246264L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "degree_id")
	private long id;

	@Column(name = "degree_name", nullable = false)
	private String name;
	
	@Column(name = "degree_label", nullable = false)
	private String label;
}
