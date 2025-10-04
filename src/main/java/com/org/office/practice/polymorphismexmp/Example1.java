package com.org.office.practice.polymorphismexmp;

class Animal{
	void makeSound() {
		System.out.println("Animal makes a sound");
	}
}
 
class Dog extends Animal{
	@Override
	void makeSound() {
		System.out.println("Dog barks");
		
	}
}




public class Example1 {
	public static void main(String[] args) {
		Animal myAnimal = new Dog(); // runtime polymorphism
		myAnimal.makeSound();
		
	}

}
