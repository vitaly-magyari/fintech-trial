import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.util.List;

public class CreatePDF {

//    public static String DEST = "C:/Users/Tanju/IdeaProjects/CreateXlsFile1/full_page_table.pdf";
    private List<User> users;

//    public static void main(String[] args) throws IOException,
//            DocumentException {
//        File file = new File(DEST);
//        file.getParentFile().mkdirs();
//        new CreatePDF().createFile(DEST);
//    }

    CreatePDF(List<User> userList){
        this.users = userList;
    }

    public void createFile(String dest) throws DocumentException, IOException {
        ITextRenderer renderer = new ITextRenderer();
        {
            renderer.getFontResolver().addFont("InconsolataCyr.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);


            Document document = new Document(PageSize.A5, 0, 0, 0, 0);
            PdfWriter.getInstance(document, new FileOutputStream(dest));
            PdfPTable table = new PdfPTable(14);
            document.open();

            table.setWidthPercentage(100);
            table.setSpacingBefore(0f);
            table.setSpacingAfter(0f);

            // first row
            PdfPCell cell = new PdfPCell(new Phrase("Пользователи"));
            cell.setColspan(14);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPadding(5.0f);
            cell.setBackgroundColor(new BaseColor(200, 200, 200));
            table.addCell(cell);

            table.addCell(new Phrase("Имя"));
            table.addCell(new Phrase("Отчество"));
            table.addCell(new Phrase("Фамилия"));
            table.addCell(new Phrase("Возраст"));
            table.addCell(new Phrase("Пол"));
            table.addCell(new Phrase("Дата рождения"));
            table.addCell(new Phrase("ИНН"));
            table.addCell(new Phrase("Почтовый индекс"));
            table.addCell(new Phrase("Страна"));
            table.addCell(new Phrase("Область"));
            table.addCell(new Phrase("Город"));
            table.addCell(new Phrase("Улица"));
            table.addCell(new Phrase("Дом"));
            table.addCell(new Phrase("Квартира"));

            for (User user : users) {
                table.addCell(user.firstName);
                table.addCell(user.lastName);

                table.addCell("time");
                table.addCell("source");
                table.addCell("destination");
                table.addCell("extension");
                table.addCell("trunk");
                table.addCell(String.valueOf(new RandomINN().getRandomINN()));
                table.addCell(String.valueOf(new RandomNumberGenerator().getRandomNumber()));

                String cellText = new RandomizedReader().generate(new FileReader("src/main/resources/Countries.txt"));
                table.addCell(cellText);
                table.addCell(new RandomizedReader().generate(new FileReader("src/main/resources/Areas.txt")));
                table.addCell(new RandomizedReader().generate(new FileReader("src/main/resources/Cities.txt")));
                table.addCell(new RandomizedReader().generate(new FileReader("src/main/resources/Streets.txt")));
                table.addCell(String.valueOf(new RandomNumberGenerator().getRandomNumber(1, 199)));
                table.addCell(String.valueOf(new RandomNumberGenerator().getRandomNumber(1, 999)));
            }
            document.add(table);
            document.close();
        }
    }
}