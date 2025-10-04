package com.org.office.practice.polymorphismexmp;

public class Student extends Person{
	
	@Override    //dynamic or runtime polymorphism
	void getInfo() {
		System.out.println(" I am a student");
	} //base class method can be override to child class
	
	
	
	void getInfo(int age) { 
		System.out.println(" I am " + age + " years old");
	}   //statis or compiletime polymorphism
		//method overloading -->same method name with different argument
}