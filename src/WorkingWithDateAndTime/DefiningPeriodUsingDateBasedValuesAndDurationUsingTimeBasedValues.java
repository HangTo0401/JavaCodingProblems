package WorkingWithDateAndTime;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class DefiningPeriodUsingDateBasedValuesAndDurationUsingTimeBasedValues {
    /**
     * Working With Date And Time
     * 63. Defining a period of time using date-based values
     * and a duration of time using time-based values
     *
     * JDK 8 comes with two new classes,
     * named java.time.Period and java.time.Duration.
     * Let's take a detailed look at them in the next sections.
     *
     * SOLUTIONS: There is 2 solution to this problem
     * */

    /**
     * 1A. Period of time using date-based values
     * The Period class is meant to represent an amount of time using date-based
     * values (years, months, weeks, and days).
     * This period of time can be obtained in different ways.
     * For example, a period of 120 days can be obtained as follows:
     * */
    public void periodOfTimeUsingDateBasedValues() {
        // Next to the ofDays() method,
        // the Period class also has ofMonths(), ofWeeks(), and ofYears().
        Period fromDays = Period.ofDays(120); // P120D
        System.out.println(fromDays);

        Period periodFromUnits = Period.of(2000, 11, 24); // P2000Y11M24D
        System.out.println(periodFromUnits);

        // Period can also be obtained from LocalDate:
        LocalDate localDate = LocalDate.now();
        Period periodFromLocalDate = Period.of(localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth());
        System.out.println(periodFromLocalDate);

        /**
         * Finally, Period can be obtained from a String object that respects
         * the ISO-8601 period formats PnYnMnD and PnW.
         * For example, the P2019Y2M25D string represents 2019 years, 2 months, and 25 days:
         * */
        Period periodFromString = Period.parse("P2019Y2M25D");
        System.out.println(periodFromString);

        /**
         * Calling Period.toString() will return the period while also respecting the ISO-8601 period formats,
         * PnYnMnD and PnW (for example, P120D, P2000Y11M24D).]
         * But, the real power of Period is revealed when it is used to represent a period
         * of time between two dates (for example, LocalDate).
         * The period of time between March 12, 2018 and July 20, 2019 can be represented as follows:
         * */
        LocalDate startLocalDate = LocalDate.of(2018, 3, 12);
        LocalDate endLocalDate = LocalDate.of(2019, 7, 20);
        Period periodBetween = Period.between(startLocalDate, endLocalDate);
        System.out.println(periodBetween);
    }

    /**
     * 1B. The amount of time in years, months, and days can be obtained via
     * Period.getYears(), Period.getMonths(), and Period.getDays().
     * For example, the following helper method uses these methods
     * to output the amount of time as a string:
     * */
    public static String periodToYMD(Period period) {
        StringBuilder sb = new StringBuilder();

        sb.append(period.getYears())
                        .append("y:")
                        .append(period.getMonths())
                        .append("m:")
                        .append(period.getDays())
                        .append("d");
        return sb.toString();
    }

    /**
     * 1C. The Period class is also useful when determining whether a particular date is
     * earlier than another date.
     * There is a flag method, named isNegative().
     * Having an A period and a B period, the result of applying Period.between(A,
     * B) can be negative if B is before A, or positive if A is before B.
     * Taking this logic further, isNegative() returns true
     * if B is before A or false if A is before B, as in our case that follows
     * (basically, this method returns false if years, months, or days is negative):
     * */
    public void comparePeriods(Period periodBetween) {
        // returns false, since 12 March 2018 is earlier than 20 July 2019
        System.out.println(periodBetween.isNegative());
    }

    /**
     * 1D. Finally, Period can be modified by adding or subtracting a period of time.
     * There are methods such as plusYears(), plusMonths(), plusDays(),
     * minusYears(), minusMonths(), and minusDays(). For example, adding 1 year to
     * periodBetween can be done as follows:
     * */
    public void modifyPeriods(Period periodBetween) {
        Period periodBetweenPlus1Year = periodBetween.plusYears(1L);
        System.out.println(periodBetweenPlus1Year);

        Period periodBetweenMinus1Year = periodBetween.minusYears(1L);
        System.out.println(periodBetweenMinus1Year);
    }

    /**
     * 1E. Adding two Period classes can be accomplished via the Period.plus()
     * method, as follows
     * */
    public void plusPeriods() {
        Period p1 = Period.ofDays(5);
        Period p2 = Period.ofDays(20);

        Period p1p2 = p1.plus(p2); // P25D
        System.out.println(p1p2);
    }

    /**
     * 2A. Duration of time using time-based values
     * The Duration class is meant to represent an amount of time using time-based
     * values (hours, minutes, seconds, or nanoseconds).
     * This duration of time can be obtained in different ways.
     * For example, a duration of 10 hours can be obtained as follows:
     * */
    public void durationOfTimeUsingTimeBasedValues() {
        Duration fromHours = Duration.ofHours(10); // PT10H
        System.out.println(fromHours);
    }

    /**
     * 2B. Next to the ofHours() method, the Duration class also has
     * ofDays(), ofMillis(), ofMinutes(), ofSeconds(), and ofNanos().
     * Alternatively, a duration of 3 minutes can be obtained via the of() method,
     * as follows:
     * */
    public void durationOfTimeUsingOfMethod() {
        Duration fromMinutes = Duration.of(3, ChronoUnit.MINUTES); //PT3M
        System.out.println(fromMinutes);
    }

    /**
     * 2C. Duration can also be obtained from LocalDateTime:
     * */
    public void durationUsingLocalDateTimeMethod() {
        LocalDateTime localDateTime = LocalDateTime.of(2018, 3, 12, 4, 14, 20, 670);
        Duration fromLocalDateTime = Duration.ofMinutes(localDateTime.getMinute());
        System.out.println(fromLocalDateTime);
    }

    /**
     * 2D. Duration can also be obtained from LocalTime:
     * */
    public void durationUsingLocalTimeMethod() {
        LocalTime localTime = LocalTime.of(4, 14, 20, 670);

        // PT0.00000067S
        Duration fromLocalTime = Duration.ofNanos(localTime.getNano());
        System.out.println(fromLocalTime);
    }

    /**
     * 2E. Finally, Duration can be obtained from a String object that
     * respects the ISO-8601 duration format PnDTnHnMn.nS,
     * with days considered to be exactly 24 hours.
     * For example, the P2DT3H4M string has 2 days, 3 hours, and 4 minutes:
     * */
    public void durationFromString() {
        Duration durationFromString = Duration.parse("P2DT3H4M");
        System.out.println(durationFromString);
    }

    /**
     * 2F. Calling Duration.toString() will return the duration that respects the ISO-8601 duration format,
     * PnDTnHnMn.nS (for example, PT10H, PT3M, or PT51H4M).
     * But, as in the case of Period, the real power of Duration is revealed when it is
     * used to represent a period of time between two times (for example, Instant).
     * The duration of time between November 3, 2015, 12:11:30, and December 6,
     * 2016, 15:17:10, can be represented as the difference between two Instant
     * classes, as follows:
     * */
    public void durationBetweenInstant() {
        Instant startInstant = Instant.parse("2015-11-03T12:11:30.00Z");
        Instant endInstant = Instant.parse("2016-12-06T15:17:10.00Z");

        // PT10059H5M40S
        Duration durationBetweenInstant = Duration.between(startInstant, endInstant);
        System.out.println(durationBetweenInstant);
    }

    /**
     * 2G. Duration is obtained by using the Duration.getSeconds() method:
     * */
    public void durationBetweenInstantUsingGetSeconds() {
        Instant startInstant = Instant.parse("2015-11-03T12:11:30.00Z");
        Instant endInstant = Instant.parse("2016-12-06T15:17:10.00Z");

        // PT10059H5M40S
        Duration durationBetweenInstant = Duration.between(startInstant, endInstant);
        System.out.println(durationBetweenInstant.getSeconds()); // 36212740 seconds
    }

    /**
     * 2H. The duration of time between March 12, 2018, 04:14:20.000000670 and
     * July 20, 2019, 06:10:10.000000720, can be represented as the difference
     * between two LocalDateTime objects, as follows:
     * */
    public void durationBetweenInstantUsingLocalDateTime() {
        LocalDateTime startLocalDateTime = LocalDateTime.of(2018, 3, 12, 4, 14, 20, 670);
        LocalDateTime endLocalDateTime = LocalDateTime.of(2019, 7, 20, 6, 10, 10, 720);

        // PT11881H55M50.00000005S, or 42774950 seconds
        Duration durationBetweenLDT = Duration.between(startLocalDateTime, endLocalDateTime);
        System.out.println(durationBetweenLDT);
    }

    /**
     * 2I. Finally, the duration of time between 04:14:20.000000670 and
     * 06:10:10.000000720, can be represented as the difference between two
     * LocalTime objects, as follows:
     * */
    public void durationBetweenInstantUsingLocalTime() {
        LocalTime startLocalTime = LocalTime.of(4, 14, 20, 670);
        LocalTime endLocalTime = LocalTime.of(6, 10, 10, 720);

        // PT1H55M50.00000005S, or 6950 seconds
        Duration durationBetweenLT = Duration.between(startLocalTime, endLocalTime);
        System.out.println(durationBetweenLT);
    }

    /**
     * 2J. Convert duration using StringBuilder
     * In the preceding examples, Duration was expressed in seconds via the
     * Duration.getSeconds() method—this is the number of seconds in the Duration
     * class. However, the Duration class contains a set of methods that are
     * dedicated to expressing Duration in other time units—in days via toDays(), in
     * hours via toHours(), in minutes via toMinutes(), in milliseconds via
     * toMillis(), and in nanoseconds via toNanos().
     * Converting from one unit of time to another unit of time may result in a
     * remnant. For example, converting from seconds to minutes may result in a
     * remnant of seconds (for example, 65 seconds is 1 minute and 5 seconds (5
     * seconds is the remnant)). The remnant can be obtained via the following set
     * of methods—the remnant in days via toDaysPart(), the remnant in hours via
     * toHoursPart(), the remnant in minutes via toMinutesPart(), and so on.
     * Let's assume that the difference should be displayed as
     * days:hours:minutes:seconds:nano (for example, 9d:2h:15m:20s:230n).
     * Joining the forces of the toFoo() and toFooPart() methods in a helper
     * method will result in the following code:
     * */
    public static String durationToDHMSN(Duration duration) {
        StringBuilder sb = new StringBuilder();

        sb.append(duration.toDays())
                            .append("d:")
                            .append(duration.toHoursPart())
                            .append("h:")
                            .append(duration.toMinutesPart())
                            .append("m:")
                            .append(duration.toSecondsPart())
                            .append("s:")
                            .append(duration.toNanosPart())
                            .append("n");
        return sb.toString();
    }

    /**
     * 2K. Compare 2 durations
     * Identical to the Period class, the Duration class has a flag method
     * named isNegative(). This method is useful when determining whether a
     * particular time is earlier than another time. Having duration A and
     * duration B, the result of applying Duration.between(A, B) can be negative if B
     * is before A, or positive if A is before B. Taking the logic further, isNegative()
     * returns true if B is before A, or false if A is before B, as in the following case:
     * */
    public void compareDurations(Duration durationBetween) {
        // returns false, since 12 March 2018 is earlier than 20 July 2019
        System.out.println(durationBetween.isNegative());
    }

    /**
     * 2L. Adding or subtracting durations
     * Finally, Duration can be modified by adding or subtracting a duration of
     * time. There are methods such as plusDays(), plusHours(), plusMinutes(),
     * plusMillis(), plusNanos(), minusDays(), minusHours(), minusMinutes(),
     * minusMillis(), and minusNanos() to perform this. For example, adding 5
     * hours to durationBetweenLT can be done as follows:
     * */
    public void modifyDurations(Duration durationBetweenLT) {
        Duration durationBetweenPlus5Hours = durationBetweenLT.plusHours(5);
        System.out.println(durationBetweenPlus5Hours);

        Duration durationBetweenMinusHours = durationBetweenLT.minusHours(1);
        System.out.println(durationBetweenMinusHours);
    }

    /**
     * 2M. Adding two Duration classes can be accomplished via the Duration.plus()
     * method, as follows:
     * */
    public void plusDurations(Duration durationBetween) {
        Duration d1 = Duration.ofMinutes(20);
        Duration d2 = Duration.ofHours(2);

        Duration d1d2 = d1.plus(d2);
        System.out.println(d1 + "+" + d2 + "=" + d1d2); // PT2H20M
    }

    public static void main(String[] args) {
        DefiningPeriodUsingDateBasedValuesAndDurationUsingTimeBasedValues solution = new DefiningPeriodUsingDateBasedValuesAndDurationUsingTimeBasedValues();

        // Period class
        solution.periodOfTimeUsingDateBasedValues();
        Period fromDays = Period.ofDays(493); // P120D
        System.out.println(solution.periodToYMD(fromDays));
        solution.comparePeriods(fromDays);
        solution.modifyPeriods(fromDays);
        solution.plusPeriods();

        // Duration class
        solution.durationOfTimeUsingTimeBasedValues();
        solution.durationOfTimeUsingOfMethod();
        solution.durationUsingLocalDateTimeMethod();
        solution.durationUsingLocalTimeMethod();
        solution.durationFromString();
        solution.durationBetweenInstant();
        solution.durationBetweenInstantUsingGetSeconds();
        solution.durationBetweenInstantUsingLocalDateTime();
        solution.durationBetweenInstantUsingLocalTime();

        Duration durationBetweenInstant = Duration.between(Instant.parse("2021-11-03T12:11:30.00Z"), Instant.parse("2021-12-06T15:17:10.00Z"));
        System.out.println(solution.durationToDHMSN(durationBetweenInstant));
        solution.compareDurations(durationBetweenInstant);
        solution.modifyDurations(durationBetweenInstant);
        solution.plusDurations(durationBetweenInstant);
    }
}
