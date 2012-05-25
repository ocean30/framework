package com.banclogix.test;

import java.io.PrintWriter;
import java.net.Socket;

public class FWebClient {
	private Socket socket;
	private PrintWriter out;
	private String sessionId;
	private String name;
	public Socket getSocket() {
		return socket;
	}
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	public PrintWriter getOut() {
		return out;
	}
	public void setOut(PrintWriter out) {
		this.out = out;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
