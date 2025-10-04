package com.org.office.practice.polymorphismexmp;

public class MethodOverLoadingEx {
	
	void test(int a) {
		System.out.println("java ");
	}
	
	void test(double b) {
		System.out.println("SqL ");
	}
	
	void test(char c) {
		System.out.println(" POSTMAN ");
	}
	
	public static void main(String[] args) {
		MethodOverLoadingEx mo = new MethodOverLoadingEx();
		mo.test(5);
		mo.test('s');
		mo.test(5.5);
		
	}
}
