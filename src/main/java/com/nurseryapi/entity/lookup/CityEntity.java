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

import com.nurseryapi.entity.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Entity(name = "City")
@Table(name = "cities")
@Setter
@Getter
public class CityEntity extends BaseEntity {

	private static final long serialVersionUID = 1331053354155820813L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id")
	private long id;

	@Column(name = "city_name", nullable = false)
	private String name;

	@Column(name = "city_label", nullable = false)
	private String label;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "country_id", nullable = false, foreignKey = @ForeignKey(name = "fk_city_country_id"))
	private CountryEntity country;
}
