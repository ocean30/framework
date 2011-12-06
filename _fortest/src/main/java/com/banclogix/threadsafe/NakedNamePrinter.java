package com.banclogix.threadsafe;

public class NakedNamePrinter {

	private final String firstName;
	private final String surName;

	public NakedNamePrinter(String firstName, String surName) {
		this.firstName = firstName;
		this.surName = surName;
		new FirstNamePrinter().start();
		new SpacePrinter().start();
		new SurnamePrinter().start();
	}

	private class FirstNamePrinter extends Thread {
		public void run() {
			System.out.print(firstName);
		}
	}

	private class SpacePrinter extends Thread {
		public void run() {
			System.out.print(' ');
		}
	}

	private class SurnamePrinter extends Thread {
		public void run() {
			System.out.println(surName);
		}
	}

	public static void main(String[] args) {
		System.out.println();
		new NakedNamePrinter("Washington", "Irving");
	}
}
