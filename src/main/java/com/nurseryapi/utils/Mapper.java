package com.nurseryapi.utils;

import org.springframework.beans.BeanUtils;

public class Mapper {

	private Mapper() {
	}

	public static <T> T map(Object source, Class<T> target) {
		if (source == null || target == null)
			return null;

		try {
			T targetInstance = target.newInstance();
			BeanUtils.copyProperties(source, targetInstance);
			return targetInstance;
		} catch (InstantiationException | IllegalAccessException e) {
			return null;
		}
	}
}