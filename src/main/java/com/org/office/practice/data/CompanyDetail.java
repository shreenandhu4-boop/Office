package com.org.office.practice.data;

public class CompanyDetail {

	int id;
	String name;
	String address;
	String industry;
	String city;

	public CompanyDetail(int id, String name, String address, String industry, String city) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.industry = industry;
		this.city = city;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
