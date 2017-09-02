package com.me.learn.java8.optionals;

import java.util.Optional;

public class App {
	
	private String value;
	
	public static void main(String[] args) {
		App app = new App();
		System.out.println(app.getValue());
		app.getValue().ifPresent(System.out::println);
		
	}

	public Optional<String> getValue() {
		return Optional.ofNullable(value);
	}

	public void setValue(String value) {
		this.value = value;
	}

	
	

}
