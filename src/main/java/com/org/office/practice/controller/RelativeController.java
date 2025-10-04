package com.org.office.practice.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.management.relation.RelationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;
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
import com.org.office.practice.data.RelativeData;
import com.org.office.practice.service.RelativeService;
import com.org.office.practice.util.PersonTableExcelGenerator;
import com.org.office.practice.util.RelativeTableExcelGenerator;

@RestController
@RequestMapping("/relative")
public class RelativeController {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	RelativeService relativeService;
	
	@PostMapping("/create")
	public ResponseEntity<Long> createRelativeData(@RequestBody RelativeData relativeDataObjectRequest) {
		Long result = relativeService.createRelativeData(relativeDataObjectRequest);
		return ResponseEntity.ok().body(result);
		
		}
@PostMapping("/update-by-id")
public ResponseEntity<Long> updateRelativeData(@RequestBody RelativeData relativeDataObjectRequest) {
	Long result = relativeService.updateRelativeData(relativeDataObjectRequest);
	return ResponseEntity.ok().body(result);
}

@GetMapping("/retrive-by-id")
public ResponseEntity<RelativeData>  retriveRelativeData(int rId) {
	RelativeData relativeData = relativeService.retriveRelativeData(rId);
	return ResponseEntity.ok().body(relativeData);
}

@GetMapping("/retriveAll")
public ResponseEntity<List<RelativeData>> retriveAllRelativeData()
{
	List<RelativeData> relativeData = relativeService.retriveAllRelativeData();
	return ResponseEntity.ok().body(relativeData);
}

@GetMapping("/deleteAll")
public ResponseEntity<Long> deleteAllRelativeData() {
	Long result = relativeService.deleteAllRelativeData();
	return ResponseEntity.ok().body(result);
}

@GetMapping("/delete-by-id")
public ResponseEntity<Long> deleteRelativeData(int rId) {
	Long result = relativeService.deleteRelativeData(rId);
	return ResponseEntity.ok().body(result);
}

@GetMapping("/export/excel")
public ResponseEntity<InputStreamResource> exportExcel() throws IOException {

	List<RelativeData> relativeDataList = relativeService.retriveAllRelativeData();
	List<String> headers = Arrays.asList("rID", "Name", "phoneNo", "relationship", "personId");
	String sheetName = "PersonRelatives";
	String fileName = "relatives.xlsx";

	ByteArrayInputStream in = RelativeTableExcelGenerator.dataToExcel(relativeDataList, sheetName, headers);

	HttpHeaders headersResponse = new HttpHeaders();
	headersResponse.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);

	return ResponseEntity.ok().headers(headersResponse)
			.contentType(
					MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
			.body(new InputStreamResource(in));
}
}














