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
@Table(name = "address")
@Setter
@Getter
public class AddressEntity extends BaseEntity {

	private static final long serialVersionUID = 5195258441612202390L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private long id;

	@Column(name = "address_name", nullable = false)
	@NotNull(message = "Address name can't be null")
	@NotBlank(message = "Address name can't be blank")
	private String name;

	@Column(name = "address_email", nullable = false, unique = true)
	@NotNull(message = "Address email can't be null")
	@NotBlank(message = "Address email can't be blank")
	private String email;

	@Column(name = "address_phone_number", nullable = false)
	@NotNull(message = "Address email can't be null")
	private String phoneNumber;

	@Column(name = "address_location")
	@NotNull(message = "Address location can't be null")
	private Point location;
}
