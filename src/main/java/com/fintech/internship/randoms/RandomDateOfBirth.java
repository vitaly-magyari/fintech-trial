package com.fintech.internship.randoms;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.GregorianCalendar;

public class RandomDateOfBirth {
    private GregorianCalendar gCalendar;

    public RandomDateOfBirth() {
        gCalendar = new GregorianCalendar();
        int year = randBetween(1910, 2010);
        gCalendar.set(gCalendar.YEAR, year);
        int dayOfYear = randBetween(1, gCalendar.getActualMaximum(gCalendar.DAY_OF_YEAR));
        gCalendar.set(gCalendar.DAY_OF_YEAR, dayOfYear);
    }


    private static int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public Date getDateTime() {
        return gCalendar.getTime();
    }

    public int getAge() {
        return Period.between(gCalendar.toZonedDateTime().toLocalDate(), LocalDate.now()).getYears();
    }
}
