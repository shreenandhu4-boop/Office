package com.org.office.practice.examples;

import java.util.TreeSet;

public class UsingTreeSet {
public static void main(String[] args) {
	TreeSet ts = new TreeSet();
	ts.add(10);
	ts.add(20);
	ts.add(3);
	ts.add(1);
	ts.add(50);
	ts.add(5);
	
	System.out.println(ts); //Treeset is a sorted collection 
	System.out.println("first element : "+ ts.first());
	System.out.println("last element: "+ ts.last());
	System.out.println("lower element using headset : " + ts.headSet(10));
	System.out.println("greater element using tailset :  "+ ts.tailSet(20));
	System.out.println("first element : "+ ts.pollFirst()); //shows first element and then it will be deleted
	System.out.println("after pollfirst the remaining elements are: " + ts);
	System.out.println("last element will be deleted: "+ ts.pollLast());
	System.out.println("after poll last : " + ts);
}
}
