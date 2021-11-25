package WorkingWithDateAndTime;

import java.time.*;

public class DefiningExtractingZoneOffsets {
    /**
     * Working With Date And Time
     * 71. DefiningExtractingZoneOffsets
     *
     * By zone of set, we understand the amount of time needed to be
     * added/subtracted from the GMT/UTC time in order to obtain the date-time
     * for a specific zone on the globe (for example, Perth, Australia). Commonly, a
     * zone offset is printed as a fixed number of hour and minutes: +02:00,
     * -08:30, +0400, UTC+01:00, and so on.
     * So, in short, a zone offset is the amount of time by which a time zone differs
     * from GMT/UTC.
     * By zone of set, we understand the amount of time needed to be
     * added/subtracted from the GMT/UTC time in order to obtain the date-time
     * for a specific zone on the globe (for example, Perth, Australia). Commonly, a
     * zone offset is printed as a fixed number of hour and minutes: +02:00,
     * -08:30, +0400, UTC+01:00, and so on.
     * So, in short, a zone offset is the amount of time by which a time zone differs
     * from GMT/UTC.
     *
     * Before JDK 8, a time zone can be defined via java.util.TimeZone. With this
     * time zone, the code can obtain the zone offset via the
     * TimeZone.getRawOffset() method (the raw part comes from the fact that this
     * method doesn't take into account Daylight Saving Time). The code that is
     * bundled to this book contains this solution.
     * */

    /**
     * 1. The first solution use ZoneId and ZoneOffset
     * Starting with JDK 8, there are two classes responsible for dealing with time
     * zone representations. First, there is java.time.ZoneId, which represents a
     * time zone such as Athens, Europe, and second there is java.time.ZoneOffset
     * (extends ZoneId), which represents the fixed amount of time (offset) of the
     * specified time zone with GMT/UTC.
     *
     * The new Java date-time API deals with Daylight Saving Time by
     * default; therefore, a region with summer-winter cycles that uses Daylight
     * Saving Time will have two ZoneOffset classes.
     * The UTC zone offset can be easily obtained as follows (this is +00:00,
     * represented in Java by the Z character):
     * */
    public void definingExtractingZoneOffsets() {
        ZoneOffset zoneOffset = ZoneOffset.UTC;
        System.out.println(zoneOffset);

        // The system default time zone can also be obtained via the ZoneOffset class:
        // Europe/Athens
        ZoneId zoneId = ZoneOffset.systemDefault();
        System.out.println(zoneId);

        /**
         * In order to take the zone offset with Daylight Saving Time, the code needs to
         * associate a date-time with it.
         * For example, associate a LocalDateTime class (Instant can also be used) like this:
         * */
        // By default it deals with the Daylight Saving Times
        LocalDateTime ldt = LocalDateTime.of(2019, 6, 15, 0, 0);
        ZoneId zoneId1 = ZoneId.of("Europe/Bucharest");
        System.out.println(zoneId1);

        // +03:00
        ZoneOffset zoneOffsets = zoneId.getRules().getOffset(ldt);
        System.out.println(zoneOffsets);

        /**
         * A zone offset can also be obtained from a string. For example, the following
         * code obtains a zone offset of +02:00:
         * */
        ZoneOffset zoneOffsetFromString = ZoneOffset.of("+02:00");
        System.out.println(zoneOffsetFromString);

        /**
         * This is a very convenient approach of quickly adding a zone offset to a
         * Temporal object that supports zone offsets. For example, use it to add a zone
         * offset to OffsetTime and OffsetDateTime (convenient ways for storing a date
         * in a database, or sending over the wires):
         * */
        OffsetTime offsetTime = OffsetTime.now(zoneOffsetFromString);
        System.out.println(offsetTime);

        OffsetDateTime offsetDateTime = OffsetDateTime.now(zoneOffsetFromString);
        System.out.println(offsetDateTime);
    }

    /**
     * 2. The second solution use ZoneOffset
     * Another solution to our problem is to rely on defining ZoneOffset from hours,
     * minutes, and seconds. One of the helper methods of ZoneOffset is dedicated
     * to this:
     * */
    public void definingZoneOffset() {
        // +08:30 (this was obtained from 8 hours and 30 minutes)
        ZoneOffset zoneOffsetFromHoursMinutes = ZoneOffset.ofHoursMinutes(8, 30);
        System.out.println(zoneOffsetFromHoursMinutes);

        // Next to ZoneOffset.ofHoursMinutes(), there is ZoneOffset.ofHours(),
        // ofHoursMinutesSeconds() and ofTotalSeconds().
    }

    /**
     * 3. The third solution use Temporal object
     * Finally, every Temporal object that supports a zone offset provides a handy
     * getOffset() method. For example, the following code gets the zone offset
     * from the preceding offsetDateTime object:
     * */
    public void definingUsingTemporal() {
        ZoneOffset zoneOffsetFromString = ZoneOffset.of("+02:00");
        OffsetDateTime offsetDateTime = OffsetDateTime.now(zoneOffsetFromString);

        // +02:00
        ZoneOffset zoneOffsetFromOdt = offsetDateTime.getOffset();
        System.out.println(zoneOffsetFromOdt);
    }

    public static void main(String[] args) {
        DefiningExtractingZoneOffsets solution = new DefiningExtractingZoneOffsets();

        // C1
        solution.definingExtractingZoneOffsets();

        // C2
        solution.definingZoneOffset();

        // C3
        solution.definingUsingTemporal();
    }
}
