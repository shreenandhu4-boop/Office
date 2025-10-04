package com.org.office.practice.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class UsingSet {
public static void main(String[] args) {
	Set<String> s1 = new HashSet<>(); 
	s1.add("sai");
	s1.add("shree");
	s1.add("dhakshwin");
	s1.add("lily");
	s1.add("sai");
	System.out.println(s1);
	
	s1.remove("shree");
	System.out.println("set after removig shree:"+ s1);
	
	Iterator<String> i1=s1.iterator();
	while(i1.hasNext())
		System.out.println(i1.next());
	
	s1.remove("sai");
	System.out.println("after removing sai" + s1);
	
	
	//operations union, intersection, difference
	Set<Integer> s2 = new HashSet<Integer>();
	s2.addAll(Arrays.asList(new Integer[] {1,3,2,4,8,9,0}));
	
	Set<Integer> s3 = new HashSet<Integer>();
	s3.addAll(Arrays.asList(new Integer[] {1,3,4,7,5,0,7,5}));
	
	//union
	Set<Integer> u = new HashSet<Integer>(s2);
	u.addAll(s3);
	System.out.println("union of two set :"+ u);
	
	//intersection
	Set<Integer> i = new HashSet<Integer>(s2);
	i.retainAll(s3);
	System.out.println("intersection of two set :"+ i);
	
	//difference
	Set<Integer> d = new HashSet<Integer>(s2);
	d.removeAll(s3);
	System.out.println("difference of two set :"+ d);
	
}
}
