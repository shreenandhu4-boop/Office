package com.org.office.practice.examples;

public class UsingString {

	public static void main(String[] args) {

		String s1 = "My name is nandhini";
		@SuppressWarnings("unused")
		String blankString = "";
		String s2 = new String("hello world");
		 

		System.out.println(s1);

		// s1 length
		System.out.println("string lenght:" + s1.length());

		// replace with "_"
		System.out.println(s1.replace(" ", "_"));
		
		// index of n
		System.out.println(s1.indexOf("n"));
		
		//add two string
		System.out.println(s1.concat(" ").concat(s2));
		
		//given string present or not(true or false)
		System.out.println(s1.contains("nandhini"));
		
		//change to uppercase
		System.out.println(s1.toUpperCase());
		
		String originalString = "My Name is Nandhini";

		StringBuilder stringBuilder = new StringBuilder(originalString);

		stringBuilder.reverse();

		String reversedString = stringBuilder.toString();

		System.out.println("Original String: " + originalString);
		System.out.println("Reversed String: " + reversedString);
	}

}
