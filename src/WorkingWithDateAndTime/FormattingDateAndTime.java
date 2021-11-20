package WorkingWithDateAndTime;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class FormattingDateAndTime {
    /**
     * Working With Date And Time
     * 59. Formatting date and time
     *
     * The previous problem contains some flavors of formatting date and time via
     * SimpleDateFormat.format() and DateTimeFormatter.format().
     *
     * In order to define format patterns, the developer must be aware of the format pattern
     * syntax.
     * In other words, the developer must be aware of the set of symbols
     * that are used by the Java date-time API in order to recognize a valid format pattern.
     *
     * Most of the symbols are common to SimpleDateFormat (before JDK 8) and to
     * DateTimeFormatter (starting with JDK 8).
     * The following table lists the most common symbols—the
     * complete list is available in the JDK documentation:
     *
     * SOLUTIONS: There are 6 solutions to this problem
     * */

    public static void main(String[] args) {
        /* Before JDK 8, a format pattern can be applied via SimpleDateFormat */
        // yyyy-MM-dd
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String stringDate = formatter.format(date);
        System.out.println(stringDate);

        /**
         * Starting with JDK 8, a format pattern can be applied via DateTimeFormatter:
         * For LocalDate (date without a time zone in the ISO-8601 calendar system):
         * */
        // yyyy-MM-dd
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatterLocalDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String stringLD = formatterLocalDate.format(localDate);
        System.out.println(stringLD);

        // or shortly
        String stringLDUsingLocalDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(stringLDUsingLocalDate);

        /**
         * For LocalTime (time without a time zone in the ISO-8601 calendar system):
         * */
        // HH:mm:ss
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter formatterLocalTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        String stringLT = formatterLocalTime.format(localTime);
        System.out.println(stringLT);

        // or shortly
        String stringLTUsingLocal = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println(stringLTUsingLocal);

        /**
         * For LocalDateTime (date-time without a time zone in the ISO-8601 calendar system):
         * */
        // yyyy-MM-dd HH:mm:ss
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatterLocalDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String stringLDT = formatterLocalDateTime.format(localDateTime);
        System.out.println(stringLDT);

        // or shortly
        String stringLDTUsingLocalDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(stringLDTUsingLocalDateTime);

        /**
         * For ZonedDateTime (date-time with a time zone in the ISO-8601 calendar system):
         * */
        // E MMM yyyy HH:mm:ss.SSSZ
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        DateTimeFormatter formatterZonedDateTime = DateTimeFormatter.ofPattern("E MMM yyyy HH:mm:ss.SSSZ");
        String stringZDT = formatterZonedDateTime.format(zonedDateTime);
        System.out.println(stringZDT);

        // or shortly
        String stringZDTUsingZonedDateTime = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("E MMM yyyy HH:mm:ss.SSSZ"));
        System.out.println(stringZDTUsingZonedDateTime);

        /**
         * For OffsetDateTime (date-time with an offset from UTC/GMT in the ISO-8601 calendar system):
         * */
        // E MMM yyyy HH:mm:ss.SSSZ
        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        DateTimeFormatter formatterOffsetDateTime = DateTimeFormatter.ofPattern("E MMM yyyy HH:mm:ss.SSSZ");
        String odt1 = formatterOffsetDateTime.format(offsetDateTime);
        System.out.println(odt1);

        // or shortly
        String odt2 = OffsetDateTime.now().format(DateTimeFormatter.ofPattern("E MMM yyyy HH:mm:ss.SSSZ"));
        System.out.println(odt2);

        /**
         * For OffsetTime (time with an offset from UTC/GMT in the ISO-8601 calendar system):
         * */
        // HH:mm:ss,Z
        OffsetTime offsetTime = OffsetTime.now();
        DateTimeFormatter formatterOffsetTime = DateTimeFormatter.ofPattern("HH:mm:ss,Z");
        String ot1 = formatterOffsetTime.format(offsetTime);
        System.out.println(ot1);

        // or shortly
        String ot2 = OffsetTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss,Z"));
        System.out.println(ot2);
    }
}
