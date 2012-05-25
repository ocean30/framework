package com.ocean.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Test {
  public static void main(String[] args) throws Exception {
        
    BlockingQueue<String> q = new LinkedBlockingQueue<String>();

    Thread p1 = new Thread(new PrepareProduction(q));
    Thread c1 = new Thread(new DoProduction(q));
    Thread c2 = new Thread(new DoProduction(q));
    Thread c3 = new Thread(new DoProduction(q));
    Thread c4 = new Thread(new DoProduction(q));
    Thread c5 = new Thread(new DoProduction(q));
    Thread c6 = new Thread(new DoProduction(q));
    Thread c7 = new Thread(new DoProduction(q));
    Thread c8 = new Thread(new DoProduction(q));
    Thread c9 = new Thread(new DoProduction(q));
       
    p1.start();
    c1.start();
    c2.start();
    c3.start();
    c4.start();
    c5.start();
    c6.start();
    c7.start();
    c8.start();
    c9.start();
 
    p1.join();
    c1.join();
    c2.join();
    c3.join();
    c4.join();
    c5.join();
    c6.join();
    c7.join();
    c8.join();
    c9.join();
       
    System.out.println("Done.");
  }
}