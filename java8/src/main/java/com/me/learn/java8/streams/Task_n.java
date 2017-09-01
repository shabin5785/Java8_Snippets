package com.me.learn.java8.streams;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Task_n {
	
	private String name;
	private String type;
	private int priority;
	

	
	public Task_n(String name, String type, int priority) {
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
