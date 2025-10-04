package com.org.office.practice.ControlStatementsExmp;

public class SimpleIfStatement {
	public static void main(String[] args) {
		int x = 10;
		int y = 12;
		if(x + y > 20) { 	//if the condition is true the blocks ends here
			System.out.println("x+y is greater than 20");
		} else { 			//if the condition is false it goes to else block
			System.out.println("x+y is lesser than 20");
		}
	}

}
