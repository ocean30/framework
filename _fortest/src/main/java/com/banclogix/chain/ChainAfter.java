package com.banclogix.chain;

// Purpose.  Chain of Responsibility design pattern

public class ChainAfter {

	interface Image {
		String process();
	}

	static class IR implements Image {
		public String process() {
			return "IR";
		}
	}

	static class LS implements Image {
		public String process() {
			return "LS";
		}
	}

	static class Processor {
		private static java.util.Random rn = new java.util.Random();
		private static int nextId = 1;
		private int id = nextId++;
		private Processor next;

		public void add(Processor nextP) {
			if (next != null)
				next.add(nextP);
			else
				next = nextP;
		}

		public void wrapAround(Processor firstP) {
			if (next != null)
				next.wrapAround(firstP);
			else
				next = firstP;
		}

		public void handle(Image img) {
			if (rn.nextInt(2) != 0) {
				System.out.println("   Processor " + id + " is busy");
				next.handle(img);
			} else
				System.out.println("Processor " + id + " - " + img.process());
		}
	}

	static public Processor setUp() {
		Processor root = new Processor();
		for (int i = 0; i < 2; i++)
			root.add(new Processor());
		root.wrapAround(root);
		return root;
	}

	public static void main(String[] args) {
		Image[] input = { new IR(), new IR(), new LS(), new IR(), new LS(), new LS() };
		Processor chain = setUp();
		for (int i = 0; i < input.length; i++)
			chain.handle(input[i]);
	}
}

// Processor 1 is busy
// Processor 2 is busy
// Processor 3 is busy
// Processor 1 - IR
// Processor 1 - IR
// Processor 1 is busy
// Processor 2 - LS
// Processor 1 - IR
// Processor 1 is busy
// Processor 2 is busy
// Processor 3 - LS
// Processor 1 is busy
// Processor 2 is busy
// Processor 3 - LS