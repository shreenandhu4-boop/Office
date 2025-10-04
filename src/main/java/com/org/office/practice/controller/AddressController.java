package com.org.office.practice.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.office.practice.data.AddressData;

import com.org.office.practice.exceptions.DuplicatePrimaryAddressException;
import com.org.office.practice.exceptions.UpdationOfDuplicatePrimaryAddressException;
import com.org.office.practice.service.AddressService;
import com.org.office.practice.util.AddressTableExcelGenerator;
import com.org.office.practice.util.PersonTableExcelGenerator;

@RestController
@RequestMapping("/address")
public class AddressController {
@Autowired
JdbcTemplate jdbcTemplate;

@Autowired
AddressService addressService;

@PostMapping("/create")
public ResponseEntity<Long> createAddressData(@RequestBody AddressData addressDataObjectRequest) throws DuplicatePrimaryAddressException {
	Long result = addressService.createAddressData(addressDataObjectRequest, 0);
	return ResponseEntity.ok().body(result);

}

@PostMapping("/update-by-id")
public ResponseEntity<Long> updateAddressData(@RequestBody AddressData addressDataObjectRequest) throws UpdationOfDuplicatePrimaryAddressException {
	Long result = addressService.updateAddressData(addressDataObjectRequest, 0);
	return ResponseEntity.ok().body(result);
}

@GetMapping("/delete-by-id")
public ResponseEntity<Long> deleteAddressData(int adId) {
	Long result = addressService.deleteAddressData(adId);
	return ResponseEntity.ok().body(result);

}

@GetMapping("/deleteAll")
public ResponseEntity<Long> deleteAllAddressData() {
	Long result = addressService.deleteAllAddressData();
	return ResponseEntity.ok().body(result);
}

@GetMapping("/retriveAll")
public ResponseEntity<List<AddressData>> retriveAllAddressData() {
	List<AddressData> addressData = addressService.retriveAllAddressData();
	return ResponseEntity.ok().body(addressData);
}

@GetMapping("/retrive-by-id")
public ResponseEntity<AddressData> retriveAddressData(int adId) {
	AddressData addressData = addressService.retriveAddressData(adId);
	return ResponseEntity.ok().body(addressData);
}
@GetMapping("/export/excel")
public ResponseEntity<InputStreamResource> exportExcel() throws IOException {

	List<AddressData> addressDataList = addressService.retriveAllAddressData();
	List<String> headers = Arrays.asList("adId", "doorNo", "street", "addressLine1", "addressLine2", 
			"district", "pincode", "state", "personId", "addressType");
	String sheetName = "PersonAddress";
	String fileName = "personAddress.xlsx";

	ByteArrayInputStream in = AddressTableExcelGenerator.dataToExcel(addressDataList, sheetName, headers);

	HttpHeaders headersResponse = new HttpHeaders();
	headersResponse.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);

	return ResponseEntity.ok().headers(headersResponse)
			.contentType(
					MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
			.body(new InputStreamResource(in));
}
}
