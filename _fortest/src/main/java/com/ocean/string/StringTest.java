package com.ocean.string;

/**
 * @author zhengzh
 * @version 1.0 2012-5-25
 */
public class StringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		useMethod();
		String str = "123\0";
		System.out.println(str);
		System.out.println("---" + str.indexOf("\0"));
		String str1 = str.substring(0, str.indexOf("\0"));
		System.out.println(str1);
		String str2 = str.replace("\0", "");
		System.out.println(str2);
	}

	/**
	 * 
	 */
	public static void useMethod() {
		String a = "foo";
		String b = "foo";
		System.out.println("a==b? " + (a==b?"yes":"no"));
	}

}
