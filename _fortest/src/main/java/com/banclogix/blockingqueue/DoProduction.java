package com.banclogix.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class DoProduction implements Runnable {
	private final BlockingQueue<String> queue;

	DoProduction(BlockingQueue<String> q) {
		queue = q;
	}

	public void run() {
		try {
			System.out.println("Start " + Thread.currentThread().getName());

			String value = queue.take();
			while (!value.equals("*")) {
				// System.out.println
				// (Thread.currentThread().getName()+": " + value );
				/*
				 * do something with value
				 */
				System.out.println(Thread.currentThread().getName() + " " + value);
				value = queue.take();
			}
		} catch (Exception e) {
			System.out.println(Thread.currentThread().getName() + " " + e.getMessage());
		}
	}
}