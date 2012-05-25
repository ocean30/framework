package com.study.tranditionalproxy;

//代理角色

public class ProxySubject extends Subject {

	private Subject realSubject;//以真实角色作为代理角色的属性

	public ProxySubject() {

	}

	@Override
	public void request() {
		this.preRequest();
		if(this.realSubject == null){
			this.realSubject = new RealSubject();
		}
		this.realSubject.request();//此处执行真实对象的request方法
		this.postRequest();
	}
	
	private void preRequest(){
		System.out.println("preRequest");
	}
	
	private void postRequest(){
		System.out.println("postRequest");
	}

}
