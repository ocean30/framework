package com.ocean.others;

import java.util.concurrent.TimeoutException;

public class TestCatchReturnFinallyRun {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 0 ;
		try {
			throw new TimeoutException();
		} catch (TimeoutException e) {
			i++;
			return ;
			//e.printStackTrace();
		}finally{
			System.out.println(i);
			i++;
		}
		//static error Unreachable code
		//System.out.println(i);
		
	}

}
