package com.banclogix.design.abstractfactory;
/**
 *@author zhengzh
 *@version 1.0 2012-5-18
 */
public class SymbolFactoryTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		SymbolFactory.Symbol symbol = SymbolFactory.getSymbol("USDJPY");
		Symbol symbol = SymbolFactory.getSymbol("USDJPY",Symbol.class);
		System.out.println(symbol.getName());
	}

}
