package com.study.reflection;

import java.lang.reflect.Method;

public class DumpMethods {

	// 从命令行接受一个字符串(该字符串是某个类的全名)
	// 打印出该类中的所有方法声明
	public static void main(String[] args) throws ClassNotFoundException {
		args = new String[]{ "com.study.reflection.TestField" } ;
		// Class类是java反射的入口点
		Class<?> classType = Class.forName(args[0]);

		Method[] methods = classType.getDeclaredMethods();

		for (Method method : methods) {
			System.out.println(method);

		}
	}

}
