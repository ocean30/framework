package com.ocean.classloadsequence;
/**
 *@author zhengzh
 *@version 1.0 2012-3-23
 */
public class ClassLoadSequenceOfField {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new PersonFacade() ;
	}

}

class Person {
	public Person(String name){
		System.out.println("Hello " + name);
	}
}

class Student extends Person {
	public Student(String name){
		super(name);
	}
}

class Worker extends Person {
	public Worker(String name){
		super(name);
	}
}

class PersonFacade {
	{
		Person other = new Person("other");
	}
	private Person worker = new Person("worker");
	private Person student = new Person("student");
	
}