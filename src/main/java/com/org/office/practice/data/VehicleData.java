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
@Table(name="vehicle")
public class VehicleData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "v_id")
	int vId;
	@Column(name= "type")
	String type;
	@Column(name= "model")
	String model;
	@Column(name= "brand")
	String brand;
	@Column(name= "color")
	String color;
	@Column(name= "vehicle_number")
	String vehicleNumber;
	
	@ManyToOne
    @JoinColumn(name = "pers_id") // Foreign key column
    @JsonBackReference
	PersonData personData;

	public VehicleData(int vId, String type, String model, String brand, String color, String vehicleNumber,
			PersonData personData) {
		super();
		this.vId = vId;
		this.type = type;
		this.model = model;
		this.brand = brand;
		this.color = color;
		this.vehicleNumber = vehicleNumber;
		this.personData = personData;
	}

	public VehicleData() {
		
	}
	public int getvId() {
		return vId;
	}

	public void setvId(int vId) {
		this.vId = vId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public PersonData getPersonData() {
		return personData;
	}

	public void setPersonData(PersonData personData) {
		this.personData = personData;
	}
	
		
}
