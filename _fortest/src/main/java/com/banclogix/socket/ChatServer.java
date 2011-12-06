package com.banclogix.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {
	private final int PORT = 8888; // 端口号
	private List<Socket> list = new CopyOnWriteArrayList<Socket>(); // 保存连接对象
	private ExecutorService exec;
	private ServerSocket server;

	public ChatServer() {
		try {
			server = new ServerSocket(PORT);
			exec = Executors.newCachedThreadPool();
			System.out.println("服务器已启动！");

			Socket client = null;
			while (true) {
				client = server.accept(); // 接收客户连接
				list.add(client);
				exec.execute(new ChatTask(client));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	class ChatTask implements Runnable {
		private Socket socket;
		private BufferedReader br;
		private PrintWriter pw;
		private String msg;

		public ChatTask(Socket socket) throws IOException {
			this.socket = socket;
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			msg = "【" + this.socket.getInetAddress() + "】进入聊天室！当前聊天室有【" + list.size() + "】人";
			sendMessage();
		}

		public void run() {
			try {
				while ((msg = br.readLine()) != null) {
					if (msg.trim().equals("bye")) {
						list.remove(socket);
						br.close();
						pw.close();
						msg = "【" + socket.getInetAddress() + "】离开聊天室！当前聊天室有【" + list.size() + "】人";
						socket.close();
						sendMessage();
						break;
					} else {
						msg = "【" + socket.getInetAddress() + "】说：" + msg;
						sendMessage();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		/**
		 * 群发消息给聊天室的所有人
		 */
		private void sendMessage() throws IOException {
			System.out.println(msg);	//向服务器屏幕输出信息
			for (Socket client : list) {	//遍历客户，并向客户发送信息
				pw = new PrintWriter(client.getOutputStream(), true);
				pw.println(msg);
			}
		}
	}
}