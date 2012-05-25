package com.ocean.zmq.client;

import org.zeromq.ZMQ;

/**
 * @author Lusen
 */
public class DurasubShowData {
    public static void main(String[] args) {
        ZMQ.Context context = ZMQ.context(1);

        // Connect our subscriber socket
        ZMQ.Socket subscriber = context.socket(ZMQ.SUB);
        subscriber.setIdentity("hello".getBytes());

        // Synchronize with the publisher
        ZMQ.Socket sync = context.socket(ZMQ.PUSH);

        subscriber.subscribe("".getBytes());
        subscriber.connect("tcp://localhost:5565");
        sync.connect("tcp://localhost:5564");
        sync.send("".getBytes(), 0);

        // Get updates, expect random Ctrl-C death
        String msg = "";
        while (!msg.equalsIgnoreCase("END")) {
            msg = new String(subscriber.recv(0));
            System.out.println(msg);
        }
    }
}
