package com.org.office.practice.javastring;

public class StringConcatenationExmp {
public static void main(String[] args) {
	
	// + operator
	String s ="Anikha" + " Vaishali";
	String a = 50+30+"Hello"+40+40;
	
	System.out.println(s);//Anikha Vaishali
	System.out.println(a); //80Hello4040 after string literal all the + will be treated as string
	
	//.concat(string another)
	String x ="good ";
	String y = "day";
	String z = x.concat(y);
	
	System.out.println(z);//good day
	
	//StringBuffer and StringBuilder is a class-->mutable class
	//which means values stored in StringBuilder objects can be updated or changed.
	//append() method accepts arguments of different types(char,int,float,double,StringBuilder,objects,boolean)
	
	String firstName = "Nandhini";
	String lastName = "Purushothaman";
	
	StringBuilder stringBuilder = new StringBuilder();
	stringBuilder.append("Hello, ");
	stringBuilder.append(firstName);
	stringBuilder.append(" ");
	stringBuilder.append(lastName);
	String result = stringBuilder.toString();
	System.out.println(result);
	
	//String.join() method
	
	String firstNamef = "Nandhini";
	String lastNamel = "Purushothaman";
	String output1 = String.join(" ","Hello,", firstNamef, lastNamel  );
	//String.format() method
	String output2 = String.format("Hello, %s %s", firstNamef, lastNamel  ); //format specifier for string objects or values %s-->firstNamef %s-->lastNamel
	
	System.out.println(output1);
	System.out.println(output2);
}
}
