package com.org.office.practice.examples;

public class MyConcreteClass {
	
 public void displayMessage() { //concrete method
	 
	 System.out.println("this is a concrete method");
	 
 }
 
 //another concrete method with parameters
 public int addNumber(int a, int b) {
	 return a + b;
 }
public static void main(String[] args) {
	MyConcreteClass obj = new MyConcreteClass();
	obj.displayMessage(); //calling concrete method
	int sum = obj.addNumber(5,10);
	System.out.println("sum: " + sum);

}
}
