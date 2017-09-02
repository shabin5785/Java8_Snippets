package com.me.learn.java8.collectors;



import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.me.learn.java8.streams.Task;
import com.me.learn.java8.streams.TaskType;

public class App {

	public static void main(String[] args) {
		

		Task task1 = new Task("Read Version Control with Git book", TaskType.READING, LocalDate.of(2015, Month.JULY, 1)).addTag("git").addTag("reading").addTag("books");

		Task task2 = new Task("Read Java 8 Lambdas book", TaskType.READING, LocalDate.of(2015, Month.JULY, 2)).addTag("java8").addTag("reading").addTag("books");

		Task task3 = new Task("Write a mobile application to store my tasks", TaskType.CODING, LocalDate.of(2015, Month.JULY, 3)).addTag("coding").addTag("mobile");

		Task task4 = new Task("Write a blog on Java 8 Streams", TaskType.WRITING, LocalDate.of(2015, Month.JULY, 4)).addTag("blogging").addTag("writing").addTag("streams");

		Task task5 = new Task("Read Domain Driven Design book", TaskType.READING, LocalDate.of(2015, Month.JULY, 5)).addTag("ddd").addTag("books").addTag("reading");

		List<Task> tks = Arrays.asList(task1, task2, task3, task4, task5);
		
		App app = new App();
		System.out.println("\n\n-------------------");
		app.groupTasksByType(tks);

	}
	
/*	It creates a Map with key as the TaskType and value as the list containing all the 
	tasks which have same TaskType*/
	public void groupTasksByType(List<Task> tks){
		Map<TaskType, List<Task>> map = tks.stream().collect(Collectors.groupingBy(Task::getType));
		System.out.println(map);
		
	}
	
	
	
	public void allTitles(List<Task> tks){
		List<String> titles = tks.stream().map(Task::getTitle).collect(Collectors.toList());
		System.out.println(titles);
	}
	
	
	public Task taskWithLongestTitle(List<Task> tks){
//		tks.stream().map(Task::getTitle).collect(Collectors.toList())
//		.stream().sorted( (a,b) -> a.length() ).limit(1);
		 return tks.stream().collect(Collectors.collectingAndThen(Collectors.maxBy((t1, t2) -> t1.getTitle().length() - t2.getTitle().length()), Optional::get));
	}
	
	
	public void totalTagCount(List<Task> tks){
		tks.stream().collect(Collectors.summingInt( (t) -> t.getTags().size() ));
		
	}
	
	public void titleSummary(List<Task> tks){
		tks.stream().map(Task::getTitle).collect(Collectors.joining(","));
		
	}
	

}
