package com.org.office.practice.ControlStatementsExmp;

import java.util.Scanner;

public class DoWhileLoop {
	// if the given condition true or false but the given executed statement should run

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int count =0;
		
		do {
			System.out.println("Enter the number > 10");
			count= scan.nextInt();
		}while(count<10);      //executes untill the given input greater than 10
	}
}
