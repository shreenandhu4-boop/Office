package com.org.office.practice.revision;

public class DefaultConstructor {
	
	DefaultConstructor(){
		System.out.println("Default Constructor");
	}
	
	// parameterized constructor
	int value;
	public DefaultConstructor(int initialValue) {
		this.value = initialValue;
		System.out.println("parameterized constructor : " + initialValue);
	}

	
	public static void main(String[] args) {
	DefaultConstructor dc = new DefaultConstructor();
	
	DefaultConstructor dc2 = new DefaultConstructor(10);
}
}
