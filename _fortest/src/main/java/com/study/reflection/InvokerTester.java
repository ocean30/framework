package com.study.reflection;

import java.lang.reflect.Method;

public class InvokerTester {

	public int add(int param1, int param2) {
		return param1 + param2;
	}

	public String echo(String msg) {
		return "hi : " + msg;
	}

	public static void main(String[] args) throws Exception {

		// class对象
		Class<?> classType = InvokerTester.class;
		Object invokerTester = classType.newInstance();// newInstance()这个方法依赖于这个类要有一个不带参数的构造方法
		// 以上两行代码等价于
		// InvokerTester invokerTester = new InvokerTester();

		// method对象
		Method addMethod = classType.getMethod("add", new Class[] { int.class, int.class });
		Object result = addMethod.invoke(invokerTester, new Object[] { 100, 10 });
		// 以上两行代码等价于
		// invokerTester.add(100,10);

		// 输出
		System.out.println(result);

		Method echoMethod = classType.getMethod("echo", new Class[] { String.class });
		Object result2 = echoMethod.invoke(invokerTester, new Object[] { "chang" });
		// 以上两行代码等价于
		// invokerTester.echo("chang");

		// 输出
		System.out.println(result2);
	}

}

class InvokerDemo {

	public int add(int param1, int param2) {
		return param1 - param2;
	}

	public String echo(String msg) {
		return "hi nihao : " + msg;
	}
}
