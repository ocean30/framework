package com.study.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

//客户端

/*-----动态代理步骤
 1.创建一个实现接口InvocationHandler的类，它必须实现invoke方法
 2.创建被代理的类以及接口
 3.通过Proxy的静态方法
 newProxyInstance(ClassLoader loader, Class[] interfaces, InvocationHandler h) 创建一个代理
 4.通过代理调用方法*/

public class Client {

	public static void main(String[] args) {
		RealSubject rs = new RealSubject();// 在这里指定被代理类

		InvocationHandler ds = new DynamicSubject(rs);

		Class<?> cls = rs.getClass();

		// 以下是一次性生成代理

		Subject subject = (Subject) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), ds);

		System.out.println("1");
		subject.request();
		subject.response();
		System.out.println("2");

	}
}
