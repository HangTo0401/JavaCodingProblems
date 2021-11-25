package WorkingWithDateAndTime;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

public class ConvertingBetweenDateAndTemporal {
    /**
     * Working With Date And Time
     * 72. Converting between Date and Temporal
     *
     * SOLUTIONS: There are 4 solutions to this problem
     * */

    /**
     * 1. The first solution use Temporal classes
     * —Instant, LocalDate, LocalDateTime, ZonedDateTime, OffsetDateTime,
     * LocalTime, and OffsetTime
     *
     * In order to convert from Date to Instant, the solution can rely on the
     * Date.toInstant() method.
     * The reverse can be accomplished via the Date.from(Instant instant) method:
     * Date to Instant can be accomplished like this:
     * */
    public void convertDateToTemporalUsingToInstant() {
        Date date = new Date();

        // e.g., 2019-02-27T12:02:49.369Z, UTC
        Instant instantFromDate = date.toInstant();
        System.out.println(instantFromDate);
    }

    /**
     * 2. The second solution use Instant
     * Instant to Date can be accomplished like this:
     */
    public Instant convertDateToTemporalUsingInstant(Date date) {
        // e.g., 2019-02-27T12:02:49.369Z, UTC
        Instant instantFromDate = date.toInstant();
        return instantFromDate;
    }

    /**
     * 3. The third solution use toInstant() method and Date.from() method
     * Keep in mind that Date is not time-zone aware, but it is displayed in the system default time zone (for
     * example, via toString()). Instant is with a UTC time zone.
     * Let's quickly wrap these snippets of code in two utility methods, defined in a
     * utility class—DateConverters:
     * */
    public static void dateToInstant(Date date) {
        System.out.println(date.toInstant());
    }

    public static void instantToDate(Instant instant) {
        System.out.println(Date.from(instant));
    }

    /**
     * 4. The fourth solution use
     * The constant from the screenshot, DEFAULT_TIME_ZONE,
     * is the system default time zone:
     * */
    public void defaultTimeZone(){
        ZoneId DEFAULT_TIME_ZONE = ZoneId.systemDefault();
        System.out.println(DEFAULT_TIME_ZONE);
    }

    public static void main(String[] args) {
        ConvertingBetweenDateAndTemporal solution = new ConvertingBetweenDateAndTemporal();

        // C1
        solution.convertDateToTemporalUsingToInstant();

        // C2
        Date date = new Date();
        Instant instant = solution.convertDateToTemporalUsingInstant(date);
        System.out.println(instant);

        // C3
        solution.dateToInstant(date);
        solution.instantToDate(instant);

        // C4
        solution.defaultTimeZone();
    }
}
