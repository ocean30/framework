package com.banclogix.zmq.server;

import org.zeromq.ZMQ;

/**
 * @author Lusen
 */
public class DurapubServer {
	public static void main(String[] args) throws InterruptedException {
//		System.out.println(System.getProperty("java.library.path"));
		ZMQ.Context context = ZMQ.context(1);
		ZMQ.Socket publisher = context.socket(ZMQ.PUB);

		// Subscriber tells us when it's ready here
		ZMQ.Socket sync = context.socket(ZMQ.PULL);

		sync.bind("tcp://*:5564");

		// We send updates via this socket
		publisher.bind("tcp://*:5565");

		// Wait for synchronization request
		sync.recv(0);

		// Now broadcast exactly 10 updates with pause
		for (int i = 0; i < 10; i++) {
			String msg = String.format("Update %d", i);
			publisher.send(msg.getBytes(), 0);
			Thread.sleep(1000);
		}
		publisher.send("END".getBytes(), 0);
		Thread.sleep(1000); // Give 0MQ/2.0.x to flush output
	}
}
