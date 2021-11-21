package WorkingWithDateAndTime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class AddingAndSubtractingToFromDateTime {
    /**
     * 65. Adding and subtracting to/from date-time
     *
     * SOLUTIONS: There is 3 solution to this problem
     * */

    /**
     * 1. Working with Date
     * For a Date object, the solution may rely on a Calendar instance
     * */

    /**
     * 2. Working with LocalDateTime
     * Jumping to JDK 8, the focus is on LocalDate, LocalTime, LocalDateTime,
     * Instant, and many more. The new Java date-time API comes with methods
     * that are dedicated to adding or subtracting an amount of time. LocalDate,
     * LocalTime, LocalDateTime, ZonedDateTime, OffsetDateTime, Instant, Period,
     * Duration, and many others come with methods such as plusFoo() and
     * minusFoo(), where Foo can be replaced with the unit of time (for example,
     * plusYears(), plusMinutes(), minusHours(), minusSeconds(), and so on).
     *
     * Let's assume the following LocalDateTime:
     * Adding 10 minutes is as easy as calling LocalDateTime.plusMinutes(long
     * minutes), while subtracting 10 minutes is as easy as calling
     * LocalDateTime.minusMinutes(long minutes):
     * */
    public void dateTimeUsingLocalDateTime() {
        // 2019-02-25T14:55:06.651155500
        LocalDateTime ldt = LocalDateTime.now();

        LocalDateTime ldtAfterAddingMinutes = ldt.plusMinutes(10);
        LocalDateTime ldtAfterSubtractingMinutes = ldt.minusMinutes(10);

        System.out.println(ldtAfterAddingMinutes);
        System.out.println(ldtAfterSubtractingMinutes);
    }

    /**
     * 3. Now, let's focus on the Instant class.
     * Besides plus/minusSeconds(), plus/minusMillis(), and plus/minusNanos(),
     * the Instant class also provides a plus/minus(TemporalAmount amountToAdd) method.
     * In order to exemplify this method, let's assume the following Instant:
     * */
    public void dateTimeUsingInstant() {
        // 2019-02-25T12:55:06.654155700Z
        Instant timestamp = Instant.now();

        Instant timestampAfterAddingHours = timestamp.plus(5, ChronoUnit.HOURS);
        Instant timestampAfterSubtractingHours = timestamp.minus(5, ChronoUnit.HOURS);

        System.out.println(timestampAfterAddingHours);
        System.out.println(timestampAfterSubtractingHours);
    }

    public static void main(String[] args) {
        AddingAndSubtractingToFromDateTime solution = new AddingAndSubtractingToFromDateTime();
        solution.dateTimeUsingLocalDateTime();
        solution.dateTimeUsingInstant();
    }
}
