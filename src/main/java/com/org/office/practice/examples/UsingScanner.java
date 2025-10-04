package com.org.office.practice.examples;

import java.util.Scanner;

public class UsingScanner {

	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in); //scanner object
		System.out.println("enter username : ");
		 
		String userName= myObj.nextLine(); // to read user input
	System.out.println("username is: " + userName);
	}
}
