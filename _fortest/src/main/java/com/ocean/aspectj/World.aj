package com.ocean.aspectj;

public aspect World {
	   after() : call(* *.sayHello(..)) && !within(World){
		      System.out.println(" World");
		   }
}
