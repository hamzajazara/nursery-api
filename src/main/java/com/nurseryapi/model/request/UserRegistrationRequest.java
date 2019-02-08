package com.nurseryapi.model.request;

import javax.validation.constraints.NotNull;

import com.nurseryapi.model.constatnt.UserType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel("User Registration Request")
@Setter
@Getter
public class UserRegistrationRequest {

	@ApiModelProperty(name = "user first name")
	@NotNull
	private String firstName;

	@ApiModelProperty(name = "user last name")
	@NotNull
	private String lastName;

	@ApiModelProperty(name = "user national id")
	@NotNull
	private String nationalId;

	@ApiModelProperty(name = "user email")
	@NotNull
	private String email;

	@ApiModelProperty(name = "user user type")
	@NotNull
	private UserType userType;

	@ApiModelProperty(name = "user phone number")
	@NotNull
	private String phoneNumber;

	@ApiModelProperty(name = "user password")
	@NotNull
	private String password;

	@ApiModelProperty(name = "user confirm password")
	@NotNull
	private String confirmPassword;
}
