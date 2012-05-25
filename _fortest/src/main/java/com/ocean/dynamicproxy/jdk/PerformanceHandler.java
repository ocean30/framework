package com.ocean.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PerformanceHandler implements InvocationHandler {

	private Object target; // 要进行代理的业务类的实例

	public PerformanceHandler(Object target) {
		this.target = target;
	}

	// 覆盖java.lang.reflect.InvocationHandler的方法invoke()进行织入（增强）的操作
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//		System.out.println("Object target proxy:" + target );
//		System.out.println("proxy: " + proxy.getClass()  +" method: " + method.getName());
		System.out.println("模拟代理加强的方法...");
		Object obj = method.invoke(target, args); // 调用目标业务类的方法
		System.out.println("模拟代理加强的方法执行完毕...");
		return obj;
	}

}
