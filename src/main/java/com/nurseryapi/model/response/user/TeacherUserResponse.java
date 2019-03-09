package com.nurseryapi.model.response.user;

import com.nurseryapi.entity.user.TeacherUserEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class TeacherUserResponse extends UserInfoResponse {

	/**
	 * 
	 * @param user
	 */
	public TeacherUserResponse(TeacherUserEntity teacherUserEntity) {
		super(teacherUserEntity);
	}
}
