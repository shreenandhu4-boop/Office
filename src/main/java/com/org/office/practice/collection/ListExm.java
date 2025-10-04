package com.org.office.practice.collection;

import java.util.ArrayList;

public class ListExm {
public static void main(String[] args) {
	
	ArrayList<Integer> numbersList = new ArrayList<>();
	numbersList.add(1);
	numbersList.add(2);
	numbersList.add(3);
	numbersList.add(4);
	numbersList.add(5);
	numbersList.add(6);
	numbersList.add(7);
	numbersList.add(8);
	numbersList.add(9);
	numbersList.add(10);
	
	    
	   int size=numbersList.size();
	  int lastIndex = size - 1;
	for( int currentIndex = lastIndex; currentIndex >= 0; currentIndex= currentIndex-1) {
		System.out.println(numbersList.get(currentIndex));
	}
	
}
}
