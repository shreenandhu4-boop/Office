package com.org.office.practice.ControlStatementsExmp;

public class JumpStatement { //two types 1.break, 2.continue
	public static void main(String[] args) {
	
		//break
		for(int i=1; i<=5; i++) //result will be 1,2,3,4,5,java
		{
			System.out.println(i);
			break; //if we use break the result will be 1,java because the loop breaks after printing i=1
		}
		System.out.println("java");
		
		//continue
		for(int i=1; i<=5; i++ ) {
			System.out.println(i);
			continue;// condition executes
		}
	System.out.println("java");
	
	for(int i=1; i<=5; i++ ) {
		System.out.println(i);
		return;
	}
	System.out.println("java");
	
	
	}

}
