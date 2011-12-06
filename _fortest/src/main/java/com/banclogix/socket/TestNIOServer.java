package com.banclogix.socket;
public class TestNIOServer{
	public static void main(String[] args){
		new Thread(new NIOServer()).start();
	}
}