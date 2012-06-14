package com.ocean.timeuse;

import org.apache.log4j.Logger;

/**
 * 记录执行一条log4j的日志记录所需要的时间
 * 记录执行一条while循环判断所需要的时间
 * @author zhengzh
 *
 */
public class TimeUseReport {
	private static Logger logger = Logger.getLogger(TimeUseReport.class);
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//manual calculate, not exact.
		//log4j result: 2612663 nano ~ 2.6 micro
//		log.info("log4j start time: " + System.nanoTime());
//		log.info(TimeUseReport.class + "log execute.");
//		log.info("log4j end time: " + System.nanoTime());
//		
//		//log4j just string result: 217752 nano ~ 0.22 micro
//		log.info("log4j start time: " + System.nanoTime());
//		log.info("log execute.");
//		log.info("log4j end time: " + System.nanoTime());
//		
//		boolean flag = false ;
//		//while condition result: 32609 nano ~ 0.033 micro ~ 33 micro 
//		log.info("while condition start time: " + System.nanoTime());
//		while(flag){
//		}
//		log.info("while condition end time: " + System.nanoTime());
//		
//		log.info();
//		log.info();
		
		//automatic calculate exactly
		long start = 0;
		long end = 0 ;
		while(true){
		System.out.println("test begin.");
		logger.info("test begin.");
		//syso just string result: 68115 nano ~ 117 micro
		start = System.nanoTime() ;
		System.out.println(TimeUseReport.class + " log execute.");
		end = System.nanoTime() - start ;
		logger.info("syso use time: " + end + " nanosecond.");
		
		//syso just string result: 68115 nano ~ 117 micro
		start = System.nanoTime() ;
		System.out.println("log execute.");
		end = System.nanoTime() - start ;
		logger.info("syso use time: " + end + " nanosecond.");
		
		//log4j result: 2323897 nano ~ 232 micro
		start = System.nanoTime() ;
		logger.info(TimeUseReport.class + "log execute.");
		end = System.nanoTime() - start ;
		logger.info("log4j use time: " + end + " nanosecond.");
		
		//log4j just string result: 116666 nano ~ 117 micro
		start = System.nanoTime() ;
		logger.info("log execute.");
		end = System.nanoTime() - start ;
		logger.info("log4j use time: " + end + " nanosecond.");
		
		//while condition result: 362 nano ~ 0.36 micro 
		boolean flag1 = false ;
		start = System.nanoTime() ;
		while(flag1){
			flag1 = false ;
		}
		end = System.nanoTime() - start ;
		logger.info("while condition use time: " + end + " nanosecond.");
		
		//
		start = System.nanoTime() ;
//		end = System.currentTimeMillis();
		end = System.nanoTime() - start ;
		logger.info("nanoTime() method use time: " + end + " nanosecond.");
		}
	}
		
}
