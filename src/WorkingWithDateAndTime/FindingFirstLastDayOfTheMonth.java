package WorkingWithDateAndTime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.*;

public class FindingFirstLastDayOfTheMonth {
    /**
     * Working With Date And Time
     * 70. Finding the first/last day of the month
     *
     * The proper solution to this problem will rely on JDK 8's, Temporal and
     * TemporalAdjuster interfaces.
     * The Temporal interface sits behind representations of date-time. In other
     * words, classes that represent a date and/or a time implement this interface.
     *
     * For example, the following classes are just a few that implement this
     * interface:
     *      LocalDate (date without a time zone in the ISO-8601 calendar system)
     *      LocalTime (time without a time zone in the ISO-8601 calendar system)
     *      LocalDateTime (date-time without a time zone in the ISO-8601 calendar system)
     *      ZonedDateTime (date-time with a time zone in the ISO-8601 calendar system), and so on
     *      OffsetDateTime (date-time with an offset from UTC/Greenwich in the ISO-8601 calendar system)
     *      HijrahDate (date in the Hijrah calendar system)
     *
     * The TemporalAdjuster class is a functional interface that defines strategies
     * that can be used to adjust a Temporal object.
     * Beside the possibility of defining custom strategies,
     * the TemporalAdjuster class provides several predefined
     * strategies, as follows (the documentation contains the entire list, which is
     * pretty impressive):
     *      firstDayOfMonth() (return the first day of the current month)
     *      lastDayOfMonth() (return the last day of the current month)
     *      firstDayOfNextMonth() (return the first day of the next month)
     *      firstDayOfNextYear() (return the first day of the next year)
     *
     * Notice that the first two adjusters in the preceding list are exactly the ones
     * needed by this problem.
     * Consider a fix—LocalDate:
     * */

    /**
     * 1. The first solution use LocalDate
     * */
    public void findingFirstLastDayOfMonthUsingLocalDate(LocalDate date) {

        // 2019-02-01
        LocalDate firstDayOfFeb = date.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(firstDayOfFeb);

        // 2019-02-28
        LocalDate lastDayOfFeb = date.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDayOfFeb);
    }

    /**
     * 2. The second solution use Lambda expression
     * Looks like relying on the predefined strategies is pretty simple. But, let's
     * assume that the problem requests you to find the date that's 21 days after
     * February, 27 2019, which is March 20, 2019. For this problem there is no
     * predefined strategy, therefore a custom strategy is needed. A solution to this
     * problem can rely on a lambda expression
     * */
    public static void findingFirstLastDayOfMonthUsingLambdaExpression(LocalDate startDate, int days) {
        Period period = Period.ofDays(days);
        TemporalAdjuster ta = p -> p.plus(period);
        LocalDate endDate = startDate.with(ta);
        System.out.println(endDate);
    }

    /**
     * 3. The third solution use ofDateAdjuster() method
     * Following the same technique, but relying on the static factory
     * method ofDateAdjuster(), the following snippet of code defines a static
     * adjuster that returns the next date that falls on a Saturday:
     * */
    static TemporalAdjuster NEXT_SATURDAY = TemporalAdjusters.ofDateAdjuster(today -> {
        DayOfWeek dayOfWeek = today.getDayOfWeek();
        if (dayOfWeek == DayOfWeek.SATURDAY) {
            return today;
        }
        if (dayOfWeek == DayOfWeek.SUNDAY) {
            return today.plusDays(6);
        }
        return today.plusDays(6 - dayOfWeek.getValue());
    });

    /**
     * 4.
     * Finally, this functional interface defines an abstract method named
     * adjustInto().
     * This method can be overridden in custom implementations by
     * passing a Temporal object to it, as follows:
     * */
    public static class NextSaturdayAdjuster implements TemporalAdjuster {
        @Override
        public Temporal adjustInto(Temporal temporal) {
            DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
            if (dayOfWeek == DayOfWeek.SATURDAY) {
                return temporal;
            }
            if (dayOfWeek == DayOfWeek.SUNDAY) {
                return temporal.plus(6, ChronoUnit.DAYS);
            }
            return temporal.plus(6 - dayOfWeek.getValue(), ChronoUnit.DAYS);
        }
    }


    public static void main(String[] args) {
        FindingFirstLastDayOfTheMonth solution = new FindingFirstLastDayOfTheMonth();

        LocalDate date = LocalDate.of(2019, Month.FEBRUARY, 27);

        // C1
        solution.findingFirstLastDayOfMonthUsingLocalDate(date);

        // C2
        findingFirstLastDayOfMonthUsingLambdaExpression(date, 50);

        // C3: 2019-03-02
        LocalDate nextSaturday = date.with(NEXT_SATURDAY);
        System.out.println(nextSaturday);

        // C4: 2019-03-02
        NextSaturdayAdjuster nsa = new NextSaturdayAdjuster();
        LocalDate anotherNextSaturday = date.with(nsa);
        System.out.println(anotherNextSaturday);
    }
}
