package com.banclogix.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TestLinkedBlockingQueue {
	
//	private static final BlockingQueue <Integer>  stringQueue = new LinkedBlockingQueue<Integer>();
//	private static final SynchronousQueue <Integer>  stringQueue = new SynchronousQueue<Integer>();
//	private static final Queue <String>  stringQueue = new LinkedList<String>();
	
//	private boolean running = true;
	
//	private static  CounterWithNonblocking addNum = new CounterWithNonblocking() ;
//	private static  CounterWithNonblocking addNum1 = new CounterWithNonblocking() ;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//result LinkedBlockingQueue not thread safe
		start();
	}

	private static void start() {
		Thread[] adderList = new Thread[1000] ;
		Thread[] takerList = new Thread[1000] ;
		
		final BlockingQueue <Integer>  stringQueue = new LinkedBlockingQueue<Integer>();
		final CounterWithNonblocking addNum = new CounterWithNonblocking() ;
		Adder adder = new Adder(stringQueue,addNum);
		Taker taker = new Taker(stringQueue,addNum);
		
		//4 thread adder
		for(int i =0 ; i<2 ; i++){
			adderList[i] = new Thread(adder,"adder:" + i );
		}
		//10 thread taker
		for(int i =0 ; i<2 ; i++){
			takerList[i] = new Thread(taker,"taker:" + i );
		}
		
		//start all thread
		for(int i =0 ; i<2 ; i++){
			adderList[i].start();
			takerList[i].start();
		}
		
	}


}


class Taker implements Runnable{
	private final BlockingQueue<Integer>  stringQueue ;
	private final CounterWithNonblocking addNum ;
	
	private boolean running = true ;
	
	public Taker(BlockingQueue<Integer> stringQueue,CounterWithNonblocking addNum){
		this.stringQueue = stringQueue ;
		this.addNum = addNum ;
	}
	@Override
	public void run() {
		while(running){
			try {	
				synchronized (addNum) {
					System.out.println(stringQueue.take() +" " + Thread.currentThread().getName() + " take.");
				}
//					synchronized (addNum) {
//						System.out.println(addNum.getValue());
//					}
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e);
				continue;
			} catch (Exception e) {
				System.out.println(e);
				continue;
			}
		}			
	}		
}

class Adder implements Runnable{
	private final BlockingQueue<Integer>  stringQueue ;
	private final CounterWithNonblocking addNum ;
	private boolean running = true ;
	
	public Adder(BlockingQueue<Integer> stringQueue, CounterWithNonblocking addNum){
		this.stringQueue = stringQueue ;
		this.addNum = addNum ;
	}
	@Override
	public void run() {
		while(running){
			try {
//					String str="";
//					synchronized (addNum1) {
//						str=Thread.currentThread().getName() + " add num: " + addNum.increment();			
//				addNum.increment();
//					if(stringQueue.offer(addNum.getValue())) 
//					stringQueue.add(addNum.getValue());
				stringQueue.add(addNum.increment());
//					}
//					addNum.increment();
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println(e);
				continue;
			}
		}			
	}		
}