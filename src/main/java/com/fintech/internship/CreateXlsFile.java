package com.fintech.internship;

import com.fintech.internship.data.UserGenerator;
import com.fintech.internship.output.XLSCreator;
import com.itextpdf.text.DocumentException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CreateXlsFile {

    private static String[] columns = {"Имя", "Отчество", "Фамилия", "Возраст",
            "Пол", "Дата рождения", "ИНН", "Почтовый индекс", "Страна",
            "Область", "Город", "Улица", "Дом", "Квартира"};

    public static void main(String[] args) throws IOException, DocumentException {
        List<User> users = new UserGenerator().fillUsers(30);
        new XLSCreator(columns).populateAndWriteWoXLS(users, "Users.xls");

        File file = new File("Users.pdf");
//        file.getParentFile().mkdirs();
        new CreatePDF(users).createFile(file.getAbsolutePath());
    }
}

