package com.ocean.threadsafe;

public class NamePrinter {

	private final String firstName;
	private final String surName;

	private final Object lock = new Object();
	private boolean printedFirstName = false;
	private boolean spaceRequested = false;

	public NamePrinter(String firstName, String surName) {
		this.firstName = firstName;
		this.surName = surName;
		new FirstNamePrinter().start();
		new SpacePrinter().start();
		new SurnamePrinter().start();
	}

	private class FirstNamePrinter extends Thread {
		public void run() {
			try {
				synchronized (lock) {
					while (firstName == null) {
						lock.wait();
					}
					System.out.print(firstName);
					printedFirstName = true;
					spaceRequested = true;
					lock.notifyAll();
				}
			} catch (InterruptedException e) {
				assert (false);
			}
		}
	}

	private class SpacePrinter extends Thread {
		public void run() {
			try {
				synchronized (lock) {
					while (!spaceRequested) {
						lock.wait();
					}
					System.out.print(' ');
					spaceRequested = false;
					lock.notifyAll();
				}
			} catch (InterruptedException e) {
				assert (false);
			}
		}
	}

	private class SurnamePrinter extends Thread {
		public void run() {
			try {
				synchronized (lock) {
					while (!printedFirstName || spaceRequested || surName == null) {
						lock.wait();
					}
					System.out.println(surName);
				}
			} catch (InterruptedException e) {
				assert (false);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println();
		new NamePrinter("Washington", "Irving");
	}
}
