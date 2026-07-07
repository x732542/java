package com.example.spring10.validator;

import java.lang.reflect.Field;

import com.example.spring10.annotation.CheckLength;

public class Validator {
	public static void validate(Object obj) throws IllegalAccessException {
		Class<?> clazz = obj.getClass();
		
		for (Field field : clazz.getDeclaredFields()) {
			if (field.isAnnotationPresent(CheckLength.class)) {
				CheckLength anno =  field.getAnnotation(CheckLength.class);
				
				field.setAccessible(true);
				String value =  (String)field.get(obj);
				//---------------------------------
				if (value == null || value.length() < anno.min() || value.length() > anno.max()) {
					System.out.println("ERROR:" + anno.message());
				}else {
					System.out.println("OK:" + field.getName() + ":" + value);
				}
			}
		}
	}
}