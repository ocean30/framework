package com.ocean.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PerformanceHandler implements InvocationHandler {

	private Object target; // Ҫ���д����ҵ�����ʵ��

	public PerformanceHandler(Object target) {
		this.target = target;
	}

	// ����java.lang.reflect.InvocationHandler�ķ���invoke()����֯�루��ǿ���Ĳ���
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//		System.out.println("Object target proxy:" + target );
//		System.out.println("proxy: " + proxy.getClass()  +" method: " + method.getName());
		System.out.println("ģ������ǿ�ķ���...");
		Object obj = method.invoke(target, args); // ����Ŀ��ҵ����ķ���
		System.out.println("ģ������ǿ�ķ���ִ�����...");
		return obj;
	}

}
