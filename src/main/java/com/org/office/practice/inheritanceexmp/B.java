package com.org.office.practice.inheritanceexmp;

public class B extends C{
	//method consist of 4things
	//1. method name
	//2. return type
	//3. method body
	//4 method perameters
 int addNo(int num1, int num2) {
	int sum= num1 + num2;
	return sum;
}
	
 
 void  m1PresentInClassB()
 {
	 System.out.println("executing m1presentInClassB");
 }

void m2PresentInClassB() { 
	System.out.println("executing m2presentInClassB");
}
}
