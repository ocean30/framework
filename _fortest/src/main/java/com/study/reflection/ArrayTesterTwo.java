package com.study.reflection;

import java.lang.reflect.Array;

public class ArrayTesterTwo {

	public static void main(String[] args) {
		int[] dims = new int[] { 5, 10, 15 };
		Object array = Array.newInstance(Integer.TYPE, dims);//array是个三维数组
		
		Object arrayObj = Array.get(array, 3);//此时的arrayObj是个二维数组
		
//		Class<?> cls = arrayObj.getClass().getComponentType();
		
		arrayObj = Array.get(arrayObj, 5);//此时的arrayObj是个一维数组
		
		Array.set(arrayObj, 10, 89);
		
		int[][][] arrayCast = (int[][][]) array;
		
		System.out.println(arrayCast[3][5][10]);
	}

}
