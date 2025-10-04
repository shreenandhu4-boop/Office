package com.org.office.practice.revision;

import java.util.Scanner;

public class ExceptionThrowKey {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in); 
		
		try {
			 int age= scan.nextInt();
			 if (age<1)
			 {
				throw new ArithmeticException("Age should be greater than 1"); 
			 }
			
		}
		catch(ArithmeticException e) 
		{
			System.out.println(e);
		}
		System.out.println("program ended");
	}

}
