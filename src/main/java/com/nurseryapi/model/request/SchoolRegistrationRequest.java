package com.nurseryapi.model.request;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.nurseryapi.model.Address;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel("School Registration Request")
@Setter
@Getter
public class SchoolRegistrationRequest {

	@NotNull(message = "School name can't be null")
	@NotBlank(message = "School name can't be blank")
	private String schoolName;

	@NotNull(message = "Address can't be null")
	@Valid
	private Address address;

	@NotNull(message = "Owner id can't be null")
	private Long ownerId;
}
