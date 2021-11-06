package StringNumbersMath;

import java.util.Arrays;
import java.util.List;

public class ApplyingIndentation {

    /**
     * String Manipulation
     * 1.23 Applying Indentation
     *
     * SOLUTIONS: There are 3 solutions to this problem
     *
     * Example: Let's assume that we have the following String values:
     * String days = "Sunday\n"
     * "Monday\n"
     * "Tuesday\n"
     * "Wednesday\n"
     * "Thursday\n"
     * "Friday\n"
     * "Saturday";
     * Printing this String values with an indentation of 10 spaces can be done as
     * follows:
     * Monday
     * Tuesday
     * Wednesday
     * Thursday
     * Friday
     * Saturday
     * */

    /**
     * 1. The first solution use Indentation
     * Starting with JDK 12, we can indent text
     * via the String.indent(int n) method.
     * This is shown in the following code:
     *
     * @param str
     * @return String
     * */
    public static String applyIndentation(String str) {
        return str.indent(10);
    }

    /**
     * 2. The second solution use Cascade Indentation
     * This is shown in the following code:
     *
     * @param str
     * @return void
     * */
    public static void applyCascadeIndentation(String str) {
        List<String> days = Arrays.asList(str);
        for (int i = 0; i < days.size(); i++) {
            System.out.print(days.get(i).indent(i));
        }
    }

    /**
     * 3. The third solution use Java Stream and Indentation
     * This is shown in the following code:
     *
     * @param str
     * @return void
     * */
    public static void applyIndentationUsingStream(String str) {
        List<String> days = Arrays.asList(str);

        days.stream()
           .forEachOrdered(d -> System.out.print(d.indent(d.length())));
    }

    /**
     * How about indenting a piece of HTML code?
     * The solution use Indentation to indent HTML codes
     * This is shown in the following code:
     *
     * @param str
     * @return void
     * */
    public static void applyHTMLIndentation(String str) {
        String html = "<html>";
        String body = "<body>";
        String h2 = "<h2>";
        String text = "Hello world!";
        String closeH2 = "</h2>";
        String closeBody = "</body>";
        String closeHtml = "</html>";
        System.out.println(html.indent(0) + body.indent(4) + h2.indent(8)
                + text.indent(12) + closeH2.indent(8) + closeBody.indent(4)
                + closeHtml.indent(0));
    }

    public static void main(String[] args) {
        ApplyingIndentation solution = new ApplyingIndentation();
        String days = "Sunday\n"
                    + "Monday\n"
                    + "Tuesday\n"
                    + "Wednesday\n"
                    + "Thursday\n"
                    + "Friday\n"
                    + "Saturday";

        // C1
        System.out.print(solution.applyIndentation(days));

        // C2
        solution.applyCascadeIndentation(days);

        // C3
        solution.applyIndentationUsingStream(days);

        // C4
        solution.applyHTMLIndentation(days);
    }
}
