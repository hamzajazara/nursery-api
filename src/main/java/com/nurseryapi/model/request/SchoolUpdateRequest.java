package com.nurseryapi.model.request;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.nurseryapi.model.Address;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel("School Update Request")
@Setter
@Getter
public class SchoolUpdateRequest {

	@NotNull(message = "School name can't be null")
	@NotBlank(message = "School name can't be blank")
	private String schoolName;

	@NotNull(message = "Address can't be null")
	@Valid
	private Address address;
}
