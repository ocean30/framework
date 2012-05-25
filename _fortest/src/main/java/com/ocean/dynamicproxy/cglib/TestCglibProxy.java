package com.ocean.dynamicproxy.cglib;

import com.ocean.dynamicproxy.jdk.ForumServiceImpl;

public class TestCglibProxy {
	 public static void main(String args[]){
        CglibProxy proxy = new CglibProxy();
        //动态生成子类的方法创建代理类
        ForumServiceImpl fsi = (ForumServiceImpl)proxy.getProxy(ForumServiceImpl.class);
//        System.out.println(fsi);
        fsi.removeForum(10);
        fsi.removeTopic(2);
    }
}