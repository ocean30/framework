package com.ocean.interview;

import java.util.ArrayList;
import java.util.List;

class SuperClass {
	private List<String> list = new ArrayList<String>();

	public void add(String str) {
		this.list.add(str);
	}

	public void setList(List<String> mylist) {
		this.list = mylist;
	}
	
	public List<String> get(){
		return this.list ;
	}
}

class SubClassOne extends SuperClass {
	private SubClassTwo subClassTwo;
	private List<String> list = new ArrayList<String>();

	public SubClassOne() {
		subClassTwo = new SubClassTwo();
		subClassTwo.setList(list);
		subClassTwo.add("two");
	}
	
	public List<String> get(){
		return this.list ;
	}
}

class SubClassTwo extends SuperClass {
}

public class Inteview {
	public static void main(String args[]) {
		SuperClass subClassOne_0 = new SubClassOne();
		SuperClass subClassOne_1 = new SubClassOne();
		subClassOne_0.add("one");
		for (int i = 0; i < subClassOne_0.get().size(); i++) {
			System.out.println(subClassOne_0.get().get(i));
		}
		for (int i = 0; i < subClassOne_1.get().size(); i++) {
			System.out.println(subClassOne_1.get().get(i));
		}
	}
}
