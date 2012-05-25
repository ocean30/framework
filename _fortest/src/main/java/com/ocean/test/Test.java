package com.ocean.test;

public class Test {
//	public void Test(){
//		
//	}
	public static void main(String[] args) {
//		Person p1 = new Person("zhangsan");
//		Person p2 = new Person("zhangsan");
//		System.out.println(p1.equals(p2));
//		System.out.println("p1's hashcode is " + p1.hashCode());
//		System.out.println("p2's hashcode is " + p2.hashCode());
//			try{System.exit(100);} 
//			finally{System.out.println("Finally");} 
//			Object o1=new Object(); 
//			Object o2=o1; 
//			if(o1.equals(o2)){ 
//			System.out.println("Equal"); 
//			}
//			new StringBuffer("Y").toString();
//		String foo=new String("blue");
//		String bar=foo; 
//		foo=new String("green"); 
//		Person foo = new Person("z");
//		Person bar = foo ;
//		foo = new Person("a");
//		System.out.println(bar); 
		System.out.println(java.lang.String.class.getClassLoader()); 
		System.out.println(Person.class.getClassLoader()); 
		System.out.println(Person.class.getClassLoader().getParent()); 
		System.out.println(Person.class.getClassLoader().getParent().getParent()); 

//		String a = new String("a");
//		String b = new String("a");
//		System.out.println(a.equals(b));
//		System.out.println("a's hashcode is " + a.hashCode());
//		System.out.println("b's hashcode is " + b.hashCode());
//		Object o = (Object) new Foo();
//
//		Foo foo = (Foo) o;
//
//		System.out.println(foo.i);

	}
	
//	static class Foo {
//
//		public int i = 3;
//
//	}
}
class Person {
	private String name ;
	public Person(String name){
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false ;
		if(obj == null) 
			return isEquals ;
		Person p = null ;
		if (obj instanceof Person )  
			p = (Person) obj ;
		if(this.name.equals(p.name)){
			isEquals = true ;
		}
		return isEquals ;
	}
	@Override
	public String toString(){
		return name;
	}
}
