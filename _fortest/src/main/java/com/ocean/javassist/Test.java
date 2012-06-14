package com.ocean.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.NotFoundException;

/*
   A very simple sample program

   This program overwrites sample/Test.class (the class file of this
   class itself) for adding a method g().  If the method g() is not
   defined in class Test, then this program adds a copy of
   f() to the class Test with name g().  Otherwise, this program does
   not modify sample/Test.class at all.

   To see the modified class definition, execute:

   % javap sample.Test

   after running this program.
*/
public class Test {
	private String name ;
	public void g(){}
	public int f(int i) {
	return i + 1;
    }

    public static void main(String[] args) throws Exception {
	ClassPool pool = ClassPool.getDefault();

	CtClass cc = pool.get("com.ocean.javassist.Test");
	try {
	    cc.getDeclaredMethod("g");
	    System.out.println("g() is already defined in sample.Test.");
	}
	catch (NotFoundException e) {
	    /* getDeclaredMethod() throws an exception if g()
	     * is not defined in sample.Test.
	     */
	    CtMethod fMethod = cc.getDeclaredMethod("f");
	    CtMethod gMethod = CtNewMethod.copy(fMethod, "g", cc, null);
	    cc.addMethod(gMethod);
	    cc.writeFile();	// update the class file
	    System.out.println("g() was added.");
	}
    }
}
