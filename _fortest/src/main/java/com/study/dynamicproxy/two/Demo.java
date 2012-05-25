package com.study.dynamicproxy.two;

import java.lang.reflect.Proxy;

public class Demo {
	public static void main(String[] args) {
		// 1.通用的动态代理实现
		CommonInvocationHandler handler = new CommonInvocationHandler();

		Foo f;

		//接口实现1
		handler.setTarget(new FooImpl());

		// 方法参数说明：代理类、代理类实现的接口列表、代理类的处理器
		// 关联代理类、代理类中接口方法、处理器，当代理类中接口方法被调用时，会自动分发到处理器的invoke方法
		// 如果代理类没有实现指定接口列表，会抛出非法参数异常
		
		f = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(),
				new Class[] { Foo.class }, handler);

		f.doAction();
		
		//接口实现2

		handler.setTarget(new FooImpl2());

		f = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(),
				new Class[] { Foo.class }, handler);
		
		f.doAction();
	}
}
