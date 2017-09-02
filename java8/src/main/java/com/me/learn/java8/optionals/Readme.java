package com.me.learn.java8.optionals;

public class Readme {

	
/*	Java 8 introduced a new data type, java.util.Optional<T>, which encapsulates an empty value. It makes 
	the intent of the API clear. If a function returns a value of type Optional<T>, then it tells the clients 
	that a value might not be present. Use of the Optional data type makes it explicit to the API client when 
	it should expect an optional value. The purpose of using the Optional type is to help API designers make 
	it visible to their clients, by looking at the method signature, whether they should expect an optional 
	value or not.
	
	public class Task{
	
	public Optional<User> getAssignedTo() {
        return assignedTo;
    }
    
    Since Task.assignedTo is a nullable field, each getter should return Optional<User>
     Now whoever tries to work with assignedTo User would know that it might not be present and they can 
     handle it in a declarative way.
     
     

    Optional.empty: This is used to create an Optional when a value is not present, like we did above 
    (this.assignedTo = Optional.empty();) in the constructor.

    Optional.of(T value): This is used to create an Optional from a non-null value. It throws NullPointerException
     when value is null. We used it in the code shown above (this.address = Optional.of(address);).

    Optional.ofNullable(T value): This static factory method which works for both null and non-null values.
	For null values it will create an empty Optional and for non-null values it will create an Optional
	 using the value.
	 
	 Optional can be thought of as a Stream with one element. It has methods similar to Stream API like map,
filter, and flatMap, which we can use to work with values contained in the Optional.


	
	}
	
	
	*/
	
}
