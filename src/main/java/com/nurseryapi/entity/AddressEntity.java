package com.nurseryapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.vividsolutions.jts.geom.Point;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Entity(name = "Address")
@Table(name = "addresses")
@Setter
@Getter
public class AddressEntity extends BaseEntity {

	private static final long serialVersionUID = 5195258441612202390L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private long id;

	@Column(name = "address_location_name", nullable = false)
	private String locationName;

	@Column(name = "address_email", nullable = false, unique = true)
	private String email;

	@Column(name = "address_phone_number", nullable = false)
	private String phoneNumber;

	@Column(name = "address_location", columnDefinition = "POINT")
	private Point location;
}
