package com.org.office.practice.examples;

public class EmployeeDefaultConstructor {
	 String name;
	    int age;
	    double salary;


	    public EmployeeDefaultConstructor() {
	        this.name = "Dhakshwin";
	        this.age = 25;
	        this.salary = 50000.0;
	    }

	    public void displayEmployeeDefaultConstructorInfo() {
	        System.out.println("Name: " + this.name);
	        System.out.println("Age: " + this.age);
	        System.out.println("Salary: " + this.salary);
	    }

	    public static void main(String[] args) {
	    	EmployeeDefaultConstructor employee1 = new EmployeeDefaultConstructor(); 
	        employee1.displayEmployeeDefaultConstructorInfo();
	    }


}

