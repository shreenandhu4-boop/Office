package com.org.office.practice.model;

public class StringOperations {
	
	
	public static void main(String[] args) {
		
		
		String s1 = "My name is nandhini";
		
		String blankString = "";
		
		String s2 = new String ("Heloow world");
		
		String s3 = s1.concat(" ").concat(s2);
		
		System.out.println(s3);
		
		System.out.println(s1.charAt( 1 ));
		
		System.out.println(s1.contains("nandhiniff"));
		
		System.out.println(s1.toLowerCase());
		
		System.out.println(s1.toUpperCase());
		
		System.out.println(s1.length());
		
		System.out.println(s1.replace(" ", "_"));
		
		System.out.println(blankString.isBlank());
		
		System.out.println(s1.endsWith("nandhini"));
		
		
		
		
		String inValueInString = String.valueOf(10);
		
		
		System.out.println(inValueInString + inValueInString) ;
		
		
		
		
		
		
	}

}
