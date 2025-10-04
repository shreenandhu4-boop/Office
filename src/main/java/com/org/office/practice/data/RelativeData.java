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
@Table(name="relatives")
public class RelativeData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "r_id")	
 int rId;
	@Column(name= "name")	
 String name;
	@Column(name= "phone_no")	
 String phoneNo;
	@Column(name= "relationship")	
 String relationship;
	
	@ManyToOne
    @JoinColumn(name = "per_id") // Foreign key column
    @JsonBackReference
	PersonData personData;

	public RelativeData(int rId, String name, String phoneNo, String relationship, PersonData personData) {
		super();
		this.rId = rId;
		this.name = name;
		this.phoneNo = phoneNo;
		this.relationship = relationship;
		this.personData = personData;
	}

	public RelativeData() {
		
	}
	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public PersonData getPersonData() {
		return personData;
	}

	public void setPersonData(PersonData personData) {
		this.personData = personData;
	}
 
}
