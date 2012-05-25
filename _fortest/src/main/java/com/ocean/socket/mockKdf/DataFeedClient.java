package com.ocean.socket.mockKdf;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DataFeedClient {
	private final int PORT = 8888;
	private ExecutorService exec = Executors.newCachedThreadPool();

	public DataFeedClient() {
		try {
			Socket socket = new Socket("127.0.0.1", PORT);
			exec.execute(new Sender(socket));
			System.out.println("��" + socket.getInetAddress() + "�����ã���ӭ�������������ң�");
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String msg;
			while ((msg = br.readLine()) != null) {
				System.out.println(msg);
			}
		} catch (Exception e) {

		}
	}
	
	public DataFeedClient(String hostName,int port) {
		try {
			Socket socket = new Socket(hostName, port);
			exec.execute(new Sender(socket));
			System.out.println("���ӵ��� " + "��" + socket.getInetAddress() + " " + socket.getPort() +  "��");
			//���ջ�����
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String msg;
			while ((msg = br.readLine()) != null) {
				System.out.println(msg);
			}
		} catch (Exception e) {
			
		}
	}

	/**
	 * �ͻ����̻߳�ȡ����̨������Ϣ
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
						//�ͷ���Դ
						pw.close();
						br.close();
						//�ر��̳߳�
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