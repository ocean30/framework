package com.ocean.chain;

// Purpose.  The number to be factored is passed through a chain of Factor-
// Elements until none of them is able to decompose the number any further.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChainContrib {

	static class Memento {
		private boolean[] done;
		private int sp = 0;
		private int[] factors = new int[10];

		public Memento(int num) {
			done = new boolean[num];
		}

		public void add(int n) {
			factors[sp++] = n;
		}

		public void setDone(int i) {
			done[i] = true;
		}

		public boolean isDone() {
			for (int i = 0; i < done.length; i++)
				if (!done[i])
					return false;
			return true;
		}

		public String toString() {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < sp; i++) {
				sb.append(factors[i]);
				sb.append(' ');
			}
			sp = 0;
			for (int i = 0; i < done.length; i++)
				done[i] = false;
			return sb.toString();
		}
	}

	static class FactorElement {
		private int index, divisor;
		private FactorElement next;
		private static Memento mem;

		public FactorElement(int i, int d, FactorElement fe) {
			index = i;
			divisor = d;
			next = fe;
		}

		public void setNext(FactorElement fe) {
			next = fe;
		}

		public String getResults() {
			return mem.toString();
		}

		public void getFactors(int[] num) {
			if (num[0] % divisor == 0) {
				mem.add(divisor);
				num[0] = num[0] / divisor;
			} else
				mem.setDone(index);
			if (!mem.isDone())
				next.getFactors(num);
		}

		public static FactorElement setUp() {
			int[] divisors = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47 };
			int size = divisors.length;
			mem = new Memento(size);
			FactorElement last = new FactorElement(size - 1, divisors[size - 1], null);
			FactorElement current = last;
			for (int i = size - 2; i > -1; i--)
				current = new FactorElement(i, divisors[i], current);
			last.setNext(current);
			return current;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
		int[] num = new int[1];
		String str;
		FactorElement root = FactorElement.setUp();
		while (true) {
			System.out.print("Enter number: ");
			str = rdr.readLine();
			if (str.equals("0"))
				break;
			num[0] = Integer.parseInt(str);
			root.getFactors(num);
			System.out.println("   " + root.getResults() + "- " + num[0]);
		}
	}
}

// Enter number: 30
// 2 3 5 - 1
// Enter number: 31
// 31 - 1
// Enter number: 32
// 2 2 2 2 2 - 1
// Enter number: 127
// - 127
// Enter number: 60
// 2 3 5 2 - 1
// Enter number: 180
// 2 3 5 2 3 - 1
// Enter number: 216
// 2 3 2 3 2 3 - 1
// Enter number: 2310
// 2 3 5 7 11 - 1
// Enter number: 4620
// 2 3 5 7 11 2 - 1
// Enter number: 13860
// 2 3 5 7 11 2 3 - 1
// Enter number: 0