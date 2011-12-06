package com.banclogix.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatClient {
	private final int PORT = 8888;
	private ExecutorService exec = Executors.newCachedThreadPool();

	public ChatClient() {
		try {
			Socket socket = new Socket("127.0.0.1", PORT);
			exec.execute(new Sender(socket));
			System.out.println("【" + socket.getInetAddress() + "】您好，欢迎来到阿飞聊天室！");
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String msg;
			while ((msg = br.readLine()) != null) {
				System.out.println(msg);
			}
		} catch (Exception e) {

		}
	}

	/**
	 * 客户端线程获取控制台输入消息
	 */
	class Sender implements Runnable {
		private Socket socket;

		public Sender(Socket socket) {
			this.socket = socket;
		}

		public void run() {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
				String msg;

				while (true) {
					msg = br.readLine();
					pw.println(msg);

					if (msg.trim().equals("bye")) {
						pw.close();
						br.close();
						exec.shutdownNow();
						break;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}