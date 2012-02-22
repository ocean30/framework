package com.banclogix.calendar;

import java.util.Calendar;

import org.apache.log4j.Logger;

/**
 *@author zhengzh
 *@version 1.0 2012-2-20
 */
public class CalendarTime {
	private static final Logger logger = Logger.getLogger(CalendarTime.class);
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Calendar cal = Calendar.getInstance();
		Thread.sleep(1000);
		Calendar cal1 = Calendar.getInstance();
		logger.info(cal.getTime());
		logger.info(cal1.getTime());
	}

}
