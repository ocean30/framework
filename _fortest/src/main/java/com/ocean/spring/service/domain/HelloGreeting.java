package com.ocean.spring.service.domain;

import com.ocean.spring.service.GreetingService;

/**
 *@author zhengzh
 *@version 1.0 2012-3-12
 */
public class HelloGreeting implements GreetingService {
	private String name ;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void sayGreeting() {
		System.out.println("Hello " + name);
	}

}
