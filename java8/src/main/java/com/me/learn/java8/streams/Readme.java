package com.me.learn.java8.streams;

public class Readme {
	
	/* 
	The real power of lambdas can be experienced when an API is designed while keeping lambdas in mind, 
	i.e. a fluent API that makes use of Functional interfaces
	Streams provide a higher level abstraction to express computations on Java collections in a declarative way 
	similar to how SQL helps you declaratively query data in a database. Declarative means developers write what
	 they want to do rather than how it should be done. 
	
	Drawbacks of collections API
	----------------------------------

1)The Collection API does not provide higher level constructs to query the data, so developers are forced 
to write a lot of boilerplate code for trivial tasks.

2)It has limited language support to process Collection data in parallel. It is left to the developer to use 
Java language concurrency constructs and process data effectively and efficiently in parallel.

	
What is a Stream?
----------------------------------

Stream is an abstract view over some data. For example, Stream can be a view over a list, 
or lines in a file, or any other sequence of elements. The Stream API provides aggregate operations that 
can be performed sequentially, or in parallel. One thing that developers should keep in mind is that Stream 
is a higher level abstraction, not a data structure. Stream does not store your data. Streams are lazy by nature, 
and they are only computed when accessed. This allows us to produce infinite streams of data. 
	
	Streams are readonly, lazly evaluated, internal iteration, can process a stream only once.

External iteration vs internal iteration
----------------------------------

The difference between Java 8 Stream API code and Collection API code shown above is who controls the iteration 
-- the iterator or the client that uses the iterator. Users of the Stream API just provide the operations they 
want to apply, and the iterator applies those operations to every element in the underlying Collection. 
When iterating over the underlying collection and the process is handled by the iterator itself, 
this is called internal iteration. On the other hand, when iteration is handled by the client it is called 
external iteration. The use of for-each construct in the Collection API code is an example of external iteration.
	
Lazy evaluation
----------------------------------

Streams are not evaluated until a terminal operation is called on them. Most of the operations in the Stream API 
return a Stream. These operations do not perform any execution -- they just build the pipeline	


List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
Stream<Integer> stream = numbers.stream().map(n -> n / 0).filter(n -> n % 2 == 0);

In the code shown above, we are dividing elements in numbers stream by 0. We might expect that this code will 
throw ArithmeticException when the code is executed. But, when you run this code no exception will be thrown.
 This is because streams are not evaluated until a terminal operation is called on the stream.
  If you add terminal operation to the stream pipeline, then the stream is executed, and an exception is thrown.

List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
Stream<Integer> stream = numbers.stream().map(n -> n / 0).filter(n -> n % 2 == 0);
stream.collect(toList());


Using Stream API
----------------------------------

The Stream API provides many operations that developers can use to query data from collections. 
Stream operations fall into either of the two categories -- intermediate operation, or terminal operation.

Intermediate operations are functions that produce another stream from the existing stream like filter, map, 
sorted, etc.

Terminal operations are functions that produce a non-stream result from the Stream like collect(toList()) , 
forEach, count etc.

Intermediate operations allow you to build the pipeline which gets executed when you call the terminal operation. 


	*/

}
