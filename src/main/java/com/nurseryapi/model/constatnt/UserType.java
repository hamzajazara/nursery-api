package com.nurseryapi.model.constatnt;

import lombok.Getter;

@Getter
public enum UserType {

	ADMIN(1), OWNER(2), TEACHER(3), PARENT(4);

	long value;

	UserType(long value) {
		this.value = value;
	}
}
