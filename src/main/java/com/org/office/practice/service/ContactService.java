package com.org.office.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.office.practice.data.AddressData;
import com.org.office.practice.data.ContactData;
import com.org.office.practice.data.VehicleData;
import com.org.office.practice.dto.ContactInformation;
import com.org.office.practice.dto.PersonContactResultSetDto;
import com.org.office.practice.exceptions.ContactNotFoundException;
import com.org.office.practice.exceptions.DuplicateMobileNumberException;
import com.org.office.practice.exceptions.DuplicatePrimaryAddressException;
import com.org.office.practice.exceptions.DuplicateVehicleNumberException;
import com.org.office.practice.repository.ContactRepository;

@Service
public class ContactService {

	@Autowired
	ContactRepository contactRepository;

//duplicate mobile number not allowed
	public long createContactData(ContactData contactDataObjectRequest) throws DuplicateMobileNumberException {
		long insertedNumberOfRows = 0;
		String contactType = contactDataObjectRequest.getContactType();
		String contactValue = contactDataObjectRequest.getContactDetail();
		String isActive = contactDataObjectRequest.getIsActive();
		

		List<ContactData> contactList = contactRepository.getContactByContactValue(contactValue);
		if (contactList != null) {
			if (contactList.size() > 0) {
				throw new DuplicateMobileNumberException("the number already excist ");
			}

			else {
				insertedNumberOfRows = contactRepository.createContactData(contactType, contactValue, isActive,
						0);
			}
		}else {
			insertedNumberOfRows = contactRepository.createContactData(contactType, contactValue, isActive,
					0);
		}
		return insertedNumberOfRows;

	}

//the update should not allowed duplicate mobile number
	public long updateContactData(ContactData contactDataObjectRequest) throws DuplicateMobileNumberException {
		int cId = contactDataObjectRequest.getcId();
		String contactType = contactDataObjectRequest.getContactType();
		String contactValue = contactDataObjectRequest.getContactDetail();
		String isActive = contactDataObjectRequest.getIsActive();
		

		List<ContactData> contactList = contactRepository.getContactByContactValue(contactValue);

		if (contactList.size() > 0) {
			ContactData contactDetailPresentInDb = contactList.get(0);
			if (contactDetailPresentInDb.getcId() == cId) {
				return contactRepository.updateContactData(contactType, contactValue, isActive, 0, cId);
			} else {
				throw new DuplicateMobileNumberException(" The number cannot be update");
			}
		}

		return contactRepository.updateContactData(contactType, contactValue, isActive, 0, cId);

	}

	public ContactData retriveContactData(int cId) {

		return contactRepository.retriveContactData(cId);
	}

	public List<ContactData> retriveAllContactData() {

		return contactRepository.retriveAllContactData();
	}

	public long deleteContactData(int cId) {
		return contactRepository.deleteContactData(cId);
	}

	public long deleteAllContactData() {
		return contactRepository.deleteAllContactData();

	}

	public ContactInformation getContactInfoByPersonId(int personId) throws ContactNotFoundException {
		List<PersonContactResultSetDto> contactIfoResultSetDtos = contactRepository.getContactInfoByPersonId(personId);

		PersonContactResultSetDto personContactResultSetDto = null;
		try {

			personContactResultSetDto = contactIfoResultSetDtos.get(0);
		} catch (IndexOutOfBoundsException ex) {
			// throw new ContactNotFoundException("Contact data not found for this Person Id
			// : " + personId);
			personContactResultSetDto = new PersonContactResultSetDto();
		}
		ContactInformation contactResponse = new ContactInformation();
		contactResponse.setName(personContactResultSetDto.getName());
		contactResponse.setPersonId(personId);
		contactResponse.setMobile(personContactResultSetDto.getMobileNo());
		String completeAddress = personContactResultSetDto.getDoorNo() + "," + personContactResultSetDto.getStreet()
				+ "," + personContactResultSetDto.getAddressLine1() + "," + personContactResultSetDto.getAddressLine2()
				+ "," + personContactResultSetDto.getDistrict() + "," + personContactResultSetDto.getPincode() + ","
				+ personContactResultSetDto.getState();
		contactResponse.setAddress(completeAddress);
		return contactResponse;
	}
}
