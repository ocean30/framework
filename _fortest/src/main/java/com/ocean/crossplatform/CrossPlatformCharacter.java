package com.ocean.crossplatform;

import java.util.Enumeration;
import java.util.Set;

import org.apache.log4j.Logger;

/**
 * Java是一个跨平台的语言，因为如果想写一个跨平台的软件，有些东西就需要考虑，例如换行。
在不同的平台上，换行符可能是不同的，例如：
    Mac平台：\r
    Unix或Linux：\n
    Windows或Http：\r\n
    Unicode标准:\u2028
所以当需要换行时，通常建议使用line.separator的系统属性:System.getProperty("line.separator");
不过如果你是在写一个网络程序或者服务器程序，则需要硬编码为"\r\n"，而不管所选的平台。
 *@author zhengzh
 *@version 1.0 2012-3-14
 */
public class CrossPlatformCharacter {
	private static Logger logger = Logger.getLogger(CrossPlatformCharacter.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//cross-platform
		logger.info("line.separator " + System.getProperty("line.separator"));
		
		//all system properties
		Enumeration<Object> keys = System.getProperties().keys();
		while(keys.hasMoreElements()){
			String key = (String) keys.nextElement() ;
			System.out.print( key + "\t");
			System.out.println(System.getProperty(key));
		}
		
		//all system properties
		Set<String> names = System.getProperties().stringPropertyNames();
		for(String name : names){
			System.out.print( name + "\t");
			System.out.println(System.getProperty(name));
		}
//		Properties props = System.getProperties();
//		for(Object p : keys){
//			
//		}
//		logger.info("props " + props);
		
		
	}

}
