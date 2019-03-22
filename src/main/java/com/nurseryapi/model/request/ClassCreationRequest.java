package com.nurseryapi.model.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel("Class Creation Request")
@Setter
@Getter
public class ClassCreationRequest {

	@ApiModelProperty(name = "Class name")
	@NotNull(message = "Class name can't be null")
	@NotBlank(message = "Class name can't be blank")
	private String name;

	@ApiModelProperty(name = "Class capacity")
	@NotNull(message = "Class capacity can't be null")
	@PositiveOrZero(message = "Class capacity must be zero or positive number")
	private long capacity;

	@ApiModelProperty(name = "Class capacity")
	@NotNull(message = "Grade id can't be null")
	private long gradeId;

	@ApiModelProperty(name = "Class capacity")
	@NotNull(message = "School id can't be null")
	private long schoolId;

	@ApiModelProperty(name = "Class teacher id")
	@NotNull(message = "Teacher id can't be null")
	private long teacherId;
}