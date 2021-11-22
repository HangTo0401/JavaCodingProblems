package WorkingWithDateAndTime;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GettingLocalDateTimeInAllAvailableTimeZones {
    /**
     * Working With Date And Time
     * 67. Getting LocalDateTime In All Available TimeZones
     * Before JDK 8, the quick solution to get the current local date-time was to call
     * the Date empty constructor. Furthermore, use Date to display it in all the
     * available time zones, which can be obtained via the TimeZone class. The code
     * that is bundled to this book contains this solution
     *
     * SOLUTIONS: There is 1 solution to this problem
     * */

    /**
     * 1. The solution to this problem can be obtained by following these steps:
     * a. Get the local date-time.
     * b. Get the available time zones.
     * c. Before JDK 8, use SimpleDateFormat with the setTimeZone()
     * method.
     * d. Starting with JDK 8, use ZonedDateTime
     *
     * Starting with JDK 8, a convenient solution to get the current local date-time
     * in the default time zone is to call the ZonedDateTime.now() method:
     *
     * ZonedDateTime zlt = ZonedDateTime.now();
     *
     * So, this is the current date in the default time zone. Furthermore, this date
     * should be displayed in all the available time zones that are obtained via the
     * ZoneId class:
     *
     * Set<String> zoneIds = ZoneId.getAvailableZoneIds();
     *
     * Finally, the code can loop the zoneIds, and for each zone id, it can call the
     * ZonedDateTime.withZoneSameInstant(ZoneId zone) method. This method
     * returns a copy of this date-time with a different time zone, retaining the
     * instant
     * */
    public static List<String> localTimeToAllTimeZones() {
        List<String> result = new ArrayList<>();
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd'T'HH:mm:ss a Z");
        ZonedDateTime zlt = ZonedDateTime.now();

        zoneIds.forEach((zoneId) -> {
            result.add(zlt.format(formatter) + " in " + zoneId + " is "
                    + zlt.withZoneSameInstant(ZoneId.of(zoneId))
                    .format(formatter));
        });
        return result;
    }

    public static void main(String[] args) {
        GettingLocalDateTimeInAllAvailableTimeZones solution = new GettingLocalDateTimeInAllAvailableTimeZones();
        List<String> listString = solution.localTimeToAllTimeZones();
        listString.forEach(System.out::println);
    }
}
