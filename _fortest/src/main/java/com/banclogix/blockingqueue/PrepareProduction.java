package com.banclogix.blockingqueue;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.BlockingQueue;

public class PrepareProduction implements Runnable{
  private final BlockingQueue<String> queue;
 
  PrepareProduction(BlockingQueue<String> q) {
	  queue = q; 
  }
 
  public void run() {
    String thisLine;
    System.out.println("Start PrepareProduction");
    FileInputStream fin =  null;
    BufferedReader input = null;
    try {
    	fin =  new FileInputStream("d:/input_data.dat");
    	input = new BufferedReader(new InputStreamReader(fin));
       while ((thisLine = input.readLine()) != null) {
           queue.put(thisLine);
       }
       // special marker for the consumer threads
       // to mark the EOF
       queue.put("*");
       queue.put("*");
       queue.put("*");
       queue.put("*");
       queue.put("*");
       queue.put("*");
       queue.put("*");
       queue.put("*");
       queue.put("*");
    }
    catch (Exception e) {
       e.printStackTrace();
    }finally{
    	 try {
    		 if(fin != null)
    			 fin.close();
    		 if(input != null)
    			 input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
  }
}