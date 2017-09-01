package com.me.learn.java8.interfaces;

class BasicCalculator implements Calculator{

	@Override
	public int add(int a, int b) {
		return a+b;
	}
	
	@Override
	public int minus(int a, int b) {
//		return Calculator.super.minus(a, b);
		return 0;
	}

}
