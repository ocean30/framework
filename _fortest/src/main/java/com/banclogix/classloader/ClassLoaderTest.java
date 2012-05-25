package com.banclogix.classloader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import com.banclogix.domain.Person;

/**
 *@author zhengzh
 *@version 1.0 2012-5-24
 */
public class ClassLoaderTest {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
//		classLoaderParent();
//		useClassLoaderLoadClass();
		useClassLoadStream();
//		printClassName(new ClassLoaderTest());
	}
	
	public static void printClassName(Object obj) {
        System.out.println("The class of " + obj +
                           " is " + obj.getClass().getName());
    }


	private static void useClassLoadStream() throws IOException {
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		System.out.println("cl: " + cl);
		URL url = cl.getResource("");
		if( url != null){
			System.out.println(url.getPath());
			System.out.println(url.getContent());
			System.out.println(url.getContent());
			System.out.println(url.getContent());
		}
		InputStream is = cl.getResourceAsStream("com/");
		byte[] buffer = new byte[8019];
		is.read(buffer, 0, buffer.length);
		System.out.println("length: " + buffer.length + " data: " + new String(buffer));
	}

	/**
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static void useClassLoaderLoadClass() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		Class<?> clazz = cl.loadClass("com.banclogix.domain.Person");
		Person person = (Person) clazz.newInstance();
		person.setName("ocean");
		System.out.println(person.getName());
	}

	/**
	 * 
	 */
	public static void classLoaderParent() {
		//sun.misc.Launcher$AppClassLoader
		ClassLoader cl = ClassLoaderTest.class.getClassLoader();// == ClassLoader.getSystemClassLoader();
		System.out.println(cl.getClass().getName());
		//sun.misc.Launcher$ExtClassLoader
		ClassLoader cl1 = ClassLoader.getSystemClassLoader().getParent();
		System.out.println(cl1.getClass().getName());
		//Exception in thread "main" java.lang.NullPointerException
		ClassLoader cl2 = ClassLoader.getSystemClassLoader().getParent().getParent();
		if(cl2 != null)
			System.out.println(cl2.getClass().getName());
	}

}
