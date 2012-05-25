package com.banclogix.enumerice;
/**
 *@author zhengzh
 *@version 1.0 2012-5-18
 */
public enum Symbol {
	EURUSD("EURUSD"),USDJPY ("USDJPY");
	private String name ;
	private String currency;
	private String currency2;
	
	//枚举类型的构造方法默认私有化
	Symbol(String name){
		this.name = name ;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getCurrency2() {
		return currency2;
	}
	public void setCurrency2(String currency2) {
		this.currency2 = currency2;
	}
	
}
