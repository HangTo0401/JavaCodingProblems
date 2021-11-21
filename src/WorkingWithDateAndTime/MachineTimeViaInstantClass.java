package WorkingWithDateAndTime;

import java.time.Clock;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

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
    public static void main(String[] args) {
        /* Using java.time.Instant to work with time */
        // 2019-02-24T15:05:21.781049600Z
        // Calling Instant.toString() produces an output that follows the ISO-8601 standard for representing
        //date and time.
        Instant now = Instant.now();
        System.out.println(now);

        /* A similar output can be obtained with the following code snippet */
        OffsetDateTime dateNow = OffsetDateTime.now(ZoneOffset.UTC);
        System.out.println(dateNow);

        /* Alternatively, use this code snippet */
        Clock clock = Clock.systemUTC();
        System.out.println(clock);
    }
}
