package com.nurseryapi.model.constatnt;

import lombok.Getter;

@Getter
public enum UserType {

	ADMIN(1), OWNER(2), STUDENT(3), PARENT(4), TEACHER(5);

	long value;

	UserType(long value) {
		this.value = value;
	}
}
