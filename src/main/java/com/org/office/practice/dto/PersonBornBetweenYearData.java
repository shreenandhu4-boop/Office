package com.org.office.practice.dto;

import java.util.Date;

public class PersonBornBetweenYearData {
	private int personId;
	private String name;
	private Date dob;
	
	
	public PersonBornBetweenYearData(int personId, String name, Date dob) {
		super();
		this.personId=personId;
		this.name=name;
		this.dob=dob;
		
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	

	
}
