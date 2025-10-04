package com.org.office.practice.javastring;
//immutable means unmodifiable or unchangeable

public class StringImmutable {
public static void main(String[] args) {
	String s = "Anikha"; //once string object created its data can not be changed
	s.concat("Vaishali");//but a new string object is created
	System.out.println(s);//result "Anikha" -->because strings are immutable


	s=s.concat(" Vaishali"); //s points to the "Anikha Vaishali"
	System.out.println(s);// Anikha object is not modified

}
}
