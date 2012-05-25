package com.ocean.instansof;
/**
 *@author zhengzh
 *@version 1.0 2012-5-25
 */
public class InstansofTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "I AM an Object!";  
		boolean isObject = s instanceof Object;
		System.out.println(isObject);
	}

}
