package com.banclogix.synchronized1;

public class Message {
	private static int id;
	private String content;
	
	public Message(){
		id++;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		Message.id = id;
	}
}