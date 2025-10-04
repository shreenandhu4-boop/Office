package com.org.office.practice.examples;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UsingHashSet {
	public static void main(String[] args) {
		Set<Integer> s = new HashSet<Integer>();
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		System.out.println("Set: " +s);
	//hash set is an unordered collection of unique elements	
		System.out.println("HashCode value: " + s.hashCode()); 
	
	
	Set<String> ss =new LinkedHashSet<>(); //liked is used to maintain order 
	ss.add("Apple");
	ss.add("orange");
	ss.add("banana");
	
	System.out.println("size of the set: " + ss.size());
	 for(String a:ss) {
		 System.out.println(a);
	 }
	
	 Scanner sc= new Scanner(System.in);
	 Set<Integer> si=new HashSet<>();
	 si.add(1);
	 si.add(28);
	 si.add(30);
	 si.add(100);
	 si.add(50);
	 
	 int n =sc.nextInt();
	 if (si.contains(n)) {
		System.out.println("data found");
	} else
		System.out.println("unfound data");
	 
	
	
	
	}
}
