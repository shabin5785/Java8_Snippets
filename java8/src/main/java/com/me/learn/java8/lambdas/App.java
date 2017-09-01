package com.me.learn.java8.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class App {

	public static void main(String[] args) {
		/*Lambda expressions allow you to define an anonymous function that is not bound to an identifier. 
		You can use them like any other construct in your programming language, like variable declaration. 
		Lambda expressions are required if a programming language needs to support higher order functions. 
		Higher order functions are functions that either accept other functions as arguments or returns a function 
		as a result.*/
		
		//lamba exp as arugment instead of passing comparator object
		//-> is the lambda operator that separates parameters from the body of the lambda.
		List<String> names = Arrays.asList("hello","something","ad");
		Collections.sort(names, (first,second)-> first.length()-second.length() );
		//above is code to replace this.
//		Collections.sort(names, new NameComparator());
		//and name comparator has compare method like lambda method above
		System.out.println(names);
		
		System.out.println("\n\n-------------------------------");
		names.forEach(System.out::println);//consumer lambda method
		names.forEach((s) -> System.out.println(s));
		names.forEach((s) -> {
			s = s+"55";
			System.out.println(s);
		});
		
		System.out.println("\n\n-------------------------------");
		Predicate<String> aTest = (n) -> n.charAt(0)=='a';
		names.forEach((name) ->{
			if(aTest.test(name)){
				System.out.println(name);
			}
		});
		
		
		System.out.println("\n\n-------------------------------");
		
		Function<String, String> firstCharExtractor = (name) -> {
			return name.charAt(0)+"";
		};
		names.forEach((n) -> System.out.println(firstCharExtractor.apply(n)));
		
		System.out.println("\n\n-------------------------------");

	}

}
