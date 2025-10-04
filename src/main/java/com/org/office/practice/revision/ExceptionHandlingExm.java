package com.org.office.practice.revision;

import java.util.Scanner;

public class ExceptionHandlingExm {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		try {
			int a = scan.nextInt(); //have to  identify where error can occur
		 }							//here the input will be integer type
									//if the given input as string then the error will occurs
		//there is a chance line no 10 will throw error so that the line will put on Try block
		
					//like if - else condition
		catch(Exception e) { // if any error occurred in try block then it goes to catch block
			System.out.println(e); // catch will take parameter of "Exception" class with object as 'e'
		}						
	System.out.println("program ended");
}
}
//this is input mismatch exception