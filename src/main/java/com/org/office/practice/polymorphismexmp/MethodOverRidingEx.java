package com.org.office.practice.polymorphismexmp;

 class A {
	 void car() {
		 System.out.println("black color");
	 }
 }
	 
	 class B extends A {
		 void car() {
			 System.out.println("Red color");
		 }	
	 }
public class MethodOverRidingEx{
	public static void main(String[] args) {
		B b = new B();
		b.car();
	}

}
 
