package com.ocean.aspectj;
public class Hello{
   public static void main(String[] args) throws InterruptedException{
	  sayHello();
      Thread.sleep(1000);
   }
   public static void sayHello(){
	   System.out.println("Hello");
   }
}