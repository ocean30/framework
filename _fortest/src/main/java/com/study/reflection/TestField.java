package com.study.reflection;

import java.lang.reflect.Field;


public class TestField {
	public double d;
	
	public static void main(String[] args) throws Exception {
		Class c = Class.forName("com.study.reflection.TestField");
		Field f = c.getField("d");
		TestField obj = new TestField();
		System.out.println("d = " + (Double)f.get(obj));
		f.set(obj, 12.34);
		System.out.println("d = "+ obj.d);
		
	}

}
