package com.ocean.test;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestLusen extends Thread{

	private static final int PORT = 3000; // 端口号
	private static List<Socket> list = new ArrayList<Socket>(); // 保存连接对象
	private static Hashtable<String,FWebClient> webClients = new Hashtable<String, FWebClient>();
	private ExecutorService exec;
	private ServerSocket server;
	private final static String SECURITY_CROSS_POLICY = "<cross-domain-policy><allow-access-from domain=\"*\" to-ports=\"*\"/></cross-domain-policy>\0";

	public static void main(String[] args) {
		new TestLusen();
	}

	public TestLusen() {
		this.start();
	}
	
	public void run(){
		try {
			server = new ServerSocket(PORT);
			exec = Executors.newCachedThreadPool();
			System.out.println("服务器已启动！");
			Socket client = null;
			exec.execute(new PushTask(webClients));
			while (true) {
				client = server.accept(); // 接收客户连接
//				list.add(client);
				FWebClient webClient = new FWebClient();
				webClient.setName("");
				webClient.setSocket(client);
				System.out.println(client.hashCode()+"~~");
				webClient.setSessionId(client.getRemoteSocketAddress().toString());
				PrintWriter out = new PrintWriter(client.getOutputStream(), true);
				//连接成功发送验证信息
				out.println(SECURITY_CROSS_POLICY);
				out.flush();
				webClient.setOut(out);
				webClients.put(client.getRemoteSocketAddress().toString(), webClient);
//				exec.execute(new ChatTask(client));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static class PushTask implements Runnable {

		private Hashtable<String,FWebClient> webClients = null;
		private String msg1 = "";

		public PushTask(Hashtable<String,FWebClient> webClients) throws IOException {
			this.webClients = webClients;
//			br = new BufferedReader(new InputStreamReader(
//					socket.getInputStream()));
		}

		public void run() {
			DataOutputStream pw;
			try {
				int i = 0;
				while (true) {
					msg1 = "姜亮";
					
					synchronized(webClients){
						Iterator<String> it = webClients.keySet().iterator();
						while(it.hasNext()){
							FWebClient webClient = webClients.get(it.next());
//							pw = webClient.getOut();
							DataOutputStream out = new DataOutputStream(webClient.getSocket().getOutputStream());
							pw = out;
//							webClient.getSocket();
							msg1+= webClient.getSessionId();
							msg1+= "(" + i + ")";
							pw.writeBytes(msg1 + "\0");
							try{
							pw.flush();
							System.out.println(webClient.getSocket().hashCode());
							}
							catch(Exception e){
								System.out.println("!!!!!!!!!!!!!!!!!!!!!!!");
							}
							msg1 = null;
						}
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					i++;
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	static class ChatTask implements Runnable {

		private Socket socket;
		private String msg1 = "";

		public ChatTask(Socket socket) throws IOException {
			this.socket = socket;
//			br = new BufferedReader(new InputStreamReader(
//					socket.getInputStream()));
		}

		public void run() {
			PrintWriter pw;
			try {
				pw = new PrintWriter(socket.getOutputStream(), true);
				int i = 0;
				pw.println(SECURITY_CROSS_POLICY);
				pw.flush();
				while (true) {
					msg1 = "姜亮";
//					msg1 = i + "jason！";

//					if (i == 0) {// 如果客户端是第一次访问服务器那么发送，安全策略允许文件，这必须的否则其余的免谈
//						pw.println(SECURITY_CROSS_POLICY);
//						pw.flush();
//					} else {// 向客户端发送数据
						pw.println(msg1 + "\0");
						pw.flush();
//					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
//					i++;
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
