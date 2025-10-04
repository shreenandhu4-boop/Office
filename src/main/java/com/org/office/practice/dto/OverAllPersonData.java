package com.org.office.practice.dto;

import java.util.List;

import com.org.office.practice.data.AddressData;
import com.org.office.practice.data.ContactData;
import com.org.office.practice.data.PersonData;
import com.org.office.practice.data.QualificationData;
import com.org.office.practice.data.RelativeData;
import com.org.office.practice.data.VehicleData;

public class OverAllPersonData {
private PersonData persondata;
private List<AddressData> addressList;
private List<ContactData> contactList;
private List<QualificationData> qualificationList;
private List<RelativeData> relativeList;
private List<VehicleData> vehicleList;
public PersonData getPersondata() {
	return persondata;
}
public void setPersondata(PersonData persondata) {
	this.persondata = persondata;
}
public List<AddressData> getAddressList() {
	return addressList;
}
public void setAddressList(List<AddressData> addressList) {
	this.addressList = addressList;
}
public List<ContactData> getContactList() {
	return contactList;
}
public void setContactList(List<ContactData> contactList) {
	this.contactList = contactList;
}
public List<QualificationData> getQualificationList() {
	return qualificationList;
}
public void setQualificationList(List<QualificationData> qualificationList) {
	this.qualificationList = qualificationList;
}
public List<RelativeData> getRelativeList() {
	return relativeList;
}
public void setRelativeList(List<RelativeData> relativeList) {
	this.relativeList = relativeList;
}
public List<VehicleData> getVehicleList() {
	return vehicleList;
}
public void setVehicleList(List<VehicleData> vehicleList) {
	this.vehicleList = vehicleList;
}



}
