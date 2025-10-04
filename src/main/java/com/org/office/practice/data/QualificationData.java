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
@Table(name="qualification")
public class QualificationData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "q_id")
	int qId;
	@Column(name= "grade_degree")
	String gradeDegree;
	@Column(name= "institute")
	String institute;
	@Column(name= "year_of_complition")
	String yearOfComplition;
	@Column(name= "percentage")
	Double percentage;
	@Column(name= "status")
	String status;
	
	@ManyToOne
    @JoinColumn(name = "person_id") // Foreign key column
    @JsonBackReference
	PersonData personData;
	

	public QualificationData(int qId, String gradeDegree, String institute, String yearOfComplition, Double percentage,
			String status, PersonData personData) {
		super();
		this.qId = qId;
		this.gradeDegree = gradeDegree;
		this.institute = institute;
		this.yearOfComplition = yearOfComplition;
		this.percentage = percentage;
		this.status = status;
		this.personData = personData;
	}
	
	public QualificationData() {
		
	}

	public int getqId() {
		return qId;
	}

	public void setqId(int qId) {
		this.qId = qId;
	}

	public String getGradeDegree() {
		return gradeDegree;
	}

	public void setGradeDegree(String gradeDegree) {
		this.gradeDegree = gradeDegree;
	}

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public String getYearOfComplition() {
		return yearOfComplition;
	}

	public void setYearOfComplition(String yearOfComplition) {
		this.yearOfComplition = yearOfComplition;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public PersonData getPersonData() {
		return personData;
	}

	public void setPersonData(PersonData personData) {
		this.personData = personData;
	}
	
	

}
