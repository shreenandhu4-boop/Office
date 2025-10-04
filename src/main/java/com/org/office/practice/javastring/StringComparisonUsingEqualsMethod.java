package com.org.office.practice.javastring;

public class StringComparisonUsingEqualsMethod {
	public static void main(String[] args) {
		String s1 ="john";
		String s2 ="john";
		String s3 =new String("john"); //s3 being developed with new keyword s1 and s3 had same content "only content is compared"
		String s4 ="jack";
		
		System.out.println(s1.equals(s2)); //true
		System.out.println(s1.equals(s3));//true
		System.out.println(s1.equals(s4));//false
		
		String a1 = "Rose";
		String a2 = "Rose";
		String a3 = new String("Rose");
	
		
		System.out.println(a1 == a2);//true
		System.out.println(a1 == a3);//false because newly ceated string object
		
		
		System.out.println(a1.compareTo(a2));//if it equals returns 0
	
		String str = "Hi welcome thank you";
		System.out.println(str.startsWith("Hi"));//true
		System.out.println(str.endsWith("you"));//true
		System.out.println(str.contains("welcome"));//true
	}

}
