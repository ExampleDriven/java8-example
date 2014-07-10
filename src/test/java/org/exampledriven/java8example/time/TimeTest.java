package org.exampledriven.java8example.time;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class TimeTest {

    @Test
    public void testGregorianCalendar() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(1978, 12, 31);
        System.out.println(gregorianCalendar);

    }

    @Test
    public void testCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1978, Calendar.DECEMBER, 31);
        System.out.println(calendar);

    }

    @Test
    public void testCalendarBuilder() {

        Calendar calendar = new Calendar.Builder()
                .set(Calendar.YEAR, 1978)
                .set(Calendar.DAY_OF_MONTH, 31)
                .set(Calendar.MONTH, Calendar.DECEMBER)
                .build();

        System.out.println(calendar);

    }

    @Test
    public void testLocalDate() {
        LocalDate localDate = LocalDate.of(1978, Month.DECEMBER, 31);

        System.out.println(localDate);

    }

}
