package com.ocean.nio;

import java.io.IOException;
import java.nio.channels.Selector;

/**
 *@author zhengzh
 *@version 1.0 2012-5-26
 */
public class MyNioTest {
	public static void main(String[] args) throws IOException, InterruptedException {
		int maxSize = 32767 ;
		Selector[] selectors = new Selector[maxSize] ;
		for(int i =0; i<maxSize ; i++){
			selectors[i] = Selector.open();
			Thread.sleep(5000);
		}
		Thread.sleep(30000);
	}
}
