package com.org.office.practice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.org.office.practice.data.AddressData;
import com.org.office.practice.data.ContactData;
import com.org.office.practice.data.PersonData;
import com.org.office.practice.data.QualificationData;
import com.org.office.practice.data.RelativeData;
import com.org.office.practice.data.VehicleData;
import com.org.office.practice.dto.AgeOfpersonData;
import com.org.office.practice.dto.CountByEducationData;
import com.org.office.practice.dto.OverAllPersonData;
import com.org.office.practice.dto.PersonBornBetweenYearData;
import com.org.office.practice.dto.PersonPhoneAndAddressResponce;


import com.org.office.practice.exceptions.DuplicateMobileNumberException;
import com.org.office.practice.exceptions.DuplicatePrimaryAddressException;
import com.org.office.practice.exceptions.DuplicateVehicleNumberException;
import com.org.office.practice.jpaRepository.PersonDataJpaRepository;
import com.org.office.practice.repository.AddressRepository;
import com.org.office.practice.repository.ContactRepository;
import com.org.office.practice.repository.PersonRepository;
import com.org.office.practice.repository.QualificationRepoository;
import com.org.office.practice.repository.RelativeRepository;
import com.org.office.practice.repository.VehicleRepository;


@Service
public class PersonService{

	@Autowired
	PersonRepository personRepository;
	@Autowired
	PersonDataJpaRepository personDataJpaRepository;
	@Autowired
	ContactRepository contactRepository;
	@Autowired
	AddressRepository addressRepository;
	@Autowired
	QualificationRepoository qualificationRepoository;
	@Autowired
	RelativeRepository relativeRepository;
	@Autowired
	VehicleRepository vehicleRepository;

	@Autowired
	AddressService addressService;
	@Autowired
	ContactService contactService;
	@Autowired
	QualificationService qualificationService;
	@Autowired
	VehicleService vehicleService;
	@Autowired
	RelativeService relativeService;

	public PersonData createOrUpdatePersonData(PersonData personDataObjectRequest) {

//		String name = personDataObjectRequest.getName();
//		String gender = personDataObjectRequest.getGender();
//		String dob = personDataObjectRequest.getDob();
//		String status = personDataObjectRequest.getStatus();
//		String bloodGroup = personDataObjectRequest.getBloodGroup();
//		return personRepository.createPersonData(name, gender, dob, status, bloodGroup);
		return personDataJpaRepository.save(personDataObjectRequest);

	}

	public String createMultiplePersonData(List<PersonData> personDataList) {
		for (PersonData personObj : personDataList) {
			createOrUpdatePersonData(personObj);
		}
		return "succesfully saved all multiple person data";
	}

	

	public void deletePersonData(int personId) {

		 personDataJpaRepository.deleteById(personId);;

	}

	public long deleteAllPersonData() {

		return personRepository.deleteAllPersonData();

	}

	public List<PersonData> retriveAllPersonData() {

		return personDataJpaRepository.findAll();
	}

	public PersonData retrivePersonData(int personId) {

		Optional<PersonData> personData= personDataJpaRepository.findById(personId);
		if(personData.isPresent()) {
			return personData.get();
		} else {
			return null;
		}
	}

	public PersonPhoneAndAddressResponce getPersonPhoneAndAddress(int personId) {

		List<ContactData> contactList = contactRepository.retriveAllContactDataByPersonId(personId);
		List<ContactData> mobileContacts = new ArrayList<>();

		for (ContactData contactObj : contactList) {

			if (contactObj.getContactType().equals("mobile") && contactObj.getIsActive().equals("yes")) {
				mobileContacts.add(contactObj);
			}
		}

		List<AddressData> addressList = addressRepository.retriveAllAddressDataByPersonId(personId);
		List<AddressData> primaryAddresslist = new ArrayList<>();

		for (AddressData addressobj : addressList) {
			if (addressobj.getAddressType().equals("primary address")) {
				primaryAddresslist.add(addressobj);
			}
		}

		PersonPhoneAndAddressResponce responseData = new PersonPhoneAndAddressResponce();
		responseData.setContactList(mobileContacts);
		responseData.setAddressList(primaryAddresslist);
		responseData.setPersonId(personId);
		return responseData;

	}

	public List<CountByEducationData> getCountByEducationGrade() {

		return personRepository.getCountByEducationGrade();
	}

	public List<PersonBornBetweenYearData> getPersonBornbetweenYears(int fromYear, int toYear) {

		return personDataJpaRepository.findPersonsBornBetweenYears(fromYear, toYear);
	}

	public List<AgeOfpersonData> getAllPersonsAgeWithNameAndPersonId() {
		return personRepository.getAllPersonsAgeWithNameAndPersonId();
	}

	public long createOverAllPersonData(OverAllPersonData overAllPersonData) {
		PersonData personData = overAllPersonData.getPersondata();
		PersonData personDataSavedIntoDb = createOrUpdatePersonData(personData);
		int personIdIntValue = personDataSavedIntoDb.getPersonId() ;
		List<AddressData> addressList = overAllPersonData.getAddressList();
		for (AddressData addressObj : addressList) {
			try {
				//addressObj.setPersonsId(personIdIntValue);
				addressService.createAddressData(addressObj, personIdIntValue);
			} catch (DuplicatePrimaryAddressException e) {

				e.printStackTrace();
			}
		}
		List<ContactData> contactList = overAllPersonData.getContactList();
		for (ContactData congtactObj : contactList) {
			try {
			//	congtactObj.setpId(personIdIntValue);
				contactService.createContactData(congtactObj);
			} catch (DuplicateMobileNumberException e) {

				e.printStackTrace();
			}

		}
		List<QualificationData> qualificationData = overAllPersonData.getQualificationList();
		for (QualificationData qualificationObj : qualificationData) {
			//qualificationObj.setPersonId(personIdIntValue);
			qualificationService.createQualificationData(qualificationObj);

		}
		List<RelativeData> relativeData = overAllPersonData.getRelativeList();
		for (RelativeData relativeObj : relativeData) {
			//relativeObj.setPerId(personIdIntValue);
			relativeService.createRelativeData(relativeObj);
		}
		List<VehicleData> vehicleData = overAllPersonData.getVehicleList();
		for (VehicleData vehicleObj : vehicleData) {
			//vehicleObj.setPersId(personIdIntValue);
			try {
				vehicleService.createVehicleData(vehicleObj);
			} catch (DuplicateVehicleNumberException e) {

				e.printStackTrace();
			}
		}

		return (long)personIdIntValue;
	}

	public OverAllPersonData getOverAllPersonDataByPersonId(int personId) {

		PersonData personData = personRepository.retrivePersonData(personId);

		List<AddressData> addressList = addressRepository.retriveAllAddressDataByPersonId(personId);

		List<QualificationData> qualificationList = qualificationRepoository
				.retriveQualificationDataByPersonId(personId);

		List<RelativeData> relativeList = relativeRepository.retriveRelativeDataByPersonId(personId);

		List<VehicleData> vehicleList = vehicleRepository.retriveVehicleDataByPersonId(personId);

		List<ContactData> contactList = contactRepository.retriveAllContactDataByPersonId(personId);

		OverAllPersonData retriveOverAllPersonData = new OverAllPersonData();

		retriveOverAllPersonData.setPersondata(personData);
		retriveOverAllPersonData.setAddressList(addressList);
		retriveOverAllPersonData.setQualificationList(qualificationList);
		retriveOverAllPersonData.setRelativeList(relativeList);
		retriveOverAllPersonData.setVehicleList(vehicleList);
		retriveOverAllPersonData.setContactList(contactList);
		return retriveOverAllPersonData;
	}
	
	 
}