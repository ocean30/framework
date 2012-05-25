package com.study.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTester {

	public Object copy(Object object) throws Exception {
		Class<?> classType = object.getClass();
		System.out.println(classType.getName());

		Object objectCopy = classType.getConstructor(new Class[] {}).newInstance(new Object[] {});
		// 上面这行代码等价于
		// Object objectCopy = classType.newInstance();

		// 获得对象的所有属性
		Field[] fields = classType.getDeclaredFields();

		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			String fieldName = field.getName();
//			System.out.println("field: " + field);
//			System.out.println("fieldName: " + fieldName);
			// 获得属性的首字母并转换为大写
			String firstLetter = fieldName.substring(0, 1).toUpperCase();

			// 获得和属性对应的getXXX()方法的名字
			String getMethodName = "get" + firstLetter + fieldName.substring(1);
			// 获得和属性对应的setXXX()方法的名字
			String setMethodName = "set" + firstLetter + fieldName.substring(1);

			Method getMethod = classType.getMethod(getMethodName, new Class[] {});
			Method setMethod = classType.getMethod(setMethodName, new Class[] { field.getType() });

			Object value = getMethod.invoke(object, new Object[] {});

			// System.out.println(fieldName + ":" + value);

			setMethod.invoke(objectCopy, new Object[] { value });
		}

		return objectCopy;
	}

	public static void main(String[] args) throws Exception {
		Customer customer = new Customer();
		customer.setId(new Long(1));
		customer.setName("chang");
		customer.setAge(23);

		Customer customerCopy = (Customer) new ReflectTester().copy(customer);

		System.out.println(customerCopy.getId() + "," + customerCopy.getName() + "," + customerCopy.getAge());
	}
}

class Customer {
	private Long id;
	private String name;
	private int age;

	public Customer() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}