package com.nurseryapi.model.request;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel("Education Creation Request")
@Setter
@Getter
public class EducationRequest {

	@ApiModelProperty(name = "Education name")
	@NotNull(message = "Education institution can't be null")
	@NotBlank(message = "Education institution can't be blank")
	private String institutionName;

	@ApiModelProperty(name = "Education capacity")
	@NotNull(message = "Education graduation date can't be null")
	@PastOrPresent(message = "Education graduation date must be on past or present")
	private LocalDate graduationDate;

	@ApiModelProperty(name = "Education capacity")
	@NotNull(message = "Degree id can't be null")
	private Long degreeId;
}