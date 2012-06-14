package com.ocean.inheritability;
/**
 *@author zhengzh
 *@version 1.0 2012-6-4
 */
public class Student implements Person {

	@Override
	public void sayHello(String name) {
		System.out.println("hello " + name);
	}
	
	public void sayGoodBye(String name){
		System.out.println("good bye " + name);
	}

}
