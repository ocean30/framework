package com.ocean.domain;
/**
 *@author zhengzh
 *@version 1.0 2012-5-24
 */
public class Student extends Person {

	@Override
	public void setName(String name) {
		super.setName("student-" + name);
	}

}
