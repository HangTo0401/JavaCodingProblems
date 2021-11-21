package WorkingWithDateAndTime;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class MachineTimeViaInstantClass {
    /**
     * Working With Date And Time
     * 62. Machine time via an Instant class
     *
     * SOLUTIONS: There is 1 solution to this problem
     * */

    /**
     * JDK 8 comes with a new class, which is named java.time.Instant.
     * Mainly, the Instant class represents an instantaneous point on the timeline,
     * beginning from the first second of January 1, 1970 (the epoch),
     * in the UTC time zone with a resolution of nanoseconds.
     *
     * A Java 8 Instant class is similar in concept to java.util.Date.
     * Both represent a moment on the timeline in UTC.
     * While Instant has a resolution up to nanoseconds,
     * java.util.Date has a milliseconds' resolution.
     * This class is very handy for generating timestamps of machine time.
     * In order to obtain such a timestamp, simply call the now() method as follows:
     * */

    /**
     * 1. Converting String to Instant
     * Calling Instant.toString() produces an output that follows the ISO-8601 standard
     * for representing date and time.
     *
     * A string that follows the ISO-8601 standard for representing date and time
     * can be easily converted to Instant via the Instant.parse() method, as in the
     * following example:
     * */
    public void setTimeStampFromString() {
        // 2019-02-24T14:31:33.197021300Z
        Instant timeStampFromString = Instant.parse("2019-02-24T14:31:33.197021300Z");
        System.out.println(timeStampFromString);
    }

    /**
     * 2. Adding or subtracting time to/from Instant
     * For adding time, Instant has a plus() methods.
     *
     * Beside the plus() method, Instant also contains
     * plusNanos(), plusMillis(), and plusSeconds().
     *
     * Moreover, beside the minus() method, Instant also contains
     * minusNanos(), minusMillis(), and minusSeconds()
     * For example, adding 2 hours to the current timestamp
     * can be accomplished as follows:
     * */
    public void addOrSubtractTimeFromInstant() {
        // Adding
        Instant twoHourLater = Instant.now().plus(2, ChronoUnit.HOURS);
        System.out.println(twoHourLater);

        // Subtracting
        Instant tenMinutesEarlier = Instant.now().minus(10, ChronoUnit.MINUTES);
        System.out.println(tenMinutesEarlier);
    }

    /**
     * 3. Comparing Instant objects
     * Comparing two Instant objects can be accomplished via the
     * Instant.isAfter() and Instant.isBefore() methods.
     * For example, let's look at the following two Instant objects:
     * */
    public void compareInstantObjects() {
        Instant timestamp1 = Instant.now();
        Instant timestamp2 = timestamp1.plusSeconds(10);

        // Check whether timestamp1 is after timestamp2:
        boolean isAfter = timestamp1.isAfter(timestamp2); // false
        System.out.println(isAfter);

        // Check whether timestamp1 is before timestamp2:
        boolean isBefore = timestamp1.isBefore(timestamp2); // false
        System.out.println(isBefore);

        // The time difference between two Instant objects can be computed via the Instant.until() method:
        // 10 seconds
        long difference = timestamp1.until(timestamp2, ChronoUnit.SECONDS);
        System.out.println(difference);
    }

    /**
     * 4A. Converting between Instant and LocalDateTime, ZonedDateTime, and OffsetDateTime
     * These common conversions can be accomplished as in the following examples:
     * Convert between Instant and LocalDateTime—since LocalDateTime
     * has no idea of time zone, use a zero offset UTC+0:
     * */
    public void convertInstantToLocalDateTime() {
        // 2019-02-24T15:27:13.990103700
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC);
        System.out.println(localDateTime);

        // 2019-02-24T17:27:14.013105Z
        Instant instantLDT = LocalDateTime.now().toInstant(ZoneOffset.UTC);
        System.out.println(instantLDT);
    }

    /**
     * 4B. Converting between Instant and LocalDateTime, ZonedDateTime, and OffsetDateTime
     * These common conversions can be accomplished as in the following examples:
     * Convert between Instant and ZonedDateTime—convert an Instant
     * UTC+0 to a Paris ZonedDateTime UTC+1:
     * */
    public void convertInstantToZonedDateTime() {
        // 2019-02-24T16:34:36.138393100+01:00[Europe/Paris]
        ZonedDateTime zdt = Instant.now().atZone(ZoneId.of("Europe/Paris"));
        System.out.println(zdt);

        // 2019-02-24T16:34:36.150393800Z
        Instant instantZDT = LocalDateTime.now().atZone(ZoneId.of("Europe/Paris")).toInstant();
        System.out.println(instantZDT);
    }

    /**
     * 4C. Converting between Instant and LocalDateTime, ZonedDateTime, and OffsetDateTime
     * These common conversions can be accomplished as in the following examples:
     * Convert between Instant and OffsetDateTime—specify an offset of
     * 2 hours:
     * */
    public void convertInstantToOffsetDateTime() {
        // 2019-02-24T17:34:36.151393900+02:00
        OffsetDateTime odt = Instant.now().atOffset(ZoneOffset.of("+02:00"));
        System.out.println(odt);

        // 2019-02-24T15:34:36.153394Z
        Instant instantODT = LocalDateTime.now().atOffset(ZoneOffset.of("+02:00")).toInstant();
        System.out.println(instantODT);
    }

    public static void main(String[] args) {
        MachineTimeViaInstantClass machineTimeViaInstantClass = new MachineTimeViaInstantClass();

        /* 1. Using java.time.Instant to work with time */
        // 2019-02-24T15:05:21.781049600Z
        Instant now = Instant.now();
        System.out.println(now);

        /* A similar output can be obtained with the following code snippet */
        OffsetDateTime dateNow = OffsetDateTime.now(ZoneOffset.UTC);
        System.out.println(dateNow);

        /* Alternatively, use this code snippet */
        Clock clock = Clock.systemUTC();
        System.out.println(clock);

        /* 2. Adding or subtracting time to/from Instant */
        machineTimeViaInstantClass.setTimeStampFromString();
        machineTimeViaInstantClass.addOrSubtractTimeFromInstant();

        /* 3. Comparing Instant Objects */
        machineTimeViaInstantClass.compareInstantObjects();

        /* 4A. Convert Instant To LocalDateTime */
        machineTimeViaInstantClass.convertInstantToLocalDateTime();

        /* 4B. Convert Instant To ZonedDateTime */
        machineTimeViaInstantClass.convertInstantToZonedDateTime();

        /* 4C. Convert Instant To OffsetDateTime */
        machineTimeViaInstantClass.convertInstantToOffsetDateTime();
    }
}
