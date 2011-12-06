package com.banclogix.blockingqueue;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterWithNonblocking {
	private AtomicInteger value= new AtomicInteger(0);

	public int getValue() {
		return value.get();
	}

	public int increment() {
		int v;
		do {
			v = value.get();
		} while (!value.compareAndSet(v, v + 1));
		return v + 1;
	}

	public int decrement() {
		int v;
		do {
			v = value.get();
		} while (!value.compareAndSet(v, v - 1));
		return v - 1;
	}
	
	public String toString(){
		return "" + value.get();
	}
}