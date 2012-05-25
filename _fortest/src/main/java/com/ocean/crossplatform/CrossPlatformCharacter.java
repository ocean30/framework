package com.ocean.crossplatform;

import java.util.Enumeration;
import java.util.Set;

import org.apache.log4j.Logger;

/**
 * Java��һ����ƽ̨�����ԣ���Ϊ�����дһ����ƽ̨���������Щ��������Ҫ���ǣ����绻�С�
�ڲ�ͬ��ƽ̨�ϣ����з������ǲ�ͬ�ģ����磺
    Macƽ̨��\r
    Unix��Linux��\n
    Windows��Http��\r\n
    Unicode��׼:\u2028
���Ե���Ҫ����ʱ��ͨ������ʹ��line.separator��ϵͳ����:System.getProperty("line.separator");
�������������дһ�����������߷�������������ҪӲ����Ϊ"\r\n"����������ѡ��ƽ̨��
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
