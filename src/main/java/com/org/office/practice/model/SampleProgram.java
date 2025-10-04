package com.org.office.practice.model;

import com.org.office.practice.controller.CompanyDetailsController;

public class SampleProgram {
	int add(int a, int b) {
		return a + b;
	}

	int subtraction(int a, int b) {
		return a - b;
	}

	int multiplication(int a, int b) {
		return a * b;
	}

	int divition(int a, int b) {
		return a / b;
	}

	public static void main(String[] args) {
		
		String s1 = "sathiya";
		String s2 = "Moorthi";
		
		int num1 = 100;
		int num2 = 200;
		
		
		String s3 = num1 + num2 + s1 + " "+ s2 + num1 + num2;
		
		System.out.println(s3);
		
	}
}
