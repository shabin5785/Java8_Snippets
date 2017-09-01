package com.me.learn.java8.interfaces;

public interface Calculator {
	
	int add(int a, int b);
	
	//static method. Replaces the need to creating a separate class
	//to do the below.
	static Calculator getInstance(){
		return new BasicCalculator();
	}
	
	//method with default implementation. Will  not break existing
	//classes that use this interface
	default int subtract(int a, int b){
		return a-b;
	}
	
	//classes can override the default method
	default int minus(int a, int b){
		return a-b;
	}

}
