package com.ocean.dynamicproxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {

	private Enhancer enhancer = new Enhancer();
	 
    //覆盖MethodInterceptor接口的getProxy()方法，设置
    public Object getProxy(Class<?> clazz){
        enhancer.setSuperclass(clazz); //设置要创建子类的类
        enhancer.setCallback(this); //设置回调的对象
        return enhancer.create(); //通过字节码技术动态创建子类实例,
    }
    
    public Object intercept(Object obj,Method method,Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("模拟代理增强方法");
        //通过代理类实例调用父类的方法，即是目标业务类方法的调用
        Object result = proxy.invokeSuper(obj, args);
        System.out.println("模拟代理增强方法结束");
        return result;
    }

}