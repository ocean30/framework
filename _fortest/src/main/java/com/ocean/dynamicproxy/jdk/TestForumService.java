package com.ocean.dynamicproxy.jdk;

import java.lang.reflect.Proxy;

public class TestForumService {
	public static void main(String args[]) {
		// 要进行代理的目标业务类
		IForumService target = new ForumServiceImpl();

		// 用代理类把目标业务类进行编织
		PerformanceHandler handler = new PerformanceHandler(target);

		// 创建代理实例，它可以看作是要代理的目标业务类的加多了横切代码(方法)的一个子类
		IForumService proxy = (IForumService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
		proxy.removeForum(10);
		proxy.removeTopic(20);
	}
}
