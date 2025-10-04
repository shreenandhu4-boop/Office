package com.org.office.practice.revision;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TypeCastingInJava {
	public static void main(String[] args) {
		
		int num = 10;
		double d = num; //int into double
		System.out.println("int to double: " + d);
		
		double dl = 10.99;
		int i = (int)dl; // double convert into int
		System.out.println("double to int : " + i);

		int a = 10;
		String strs= String.valueOf(a); //int to string
		System.out.println("int to string: " + strs);
		
		int maxScore =500;
		int userScore=423;
		float percentage = (float)userScore/maxScore * 100;
		System.out.println("percentage: " + percentage);
		
		 int num1 = 5004;
	     double num2 = 2.5;
	     double sum = num1 + num2;
	     System.out.println("sum: " + sum );
		
		
		//date to string
		Date now = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
		String dateToString = formatter.format(now);
		System.out.println("date to string: " + dateToString);
		
		//string to date
		String stringToDate ="2025-10-26 14:30:00";
		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date parsedDate = formatter1.parse(stringToDate);
			System.out.println("string to date: " + parsedDate);
		} catch (ParseException e) {
		
			e.printStackTrace();
			
		}
				
			}
	
	

}
