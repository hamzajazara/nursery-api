package com.nurseryapi.model;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel("Address")
@Setter
@Getter
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

	@ApiModelProperty(name = "Owner Id")
	@NotNull
	private Long ownerId;
}
