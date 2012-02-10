package com.banclogix.test;

import org.apache.log4j.Logger;

/**
 * 递归大约4K次就会内存溢出
 *@author zhengzh
 *@version 1.0 2012-2-3
 */
public class RecusiveTest {
	private static Logger logger = Logger.getLogger(RecusiveTest.class);
	
	private static int recusiveCounter = 0 ;

	private static void findException4Recusive(){
		logger.info("Recusive count: " + (++recusiveCounter));
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			logger.error("findException4Recusive error: " + e);
		}
		findException4Recusive();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try{
			findException4Recusive();
		}catch(Error e) {
			logger.error("error in main: " + e );
		}
		long end = System.currentTimeMillis();
		logger.info("use time: " + (end-start) + "ms");
	}

}
