package com.ocean.thread.threadlocal;
/**
 *@author zhengzh
 *@version 1.0 2012-6-1
 */
public class ThreadLocalTest {

	private static final ThreadLocal<String> context = new ThreadLocal<String>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		context.set("zhangsan");

		Object object = context.get();
		System.out.println(object.getClass().getName());
	}

}
