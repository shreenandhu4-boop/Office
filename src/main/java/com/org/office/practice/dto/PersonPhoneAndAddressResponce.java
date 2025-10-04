package com.org.office.practice.dto;

import java.util.List;

import com.org.office.practice.data.AddressData;
import com.org.office.practice.data.ContactData;



public class PersonPhoneAndAddressResponce {

private int personId;
private List<ContactData> contactList;
private List<AddressData> addressList;

public int getPersonId() {
	return personId;
}
public void setPersonId(int personId) {
	this.personId = personId;
}
public List<ContactData> getContactList() {
	return contactList;
}
public void setContactList(List<ContactData> contactList) {
	this.contactList = contactList;
}
public List<AddressData> getAddressList() {
	return addressList;
}
public void setAddressList(List<AddressData> addressList) {
	this.addressList = addressList;
}



	
	
}
