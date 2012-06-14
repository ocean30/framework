package com.ocean.aspectj;

public aspect World {
	private String Hello.name = "ocean " ;
	/**
	 * after 意思是下面的条件成立之后执行
	 * call 意思是所有调用的语句
	 * execution 意思是所有的执行方法
	 * within 指的是包含World类的所有方法调用
	 */
	after() : call(* *.sayHello(..)) && !within(World){
		System.out.println(" World");
	}
	
	public String Hello.getName(){
		return this.name;
	}
}
