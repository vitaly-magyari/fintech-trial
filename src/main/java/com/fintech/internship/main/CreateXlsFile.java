package com.fintech.internship.main;

import com.fintech.internship.data.User;
import com.fintech.internship.data.UserGenerator;
import com.fintech.internship.output.CreatePDF;
import com.fintech.internship.output.XLSCreator;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class CreateXlsFile {

    private static String[] columns = {"Имя", "Отчество", "Фамилия", "Возраст",
            "Пол", "Дата рождения", "ИНН", "Почтовый индекс", "Страна",
            "Область", "Город", "Улица", "Дом", "Квартира"};

    public static void main(String[] args) {
        List<User> users = null;
        try {
            users = new UserGenerator().fillUsers(30);
        } catch (IOException e) {
            e.printStackTrace();
        }
        new XLSCreator(columns).populateAndWriteToXLS(users, "Users.xls");

        File file = new File("Users.pdf");
        new CreatePDF(users).createFile(file.getAbsolutePath());
        System.out.println("Файл создан. Путь: " + file.getAbsolutePath());
    }
}