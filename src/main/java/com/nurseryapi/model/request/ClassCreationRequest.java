package com.nurseryapi.model.request;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel("Class Creation Request")
@Setter
@Getter
public class ClassCreationRequest {

	private String name;

	private long capacity;

	private long grade;

	private long school;

	private long teacher;
}