package com.nurseryapi.entity.lookup;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Entity(name = "Country")
@Table(name = "countries")
@Setter
@Getter
public class CountryEntity extends BaseEntity {

	private static final long serialVersionUID = -7430329977387445485L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "country_id")
	private long id;

	@Column(name = "country_name", nullable = false)
	private String name;

	@Column(name = "country_label", nullable = false)
	private String label;

	@OneToMany(mappedBy = "country")
	private List<CityEntity> cities;
}
