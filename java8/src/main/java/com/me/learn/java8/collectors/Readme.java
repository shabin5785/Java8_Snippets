package com.me.learn.java8.collectors;

public class Readme {
/*	
 * 
 	ToList
 	---------------
	The toList collector uses the List's add method to add elements into the resulting List. 
	toList collector uses ArrayList as the List implementation.
	
	ToSet
	---------------
	The toSet method uses a HashSet as the Set implementation to store the result set.And has only
	unique values
	
	
	ToMap
	---------------
	You can convert a stream to a Map by using the toMap collector. The toMap collector takes two mapper 
	functions to extract the key and values for the Map. In the code shown below, Task::getTitle is Function 
	that takes a task and produces a key with only title. The task -> task is a lambda expression that just 
	returns itself i.e. task in this case.

	private static Map<String, Task> taskMap(List<Task> tasks) {
	  return tasks.stream().collect(toMap(Task::getTitle, task -> task));
	}
	
	We can improve the code shown above by using the identity default method in the Function interface to make 
	code cleaner and better convey developer intent, as shown below.
	
	import static java.util.function.Function.identity;
	
	private static Map<String, Task> taskMap(List<Task> tasks) {
	  return tasks.stream().collect(toMap(Task::getTitle, identity()));
	}
	
	The code to create a Map from the stream will throw an exception when duplicate keys are present. 
	
	You can handle duplicates by using another variant of the toMap function which allows us to specify a 
	merge function. The merge function allows a client to specify how they want to resolve collisions 
	between values associated with the same key.
	
	toCollection
	--------------------
	The specific collectors like toList and toSet do not allow you to specify the underlying List or Set
	 implementation. You can use the toCollection collector when you want to collect the result to other types 
	 of collections, as shown below.

	private static LinkedHashSet<Task> collectToLinkedHaskSet(List<Task> tasks) {
	  return tasks.stream().collect(toCollection(LinkedHashSet::new));
	}
	
	


	*/

}
