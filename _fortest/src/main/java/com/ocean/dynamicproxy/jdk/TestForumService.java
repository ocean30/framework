package com.ocean.dynamicproxy.jdk;

import java.lang.reflect.Proxy;

public class TestForumService {
	public static void main(String args[]) {
		// Ҫ���д����Ŀ��ҵ����
		IForumService target = new ForumServiceImpl();

		// �ô������Ŀ��ҵ������б�֯
		PerformanceHandler handler = new PerformanceHandler(target);

		// ��������ʵ���������Կ�����Ҫ�����Ŀ��ҵ����ļӶ��˺��д���(����)��һ������
		IForumService proxy = (IForumService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
		proxy.removeForum(10);
		proxy.removeTopic(20);
	}
}
