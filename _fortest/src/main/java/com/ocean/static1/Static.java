package com.ocean.static1;

public class Static {
	
	private static Static hello = new Static("static");
	
	public Static(){
		System.out.println("Static Class.....");
	}

	public Static(String string) {
		System.out.println("Static Class ..... " + string);
	}
}
