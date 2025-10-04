package com.org.office.practice.service;

import java.nio.channels.IllegalChannelGroupException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.office.practice.data.AddressData;
import com.org.office.practice.exceptions.DuplicatePrimaryAddressException;
import com.org.office.practice.exceptions.UpdationOfDuplicatePrimaryAddressException;
import com.org.office.practice.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepository;

	public long createAddressData(AddressData addressDataObjectRequest, int personId) throws DuplicatePrimaryAddressException {
		long insertedNumberOfRows = 0;

		String doorNo = addressDataObjectRequest.getDoorNo();
		String street = addressDataObjectRequest.getStreet();
		String AddressLine1 = addressDataObjectRequest.getAddressLine1();
		String AddressLine2 = addressDataObjectRequest.getAddressLine2();
		String district = addressDataObjectRequest.getDistrict();
		String pincode = addressDataObjectRequest.getPincode();
		String state = addressDataObjectRequest.getState();
		
		String addressType = addressDataObjectRequest.getAddressType();
		if (addressType.equals("primary address")) {

			List<AddressData> primaryAddressList = addressRepository.getAddressByPersonIdAndAddressType(personId,
					addressType);
			if (primaryAddressList.isEmpty()) {
				insertedNumberOfRows = addressRepository.createAddressData(doorNo, street, AddressLine1, AddressLine2,
						district, pincode, state, addressType);
			}

			else {
				//  throw duplicate primary address exception,
				throw new DuplicatePrimaryAddressException("This address can not save as primary address ");

			}

		}
		if (addressType.equals("secondary address")) {
			insertedNumberOfRows = addressRepository.createAddressData(doorNo, street, AddressLine1, AddressLine2,
					district, pincode, state, addressType);
		}
		return insertedNumberOfRows;
	}

	/**
	 * this method will update person address received in request before updating we
	 * need to ensure that our address update will not result in duplicate primary
	 * address
	 * @param personsId 
	 *  
	 */
	public long updateAddressData(AddressData request, int personsId) throws UpdationOfDuplicatePrimaryAddressException {
		int adId = request.getAdId();
		String doorNo = request.getDoorNo();
		String street = request.getStreet();
		String addressLine1 = request.getAddressLine1();
		String addressLine2 = request.getAddressLine2();
		String district = request.getDistrict();
		String pincode = request.getPincode();
		String state = request.getState();
		String addressType = request.getAddressType();
	
		if (addressType.equals("secondary address")) {
			return addressRepository.updateAddressData(doorNo, street, addressLine1, addressLine2, district, pincode,
					state, addressType, adId);

		} else {
			List<AddressData> primaryAddressList = addressRepository.getAddressByPersonIdAndAddressType(personsId,
					addressType);
			if (primaryAddressList.size() > 0) {
				AddressData primaryAddressPresentInDb = primaryAddressList.get(0);
				if (primaryAddressPresentInDb.getAdId() == adId) {
					return addressRepository.updateAddressData(doorNo, street, addressLine1, addressLine2, district,
							pincode, state, addressType, adId);
				} else {
					// to do throw duplicatePrimaryAddressException
					throw new UpdationOfDuplicatePrimaryAddressException("Can not update Duplicate Primary Address for this Id ");
				}
			} else {
				return addressRepository.updateAddressData(doorNo, street, addressLine1, addressLine2, district,
						pincode, state, addressType, adId);
			}
		}

	}

	public long deleteAddressData(int adId) {

		return addressRepository.deleteAddressData(adId);

	}

	public long deleteAllAddressData() {

		return addressRepository.deleteAllAddressData();

	}

	public List<AddressData> retriveAllAddressData() {

		return addressRepository.retriveAllAddressData();
	}

	public AddressData retriveAddressData(int adId) {

		return addressRepository.retriveAddressData(adId);
	}

}
