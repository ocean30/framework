package com.ocean.dynamicproxy.jdk;

public class ForumServiceImpl implements IForumService {
	public void removeTopic(int topicId) {
		System.out.println("ģ��ɾ����¼" + topicId);
		try {
			Thread.currentThread().sleep(20);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void removeForum(int forumId) {
		System.out.println("ģ��ɾ����¼" + forumId);
		try {
			Thread.currentThread().sleep(20);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
