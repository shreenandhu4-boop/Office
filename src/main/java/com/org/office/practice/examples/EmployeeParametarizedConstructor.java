package com.org.office.practice.examples;

public class EmployeeParametarizedConstructor {
	
    int id;
    String name;
    
    public EmployeeParametarizedConstructor(int employeeId, String employeeName) {
        
        this.id = employeeId;
        this.name = employeeName;
    }

    public void displayInfo() {
        System.out.println("Id: " + id + ", Name: " + name);
    }

    public static void main(String[] args) {
        
    	EmployeeParametarizedConstructor e1 = new EmployeeParametarizedConstructor(101,"Aathi" );
    	EmployeeParametarizedConstructor e2 = new EmployeeParametarizedConstructor(102,"Balaji");

        e1.displayInfo(); 
        e2.displayInfo();
    }

}
