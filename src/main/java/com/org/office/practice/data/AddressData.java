package com.org.office.practice.data;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="address")
public class AddressData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "ad_id")
	int adId;
	@Column(name= "door_no")
	String doorNo;
	@Column(name= "street")
	String street;
	@Column(name= "address_line_1")
	String addressLine1;
	@Column(name= "address_line_2")
	String addressLine2;
	@Column(name= "district")
	String district;
	@Column(name= "pincode")
	String pincode;
	@Column(name= "state")
	String state;
	@Column(name= "address_type")
	String addressType;
	 
	@ManyToOne
    @JoinColumn(name = "persons_id") // Foreign key column
    @JsonBackReference
	PersonData personData;
	

	public AddressData(int adId, String doorNo, String street, String addressLine1, String addressLine2,
			String district, String pincode, String state, String addressType, PersonData personData) {
		super();
		this.adId = adId;
		this.doorNo = doorNo;
		this.street = street;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.district = district;
		this.pincode = pincode;
		this.state = state;
		this.addressType = addressType;
		this.personData = personData;
	}

	public AddressData() {
		
	}
	public int getAdId() {
		return adId;
	}

	public void setAdId(int adId) {
		this.adId = adId;
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

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public PersonData getPersonData() {
		return personData;
	}

	public void setPersonData(PersonData personData) {
		this.personData = personData;
	}
	
	

		
}
