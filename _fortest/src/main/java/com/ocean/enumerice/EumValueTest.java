package com.ocean.enumerice;
/**
 *@author zhengzh
 *@version 1.0 2012-5-26
 */
public class EumValueTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RepositoryType t = RepositoryType.DIR ;
		System.out.println("ordinal: " + t.ordinal() + " name: " + t.name()+ " values: " + RepositoryType.values());
		RepositoryType[] types = RepositoryType.values();
		System.out.println( types[t.ordinal()]);
	}

}

enum RepositoryType {
    DIR,
    GLOB,
    JAR,
    URL;
    private String value="hello world.";
}
