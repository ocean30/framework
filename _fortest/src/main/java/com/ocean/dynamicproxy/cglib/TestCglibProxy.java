package com.ocean.dynamicproxy.cglib;

import com.ocean.dynamicproxy.jdk.ForumServiceImpl;

public class TestCglibProxy {
	 public static void main(String args[]){
        CglibProxy proxy = new CglibProxy();
        //��̬��������ķ�������������
        ForumServiceImpl fsi = (ForumServiceImpl)proxy.getProxy(ForumServiceImpl.class);
//        System.out.println(fsi);
        fsi.removeForum(10);
        fsi.removeTopic(2);
    }
}