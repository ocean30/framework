package com.study.dynamicproxy;

//具体角色

public class RealSubject implements Subject {

	@Override
	public void response() {
		System.out.println("I am real");
		
	}

	public RealSubject() {

	}

	@Override
	public void request() {
		System.out.println("from real subject");
	}

}
