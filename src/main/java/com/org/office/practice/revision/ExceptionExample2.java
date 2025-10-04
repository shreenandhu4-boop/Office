package com.org.office.practice.revision;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionExample2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int a=0;
		int b=0;
		int c=0;
		try {
		 a = scan.nextInt();
		 b = scan.nextInt();
		 c = 0;
		
			 c = a/b;
		}
		catch(ArithmeticException e) {
			System.out.println("Arithmetic exception, please retry");
		}
		catch(InputMismatchException e) {
			System.out.println("InputMismatchException");
		}
		System.out.println(" Final result of a/b is: " + c);
	}

}
