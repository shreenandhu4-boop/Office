package com.org.office.practice.data;

import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "person")
public class PersonData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "person_id")
	private int personId;
	@Column(name = "Name")
	private String name;
	@Column(name = "Gender")
	private String gender;
	@Column(name = "DOB")
	private Date dob;
	@Column(name = "Status")
	private String status;
	@Column(name = "Bloodgroup")
	private String bloodGroup;

	@OneToMany(mappedBy = "personData", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	List<ContactData> contactList;

	@OneToMany(mappedBy = "personData", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	List<QualificationData> qualificationData;

	@OneToMany(mappedBy = "personData", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	List<AddressData> addressData;

	@OneToMany(mappedBy = "personData", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	List<RelativeData> relativeData;

	@OneToMany(mappedBy = "personData", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	List<VehicleData> vehicleData;

	public PersonData() {

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public List<ContactData> getContactList() {
		return contactList;
	}

	public void setContactList(List<ContactData> contactList) {
		this.contactList = contactList;
	}

	public PersonData(int personId, String name, String gender, Date dob, String status, String bloodGroup,
			List<ContactData> contactList) {
		super();
		this.personId = personId;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.status = status;
		this.bloodGroup = bloodGroup;
		this.contactList = contactList;
	}

}
