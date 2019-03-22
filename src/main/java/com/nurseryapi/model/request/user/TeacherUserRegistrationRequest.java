package com.nurseryapi.model.request.user;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.nurseryapi.model.request.EducationRequest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel("Teacher User Registration Request")
@Setter
@Getter
public class TeacherUserRegistrationRequest extends UserRegistrationRequest {

	@ApiModelProperty(name = "Education Creation Request")
	@NotNull(message = "Education can't be null")
	@Valid
	private EducationRequest education;

	@ApiModelProperty(name = "School Id")
	@NotNull(message = "School id can't be null")
	private long schoolId;

	@ApiModelProperty(name = "Degree Id")
	@NotNull(message = "Degree id can't be null")
	private long degreeId;

	@ApiModelProperty(name = "Topic Ids")
	private List<Long> topicIds;
}
