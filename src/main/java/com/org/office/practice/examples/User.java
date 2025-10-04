package com.org.office.practice.examples;

import java.io.OptionalDataException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class User {

	    private String name;
	    private String gender;
	    private int age;
	    private String email;
	    

	    public User(String name, String gender, int age, String email) {
	        this.name = name;
	        this.gender = gender;
	        this.age = age;
	        this.email = email;
	    }

	    // Getters for user details
	    public String getName() {
	        return name;
	    }
	    
	    public String getGender() {
	        return gender;
	    }

	    public int getAge() {
	        return age;
	    }

	    public String getEmail() {
	        return email;
	    }

	    @Override
	    public String toString() {
	        return "Name: " + name + ", Gender: " + gender + ", Age: " + age + ", Email: " + email;
	    }
	


	    public static void main(String[] args) {
	        // Create an ArrayList to store User objects
	        ArrayList<User> userList = new ArrayList<>();
	       

	        System.out.println("--- User Details Management System ---");
	        // Add some sample users
	        userList.add(new User("Alice Smith", "male", 30, "alice@example.com"));
	        userList.add(new User("Amy", "female", 25, "amy@example.com"));
	        userList.add(new User("grey", "female", 27, "grey4@example.com"));
	        userList.add(new User("ronald", "male", 29, "ronald@example.com"));
	        userList.add(new User("jack", "male", 29, "jack@example.com"));
	        userList.add(new User("marry", "female", 50, "marry@example.com"));
	        userList.add(new User("richard", "male", 55, "richard@example.com"));
	        userList.add(new User("rechal", "female", 53, "rechal@example.com"));
	        userList.add(new User("harry", "male", 58, "harry@example.com"));
	        userList.add(new User("peter", "male", 59, "peter@example.com"));
	        userList.add(new User("Aisha", "female", 60, "ronald@example.com"));
	        
//add 5 more users, with age above 50, get list of emailIds of users with age above 50 and below 50
	        ArrayList<String> maleUsers = new ArrayList<>();
	        ArrayList<String> femaleUsers = new ArrayList<>();
	        
	        for(int index=0; index<userList.size(); index++) {
	        	User userObj = userList.get(index);
	        	if(userObj.getGender().equals("male")) {
	        		 maleUsers.add(userObj.getName());
	        		 }
	        	if(userObj.getGender().equals("female")) {
	        		femaleUsers.add(userObj.getName());
	        	}
	        		
	        	
	       
	        }
	        
	        List<String> emailsAbove50 = userList.stream()	
	        		.filter(userLists -> userLists.getAge() > 50)
	        		.map(User::getEmail)
	        		.collect(Collectors.toList());
	        System.out.println("email : " + emailsAbove50);
	        
	        List<String> emailsbelow50 = userList.stream()	
	        		.filter(userLists -> userLists.getAge() < 50)
	        		.map(User::getEmail)
	        		.collect(Collectors.toList());
	        System.out.println("email : " + emailsbelow50);
	        
	     
	         System.out.println("male users : "  + maleUsers);
	        System.out.println("female users : " + femaleUsers);
	    }
	      	        
}



