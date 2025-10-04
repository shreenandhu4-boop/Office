package com.org.office.practice.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.org.office.practice.data.ContactData;


public class ContactTableExcelGenerator {
	public static ByteArrayInputStream dataToExcel(List<ContactData> contactDataList, String sheetName, List<String> headers) throws IOException {
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
            for (ContactData contactData : contactDataList) {
                Row row = sheet.createRow(rowIdx++);
               
                    Cell cell1 = row.createCell(0);
                    cell1.setCellValue(String.valueOf(contactData.getcId())); // Assuming data is convertible to String
                    
                    Cell cell2 = row.createCell(1);
                    cell2.setCellValue(String.valueOf(contactData.getContactType()));
                    Cell cell3 = row.createCell(2);
                    cell3.setCellValue(String.valueOf(contactData.getContactDetail()));
                    Cell cell4 = row.createCell(3);
                    cell4.setCellValue(String.valueOf(contactData.getIsActive()));
                    Cell cell5 = row.createCell(4);
                    cell5.setCellValue(String.valueOf(""));
                   
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }
}
