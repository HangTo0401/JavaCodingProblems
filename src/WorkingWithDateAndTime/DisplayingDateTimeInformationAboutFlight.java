package WorkingWithDateAndTime;

import java.time.*;

public class DisplayingDateTimeInformationAboutFlight {
    /**
     * Working With Date And Time
     * 68. Displaying date-time information about a flight
     *
     * SOLUTIONS: There is 1 solution to this problem
     * */

    /**
     * 1. The solution that is presented in this section will display the following
     * information about the 15 hours and 30 minutes flight from Perth, Australia
     * to Bucharest, Europe:
     * UTC date-time at departure and arrival
     * Perth date-time at departure and arrival in Bucharest
     * Bucharest date-time at departure and arrival
     * Let's assume that the reference departure date-time from Perth is February
     * 26, 2019, at 16:00 (or 4:00 PM):
     *
     * First, let's combines this date-time with the time zone of Australia/Perth
     * (+08:00). This will result in a ZonedDateTime object that is specific to
     * Australia/Perth (this is the clock date and time in Perth at departure):
     * */
    public void displayFlightDateTime() {
        // Assume the reference departure date-time from Perth
        LocalDateTime ldt = LocalDateTime.of(2019, Month.FEBRUARY, 26, 16, 00);

        // 04:00 PM, Feb 26, 2019 +0800 Australia/Perth
        ZonedDateTime AUPerthDepart = ldt.atZone(ZoneId.of("Australia/Perth"));
        System.out.println("Australia/Perth Departure time: " + AUPerthDepart);

        /**
         * Further, let's add 15 hours and 30 minutes to ZonedDateTime. The resulting
         * ZonedDateTime represents the date-time in Perth (this is the clock date and
         * time in Perth on arrival in Bucharest):
         * */
        // 07:30 AM, Feb 27, 2019 +0800 Australia/Perth
        ZonedDateTime AUPerthArrive = AUPerthDepart.plusHours(15).plusMinutes(30);
        System.out.println("Australia/Perth Arrive time: " + AUPerthArrive);

        /**
         * Now, let's calculate the date-time in Bucharest at the departure date-time in
         * Perth. Basically, the following code expresses the departure date-time from
         * the Perth time zone in the Bucharest time zone:
         * */
        ZonedDateTime EUBucharestDepart = AUPerthDepart.withZoneSameInstant(ZoneId.of("Europe/Bucharest"));
        System.out.println("Europe/Bucharest Departure time: " + EUBucharestDepart);

        /**
         * Finally, let's calculate the date-time in Bucharest on arrival. The following
         * code expresses the arrival date-time from the Perth time zone in the
         * Bucharest time zone:
         * */
        ZonedDateTime EUBucharestArrive = AUPerthArrive.withZoneSameInstant(ZoneId.of("Europe/Bucharest"));
        System.out.println("Europe/Bucharest Arrive time: " + EUBucharestArrive);

        /**
         * As shown in the following figure, the UTC time at departure from Perth is
         * 8:00 AM, while the UTC time on arrival in Bucharest is 11:30 PM:
         * */
        // 08:00 AM, Feb 26, 2019
        OffsetDateTime utcAtDepart = AUPerthDepart.withZoneSameInstant(ZoneId.of("UTC")).toOffsetDateTime();
        System.out.println("UTC Departure time: " + utcAtDepart);

        // 11:30 PM, Feb 26, 2019
        OffsetDateTime utcAtArrive = AUPerthArrive.withZoneSameInstant(ZoneId.of("UTC")).toOffsetDateTime();
        System.out.println("UTC Arrive time: " + utcAtArrive);
    }

    public static void main(String[] args) {
        DisplayingDateTimeInformationAboutFlight solution = new DisplayingDateTimeInformationAboutFlight();
        solution.displayFlightDateTime();
    }
}
