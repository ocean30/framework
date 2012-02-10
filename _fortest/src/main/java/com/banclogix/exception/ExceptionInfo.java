package com.banclogix.exception;

import org.apache.log4j.Logger;

import com.banclogix.class1.ClassMeans;

/**
 * show exception info
 *@author zhengzh
 *@version 1.0 2012-2-8
 */
public class ExceptionInfo {
	private static Logger logger = Logger.getLogger(ClassMeans.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			throw new NullPointerException();
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e +" " + e.getMessage());
			logger.error(e.toString());
		}

	}

}
