package com.ocean.array;

import java.lang.reflect.Array;

/**
 * @author zhengzh
 * @version 1.0 2012-5-25
 */
public class ArrayTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int length = 2;
		int[] x = { length };
		Object intArray = Array.newInstance(int.class, 1,2,5);
		Array.set(intArray, 1, 5);
		System.out.println(" " + Array.getInt(intArray, 1));
	}

}
