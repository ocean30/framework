package com.banclogix.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class NIOServer implements Runnable {
	private final int PORT = 9000;
	private static List<Thread> serveThreads = new ArrayList<Thread>();

	public void run() {
		try {
			ServerSocket ss = new ServerSocket(PORT);
			System.out.println("Server start.");
			while (!Thread.interrupted()){
				//new Handler(ss.accept()).start()
				Thread serveThread = new Thread(new Handler(ss.accept()));
				serveThread.start();
				serveThreads.add(serveThread);
			}
			// or, single-threaded, or a thread pool
		} catch (IOException ex) { /* ... */
		}
	}

	static class Handler implements Runnable {
		private static final int MAX_INPUT = 1024;
		final Socket socket;

		Handler(Socket s) {
			socket = s;
		}

		public void run() {
			while(true){
				try {
					byte[] input = new byte[MAX_INPUT];
					socket.getInputStream().read(input);
					byte[] output = process(input);
					socket.getOutputStream().write(output);
					System.out.println(serveThreads);
				} catch (IOException ex) { /* ... */
				}
			}
		}

		private byte[] process(byte[] cmd) { /* ... */
			String n_cmd = "I'm receive " + new String(cmd) ;
			System.out.println(n_cmd.trim());
			return n_cmd.getBytes();
		}
	}
}