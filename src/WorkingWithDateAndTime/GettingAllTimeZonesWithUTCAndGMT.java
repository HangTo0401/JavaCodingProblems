package WorkingWithDateAndTime;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

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
    public void getZoneID() {
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();

        /**
         * At the second step, each time zone ID should be used to create a ZoneId
         * instance.
         * This can be accomplished via the ZoneId.of(String zoneId) method:
         * */
        ZoneId zoneId = ZoneId.of("Asia/Tokyo");

        /**
         * At the third step, each ZoneId can be used to obtain the time that is specific to
         * the identified zone. This means that a "lab rats" reference date-time is
         * needed. This reference date-time (without a time zone, LocalDateTime.now())
         * is combined with the given time zone (ZoneId), via LocalDateTime.atZone(), in
         * order to obtain ZoneDateTime (a date-time that is time-zone aware):
         * */
        LocalDateTime now = LocalDateTime.now();
        ZonedDateTime zdt = now.atZone(zoneId);
        System.out.println(zdt);

        /**
         * At the fourth step, the code can exploit ZonedDateTime
         * in order to extract the UTC offset
         * (for example, for Europe/Bucharest the UTC offset is +02:00):
         * */
        String utcOffset = zdt.getOffset().getId().replace("Z", "+00:00");
        System.out.println(utcOffset);
    }

    /**
     * The getId() method returns the normalized zone offset ID. The +00:00
     * offset is returned as the Z character;
     * therefore the code needs to quickly replace Z with +00:00,
     * in order to align with the rest of the offsets, which
     * respect the format +hh:mm or +hh:mm:ss.
     * Now, let's join these steps into a helper method:
     * */
    public static List<String> fetchTimeZone(OffsetDateTime offsetDateTime) {
        List<String> timezones = new ArrayList<>();
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        LocalDateTime now = LocalDateTime.now();

        zoneIds.forEach((zoneId) ->
        {timezones.add("(" + offsetDateTime + now.atZone(ZoneId.of(zoneId)).getOffset().getId().replace("Z", "+00:00") + ") " + zoneId);
        });

        return timezones;
    }

    public static void main(String[] args) {
        GettingAllTimeZonesWithUTCAndGMT solution = new GettingAllTimeZonesWithUTCAndGMT();
        solution.getZoneID();

        OffsetDateTime offsetDT = OffsetDateTime.now();
        List<String> timezones = GettingAllTimeZonesWithUTCAndGMT.fetchTimeZone(offsetDT);

        // Sort List<String>
        Collections.sort(timezones); // optional sort
        timezones.forEach(System.out::println);
    }
}
