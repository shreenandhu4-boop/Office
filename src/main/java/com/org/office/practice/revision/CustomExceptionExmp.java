package com.org.office.practice.revision;

import java.util.Scanner;


class NotValidException extends Exception{  // this class should extend exception class

	public NotValidException(String s) { //constructor for line 21
	super(s); // this string send to parent class (Exception) using with super() key
}
}

public class CustomExceptionExmp {
	public static void main(String[] args) {
	
	Scanner scan = new Scanner(System.in);
	
	try {
		int age = scan.nextInt();
		if(age<18) {
			throw new NotValidException("your age should be above 18");
		} //to create our exception first we have have create class for this exception (line no 6)
	}
	catch(NotValidException e) {
		System.out.println(e); //this catch block handle our exception
	}
	
	catch(Exception e) {
		System.out.println(e); //this block handle Inputmismatch exception
	}
}
}
