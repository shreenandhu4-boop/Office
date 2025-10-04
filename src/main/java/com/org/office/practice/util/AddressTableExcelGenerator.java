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

import com.org.office.practice.data.AddressData;


public class AddressTableExcelGenerator {
	public static ByteArrayInputStream dataToExcel(List<AddressData> addressDataList, String sheetName, List<String> headers) throws IOException {
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
            for (AddressData addressData : addressDataList) {
                Row row = sheet.createRow(rowIdx++);
               
                    Cell cell1 = row.createCell(0);
                    cell1.setCellValue(String.valueOf(addressData.getAdId())); // Assuming data is convertible to String
                    
                    Cell cell2 = row.createCell(1);
                    cell2.setCellValue(String.valueOf(addressData.getDoorNo()));
                    Cell cell3 = row.createCell(2);
                    cell3.setCellValue(String.valueOf(addressData.getStreet()));
                    Cell cell4 = row.createCell(3);
                    cell4.setCellValue(String.valueOf(addressData.getAddressLine1()));
                    Cell cell5 = row.createCell(4);
                    cell5.setCellValue(String.valueOf(addressData.getAddressLine2()));
                    Cell cell6 = row.createCell(5);
                    cell6.setCellValue(String.valueOf(addressData.getDistrict()));
                    Cell cell7 = row.createCell(6);
                    cell7.setCellValue(String.valueOf(addressData.getPincode()));
                    Cell cell8 = row.createCell(7);
                    cell8.setCellValue(String.valueOf(addressData.getState()));                  
                    Cell cell9 = row.createCell(8);
                    cell9.setCellValue(String.valueOf(addressData.getAddressType()));
                    
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }


}
