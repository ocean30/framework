package com.banclogix.synchronized1;

public class QueueTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Queue q = new Queue();
		System.out.println(q.getCount());
		for(int i = 0 ; i < 6; i++){
			Message msg = new Message();
			msg.setContent("I = " + i);
			q.produce(msg);
		}
		q.consume();
		q.consume();
		q.consume();
	}

}
