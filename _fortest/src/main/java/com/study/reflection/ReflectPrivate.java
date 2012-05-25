package com.study.reflection;

import java.lang.reflect.Field;

public class ReflectPrivate {

	public static void main(String[] args) throws Exception{
		privateTest pt = new privateTest();
		Class<?> clazz = privateTest.class;
		
		Field field = clazz.getDeclaredField("name");
		
		field.setAccessible(true);
		
		System.out.println(field.get(pt));
		
		field.set(pt, "world");
		
		System.out.println(pt.getName());
	}

}

class privateTest {
	private String name = "hello";

	public String getName() {
		return name;
	}

}
