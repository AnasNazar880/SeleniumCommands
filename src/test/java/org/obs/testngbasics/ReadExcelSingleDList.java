package org.obs.testngbasics;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadExcelSingleDList {
    public static void main(String[] args) {
        String excelFilePath = "D:\\Obsquira\\ReadExcell\\readExcell.xlsx"; // Replace with your file path

        try (FileInputStream inputStream = new FileInputStream(excelFilePath);
             Workbook workbook = WorkbookFactory.create(inputStream)) {

            List<String> dataList = new ArrayList<>();

            // Assuming you are reading the first sheet in the Excel file
            Sheet sheet = workbook.getSheetAt(0);

            int rowCount = sheet.getPhysicalNumberOfRows();
            for (int i = 0; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    int cellCount = row.getPhysicalNumberOfCells();
                    for (int j = 0; j < cellCount; j++) {
                        Cell cell = row.getCell(j);
                        if (cell != null) {
                            // Assuming all cells contain string data
                            dataList.add(cell.getStringCellValue());
                        }
                    }
                }
            }

            // Print the data using indices
            for (int i = 0; i < dataList.size(); i++) {
                System.out.println("Data at index " + i + ": " + dataList.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
