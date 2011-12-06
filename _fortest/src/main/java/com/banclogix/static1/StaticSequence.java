package com.banclogix.static1;

public class StaticSequence extends Static{
	//static variable load 1
	private static Static staticVar = new Static("staticVar");
	
	//static block load 2
	static {
		System.out.println("static block......");
	}
	
	//instant variable load 3
	private Static instatVar = new Static("instatVar") ;
	
	//instant block load 4
	{
		System.out.println("instant block.....");
	}
	
	//constructor load 5
	public StaticSequence(){
		System.out.println("StaticSequence Class.....");
	}
}
