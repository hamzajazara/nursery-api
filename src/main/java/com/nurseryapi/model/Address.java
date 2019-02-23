package com.nurseryapi.model;

import javax.validation.constraints.NotNull;

import com.nurseryapi.entity.AddressEntity;
import com.nurseryapi.utils.Mapper;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel("Address")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	@ApiModelProperty(name = "Location Name")
	@NotNull
	private String locationName;

	@ApiModelProperty(name = "Email")
	@NotNull
	private String email;

	@ApiModelProperty(name = "Phone Number")
	@NotNull
	private String phoneNumber;

	@ApiModelProperty(name = "Phone Number")
	@NotNull
	private Point point;

	public Address(AddressEntity addressEntity) {
		Mapper.map(addressEntity, this);
		this.point = new Point(addressEntity.getLocation());
	}
}