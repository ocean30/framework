package com.banclogix.testkdf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;

/**
 * @author zhengzh
 * @version 1.0 2012-2-22
 */
public class KDFMaxConnection {
	private static final Logger logger = Logger.getLogger(KDFMaxConnection.class);

	private static String ip = "127.0.0.1";
	private static int port = 12000;
	private static int maxThreadNum = 500 ;
	
//	private static List<Thread> 

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		ConnectionThread ct = new ConnectionThread() ;
		int threadNum = 0;
		while (threadNum < maxThreadNum) {
			new Thread( ct , "myThread").start();
//			if(threadNum%100 == 0)
			Thread.sleep(100);
			logger.info("threadNum: " + (++threadNum));
		}
	}

	static class ConnectionThread implements Runnable {
		@Override
		public void run() {
			Socket s = null;
			OutputStream os = null;
			BufferedReader br = null;
			try {
				s = new Socket(ip, port);
				os = s.getOutputStream() ;
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				os.write("kdf\r\n".getBytes());
				os.flush();
				os.write("kdf\r\n".getBytes());
				os.flush();
//				Thread.sleep(10000);
				String msg = null ;
				while ((msg = br.readLine()) != null) {
					try {
//						synchronized(this){
//							this.wait();
//						}
//						System.out.println(KDFUtility.timeFormat(new Date()));
						logger.debug(msg);
					} catch (Exception e) {
						logger.error(e);
					}
				}
			} catch (Throwable t) {
				logger.error(t);
				t.printStackTrace();
			} finally{
				logger.info(s + " closed.");
				close(s,os,br);
			}
		}

		private void close(Socket s, OutputStream os, BufferedReader br) {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
