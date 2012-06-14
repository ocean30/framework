package com.ocean.inheritability;
/**
 *@author zhengzh
 *@version 1.0 2012-6-4
 */
public class InheritabilityTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Student student = null ; //new Student();
		String name = "Ocean";
//		student.sayHello(name );
//		student.sayGoodBye(name);
		Person person = student ;
//		person.sayHello(name);
		Student student1 = (Student) person ;
//		student1.sayHello(name);
//		student1.sayGoodBye(name);
	}

}
