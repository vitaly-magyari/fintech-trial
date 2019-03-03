import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.GregorianCalendar;

public class RandomDateOfBirth {
    private GregorianCalendar gc;

    public RandomDateOfBirth() {
        gc = new GregorianCalendar();
        int year = randBetween(1910, 2010);
        gc.set(gc.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);
    }


    private static int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public Date getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return gc.getTime();
    }

    public int getAge() {
        return Period.between(gc.toZonedDateTime().toLocalDate(), LocalDate.now()).getYears();
    }
}
