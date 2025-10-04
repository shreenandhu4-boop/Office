package com.org.office.practice.polymorphismexmp;

class Persons{
	void role() {
		System.out.println("I am a person");
	}
}

class Father extends Persons{
	@Override
	void role() {
		System.out.println(" I am a father");
	}
}



public class Example3 {
public static void main(String[] args) {
	Persons p =new Father();
	p.role();
}
}
