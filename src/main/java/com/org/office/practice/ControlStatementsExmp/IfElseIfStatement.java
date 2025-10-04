package com.org.office.practice.ControlStatementsExmp;

public class IfElseIfStatement {
public static void main(String[] args) {
	String city = "Meerut";
	if(city == "Meerut") {
		System.out.println("city is meerut");
	} else if(city == "Noida") {
		System.out.println("city is noida");
		
	}else if(city=="Agra") {
		System.out.println("city is agra");
	} else {
		System.out.println(city);
	}
}
}
