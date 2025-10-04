package com.org.office.practice.dto;

public class CountByEducationData {
	private String grade;
	private int count;
	
	public CountByEducationData(String grade, int count) {
		super();
		this.grade=grade;
		this.count=count;
	}
	
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	

}
