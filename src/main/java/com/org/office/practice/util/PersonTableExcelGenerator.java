package com.org.office.practice.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.org.office.practice.data.PersonData;

public class PersonTableExcelGenerator {
	public static ByteArrayInputStream dataToExcel(List<PersonData> personDataList, String sheetName, List<String> headers) throws IOException {
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet(sheetName);

            // Create Header Row
            Row headerRow = sheet.createRow(0);
            for (int col = 0; col < headers.size(); col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(headers.get(col));
            }

            // Create Data Rows
            int rowIdx = 1;
            for (PersonData personData : personDataList) {
                Row row = sheet.createRow(rowIdx++);
               
                    Cell cell1 = row.createCell(0);
                    cell1.setCellValue(String.valueOf(personData.getPersonId())); // Assuming data is convertible to String
                    
                    Cell cell2 = row.createCell(1);
                    cell2.setCellValue(String.valueOf(personData.getName()));
                    Cell cell3 = row.createCell(2);
                    cell3.setCellValue(String.valueOf(personData.getGender()));
                    Cell cell4 = row.createCell(3);
                    cell4.setCellValue(String.valueOf(personData.getDob()));
                    Cell cell5 = row.createCell(4);
                    cell5.setCellValue(String.valueOf(personData.getStatus()));
                    Cell cell6 = row.createCell(5);
                    cell6.setCellValue(String.valueOf(personData.getBloodGroup()));
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
	}
        
       
}
