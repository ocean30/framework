package com.ocean.socket;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;

/**
 *@author zhengzh
 *@version 1.0 2011-12-23
 */
public class TestConnectionUseTime {
	private static Logger logger = Logger.getLogger(TestConnectionUseTime.class);
	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		long beginTime = 0;
		long endTime =0 ;
		beginTime = System.nanoTime();
		Socket s = new Socket("172.20.0.15",12000);
		endTime = System.nanoTime() - beginTime ;
//		long useTime = endTime - beginTime ;
		logger.info("Connection to server use time : " + (endTime) + " nano seconds.");
		s.close();
//		logger.info("Connection to server use time : " + (useTime) + " mill seconds.");
		beginTime = System.nanoTime();
		Socket s1 = new Socket("198.190.11.21",4001);
		endTime = System.nanoTime() - beginTime ;
//		long useTime = endTime - beginTime ;
		logger.info("Connection to server use time : " + (endTime) + " nano seconds.");
		s1.close();
		
//		Socket s = new Socket();
//		long beginTime = System.nanoTime();
//		long endTime = System.nanoTime() ;
//		long useTime = endTime - beginTime ;
//		logger.info("Connection to server use time : " + (useTime/1000) + " micro seconds.");
	}

}
