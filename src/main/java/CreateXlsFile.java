import com.itextpdf.text.DocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class CreateXlsFile {
    private static String[] columns = {"Имя", "Отчество", "Фамилия", "Возраст",
            "Пол", "Дата рождения", "ИНН", "Почтовый индекс", "Страна",
            "Область", "Город", "Улица", "Дом", "Квартира"};
    private static List<User> users = new ArrayList<>();

    static {
        Calendar dateOfBirth = Calendar.getInstance();
        RandomizedReader rReader = new RandomizedReader();
        int limit = ThreadLocalRandom.current().nextInt(1, 30);

        for (int j = 1; j <= limit; j++) {

            try {
                String randomGender;
                String randomFirstName;
                String randomSecondName;
                String randomLastName;
                RandomDateOfBirth rd = new RandomDateOfBirth();

                boolean genderFlag = new Random().nextBoolean();
                if (genderFlag) {
                    randomGender = "М";
                    randomFirstName = rReader.generate(new FileReader(
                            "src/main/resources/NamesMale.txt"));
                    randomSecondName = rReader.generate(new FileReader(
                            "src/main/resources/SecNamesMale.txt"));
                    randomLastName = rReader.generate(new FileReader(
                            "src/main/resources/SurnamesMale.txt"));
                } else {
                    randomGender = "Ж";
                    randomFirstName = rReader.generate(new FileReader(
                            "src/main/resources/NamesFem.txt"));
                    randomSecondName = rReader.generate(new FileReader(
                            "src/main/resources/SecNamesFem.txt"));
                    randomLastName = rReader.generate(new FileReader(
                            "src/main/resources/SurnamesFem.txt"));
                }

                users.add(new User(
                        randomFirstName,
                        randomSecondName,
                        randomLastName,
                        rd.getAge(),
                        randomGender,
                        rd.getDateTime(),
                        new RandomINN().getRandomINN(),
                        new RandomNumberGenerator().getRandomNumber(),
                        new RandomizedReader().generate(new FileReader(
                                "src/main/resources/Countries.txt")),
                        new RandomizedReader().generate(new FileReader(
                                "src/main/resources/Areas.txt")),
                        new RandomizedReader().generate(new FileReader(
                                "src/main/resources/Cities.txt")),
                        new RandomizedReader().generate(new FileReader(
                                "src/main/resources/Streets.txt")),
                        new RandomNumberGenerator().getRandomNumber(1, 199),
                        new RandomNumberGenerator().getRandomNumber(1, 999)));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException, DocumentException {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("Пользователи");

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setColor(IndexedColors.BLUE_GREY.getIndex());

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        Row headerRow = sheet.createRow(0);

        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        CellStyle dateCellStyle = workbook.createCellStyle();
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

        File outputFile = new File("Users.xls");
        FileOutputStream fileOut = new FileOutputStream(outputFile);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
        System.out.println("Файл создан. Путь: " + outputFile.getAbsolutePath());

        File file = new File("Users.pdf");
//        file.getParentFile().mkdirs();
        new CreatePDF(users).createFile(file.getAbsolutePath());
    }
}

