package com.banclogix.design.abstractfactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


/**
 *@author zhengzh
 *@version 1.0 2012-5-18
 */
public class SymbolFactory {
//	private Map<String, Symbol> symbolMap = new HashMap<String, Symbol>() ;
	
//	static class Symbol {
//		private Symbol(){}
//	}
	
	public static Symbol getSymbol(String symbolName,Class<Symbol> clazz) {
		Symbol symbol = null ;
		try {
//			symbol = clazz.newInstance();
			Constructor<?>[]  constructors = clazz.getDeclaredConstructors() ;
			Constructor<?>  constructor = constructors[0] ;
			constructor.setAccessible(true);
			symbol = (Symbol) constructor.newInstance(null);
			symbol.setName(symbolName);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return symbol;
	}
}
