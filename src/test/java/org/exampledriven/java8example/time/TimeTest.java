package org.exampledriven.java8example.time;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.*;

import static org.junit.Assert.assertEquals;


public class TimeTest {

    @Test
    public void gregorianCalendar_constuctorParameters() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(1978, Calendar.DECEMBER, 31);

        System.out.println(gregorianCalendar.getTime());

    }

    @Test
    public void gregorianCalendar_setters() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(Calendar.YEAR,1978);
        gregorianCalendar.set(Calendar.MONTH,Calendar.DECEMBER);
        gregorianCalendar.set(Calendar.DAY_OF_MONTH,31);
        gregorianCalendar.set(Calendar.HOUR_OF_DAY,0);
        gregorianCalendar.set(Calendar.MINUTE,0);
        gregorianCalendar.set(Calendar.SECOND, 0);
        gregorianCalendar.set(Calendar.MILLISECOND, 0);

        assertEquals(new GregorianCalendar(1978, Calendar.DECEMBER, 31).getTime(), gregorianCalendar.getTime());

    }

    @Test
    public void calendar_setters() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,1978);
        calendar.set(Calendar.MONTH,Calendar.DECEMBER);
        calendar.set(Calendar.DAY_OF_MONTH,31);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        assertEquals(new GregorianCalendar(1978, Calendar.DECEMBER, 31).getTime(), calendar.getTime());

    }

    @Test
    public void calendarBuilder_setters() {

        Calendar calendar = new Calendar.Builder()
                .set(Calendar.YEAR, 1978)
                .set(Calendar.DAY_OF_MONTH, 31)
                .set(Calendar.MONTH, Calendar.DECEMBER)
                .build();

        assertEquals(new GregorianCalendar(1978, Calendar.DECEMBER, 31).getTime(), calendar.getTime());

    }
    @Test
    public void calendarBuilder_setter() {

        Calendar calendar = new Calendar.Builder()
                .setFields(Calendar.YEAR, 1978, Calendar.DAY_OF_MONTH, 31, Calendar.MONTH, Calendar.DECEMBER)
                .build();

        assertEquals(new GregorianCalendar(1978, Calendar.DECEMBER, 31).getTime(), calendar.getTime());

    }

    @Test
    public void localDate() {
        LocalDate localDate = LocalDate.of(1978, Month.DECEMBER, 31);
        assertEquals(new GregorianCalendar(1978, Calendar.DECEMBER, 31).getTime(), Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));

    }

}
