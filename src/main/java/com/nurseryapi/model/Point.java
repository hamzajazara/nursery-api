package com.nurseryapi.model;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel("Point")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Point {

	@ApiModelProperty(name = "Latitude")
	@NotNull
	private double lat;

	@ApiModelProperty(name = "Longitude")
	@NotNull
	private double lng;

	public Point(com.vividsolutions.jts.geom.Point point) {
		this.lat = point.getY();
		this.lng = point.getX();
	}
}
