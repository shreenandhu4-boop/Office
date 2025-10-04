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
@Table(name="contacts")
public class ContactData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "c_id")
	int cId;
	@Column(name= "contact_type")
	String contactType;
	@Column(name= "contact_detail")
	String contactDetail;
	@Column(name= "is_active")
	String isActive;
	
	
	@ManyToOne
    @JoinColumn(name = "p_id") // Foreign key column
    @JsonBackReference
	PersonData personData;
	
	public ContactData() {
		
	}
	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getContactType() {
		return contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

	public String getContactDetail() {
		return contactDetail;
	}

	public void setContactDetail(String contactDetail) {
		this.contactDetail = contactDetail;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public PersonData getPersonData() {
		return personData;
	}

	public void setPersonData(PersonData personData) {
		this.personData = personData;
	}

	public ContactData(int cId, String contactType, String contactDetail, String isActive, PersonData personData) {
		super();
		this.cId = cId;
		this.contactType = contactType;
		this.contactDetail = contactDetail;
		this.isActive = isActive;
		this.personData = personData;
	}
	
	
		
}



