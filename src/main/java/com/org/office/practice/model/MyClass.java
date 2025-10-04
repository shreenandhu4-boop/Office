package com.org.office.practice.model;

public class MyClass {
	
	static String x = "Saisha" ;
	
	static String name;
	
	
	static int value;

	
	double score;
	
	String city;

	static int sum(int a, int b) {
		return a + b;
	}

	 MyClass() {

	}

	MyClass(int v ) {
		this.value = v;
	}
	
	MyClass(String s ) {
		this.name = s;
	}
	
	
	
	MyClass(int v , String x , double score) {
		this.value = v;
		this.name = x;
		this.score = score;
	}

	public static void main(String[] args) {
		MyClass obj1 = new MyClass();
		obj1.name = "ABC";
		
		obj1.value = 10;
		
		obj1.name = "xyz";
		
		System.out.println("default value of 'value':" + obj1.value);
		System.out.println("default value of 'name':" + obj1.name);
		System.out.println("default value of 'Score':" + obj1.score);
		
		MyClass obj2 = new MyClass( 5 );
		System.out.println("default value of 'value':" + obj2.value);
		System.out.println("default value of 'name':" + obj2.name);
		System.out.println("default value of 'Score':" + obj2.score);
		
		MyClass obj3 = new MyClass( 5 , "AMC" , 99.5);
		System.out.println("default value of 'value':" + obj3.value);
		System.out.println("default value of 'name':" + obj3.name);
		System.out.println("default value of 'Score':" + obj3.score);
		
		
		MyClass obj4 = new MyClass("test" );
		System.out.println("default value of 'value':" + obj4.value);
		System.out.println("default value of 'name':" + obj4.name);
		System.out.println("default value of 'Score':" + obj4.score);
		
		
		
		
		

	}

}
