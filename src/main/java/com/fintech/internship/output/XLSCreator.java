package com.fintech.internship.output;

import com.fintech.internship.User;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

public class XLSCreator {

    private Workbook workbook;
    private Sheet sheet;
    private Font headerFont;
    private CellStyle headerCellStyle;
    public String[] columns;

    public XLSCreator(String[] columns) {
        this.workbook = new HSSFWorkbook();
        this.sheet = workbook.createSheet("Пользователи");
        this.headerFont = initHeaderFont();
        this.headerCellStyle = initHeaderStyle();
        this.columns = columns;
    }

private     Font initHeaderFont() {
        Font resultFont = workbook.createFont();
        resultFont.setBold(true);
        resultFont.setColor(IndexedColors.BLUE_GREY.getIndex());
        return resultFont;
    }

   private CellStyle initHeaderStyle() {
        CellStyle resultCellStyle= workbook.createCellStyle();
        resultCellStyle.setFont(headerFont);
        return resultCellStyle;
    }


    private void setHeader() {
        Row headerRow = sheet.createRow(0);

        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }
    }

    private void setContent(List<User> users) {

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        int rowNum = 1;
        for (User user : users) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(user.firstName);
            row.createCell(1).setCellValue(user.secondName);
            row.createCell(2).setCellValue(user.lastName);
            row.createCell(3).setCellValue(user.age);
            row.createCell(4).setCellValue(user.gender);

            Cell dateOfBirthCell = row.createCell(5);
            dateOfBirthCell.setCellValue(format.format(user.dateOfBirth));

            row.createCell(6).setCellValue(user.iNN);
            row.createCell(7).setCellValue(user.zipcode);
            row.createCell(8).setCellValue(user.country);
            row.createCell(9).setCellValue(user.area);
            row.createCell(10).setCellValue(user.city);
            row.createCell(11).setCellValue(user.street);
            row.createCell(12).setCellValue(user.house);
            row.createCell(13).setCellValue(user.flat);
        }

        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }
    }

    private File writeXLSFile(String pathToFile) throws IOException {
        File outputFile = new File(pathToFile);
        FileOutputStream fileOut = new FileOutputStream(outputFile);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
        return outputFile;
    }

    public File populateAndWriteWoXLS(List<User> users, String pathToFile) throws IOException {
        setHeader();
        setContent(users);
        File outputFile = writeXLSFile(pathToFile);
        System.out.println("Файл создан. Путь: " + outputFile.getAbsolutePath());
        return outputFile;
    }

}
