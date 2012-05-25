package com.ocean.test;

import org.apache.log4j.Logger;

/**
 *@author zhengzh
 *@version 1.0 2012-1-9
 */
public class StringSplit {
	private static Logger logger = Logger.getLogger(StringSplit.class);
	
	public static void main(String[] args){
		String str = "Hello world.";
		logger.info(new String(str.getBytes(),2,4));
		String str1 = "";
		logger.info(str1.length());
	}
}
