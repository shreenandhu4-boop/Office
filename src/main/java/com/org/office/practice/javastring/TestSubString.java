package com.org.office.practice.javastring;

public class TestSubString { // a part of string called substring
public static void main(String[] args) {
	
	String s = "Knoweledge Encyclopedia";
	System.out.println("Original string; " + s);
	System.out.println("SubString starting from index 6: " + s.substring(6));
	System.out.println("SubString starting from index 0 to 6: " + s.substring(0, 6));
}
}
