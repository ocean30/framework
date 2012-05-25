package com.banclogix.classloadsequence;
class Singleton {     
    
	static{
		b=2;
	}
    public static Singleton singleton = new Singleton();     
    public static int a;     
    public static int b;     
    
    private Singleton() {     
        super();     
        a++;     
        b++;     
    }     
    
    public static Singleton GetInstence() {     
        return singleton;     
    }     
    
}     
    
public class ClassLoadSequenceOfStaticField {     
    
    /**    
     * @param args    
     */    
    public static void main(String[] args) {     
        Singleton mysingleton = Singleton.GetInstence();     
        System.out.println(mysingleton.a);     
        System.out.println(mysingleton.b);     
    }     
    
}   