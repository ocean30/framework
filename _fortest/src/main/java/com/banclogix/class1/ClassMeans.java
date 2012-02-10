package com.banclogix.class1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

/**
 * show *.class's value
 *@author zhengzh
 *@version 1.0 2012-2-7
 */
public class ClassMeans {
	private static Logger logger = Logger.getLogger(ClassMeans.class);

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		logger.info(String.class);
		logger.info(void.class);
		logger.info(int.class);
		logger.info(ClassMeans.class);
		logger.info(ClassMeans[].class);
		logger.info(Integer.class);
		logger.info(double[].class);
		logger.info(int[].class);
		logger.info(long[].class);
		logger.info(List.class);
		logger.info(ArrayList.class);
		logger.info(List[].class);
		logger.info(Set.class);
		logger.info(Set[].class);
		logger.info(Integer[].class);
	}

}
