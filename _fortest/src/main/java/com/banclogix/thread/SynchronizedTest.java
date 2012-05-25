package com.banclogix.thread;

public class SynchronizedTest {
    static class ThreadA implements Runnable{
       private TestClass tc = null;
       
       public ThreadA(TestClass tc){
           this.tc = tc;
       }
       
       public void run() {
           tc.get1();
           System.out.println(this.getClass().getName() + " TestClass.get() before");
           tc.get();
           System.out.println(this.getClass().getName() + " TestClass.get() after");
       }
    }
    
    public static void main(String[] args) {
       TestClass tc = new TestClass();
       new Thread(new ThreadA(tc)).start();
       System.out.println("----------------------------------");
       tc.get1();
       tc.get();
    }
    
}


class TestClass{
    public void get(){
       System.out.println(Thread.currentThread().toString() + " " + this.getClass().getName() + ".get()" + " before synchronized");
       synchronized(this){
           System.out.println(Thread.currentThread().toString() + " " + this.getClass().getName() + ".get()" + " before sleep");
           try{
              Thread.sleep(1000 * 10);
           }catch(Exception e){
              e.printStackTrace();
           }
           System.out.println(Thread.currentThread().toString() + " " + this.getClass().getName() + ".get()" + " after sleep");
       }
       System.out.println(Thread.currentThread().toString() + " " + this.getClass().getName() + ".get()" + " after synchronized");
    }
    public void get1(){
       System.out.println(Thread.currentThread().toString() + " " + this.getClass().getName() + ".get1()" + " before synchronized");
       synchronized(this){
           System.out.println(Thread.currentThread().toString() + " " + this.getClass().getName() + ".get1()" + " before sleep");
           try{
              Thread.sleep(1000 * 10);
           }catch(Exception e){
              e.printStackTrace();
           }
           System.out.println(Thread.currentThread().toString() + " " + this.getClass().getName() + ".get1()" + " after sleep");
       }
       System.out.println(Thread.currentThread().toString() + " " + this.getClass().getName() + ".get1()" + " after synchronized");
    }
}
