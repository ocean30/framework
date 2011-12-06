package com.banclogix.synchronized2;

import java.util.ArrayList;
import java.util.List;

public class MultiThread {
	private List<Object> container = new ArrayList<Object>();
	public final static int MAX = 5;

	public static void main(String args[]) {
		MultiThread m = new MultiThread();
		new Thread(new Consume(m.getContainer())).start();
		new Thread(new Product(m.getContainer())).start();
		new Thread(new Consume(m.getContainer())).start();
		new Thread(new Product(m.getContainer())).start();
	}

	public List<Object> getContainer() {
		return container;
	}

	public void setContainer(List<Object> container) {
		this.container = container;
	}
}