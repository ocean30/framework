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
	private final int PORT = 8888; // �˿ں�
	private List<Socket> list = new CopyOnWriteArrayList<Socket>(); // �������Ӷ���
	private ExecutorService exec;
	private ServerSocket server;

	public ChatServer() {
		try {
			server = new ServerSocket(PORT);
			exec = Executors.newCachedThreadPool();
			System.out.println("��������������");

			Socket client = null;
			while (true) {
				client = server.accept(); // ���տͻ�����
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
			msg = "��" + this.socket.getInetAddress() + "�����������ң���ǰ�������С�" + list.size() + "����";
			sendMessage();
		}

		public void run() {
			try {
				while ((msg = br.readLine()) != null) {
					if (msg.trim().equals("bye")) {
						list.remove(socket);
						br.close();
						pw.close();
						msg = "��" + socket.getInetAddress() + "���뿪�����ң���ǰ�������С�" + list.size() + "����";
						socket.close();
						sendMessage();
						break;
					} else {
						msg = "��" + socket.getInetAddress() + "��˵��" + msg;
						sendMessage();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		/**
		 * Ⱥ����Ϣ�������ҵ�������
		 */
		private void sendMessage() throws IOException {
			System.out.println(msg);	//���������Ļ�����Ϣ
			for (Socket client : list) {	//�����ͻ�������ͻ�������Ϣ
				pw = new PrintWriter(client.getOutputStream(), true);
				pw.println(msg);
			}
		}
	}
}