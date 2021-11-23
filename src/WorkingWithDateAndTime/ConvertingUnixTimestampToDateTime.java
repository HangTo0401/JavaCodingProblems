package WorkingWithDateAndTime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ConvertingUnixTimestampToDateTime {
    /**
     * Working With Date And Time
     * 69. Converting a Unix timestamp to date-time
     *
     * SOLUTIONS: There are 3 solutions to this problem
     * */

    /**
     * 1. For this solution, let's suppose the following Unix timestamp—1573768800.
     * This timestamp is equivalent to the following:
     * 11/14/2019 @ 10:00pm (UTC)
     * 2019-11-14T22:00:00+00:00 in ISO-8601
     * Thu, 14 Nov 2019 22:00:00 +0000 in RFC 822, 1036, 1123, 2822
     * Thursday, 14-Nov-19 22:00:00 UTC in RFC 2822
     * 2019-11-14T22:00:00+00:00 in RFC 3339
     *
     * In order to convert a Unix timestamp to a date-time, it is important to know
     * that the Unix timestamps resolution is in seconds,
     * while java.util.Date needs milliseconds.
     *
     * So, the solution to obtain a Date object from a Unix
     * timestamp requires a conversion from seconds to milliseconds by
     * multiplying the Unix timestamp by 1,000 as shown in the following two
     * examples:
     * */
    public void unixTimeStampToDateObject(long unixTimestamp) {
        // Fri Nov 15 00:00:00 EET 2019 - in the default time zone
        Date dateInMilliseconds = new Date(unixTimestamp * 1000L);
        System.out.println(dateInMilliseconds);

        // Fri Nov 15 00:00:00 EET 2019 - in the default time zone
        Date dateByConvertSeconds2Milliseconds = new Date(TimeUnit.MILLISECONDS.convert(unixTimestamp, TimeUnit.SECONDS));
        System.out.println(dateByConvertSeconds2Milliseconds);
    }

    /**
     * 2. The second solution use from() method
     * Starting with JDK 8, the Date class uses the from(Instant instant) method.
     * Moreover, the Instant class comes with the ofEpochSecond(long epochSecond)
     * method, which returns an instance of Instant, using the given seconds from
     * the epoch, of 1970-01-01T00:00:00Z:
     * */
    public void unixTimeStampToDateObjectUsingFromMethod(long unixTimestamp) {
        // 2019-11-14T22:00:00Z in UTC
        Instant instant = Instant.ofEpochMilli(unixTimestamp);
        System.out.println(instant);

        // Fri Nov 15 00:00:00 EET 2019 - in the default time zone
        Date date = Date.from(instant);
        System.out.println(date);
    }

    /**
     * 3. The third solution use LocalDateTime
     * The instant that was obtained in the previous example can be used to create
     * LocalDateTime or ZonedDateTime, as follows:
     * */
    public void unixTimeStampToDateObjectUsingLocalDateTime(long unixTimestamp) {
        // 2019-11-14T22:00:00Z in UTC
        Instant instant = Instant.ofEpochMilli(unixTimestamp);

        // 2019-11-15T06:00
        LocalDateTime localDateTimeAUPerth = LocalDateTime.ofInstant(instant, ZoneId.of("Australia/Perth"));
        System.out.println(localDateTimeAUPerth);

        // 2019-Nov-15 00:00:00 +0200 Europe/Bucharest
        ZonedDateTime localDateTimeEUBucharest = ZonedDateTime.ofInstant(instant, ZoneId.of("Europe/Bucharest"));
        System.out.println(localDateTimeEUBucharest);
    }

    public static void main(String[] args) {
        ConvertingUnixTimestampToDateTime solution = new ConvertingUnixTimestampToDateTime();

        // C1
        long unixTimestamp = 1573768800;
        solution.unixTimeStampToDateObject(unixTimestamp);

        // C2
        solution.unixTimeStampToDateObjectUsingFromMethod(unixTimestamp);

        // C3
        solution.unixTimeStampToDateObjectUsingLocalDateTime(unixTimestamp);
    }
}
