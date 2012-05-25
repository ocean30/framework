package com.banclogix.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

import com.banclogix.domain.Person;

/**
 * @author zhengzh
 * @version 1.0 2012-5-24
 */
public class DynamicProxyTest {

	/**
	 * @param args
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 */
	public static void main(String[] args) throws IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		InvocationHandler handler = new MyInvocationHandler();
		Class proxyClass = Proxy.getProxyClass(Person.class.getClassLoader(),
				new Class[] { Person.class });
		Person f = (Person) proxyClass.getConstructor(
				new Class[] { InvocationHandler.class })
				.newInstance(new Object[] { handler });
		
		Person p = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(),
                new Class[] { Person.class },
                handler);


	}
}
