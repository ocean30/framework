package com.banclogix.timeuse;

import org.apache.log4j.Logger;

/**
 * 记录执行一条log4j的日志记录所需要的时间
 * 记录执行一条while循环判断所需要的时间
 * @author zhengzh
 *
 */
public class TimeUseReport {
	private static Logger log = Logger.getLogger(TimeUseReport.class);
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//manual calculate, not exact.
		//log4j result: 2612663 nano ~ 2.6 micro
//		System.out.println("log4j start time: " + System.nanoTime());
//		log.info(TimeUseReport.class + "log execute.");
//		System.out.println("log4j end time: " + System.nanoTime());
//		
//		//log4j just string result: 217752 nano ~ 0.22 micro
//		System.out.println("log4j start time: " + System.nanoTime());
//		log.info("log execute.");
//		System.out.println("log4j end time: " + System.nanoTime());
//		
//		boolean flag = false ;
//		//while condition result: 32609 nano ~ 0.033 micro ~ 33 mill 
//		System.out.println("while condition start time: " + System.nanoTime());
//		while(flag){
//		}
//		System.out.println("while condition end time: " + System.nanoTime());
//		
//		System.out.println();
//		System.out.println();
		
		//automatic calculate exactly
		long start = 0;
		long end = 0 ;
		
		//log4j result: 2323897 nano ~ 232 mill
		start = System.nanoTime() ;
		log.info(TimeUseReport.class + "log execute.");
		end = System.nanoTime() - start ;
		System.out.println("log4j end time: " + end);
		
		//log4j just string result: 116666 nano ~ 117 mill
		start = System.nanoTime() ;
		log.info("log execute.");
		end = System.nanoTime() - start ;
		System.out.println("log4j end time: " + end);
		
		//while condition result: 362 nano ~ 0.36 mill 
		boolean flag1 = false ;
		start = System.nanoTime() ;
		while(flag1){
		}
		end = System.nanoTime() - start ;
		System.out.println("while condition end time: " + end);
	}

}
