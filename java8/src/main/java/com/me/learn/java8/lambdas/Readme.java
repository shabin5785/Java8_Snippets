package com.me.learn.java8.lambdas;

public class Readme {
	
	/*The main concept in Lambda calculus is the expression. An expression can be expressed as:

		<expression> := <variable> | <function>| <application>

		    variable -- A variable is a placeholder like x, y, z for values like 1, 2, etc, or lambda functions.
		    function -- It is an anonymous function definition that takes one variable and produces another lambda 
		    expression. For example, λx.x*x is a function to compute square of a number.
		    application -- This is the act of applying a function to an argument. 
		    Suppose you want a square of 10, so in lambda calculus you will write a square function λx.x*x 
		    and apply it to 10. This function application would result in (λx.x*x) 10 = 10*10 = 100.
		    You can not only apply simple values like 10 but, you can apply a function to another function to 
		    produce another function. For example, (λx.x*x) (λz.z+10) will produce a function λz.(z+10)*(z+10). 
		    Now, you can use this function to produce number plus 10 squares. This is an example of higher order
		     function.
		     
		     
		     sendEmail(() -> System.out.println("Sending email..."));
		     above one, avoid creating a runnable inner class with run method,instead just passed the
		     method that needs to be executed.
		     
		     
To sort a list of names by their length, we passed a Comparator to the sort function. 
The Comparator is shown below.
Comparator<String> comparator = (first, second) -> first.length() - second.length();

The lambda expression that we wrote was corresponding to the compare method in the Comparator interface. 
The signature of the compare function is shown below.

int compare(T o1, T o2);

T is the type parameter passed to Comparator interface. In this case it will be a String as we are working 
over a List of Strings, i.e. names.
In the lambda expression, we didn't have to explicitly provide the type -- String. 
The javac compiler inferred the type information from its context. The Java compiler inferred that both parameters 
should be String, as we are sorting a List of String, and the compare method specifies only one type, T.
 The act of inferring the type from the context in this way is called Type Inference. 
 Java 8 improves the already existing type inference system in Java and makes it more robust and powerful to
  support lambda expressions. javac under the hood looks for the information close to your lambda expression
   and uses that information to find the correct type for the parameters


    In most cases, javac will infer the type from the context. In case it can't resolve type because of missing 
    or incomplete context information then the code will not compile. For example,
if we remove String type information from Comparator then code will fail to compile as shown below.

Comparator comparator = (first, second) -> first.length() - second.length(); // compilation error - Cannot resolve method 'length()'		    

You can't use any arbitrary interface with lambda expressions. Only those interfaces which have 
only one non-object abstract method can be used with lambda expressions. 
These kinds of interfaces are called Functional interfaces, and they can be annotated with the @FunctionalInterface
 annotation. Runnable interface is an example of a functional interface, as shown below.

@FunctionalInterface
public interface Runnable {
    public abstract void run();
}

@FunctionalInterface annotation is not mandatory but, it can help tools know that an interface is a 
functional interface and perform meaningful actions. For example, if you try to compile an interface 
that annotates itself with the @FunctionalInterface annotation, and has multiple abstract methods, 
then compilation will fail with an error Multiple non-overriding abstract methods found. Similarly, 
if you add @FunctionInterface annotation to an interface without any method, i.e. a marker interface, 
then you will get error message No target method found.


Are Java 8 lambda expressions just the syntactic sugar over anonymous inner classes, or how do functional 
interfaces otherwise get translated to bytecode?
----------------------------------------------------------------------------------------------------------------------------

The short answer is NO. Java 8 does not use anonymous inner classes mainly for two reasons:

Performance impact: If lambda expressions were implemented using anonymous classes, then each lambda 
expression would result in a class file on disk. If these classes were loaded by the JVM at startup, 
then the startup time of the JVM would increase, as all the classes would need to be first loaded and 
verified before use.

Possibility to change in future: If Java 8 designers would have used anonymous classes from the start, 
then it would have limited the scope of future lambda implementation changes.


Using invokedynamic
-------------------------------

Java 8 designers decided to use the invokedynamic instruction, added in Java 7, to defer the translation strategy
 at runtime. When javac compiles the code, it captures the lambda expression and generates an invokedynamic 
 call site (called lambda factory). The invokedynamic call site, when invoked, returns an instance of the 
 functional interface to which the lambda is being converted
 
 
 Anonymous classes vs lambdas
 -------------------------------

Let's compare anonymous classes with lambdas to understand the differences between them.

    1)In anonymous classes, this refers to the anonymous class itself whereas in lambda expressions, 
    this refers to the class enclosing the lambda expression.

    2)You can shadow variables in the enclosing class inside the anonymous class. This gives a compile time 
    error when done inside a lambda expression.

    3)The type of the lambda expression is determined from the context, whereas the type of the anonymous 
    class is specified explicitly as you create the instance of anonymous class.

	By default, Java 8 comes with many functional interfaces which you can use in your code. 
	They exist inside java.util.function package.	
	
	
	
	java.util.function.Predicate
	-------------------------------

This functional interface is used to define a check for some condition, i.e. a predicate. 
Predicate interface has one method called test which takes a value of type T and returns boolean. 
For example, from a list of names if we want to filter out all the names which starts with s then we will use 
a predicate as shown below.

Predicate<String> namesStartingWithS = name -> name.startsWith("s");

java.util.function.Consumer
-------------------------------

This functional interface is used for performing actions which do not produce any output. 
The consumer interface has one method called accept which takes a value of type T and returns nothing, i.e. 
it is void. For example, sending an email with given message.

Consumer<String> messageConsumer = message -> System.out.println(message);

java.util.function.Function<T,R>
-------------------------------

This functional interface takes one value and produces a result. For example, if we want to uppercase all the 
names in our names list, we can write a Function as shown below.

Function<String, String> toUpperCase = name -> name.toUpperCase();

java.util.function.Supplier
-------------------------------

This functional interface does not take any input but produces a value. This could be used to generate unique 
identifiers as shown below.

Supplier<String> uuidGenerator= () -> UUID.randomUUID().toString();


Method references
-------------------------------

There would be times when you will be creating lambda expressions that only calls a specific method like 

Function<String, Integer> strToLength = str -> str.length();.

 The lambda only calls length() method on the String object. This could be simplified using method references like 
 
 Function<String, Integer> strToLength = String::length;. 
 
 They can be seen as shorthand notation for lambda expression that only calls a single method. 
 In the expression String::length, String is the target reference, :: is the delimiter, and length is the 
 function that will be called on the target reference. 
 You can use method references on both static and instance methods.

     
 Static method references
 -------------------------------

Suppose we have to find a maximum number from a list of numbers, then we can write a method reference 

Function<List<Integer>, Integer> maxFn = Collections::max. 

max is a static method in the Collections class that takes one argument of type List. You can then call this like 
maxFn.apply(Arrays.asList(1, 10, 3, 5)). The above lambda expression is equivalent to a 
Function<List<Integer>, Integer> maxFn = (numbers) -> Collections.max(numbers); lambda expression. 

   
Instance method references
-------------------------------

This is used for method reference to an instance method, for example String::toUpperCase calls toUpperCase method on a String reference. 
You can also use method reference with parameters for example BiFunction<String, String, String> concatFn = String::concat. 
The concatFn can be called as concatFn.apply("shekhar", "gulati"). The String concat method is called on a String object and passed a
 parameter like "shekhar".concat("gulati").
 
*/

}
