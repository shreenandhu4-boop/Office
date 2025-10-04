package com.org.office.practice.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.office.practice.data.PersonData;
import com.org.office.practice.dto.AgeOfpersonData;
import com.org.office.practice.dto.CountByEducationData;
import com.org.office.practice.dto.OverAllPersonData;
import com.org.office.practice.dto.PersonBornBetweenYearData;
import com.org.office.practice.dto.PersonPhoneAndAddressResponce;
import com.org.office.practice.email.Email;
import com.org.office.practice.email.EmailExcelExportService;
import com.org.office.practice.email.EmailService;
import com.org.office.practice.jpaRepository.PersonDataJpaRepository;
import com.org.office.practice.service.PersonService;
import com.org.office.practice.util.PersonTableExcelGenerator;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonDataJpaRepository personDataJpaRepository;

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	EmailExcelExportService emailExcelExportService;
	
	
	
	@Autowired
	PersonService personService;

    PersonController(PersonDataJpaRepository personDataJpaRepository) {
        this.personDataJpaRepository = personDataJpaRepository;
    }

	@PostMapping("/create-or-update")
	public ResponseEntity<PersonData> createOrUpdatePersonData(@RequestBody PersonData personDataObjectRequest) {
		PersonData result = personService.createOrUpdatePersonData(personDataObjectRequest);
		return ResponseEntity.ok().body(result);

	}

	@PostMapping("/create-multiple-persons")
	public ResponseEntity<String> createMultiplePersonData(@RequestBody List<PersonData> personDataList) {
		String result = personService.createMultiplePersonData(personDataList);
		return ResponseEntity.ok().body(result);

	}

	@PostMapping("/create-overAll-person-information")
	public ResponseEntity<Long> createOverAllPersonData(@RequestBody OverAllPersonData overAllPersonData) {
		Long result = personService.createOverAllPersonData(overAllPersonData);
		return ResponseEntity.ok().body(result);

	}

	

	@GetMapping("/delete-by-id")
	public ResponseEntity<String> deletePersonData(int personId) {
		 personService.deletePersonData(personId);
		return ResponseEntity.ok().body("Deleted successfully");

	}

	@GetMapping("/deleteAll")
	public ResponseEntity<Long> deleteAllPersonData() {
	Long result	 = personService.deleteAllPersonData();
		return ResponseEntity.ok().body(result);
	}

	@GetMapping("/retriveAll")
	public ResponseEntity<List<PersonData>> retriveAllPersonData() {
		List<PersonData> personData = personService.retriveAllPersonData();
		return ResponseEntity.ok().body(personData);
	}

	@GetMapping("/retrive-by-id")
	public ResponseEntity<PersonData> retrivePersonData(int personId) {
		PersonData personData = personService.retrivePersonData(personId);
		return ResponseEntity.ok().body(personData);
	}

	@GetMapping("/get-phone-address-by-personId")
	public ResponseEntity<PersonPhoneAndAddressResponce> getPersonPhoneAndAddress(int personId) {
		PersonPhoneAndAddressResponce personPhoneAndAddressResponce = personService.getPersonPhoneAndAddress(personId);
		return ResponseEntity.ok().body(personPhoneAndAddressResponce);
	}

	@GetMapping("/get-count-by-education-grade")
	public ResponseEntity<List<CountByEducationData>> getCountByEducationGrade() {
		List<CountByEducationData> countByEducationData = personService.getCountByEducationGrade();
		return ResponseEntity.ok().body(countByEducationData);
	}

	@GetMapping("/get-person-born-between-years")
	public ResponseEntity<List<PersonBornBetweenYearData>> getPersonBornbetweenYears(int fromYear, int toYear) {
		List<PersonBornBetweenYearData> personBornBetweenYearData = personService.getPersonBornbetweenYears(fromYear, toYear);
		return ResponseEntity.ok().body(personBornBetweenYearData);
	}

	@GetMapping("/get-all-persons-age-with-name-and-personId")
	public ResponseEntity<List<AgeOfpersonData>> getAllPersonsAgeWithNameAndPersonId() {
		
		List<AgeOfpersonData> ageOfpersonData = personService.getAllPersonsAgeWithNameAndPersonId();
		return ResponseEntity.ok().body(ageOfpersonData);
	}

	@GetMapping("/retrive-over-allperson-data-by-id")
	public ResponseEntity<OverAllPersonData> getOverAllPersonDataByPersonId(int personId) {
		OverAllPersonData overAllPersonData = personService.getOverAllPersonDataByPersonId(personId);
		return ResponseEntity.ok().body(overAllPersonData);
	}

	@GetMapping("/export/excel")
	public ResponseEntity<InputStreamResource> exportExcel() throws IOException {

		List<PersonData> personDataList = personService.retriveAllPersonData();
		List<String> headers = Arrays.asList("PersonID", "Name", "Gender", "Dob", "Status", "BloodGroup");
		String sheetName = "Users";
		String fileName = "users.xlsx";

		ByteArrayInputStream in = PersonTableExcelGenerator.dataToExcel(personDataList, sheetName, headers);

		HttpHeaders headersResponse = new HttpHeaders();
		headersResponse.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);

		return ResponseEntity.ok().headers(headersResponse)
				.contentType(
						MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
				.body(new InputStreamResource(in));
	}
	
	@GetMapping("/{name}")
	public PersonData getPersonByName(@PathVariable(name = "Name")String name) {
		return personDataJpaRepository.findByName(name);
	}
	
	@PostMapping("/send-persondata-in-mail")
	public ResponseEntity<String> sendPersonDataInMail( @RequestParam String recipientEmail)  {
try {
		List<PersonData> personDataList = personService.retriveAllPersonData();
		List<String> headers = Arrays.asList("PersonID", "Name", "Gender", "Dob", "Status", "BloodGroup");
		String sheetName = "Users";
		String fileName = "users.xlsx";

		ByteArrayInputStream excelStream = PersonTableExcelGenerator.dataToExcel(personDataList, sheetName, headers);

		HttpHeaders headersResponse = new HttpHeaders();
		headersResponse.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
		
		emailExcelExportService.sendMailWithExcelAttachment(recipientEmail, "personList",  " Hi, Please find the attached person details in excel format.", excelStream, "personData.xlsx");
		return ResponseEntity.ok("email sent successfully");
	} catch(Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email: " + e.getMessage());
	}
	}
	
}
