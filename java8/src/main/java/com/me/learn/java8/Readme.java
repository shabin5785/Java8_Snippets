package com.me.learn.java8;

public class Readme {
	
	
/*	Nashorn is a high-performance JavaScript runtime written in Java for the JVM. 
	It allows developers to embed JavaScript code inside their Java applications and 
	even use Java classes and methods from their JavaScript code. You can think it as an alternative 
	to Google's V8 JavaScript engine. It is a successor to Rhino JavaScript runtime which came 
	bundled with earlier JDK versions. Nashorn is written from scratch using new language features 
	like JSR 292(Supporting Dynamically Typed Languages) and invokedynamic.
	
	Currently, Nashorn supports ECMAScript 5.1 specification and work is in progress to support
	 ECMAScript 6 as well.
	 
	To use Nashorn from inside Java code, you have to create an instance of ScriptEngine from ScriptEngineManager
	 as shown below. Once you have ScriptEngine you can evaluate expressions.


public class NashornExample1 {

    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine nashorn = manager.getEngineByName("nashorn");
        Integer eval = (Integer) nashorn.eval("10 + 20");
        System.out.println(eval);
    }
}

Java 8 supports lambdas and many API in JDK make use of them. Every collection in Java has forEach method 
that accepts a consumer.In Nashorn, you can use them same API but you will pass JavaScript function 
	
	In case you need to disallow Java usage, you can very easily turn off by passing --no-java option to jjs
	
	
	*/

}
