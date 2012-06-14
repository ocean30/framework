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
//		dynamicCreateArray();
		getDimensionOfArray();
	}

	/**
	 * 
	 */
	public static void getDimensionOfArray() {
		int[][] array = new int[2][5];
		System.out.println(array.length);
		System.out.println(array[0].length);
	}

	/**
	 * 
	 */
	public static void dynamicCreateArray() {
//		int length = 2;
//		int[] x = { length };
		Object intArray = Array.newInstance(int.class, 1);
		Array.set(intArray, 0, 5);
		System.out.println(" " + Array.getInt(intArray, 0));
	}

}
