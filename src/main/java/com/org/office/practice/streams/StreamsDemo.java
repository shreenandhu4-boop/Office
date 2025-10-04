package com.org.office.practice.streams;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.org.office.practice.dto.EmployeeData;

public class StreamsDemo {
	
	
	public static void main(String[] args) {
		StreamsDemo obj = new StreamsDemo();
		
		List<EmployeeData> employeeList = obj.getEmployeeList();
		
		List<String> employeeNameListWithSalaryAbove30K = employeeList.stream()
		 				.filter(e -> e.getSalary() > 30000)
		 				.map(emp -> emp.getName())
		 				.filter(name -> name.startsWith("a"))
		 				.map(nameStartsWithA -> nameStartsWithA.toUpperCase())
		 				.collect(Collectors.toList());
		
		
		employeeNameListWithSalaryAbove30K.forEach(name -> {
			System.out.println(name);
		});
		
		
	}
	
	
	

	
	List<EmployeeData> getEmployeeList(){
		
		List<EmployeeData> employeeList = new ArrayList<>();
		EmployeeData employee1 = new EmployeeData("nandhini", 29,"software engineer", 20000 );
		EmployeeData employee2 = new EmployeeData("anikha", 25,"software engineer", 24000 );
		EmployeeData employee3 = new EmployeeData("anu", 26,"software engineer", 38000 );
		EmployeeData employee4 = new EmployeeData("deva", 39,"software engineer", 50000 );
		EmployeeData employee5 = new EmployeeData("dhakshwin", 29,"software engineer", 40000 );
		employeeList.add(employee1);
		employeeList.add(employee2);
		employeeList.add(employee3);
		employeeList.add(employee4);
		employeeList.add(employee5);
		return employeeList;
	}
	
}
