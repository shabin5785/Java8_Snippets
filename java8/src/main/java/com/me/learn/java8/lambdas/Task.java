package com.me.learn.java8.lambdas;

public class Task {
	
	private String name;
	private String type;
	private int priority;
	
	public Task(String name, String type, int priority) {
		this.name = name;
		this.type = type;
		this.priority = priority;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	

}
