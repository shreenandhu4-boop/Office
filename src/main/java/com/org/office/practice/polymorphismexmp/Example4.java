package com.org.office.practice.polymorphismexmp;

class Helper{
	static int multiply(int a, int b) {
		return a * b;
		}
	static double multiply(double a, double b) {
		return a * b;
		
	}
}

public class Example4 {
	public static void main(String[] args) {
		System.out.println(Helper.multiply(2, 4));
		
		System.out.println(Helper.multiply(5.5, 6.3));
	} // calling method by passing input as arguments
}
