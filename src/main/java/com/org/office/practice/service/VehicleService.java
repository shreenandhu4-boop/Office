package com.org.office.practice.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.office.practice.data.AddressData;
import com.org.office.practice.data.VehicleData;
import com.org.office.practice.exceptions.DuplicateVehicleNumberException;
import com.org.office.practice.exceptions.UpdationOfDuplicatePrimaryAddressException;

import com.org.office.practice.repository.VehicleRepository;

@Service
public class VehicleService {
	@Autowired
	VehicleRepository vehicleRepository;

	// to do should not allowed duplicate vehicle number
	public long createVehicleData(VehicleData vehicleDataObjectRequest) throws DuplicateVehicleNumberException {
		long insertedNumberOfRows = 0;

		String type = vehicleDataObjectRequest.getType();
		String model = vehicleDataObjectRequest.getModel();
		String brand = vehicleDataObjectRequest.getBrand();
		String color = vehicleDataObjectRequest.getColor();
		String vehicleNumber = vehicleDataObjectRequest.getVehicleNumber();
		List<VehicleData> vehicleNumberList = vehicleRepository.getByVehicleNo(vehicleNumber);
		if (vehicleNumberList != null) {
			if (vehicleNumberList.size() > 0) {
				throw new DuplicateVehicleNumberException(" The number already excist");
			} else {

				return vehicleRepository.createVehicleData(type, model, brand, color, vehicleNumber);
			}
		}
		return insertedNumberOfRows;

	}

	// the update should not result in duplicate vehicleNumber
	public long updateVehicleData(VehicleData vehicleDataObjectRequest) throws DuplicateVehicleNumberException {

		int vId = vehicleDataObjectRequest.getvId();
		String type = vehicleDataObjectRequest.getType();
		String model = vehicleDataObjectRequest.getModel();
		String brand = vehicleDataObjectRequest.getBrand();
		String color = vehicleDataObjectRequest.getColor();
		String vehicleNumber = vehicleDataObjectRequest.getVehicleNumber();

		List<VehicleData> vehicleNumberList = vehicleRepository.getByVehicleNo(vehicleNumber);

		if (vehicleNumberList.size() > 0) {
			VehicleData vehicleNumberPresentInDb = vehicleNumberList.get(0);
			if (vehicleNumberPresentInDb.getvId() == vId) {
				return vehicleRepository.updateVehicleData(type, model, brand, color,vehicleNumber, vId);
			} else {
				throw new DuplicateVehicleNumberException(" The number cannot be update");
			}
		}

		return vehicleRepository.updateVehicleData(type, model, brand, color, vehicleNumber, vId);

	}

	public long deleteVehicleData(int vId) {

		return vehicleRepository.deleteVehicleData(vId);

	}

	public long deleteAllVehicleData() {

		return vehicleRepository.deleteAllVehicleData();

	}

	public List<VehicleData> retriveAllVehicleData() {

		return vehicleRepository.retriveAllVehicleData();
	}

	public VehicleData retriveVehicleData(int vId) {

		return vehicleRepository.retriveVehicleData(vId);
	}

}
