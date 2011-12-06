package com.banclogix.synchronized1;

import java.util.ArrayList;
import java.util.List;

public class Queue {
	
	private List<Message> queue = new ArrayList<Message>();
	
	/** 队列中message对象的最大值,默认为5 */
	private int maxMessageNum = 5;

	public synchronized void produce(Message message) {
		this.notifyAll();
		while (queue.size() == maxMessageNum) {
			System.out.println(Thread.currentThread().getName() + " 队列满！等待中。。。");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		queue.add(message);
		System.out.println(Thread.currentThread().getName() + "正在生产" + message.getContent() + "。。。 ,当前个数:" + getCount());
	}

	public synchronized void consume() {
		this.notifyAll();
		while (queue.size() == 0) {
			System.out.println(Thread.currentThread().getName() + " 队列空！等待中。。。");
			try {
				System.out.println("begin!");
				wait();
				System.out.println("end!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Message message = queue.get(0);
		queue.remove(0);
		System.out.println(Thread.currentThread().getName() + "正在消费" + message.getContent() + "。。。 ,当前个数: "
				+ getCount());
	}

	public synchronized int getCount() {
		return queue.size();
	}
}