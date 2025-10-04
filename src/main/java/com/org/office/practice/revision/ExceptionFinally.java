package com.org.office.practice.revision;

public class ExceptionFinally {
	public static void main(String[] args) {
		
	
	
	try {
		int a=10/0;
		
	}
catch(Exception e)
	{
	System.out.println(e);
	
	}
	//if error occurs or not the finally block will works
	finally {
		System.out.println("hi i am finally");
	} // finally is used to open or close any file or resource

	
	}
	
	
}