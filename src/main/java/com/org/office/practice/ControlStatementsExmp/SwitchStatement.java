package com.org.office.practice.ControlStatementsExmp;

import java.util.Scanner;

public class SwitchStatement {
	public static void main(String[] args) { //this statement is called selection statement
		int a,b;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter first number : ");
		a = scanner.nextInt();
		System.out.println("enter second number: ");
		b = scanner.nextInt();
		char operator;
		System.out.println("enter the operator +, -, *, /, or % : ");
		operator = scanner.next().charAt(0);
		//"switch" is an alternative for "if" 
		switch(operator) { // switch is used when we handling  multiple scenario 
		case '+' :
			System.out.println(a+ "+" +b+ "=" + (a+b));
			break;
		case '-' :
			System.out.println(a+ "-" +b+ "=" + (a-b));
			break;
		case '*' :
			System.out.println(a+ "*" +b+ "=" + (a*b));
			break;
		case '/' :
			System.out.println(a+ "/" +b+ "=" + (a/b));
			break;
		case '%' :
			System.out.println(a+ "%" +b+ "=" + (a%b));
			break;
			default:
				System.out.println("you have entered incorrect operator");
				
		}

}
}
