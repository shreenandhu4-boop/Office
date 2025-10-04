package com.org.office.practice.dto;

public class PersonContactResultSetDto {
	private String name;
	private String mobileNo;
	private String doorNo;
	private String street;
	private String addressLine1;
	private String addressLine2;
	private String district;
	private String pincode;
	private String state;
	
	public PersonContactResultSetDto() {
		
	}
	
	public PersonContactResultSetDto(String name, String mobileNo, String doorNo, String street, String addressLine1,
			String addressLine2, String district, String pincode, String state) {
		super();
		this.name = name;
		this.mobileNo = mobileNo;
		this.doorNo = doorNo;
		this.street = street;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.district = district;
		this.pincode = pincode;
		this.state = state;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	

}
