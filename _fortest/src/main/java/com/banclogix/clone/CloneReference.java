package com.banclogix.clone;

import com.banclogix.domain.Person;

/**
 *@author zhengzh
 *@version 1.0 2012-5-5
 */
public class CloneReference {

	/**
	 * @param args
	 * @throws CloneNotSupportedException 
	 */
	public static void main(String[] args) throws CloneNotSupportedException {
		Person person = new Person("zhangsan","man",18);
		System.out.println("person;" + person);
		Person person2 = (Person) person.clone();
		System.out.println("person2;" + person2);
		Person person3 = person;
		System.out.println("person3;" + person3);
	}

}
