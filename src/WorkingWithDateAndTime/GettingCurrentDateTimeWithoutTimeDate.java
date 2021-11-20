package WorkingWithDateAndTime;

import java.time.LocalDate;
import java.time.LocalTime;

public class GettingCurrentDateTimeWithoutTimeDate {
    /**
     * Working With Date And Time
     * 60. Getting Current Date Time Without Time Date
     *
     * Before JDK 8, the solution must focus on the java.util.Date class.
     * The code that is bundled to this book contains this solution.
     *
     * Starting with JDK 8, the date and time can be obtained via the dedicated
     * classes, LocalDate and LocalTime, from the java.time package:
     *
     * SOLUTIONS: There is 1 solution to this problem
     * */
    public static void main(String[] args) {
        // 2019-02-24
        LocalDate onlyDate = LocalDate.now();
        System.out.println(onlyDate);

        // 12:53:28.812637300
        LocalTime onlyTime = LocalTime.now();
        System.out.println(onlyTime);
    }
}
