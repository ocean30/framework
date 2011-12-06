package com.banclogix.synchronized2;

import java.util.List;

public class Product implements Runnable {
	private List<Object> container = null;
	private int count;

	public Product(List<Object> lst) {
		this.container = lst;
	}

	public void run() {
		while (true) {
			synchronized (container) {
				if (container.size() > MultiThread.MAX) {
					try {
						container.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				container.add(new Object());
				container.notify();
				System.out.println("我生产了" + (++count) + "个");
			}
		}
	}
}