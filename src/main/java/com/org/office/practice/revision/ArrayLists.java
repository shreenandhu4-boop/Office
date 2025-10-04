package com.org.office.practice.revision;

import java.util.ArrayList;
import java.util.List;

public class ArrayLists {
	
	public static void main(String[] args) {
		List<Integer> al = new ArrayList<>();
		al.add(10);
		al.add(20);
		al.add(25);
		System.out.println("given array element is : " + al);
		
		List<Integer> a1 = new ArrayList<>();
		for(int i=1; i<=10; i++)a1.add(i);
		System.out.println("elements are: " + a1);
		
		System.out.println("contains: " + a1.contains(7));
		System.out.println("indexof : " + a1.indexOf(7));
		System.out.println("get: " + a1.get(1));
		System.out.println("size: " + a1.size());
		System.out.println("hashcode: " + a1.hashCode());
		System.out.println("to string: " + a1.toString());
		System.out.println("is empty: " + a1.isEmpty());
		
		
		
		
		
		
		
		
	}

}
