package com.org.office.practice.dto;

public class EmployeeData {
public String name;
public int age;
public String department;
public double salary;


public EmployeeData(String name, int age, String department, double salary) {
	super();
	this.name = name;
	this.age = age;
	this.department = department;
	this.salary = salary;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
@Override
public String toString() {
	return "EmployeeData [name=" + name + ", age=" + age + ", department=" + department + ", salary=" + salary + "]";
}
public void setAge(int age) {
	this.age = age;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}



}
