package com.me.learn.java8.interfaces;

public class App {
	public static void main(String[] args) {
		
		Calculator c = Calculator.getInstance();
		System.out.println(c.add(1, 2));
		
		//calling the default mehtod
		System.out.println(c.subtract(2, 1));
		
		//calling overriden method returning 0
		System.out.println(c.minus(3, 5));
	}

}
