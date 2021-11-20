package WorkingWithDateAndTime;

import java.time.*;
import java.time.format.DateTimeFormatter;

class ConvertingStringToDateAndTime {
    /**
     * Working With Date And Time
     * 58. Converting String To Date And Time
     *
     * Converting or parsing String to date and time can be accomplished
     * via a set of parse() methods.
     * Converting from date and time to String can be
     * accomplished via the toString() or format() methods.
     * */

    /**
     * Before JDK 8, the typical solution to this problem relies on the main
     * extension of the abstract DateFormat class, named SimpleDateFormat (this is
     * not a thread-safe class).
     * In the code that is bundled to this book, there are
     * several examples of how to use this class.
     *
     * Starting with JDK 8, SimpleDateFormat can be replaced with a new class
     * —DateTimeFormatter. This is an immutable (and, therefore, thread-safe) class,
     * and is used for printing and parsing date-time objects. This class supports
     * everything from predefined formatters (represented as constants, as the ISO
     * local date, 2011-12-03, is ISO_LOCAL_DATE) to user-defined formatters (relying
     * on a set of symbols for writing custom format patterns).
     *
     * Moreover, beside the Date class, JDK 8 comes with several new classes,
     * which are dedicated to working with date and time. Some of these classes are
     * shown in the following list (these are also referenced as temporals because
     * they implement the Temporal interface):
     * a. LocalDate (date without a time zone in the ISO-8601 calendar
     * system)
     * b. LocalTime (time without a time zone in the ISO-8601 calendar
     * system)
     * c. LocalDateTime (date-time without a time zone in the ISO-8601
     * calendar system)
     * d. ZonedDateTime (date-time with a time zone in the ISO-8601
     * calendar system), and so on
     * e. OffsetDateTime (date-time with an offset from UTC/GMT in the
     * ISO-8601 calendar system)
     * f. OffsetTime (time with an offset from UTC/GMT in the ISO-8601
     * calendar system)
     *
     * In order to convert String to LocalDate via a predefined formatter, it should
     * respect the DateTimeFormatter.ISO_LOCAL_DATE pattern, for example, 2020-
     * 06-01. LocalDate provides a parse() method that can be used as follows:
     * */

    public static void main(String[] args) {
        // 06 is the month, 01 is the day
        LocalDate localDate = LocalDate.parse("2020-06-01");
        System.out.println(localDate);

        /**
         * Similarly, in the case of LocalTime, the string should respect the
         * DateTimeFormatter.ISO_LOCAL_TIME pattern;
         * for example, 10:15:30, as shown in the following code snippet:
         * */
        LocalTime localTime = LocalTime.parse("12:23:44");
        System.out.println(localTime);

        /**
         * In the case of LocalDateTime, the string should respect the
         * DateTimeFormatter.ISO_LOCAL_DATE_TIME pattern;
         * for example, 2020-06-01T11:20:15, as shown in the following code snippet:
         * */
        LocalDateTime localDateTime = LocalDateTime.parse("2020-06-01T11:20:15");
        System.out.println(localDateTime);

        /**
         * And, in case of ZonedDateTime, the string must respect the
         * DateTimeFormatter.ISO_ZONED_DATE_TIME pattern;
         * for example, 2020-06-01T10:15:30+09:00[Asia/Tokyo], as shown in the following code snippet:
         * */
        ZonedDateTime zonedDateTime = ZonedDateTime.parse("2020-06-01T10:15:30+09:00[Asia/Tokyo]");
        System.out.println(zonedDateTime);

        /**
         * In the case of OffsetDateTime, the string must respect the
         * DateTimeFormatter.ISO_OFFSET_DATE_TIME pattern;
         * for example, 2007-12-03T10:15:30+01:00, as shown in the following code snippet:
         * */
        OffsetDateTime offsetDateTime = OffsetDateTime.parse("2007-12-03T10:15:30+01:00");
        System.out.println(offsetDateTime);

        /**
         * Finally, in the case of OffsetTime, the string must respect the
         * DateTimeFormatter.ISO_OFFSET_TIME pattern;
         * for example, 10:15:30+01:00, as shown in the following code snippet:
         * */
        OffsetTime offsetTime = OffsetTime.parse("10:15:30+01:00");
        System.out.println(offsetTime);

        /**
         * If the string doesn't respect any of the predefined formatters, then it is time
         * for a user-defined formatter via a custom format pattern;
         * for example, the string 01.06.2020 represents a date
         * that needs a user-defined formatter, as follows:
         * */
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate localDateFormatted = LocalDate.parse("01.06.2020", dateFormatter);
        System.out.println(localDateFormatted);

        /**
         * However, a string such as 12|23|44 requires a user-defined formatter as follows:
         * */
        DateTimeFormatter timeFormatter  = DateTimeFormatter.ofPattern("HH|mm|ss");
        LocalTime localTimeFormatted = LocalTime.parse("12|23|44", timeFormatter);
        System.out.println(localTimeFormatted);

        /**
         * A string such as 01.06.2020, 11:20:15 requires a user-defined formatter
         * as follows:
         * */
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm:ss");
        LocalDateTime localDateTimeFormatted = LocalDateTime.parse("01.06.2020, 11:20:15", dateTimeFormatter);
        System.out.println(localDateTimeFormatted);

        /**
         * A string such as 01.06.2020, 11:20:15+09:00 [Asia/Tokyo]
         * requires a user-defined formatter as follows:
         * */
        DateTimeFormatter zonedDateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm:ssXXXXX '['VV']'");
        ZonedDateTime zonedDateTimeFormatted = ZonedDateTime.parse("01.06.2020, 11:20:15+09:00 [Asia/Tokyo]", zonedDateTimeFormatter);
        System.out.println(zonedDateTimeFormatted);

        /**
         * A string such as 2007.12.03, 10:15:30, +01:00
         * requires a user-defined formatter as follows:
         * */
        DateTimeFormatter offsetDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd, HH:mm:ss, XXXXX");
        OffsetDateTime offsetDateTimeFormatted = OffsetDateTime.parse("2007.12.03, 10:15:30, +01:00", offsetDateTimeFormatter);
        System.out.println(offsetDateTimeFormatted);

        /**
         * Finally, a string such as 10 15 30 +01:00 requires a user-defined formatter as follows:
         * */
        DateTimeFormatter offsetTimeFormatter = DateTimeFormatter.ofPattern("HH mm ss XXXXX");
        OffsetTime offsetTimeFormatted = OffsetTime.parse("10 15 30 +01:00", offsetTimeFormatter);
        System.out.println(offsetTimeFormatted);

        /**
         * Converting from LocalDate, LocalDateTime, or ZonedDateTime to String can be
         * accomplished in at least two ways:
         * Rely on the LocalDate, LocalDateTime, or ZonedDateTime.toString()
         * method (automatically or explicitly).
         * Notice that relying on toString() will always print the date via the corresponding
         * predefined formatter:
         * */
        // 2020-06-01 results in ISO_LOCAL_DATE, 2020-06-01
        String localDateAsString = localDate.toString();
        System.out.println(localDateAsString);

        // 01.06.2020 results in ISO_LOCAL_DATE, 2020-06-01
        String localDateFormattedAsString = localDateFormatted.toString();
        System.out.println(localDateFormattedAsString);

        // 01.06.2020, 11:20:15 results in
        // ISO_LOCAL_DATE_TIME, 2020-06-01T11:20:15
        String localDateTimeAsString = localDateTimeFormatted.toString();
        System.out.println(localDateTimeAsString);

        // 2020-06-01T10:15:30+09:00[Asia/Tokyo]
        // results in ISO_ZONED_DATE_TIME,
        // 2020-06-01T11:20:15+09:00[Asia/Tokyo]
        String zonedDateTimeAsString = zonedDateTime.toString();
        System.out.println(zonedDateTimeAsString);

        // 01.06.2020, 11:20:15+09:00 [Asia/Tokyo]
        // results in ISO_ZONED_DATE_TIME,
        // 2020-06-01T11:20:15+09:00[Asia/Tokyo]
        String zonedDateTimeFormattedAsString = zonedDateTimeFormatted.toString();
        System.out.println(zonedDateTimeFormattedAsString);

        /**
         * Rely on the DateTimeFormatter.format() method. Notice that
         * relying on DateTimeFormatter.format() will always print the
         * date/time using the specified formatter (by default, the time zone
         * will be null), as follows:
         * */
        // 01.06.2020
        String localDateAsFormattedString = dateFormatter.format(localDateFormatted);
        System.out.println(localDateAsFormattedString);

        // 01.06.2020, 11:20:15
        String localDateTimeAsFormattedString = dateTimeFormatter.format(localDateTimeFormatted);
        System.out.println(localDateTimeAsFormattedString);

        // 01.06.2020, 11:20:15+09:00 [Asia/Tokyo]
        String zonedDateTimeAsFormattedString = zonedDateTimeFormatted.format(zonedDateTimeFormatter);
        System.out.println(zonedDateTimeAsFormattedString);

        /* Adding an explicit time zone into the discussion can be done as follows */
        DateTimeFormatter zonedDateTimeFormatterUsingPattern = DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm:ssXXXXX '['VV']'").withZone(ZoneId.of("Europe/Paris"));
        System.out.println(zonedDateTimeFormatterUsingPattern);

        ZonedDateTime zonedDateTimeFormattedUsingParse = ZonedDateTime.parse("01.06.2020, 11:20:15+09:00 [Asia/Tokyo]", zonedDateTimeFormatter);
        System.out.println(zonedDateTimeFormattedUsingParse);

        /* This time, the string represents the date/time in the Europe/Paris time zone */
        // 01.06.2020, 04:20:15+02:00 [Europe/Paris]
        String zonedDateTimeFormattedString = zonedDateTimeFormatted.format(zonedDateTimeFormatter);
        System.out.println(zonedDateTimeFormattedString);
    }
}