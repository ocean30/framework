package com.ocean.observer;
public class MyApp {
    public static void main(String args[]) {
        System.out.println("Enter Text >");
 
        // create an event source - reads from stdin
        final EventSource evSrc = new EventSource();
 
        // create an observer
        final ResponseHandler respHandler = new ResponseHandler();
 
        // subscribe the observer to the event source
        evSrc.addObserver( respHandler );
//        evSrc.addObserver( respHandler );
 
        // starts the event thread
        Thread thread = new Thread(evSrc);
       // Thread thread1 = new Thread(evSrc);
        thread.start();
        //thread1.start();
    }
}