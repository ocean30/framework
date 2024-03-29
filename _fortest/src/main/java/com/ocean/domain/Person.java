package com.ocean.domain;
/**
 *@author zhengzh
 *@version 1.0 2012-5-5
 */
public class Person implements Cloneable {
	private String name ;
	private String sex ;
	private int age ;
	
	public Person() {
		super();
	}
	public Person(String name, String sex, int age) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
}
