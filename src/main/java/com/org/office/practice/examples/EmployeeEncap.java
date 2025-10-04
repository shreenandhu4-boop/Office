package com.org.office.practice.examples;

 class EmployeeEncap {
	 private int id;
	 private String name; //encapsulated data should be private

	 public void setId(int id) {
	        this.id = id;
	    }
	 public void setName(String name) {
	        this.name = name;
	    } //set method
	 
	 public int getId() {    //get method
	        return id;
	    }

	    public String getName() {
	        return name;
	    }

 public static void main(String[] args) {
	 
     EmployeeEncap emp = new EmployeeEncap();
     
     // Using setters
     emp.setId(101);
     emp.setName("nandhini");

     // Using getters
     System.out.println("Employee ID: " + emp.getId());
     System.out.println("Employee Name: " + emp.getName());
 }
 }