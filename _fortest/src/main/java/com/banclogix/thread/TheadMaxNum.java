package com.banclogix.thread;

import org.apache.log4j.Logger;

/**
 * 测试同时最多能创建多少个线程
 * 结论: 1.子线程出异常不会影响主线程,因此子线程必须捕获异常( 在run方法中捕获所有Throwable异常 )
 * 		   2.同时( 1S内 )创建4972就会出现异常( java.lang.OutOfMemoryError: unable to create new native thread ),也就是说系统同时最多只能拥有大概5000线程
 * 		   3.线程的增长速率必须小于线程的消亡速率,否则会出现 java.lang.OutOfMemoryError: unable to create new native thread异常
 * 注:一个Timer 也是一个线程
 *@author zhengzh
 *@version 1.0 2012-2-22
 */
public class TheadMaxNum {
	protected static Logger logger = Logger.getLogger(TheadMaxNum.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int threadNum = 0 ;
		try{
//		Thread t = null ;
		while(threadNum<100000){
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(700);
//						wait(1000);
					} catch (InterruptedException e) {
						logger.error(e);
					}/*catch (Throwable t){
						logger.error(t);
					}*/
				}
			},"myThread").start();
			logger.info("threadNum: "+(++threadNum));
		}
		}catch (Exception e){	//Exception不能捕获OutOfMemoryError异常
			logger.error(e);
		}catch (Throwable t ){	//Throwable能捕获OutOfMemoryError异常
			logger.error(t);
		}
	}

}
