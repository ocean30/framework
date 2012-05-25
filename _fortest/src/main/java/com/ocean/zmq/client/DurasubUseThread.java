package com.ocean.zmq.client;

import org.zeromq.ZMQ;

/**
 * @author Lusen
 */
public class DurasubUseThread extends Thread {
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			DurasubUseThread sub = new DurasubUseThread();
			sub.start();
			try {
				sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread " + i);
		}

	}

	public void run() {
		ZMQ.Context context = ZMQ.context(1);

		// Connect our subscriber socket
		ZMQ.Socket subscriber = context.socket(ZMQ.SUB);
		subscriber.setIdentity("hello".getBytes());

		// Synchronize with the publisher
		ZMQ.Socket sync = context.socket(ZMQ.PUSH);

		subscriber.subscribe("".getBytes());
		subscriber.connect("tcp://172.20.1.192:5565");
		sync.connect("tcp://172.20.1.192:5564");
		sync.send("".getBytes(), 0);

		// Get updates, expect random Ctrl-C death
		String msg = "";
		while (!msg.equalsIgnoreCase("END")) {
			msg = new String(subscriber.recv(0));
			// System.out.println(msg);
		}
	}
}
