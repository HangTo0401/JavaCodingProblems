package WorkingWithDateAndTime;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

public class GettingDateTimeUnits {
    /**
     * Working With Date And Time
     * 64. Getting date and time units
     *
     * For a Date object, the solution may rely on a Calendar instance.
     * The code that is bundled to this book contains this solution.
     *
     * For JDK 8 classes, Java provides dedicated getFoo() methods and a get
     * (TemporalField field) method.
     * With a little intuition and documentation, it is very easy to adapt this
     * example for LocalDate, LocalTime, ZonedDateTime, and others.
     *
     * SOLUTIONS: There is 1 solution to this problem
     * */

    /**
     * 1A. Getting Date and Time using LocalDateTime
     * */
    public void gettingDateTimeUnitsUsingLocalDateTime() {
        LocalDateTime ldt = LocalDateTime.now();

        /* Relying on getFoo() methods, we get the following code: */
        int year = ldt.getYear();
        int month = ldt.getMonthValue();
        int day = ldt.getDayOfMonth();
        int hour = ldt.getHour();
        int minute = ldt.getMinute();
        int second = ldt.getSecond();
        int nano = ldt.getNano();

        System.out.println(year);
        System.out.println(month);
        System.out.println(day);
        System.out.println(hour);
        System.out.println(minute);
        System.out.println(second);
        System.out.println(nano);
    }

    /**
     * 1B. Relying on get(TemporalField field) results in the following:
     * */
    public void gettingDateTimeUnitsUsingChronoField() {
        LocalDateTime ldt = LocalDateTime.now();

        int yearLDT = ldt.get(ChronoField.YEAR);
        int monthLDT = ldt.get(ChronoField.MONTH_OF_YEAR);
        int dayLDT = ldt.get(ChronoField.DAY_OF_MONTH);
        int hourLDT = ldt.get(ChronoField.HOUR_OF_DAY);
        int minuteLDT = ldt.get(ChronoField.MINUTE_OF_HOUR);
        int secondLDT = ldt.get(ChronoField.SECOND_OF_MINUTE);
        int nanoLDT = ldt.get(ChronoField.NANO_OF_SECOND);

        System.out.println(yearLDT);
        System.out.println(monthLDT);
        System.out.println(dayLDT);
        System.out.println(hourLDT);
        System.out.println(minuteLDT);
        System.out.println(secondLDT);
        System.out.println(nanoLDT);
    }

    public static void main(String[] args) {
        GettingDateTimeUnits solution = new GettingDateTimeUnits();
        solution.gettingDateTimeUnitsUsingLocalDateTime();
        solution.gettingDateTimeUnitsUsingChronoField();
    }
}
