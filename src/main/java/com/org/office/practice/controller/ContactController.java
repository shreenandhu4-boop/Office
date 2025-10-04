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

import com.org.office.practice.data.ContactData;
import com.org.office.practice.dto.ContactInformation;
import com.org.office.practice.exceptions.ContactNotFoundException;
import com.org.office.practice.exceptions.DuplicateMobileNumberException;
import com.org.office.practice.service.ContactService;
import com.org.office.practice.util.ContactTableExcelGenerator;


@RestController
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	ContactService contactService;

	@PostMapping("/create")
	public ResponseEntity<Long> createContactData(@RequestBody ContactData contactDataObjectRequest) throws DuplicateMobileNumberException {
		Long result = contactService.createContactData(contactDataObjectRequest);
		return ResponseEntity.ok().body(result);

	}

	@PostMapping("/update-by-id")
	public ResponseEntity<Long> updateContactData(@RequestBody ContactData contactDataObjectRequest) throws DuplicateMobileNumberException {
		Long result = contactService.updateContactData(contactDataObjectRequest);
		return ResponseEntity.ok().body(result);

	}

	@GetMapping("/retriveAll")
	public ResponseEntity<List<ContactData>> retriveAllContactData() {
		List<ContactData> contactData = contactService.retriveAllContactData();
		return ResponseEntity.ok().body(contactData);
	}

	@GetMapping("/retrive-by-id")
	public ResponseEntity<ContactData> retriveContactData(int cId) {
		ContactData contactData = contactService.retriveContactData(cId);
		return ResponseEntity.ok().body(contactData);

	}

	@GetMapping("/delete-by-id")
	public ResponseEntity<Long> deleteContactData(int cId) {
		Long result = contactService.deleteContactData(cId);
		return ResponseEntity.ok().body(result);

	}

	@GetMapping("/deleteAll")
	public ResponseEntity<Long> deleteAllContactData() {
		Long result = contactService.deleteAllContactData();
		return ResponseEntity.ok().body(result);

	}
	
	@GetMapping("/get-contact-by-personId")
	public ResponseEntity<ContactInformation> getContactInfoByPersonId(int personId) throws ContactNotFoundException {
		ContactInformation contactInformation = contactService.getContactInfoByPersonId(personId);
		return ResponseEntity.ok().body(contactInformation);
	}
	
	@GetMapping("/export/excel")
	public ResponseEntity<InputStreamResource> exportExcel() throws IOException {

		List<ContactData> contactDataList = contactService.retriveAllContactData();
		List<String> headers = Arrays.asList("cId", "contactType", "contactDetail", "isActive", "personId");
		String sheetName = "PersonContact";
		String fileName = "contacts.xlsx";

		ByteArrayInputStream in = ContactTableExcelGenerator.dataToExcel(contactDataList, sheetName, headers);

		HttpHeaders headersResponse = new HttpHeaders();
		headersResponse.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);

		return ResponseEntity.ok().headers(headersResponse)
				.contentType(
						MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
				.body(new InputStreamResource(in));
	}

}
