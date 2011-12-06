package com.banclogix.synchronized1;

import java.util.ArrayList;
import java.util.List;

public class Queue {
	
	private List<Message> queue = new ArrayList<Message>();
	
	/** ������message��������ֵ,Ĭ��Ϊ5 */
	private int maxMessageNum = 5;

	public synchronized void produce(Message message) {
		this.notifyAll();
		while (queue.size() == maxMessageNum) {
			System.out.println(Thread.currentThread().getName() + " ���������ȴ��С�����");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		queue.add(message);
		System.out.println(Thread.currentThread().getName() + "��������" + message.getContent() + "������ ,��ǰ����:" + getCount());
	}

	public synchronized void consume() {
		this.notifyAll();
		while (queue.size() == 0) {
			System.out.println(Thread.currentThread().getName() + " ���пգ��ȴ��С�����");
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
		System.out.println(Thread.currentThread().getName() + "��������" + message.getContent() + "������ ,��ǰ����: "
				+ getCount());
	}

	public synchronized int getCount() {
		return queue.size();
	}
}