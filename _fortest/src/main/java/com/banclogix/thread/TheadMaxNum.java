package com.banclogix.thread;

import org.apache.log4j.Logger;

/**
 * ����ͬʱ����ܴ������ٸ��߳�
 * ����: 1.���̳߳��쳣����Ӱ�����߳�,������̱߳��벶���쳣( ��run�����в�������Throwable�쳣 )
 * 		   2.ͬʱ( 1S�� )����4972�ͻ�����쳣( java.lang.OutOfMemoryError: unable to create new native thread ),Ҳ����˵ϵͳͬʱ���ֻ��ӵ�д��5000�߳�
 * 		   3.�̵߳��������ʱ���С���̵߳���������,�������� java.lang.OutOfMemoryError: unable to create new native thread�쳣
 * ע:һ��Timer Ҳ��һ���߳�
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
		}catch (Exception e){	//Exception���ܲ���OutOfMemoryError�쳣
			logger.error(e);
		}catch (Throwable t ){	//Throwable�ܲ���OutOfMemoryError�쳣
			logger.error(t);
		}
	}

}
