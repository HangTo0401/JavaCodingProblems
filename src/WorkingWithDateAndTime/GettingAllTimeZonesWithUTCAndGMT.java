package WorkingWithDateAndTime;

public class GettingAllTimeZonesWithUTCAndGMT {
    /**
     * Working With Date And Time
     * 66. Getting all time zones with UTC and GMT
     *
     * UTC and GMT are recognized as the standard references for dealing with
     * dates and times. Today, UTC is the preferred way to go, but UTC and GMT
     * should return the same result in most cases.
     * In order to get all the time zones with UTC and GMT, the solution should
     * focus on the implementation before and after JDK 8. So, let's start with the
     * solution that was useful before JDK 8.
     * */

    /**
     * 1. Getting All Time Zones Using zoneID
     * Before JDK 8
     * The solution needs to extract the available time zone IDs (Africa/Bamako,
     * Europe/Belgrade, and so on). Furthermore, each time zone ID should be
     * used to create a TimeZone object. Finally, the solution needs to extract the
     * offset that was specific to each time zone, taking into account Daylight
     * Saving Time. The code that is bundled to this book contains this solution.
     *
     * Starting with JDK 8
     * The new Java date-time API provides new leverages for solving this problem.
     * At the first step, the available time zones IDs can be obtained via the ZoneId
     * class, as follows:
     * */
}
