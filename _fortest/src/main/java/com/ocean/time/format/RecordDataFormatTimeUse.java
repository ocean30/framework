package com.ocean.time.format;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试new Date 和format date所需要的时间
 *@author zhengzh
 *@version 1.0 2012-5-30
 */
public class RecordDataFormatTimeUse {

	private static SimpleDateFormat dateFormat = new SimpleDateFormat() ;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(dateFormat.toLocalizedPattern());
		System.out.println(dateFormat.toPattern());
		
		dateFormat.applyLocalizedPattern(dateFormat.toLocalizedPattern());
		String dateStr = dateFormat.format(new Date());
		System.out.println(dateStr);
		
		dateFormat.applyPattern(dateFormat.toPattern());
		String dateStr1 = dateFormat.format(new Date());
		System.out.println(dateStr1);
		
		dateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
		long startTime = System.nanoTime();
		Date date = new Date() ;
		long dateUseTime = System.nanoTime() - startTime;
		String formatDate = dateFormat.format(date);
		long formatUseTime = System.nanoTime() - startTime;// - dateUseTime ;
		System.out.println("formatDate: " + formatDate);
		System.out.println("dateUseTime: " + dateUseTime +" formatUseTime: " + formatUseTime );
		
		
	}

}
