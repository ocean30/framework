package com.ocean.numeric;

import java.math.BigDecimal;

/**
 *@author zhengzh
 *@version 1.0 2012-5-16
 */
public class BigdecimalTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BigDecimal bd = new BigDecimal("1.00000");
		BigDecimal bd1 = new BigDecimal("1");
		if(bd.compareTo(bd1) == 0){
			System.out.println("yes");
		}
		Double i = new Double("1.00000");
		Double i1 = new Double("1");
		if(i.compareTo(i1) == 0){
			System.out.println("yes");
		}
		if(i==i1){
			System.out.println("yes");
		}
	}

}
