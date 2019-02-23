package com.nurseryapi.entity;

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

import com.nurseryapi.entity.user.OwnerUserEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Entity(name = "School")
@Table(name = "schools")
@Setter
@Getter
public class SchoolEntity extends BaseEntity {

	private static final long serialVersionUID = 5195258441612202390L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "school_id")
	private long id;

	@Column(name = "school_name", nullable = false)
	@NotNull(message = "School name can't be null")
	@NotBlank(message = "School name can't be blank")
	private String name;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "address_id", nullable = false, foreignKey = @ForeignKey(name = "fk_school_address_id"))
	@NotNull(message = "Address can't be null")
	private AddressEntity address;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "owner_user_id", nullable = false, foreignKey = @ForeignKey(name = "fk_school_owner_user_id"))
	@NotNull(message = "Owner can't be null")
	private OwnerUserEntity owner;
}
