package com.org.office.practice.data;

import java.util.List;



public class ToppersData {
	private int personId;
	private String name;
	private String gradeDegree;
	private double percentage;
	
	public ToppersData(int personId, String name, 
			String gradeDegree, double percentage  ) {
		
		super();
		this.personId=personId;
		this.name=name;
		this.gradeDegree=gradeDegree;
		this.percentage=percentage;
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

	public String getGradeDegree() {
		return gradeDegree;
	}

	public void setGradeDegree(String gradeDegree) {
		this.gradeDegree = gradeDegree;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

}
