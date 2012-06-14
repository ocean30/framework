package com.ocean.aspectj;
public class Hello{
   public static void main(String[] args) throws InterruptedException{
	  new Hello().sayHello();
      Thread.sleep(1000);
   }
   public void sayHello(){
	   System.out.println("Hello " + getName());
   }
}