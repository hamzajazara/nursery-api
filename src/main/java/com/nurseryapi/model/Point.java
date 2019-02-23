package com.nurseryapi.model;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel("Point")
@Setter
@Getter
public class Point {

	@ApiModelProperty(name = "Latitude")
	@NotNull
	private double lat;

	@ApiModelProperty(name = "Longitude")
	@NotNull
	private double lng;
}
