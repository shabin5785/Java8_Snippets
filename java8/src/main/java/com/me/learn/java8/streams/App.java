package com.me.learn.java8.streams;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class App {
	
	public static void main(String[] args) {
		
		Task_n t = new Task_n("first", "good", 3);
		Task_n t2 = new Task_n("second", "bad", 9);
		Task_n t3 = new Task_n("third", "good", 7);
		
		List<Task_n> tasks = Arrays.asList(t,t2,t3);
		
		List<Task_n> filteredtasks = tasks.stream()
		.filter((task)-> task.getPriority()>5 )
		.sorted( (task,task2) -> task.getPriority())
		.map((task) -> {
			task.setName(task.getName().toUpperCase());
		return task;
		})
		.collect(Collectors.toList());
		
		filteredtasks.forEach( (tk) -> System.out.println(tk.getName()) );
		
		Task task1 = new Task("Read Version Control with Git book", TaskType.READING, LocalDate.of(2015, Month.JULY, 1)).addTag("git").addTag("reading").addTag("books");

		Task task2 = new Task("Read Java 8 Lambdas book", TaskType.READING, LocalDate.of(2015, Month.JULY, 2)).addTag("java8").addTag("reading").addTag("books");

		Task task3 = new Task("Write a mobile application to store my tasks", TaskType.CODING, LocalDate.of(2015, Month.JULY, 3)).addTag("coding").addTag("mobile");

		Task task4 = new Task("Write a blog on Java 8 Streams", TaskType.WRITING, LocalDate.of(2015, Month.JULY, 4)).addTag("blogging").addTag("writing").addTag("streams");

		Task task5 = new Task("Read Domain Driven Design book", TaskType.READING, LocalDate.of(2015, Month.JULY, 5)).addTag("ddd").addTag("books").addTag("reading");

		List<Task> tks = Arrays.asList(task1, task2, task3, task4, task5);
		
		
		App app = new App();
		System.out.println("\n\n-------------------");
		app.allReadingTasks(tks);
		
		System.out.println("\n\n-------------------");
		app.allReadingTasksSortedByCreatedOnDesc(tks);
		
		
	}
	

/*    Filter all the tasks that have TaskType as READING.
    Sort the filtered values tasks by createdOn field.
    Get the value of title for each task.
    Collect the resulting titles in a List.*/
	
	public void allReadingTasks(List<Task> tks){
		
		List<String> result = tks.stream()
		.filter( (t) -> t.getType()==TaskType.READING )
		.sorted( (tk1,tk2) -> tk1.getCreatedOn().compareTo(tk2.getCreatedOn()) )
		.map((t) -> t.getTitle() )
		.collect(Collectors.toList());
		
		result.forEach(System.out::println);
		
		
		tks.stream()
		.filter((t) -> t.getType()==TaskType.READING )
		.sorted(Comparator.comparing(Task::getCreatedOn))
		.map(Task::getTitle)
		.collect(Collectors.toList());
		result.forEach(System.out::println);
		
		/*In the code shown above, we used a static helper method comparing available in the Comparator interface
		which accepts a Function that extracts a Comparable key, and returns a Comparator that compares by that key.
		The method reference Task::getCreatedOn resolves to Function<Task, LocalDate>.*/
		
	}
	
	public void allReadingTasksSortedByCreatedOnDesc(List<Task> tks){
		List<String> result = tks.stream()
				.filter((t) -> t.getType()==TaskType.READING )
				.sorted(Comparator.comparing(Task::getCreatedOn).reversed())
				.map(Task::getTitle)
				.collect(Collectors.toList());
				result.forEach(System.out::println);
				
				result.forEach(System.out::println);
				
	}
	
/*	The distinct() method converts one stream into another without duplicates. 
	It uses the Object's equals method for determining the object equality.
*/	
	public void allDistinctTasks(List<Task> tks){
		List<Task> result = tks.stream()
			.distinct().collect(Collectors.toList());
	}
	
	
/*	The limit function can be used to limit the result set to a given size. 
	limit is a short circuiting operation which means it does not evaluate all the elements to find the result.
*/	
	public void topN(List<Task> tks, int n){
		List<Task> result  = tks.stream()
		.filter((t)-> t.getType()==TaskType.READING )
		.sorted((tk1,tk2) -> tk1.getCreatedOn().compareTo(tk2.getCreatedOn()))
		.limit(n)
		.collect(Collectors.toList());
		
	}
	
	/*You can use limit along with the skip method to create pagination,
	 * Limit the result, then use skip to go to  next set 
*/
	
	public void countAllReadingTasks(List<Task> tks){
		long count = tks.stream()
		.filter( (t) -> t.getType()==TaskType.READING)
		.count();
		
	}
	

/*    Extract tags for each task.
    Collect all the tags into one stream.
    Remove the duplicates.
    Finally collect the result into a list.*/

	
	public void allDistinctTags(List<Task> tks){
		
		/*The flatMap operation flattens the streams returned by each invocation of tasks.getTags().stream()4
		into one stream.*/
		
		List<String> result = tks.stream()
		.flatMap( (t) -> t.getTags().stream() )
		.distinct()
		.collect(Collectors.toList());
		
		
	}
	
/*	The Stream API has methods that allows the user to check if elements in the dataset match a given property. 
	These methods are allMatch, anyMatch, noneMatch, findFirst, and findAny.*/
	public void isAllReadingTasksWithTagBooks(List<Task> tks){
		
//		To check if all reading titles have a tag with name books, we can write code as shown below.
		tks.stream()
		.filter( (t) -> t.getType() == TaskType.READING )
		.allMatch( (t)-> t.getTags().contains("books") );
		
//		To check whether any reading task has a java8 tag, then we can use anyMatch operation as shown below.
		tks.stream()
		.filter( (t) -> t.getType() == TaskType.READING )
		.anyMatch( (t)-> t.getTags().contains("java8") );
	}
	
/*	you want to create a summary of all the titles. Use the reduce operation, which reduces the stream 
	to a value. The reduce function takes a lambda which joins elements of the stream.*/
	public void joinAllTaskTitles(List<Task> tks){
		tks.stream()
		.map( Task::getTitle )
		.reduce( (f,s) -> f+"***"+s )
		.get();
	}
	
	
	public void primitiveStream(){
		IntStream.range(0, 8).forEach(System.out::println);
		
//		You can also create infinite streams using iterate method on the primitive streams as shown below.

		LongStream infiniteStream = LongStream.iterate(1, el -> el + 1);
		infiniteStream.filter(el -> el % 2 == 0).limit(100).forEach(System.out::println);
		
//		You can create streams from arrays by using the static stream method on the Arrays class as shown below.

		String[] tags = {"java", "git", "lambdas", "machine-learning"};
		Arrays.stream(tags).map(String::toUpperCase).forEach(System.out::println);
	}
	
	
}
