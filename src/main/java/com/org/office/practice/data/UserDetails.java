package com.org.office.practice.data;
import java.util.Date;

public class UserDetails {
	int id;
	String name;
	String gender;
	String phone;
	String password;
	public UserDetails(int id, String name, String gender, String phone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.password= password;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}

	public void setPhone(String  phone) {
		this. phone =  phone;
	}

}
