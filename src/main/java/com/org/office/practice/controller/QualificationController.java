package com.org.office.practice.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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

import com.org.office.practice.data.PersonData;
import com.org.office.practice.data.QualificationData;
import com.org.office.practice.data.ToppersData;

import com.org.office.practice.service.QualificationService;
import com.org.office.practice.util.PersonTableExcelGenerator;
import com.org.office.practice.util.QualificationTableExcelGeneration;

@RestController
@RequestMapping("/qualification")
public class QualificationController {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	QualificationService qualificationService;

	@PostMapping("/create")
	public ResponseEntity<Long> createQualificationData(@RequestBody QualificationData qualificationDataObjectRequest) {
		Long result = qualificationService.createQualificationData(qualificationDataObjectRequest);
		return ResponseEntity.ok().body(result);

	}

	@PostMapping("/update-by-id")
	public ResponseEntity<Long> updateQualificationData(@RequestBody QualificationData qualificationDataObjectRequest) {
		Long result = qualificationService.updateQualificationData(qualificationDataObjectRequest);
		return ResponseEntity.ok().body(result);
	}

	@GetMapping("/delete-by-id")
	public ResponseEntity<Long> deleteQualificationData(int qId) {
		Long result = qualificationService.deleteQualificationData(qId);
		return ResponseEntity.ok().body(result);
	}

	@GetMapping("/deleteAll")
	public ResponseEntity<Long> deleteAllQualificationData() {
		Long result = qualificationService.deleteAllQualificationData();
		return ResponseEntity.ok().body(result);

	}

	@GetMapping("/retriveAll")
 public ResponseEntity<List<QualificationData>> retriveAllQualificationData() {
		List<QualificationData> qualificationData = qualificationService.retriveAllQualificationData();
		return ResponseEntity.ok().body(qualificationData);
	}

	@GetMapping("/retrive-by-id")
	public ResponseEntity<QualificationData> retriveQualificationData(int qId) {
		QualificationData qualificationData = qualificationService.retriveQualificationData(qId);
		return ResponseEntity.ok().body(qualificationData);

	}
	
	@GetMapping("/get-topers-in-tenth-and-twelfth")
	public ResponseEntity<List<ToppersData>> getTopersInTenthAndTwelfth() {
		List<ToppersData> toppersData = qualificationService.getTopersInTenthAndTwelfth();
		return ResponseEntity.ok().body(toppersData);
	}
	
	@GetMapping("/export/excel")
	public ResponseEntity<InputStreamResource> exportExcel() throws IOException {

		List<QualificationData> qualificationDataList = qualificationService.retriveAllQualificationData();
		List<String> headers = Arrays.asList("qID", "gradeDegree", "institute", "yearOfComplition", "percentage", "Status", "personId");
		String sheetName = "PersonQualification";
		String fileName = "qualification.xlsx";

		ByteArrayInputStream in = QualificationTableExcelGeneration.dataToExcel(qualificationDataList, sheetName, headers);

		HttpHeaders headersResponse = new HttpHeaders();
		headersResponse.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);

		return ResponseEntity.ok().headers(headersResponse)
				.contentType(
						MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
				.body(new InputStreamResource(in));
	}

}
