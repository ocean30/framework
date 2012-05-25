package com.ocean.dynamicproxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {

	private Enhancer enhancer = new Enhancer();
	 
    //����MethodInterceptor�ӿڵ�getProxy()����������
    public Object getProxy(Class<?> clazz){
        enhancer.setSuperclass(clazz); //����Ҫ�����������
        enhancer.setCallback(this); //���ûص��Ķ���
        return enhancer.create(); //ͨ���ֽ��뼼����̬��������ʵ��,
    }
    
    public Object intercept(Object obj,Method method,Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("ģ�������ǿ����");
        //ͨ��������ʵ�����ø���ķ���������Ŀ��ҵ���෽���ĵ���
        Object result = proxy.invokeSuper(obj, args);
        System.out.println("ģ�������ǿ��������");
        return result;
    }

}