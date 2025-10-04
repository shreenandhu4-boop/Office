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

import com.org.office.practice.data.PersonData;
import com.org.office.practice.data.VehicleData;
import com.org.office.practice.exceptions.DuplicateVehicleNumberException;

import com.org.office.practice.service.VehicleService;
import com.org.office.practice.util.PersonTableExcelGenerator;
import com.org.office.practice.util.VehicleTableExcelGenerator;

@RestController

@RequestMapping("/vehicle")

public class VehicleController {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	VehicleService vehicleService;
	
	@PostMapping("/create")
	public ResponseEntity<Long> createVehicleData(@RequestBody VehicleData vehicleDataObjectRequest) throws DuplicateVehicleNumberException {
		Long result = vehicleService.createVehicleData(vehicleDataObjectRequest);
		return ResponseEntity.ok().body(result);

	}

	@PostMapping("/update-by-id")
	public ResponseEntity<Long> updateVehicleData(@RequestBody VehicleData vehicleDataObjectRequest) throws DuplicateVehicleNumberException {
		Long result = vehicleService.updateVehicleData(vehicleDataObjectRequest);
		return ResponseEntity.ok().body(result);
	}

	@GetMapping("/delete-by-id")
	public ResponseEntity<Long> deleteVehicleData(int vId) {
		Long result = vehicleService.deleteVehicleData(vId);
		return ResponseEntity.ok().body(result);
	}

	@GetMapping("/deleteAll")
	public ResponseEntity<Long> deleteAllVehicleData() {
		Long result = vehicleService.deleteAllVehicleData();
		return ResponseEntity.ok().body(result);
	}

	@GetMapping("/retriveAll")
	public ResponseEntity<List<VehicleData>> retriveAllVehicleData() {
		List<VehicleData> vehicleData= vehicleService.retriveAllVehicleData();
		return ResponseEntity.ok().body(vehicleData);
	}

	@GetMapping("/retrive-by-id")
	public ResponseEntity<VehicleData>  retriveVehicleData(int vId) {
		VehicleData vehicleData= vehicleService.retriveVehicleData(vId);
		return ResponseEntity.ok().body(vehicleData);
	}
	@GetMapping("/export/excel")
	public ResponseEntity<InputStreamResource> exportExcel() throws IOException {

		List<VehicleData> vehicleDataList = vehicleService.retriveAllVehicleData();
		List<String> headers = Arrays.asList("rID", "type", "model", "brand", "color", "personId", "vehicleNumber");
		String sheetName = "PersonVehicle";
		String fileName = "vehicles.xlsx";

		ByteArrayInputStream in = VehicleTableExcelGenerator.dataToExcel(vehicleDataList, sheetName, headers);

		HttpHeaders headersResponse = new HttpHeaders();
		headersResponse.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);

		return ResponseEntity.ok().headers(headersResponse)
				.contentType(
						MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
				.body(new InputStreamResource(in));
	}
	
	
}
