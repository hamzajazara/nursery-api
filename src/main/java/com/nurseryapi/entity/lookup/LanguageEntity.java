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
@Entity(name = "Language")
@Table(name = "languages")
@Setter
@Getter
public class LanguageEntity extends BaseEntity {

	private static final long serialVersionUID = 1331053354155820813L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "language_id")
	private long id;

	@Column(name = "language_name", nullable = false)
	private String name;

	@Column(name = "language_label", nullable = false)
	private String label;
}
