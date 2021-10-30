package StringNumbersMath;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class JoiningMultipleStringsWithDelimiter {

    /**
     * String Manipulation
     * 1.9  Joining Multiple Strings With Delimiter
     *
     * SOLUTIONS: There are 5 solutions to this problem
     *
     * Note that:
     * Pay attention to concatenating strings via the += operator, and the concat() and String.format()
     * methods. These can be used to join several strings, but they are prone to performance penalties
     *
     * For example, the following code relies on += and is much slower than relying on StringBuilder:
     * String str = "";
     * for(int i = 0; i < 1_000_000; i++) {
     * str += "x";
     * }
     *
     * += is appended to a string and RECONSTRUCTS A NEW STRING so that
     * it costs more linear time to the length of your strings
     * Avoid using "+" or concat it in loops because
     * both + and concat create a new object every time you call them
     * This can quickly add up to a lot of objects, almost all of which are completely unnecessary
     *
     * StringBuilder DOES NOT RECONSTRUCT A NEW STRING
     * Using StringBuilder for multiple statements/ loops.
     *
     * For third-party library support, please consider Apache Commons Lang, StringUtils.join(), and
     * Guava, Joiner.
     *
     */

    /**
     * 1. The first solution is Brute Force solution using StringBuilder
     * This is shown in the following code:
     *
     * @param delimiter
     * @param args
     * @return String
     * */
    public static String joinByDelimiterBruteForce(char delimiter, String...args) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < args.length; i++) {
            result.append(args[i]).append(delimiter);
        }

        return result.toString().substring(0, result.toString().length() -1);
    }

    /**
     * 2. The second solution is using StringBuilder, as follows:
     * This is shown in the following code:
     *
     * @param delimiter
     * @param args
     * @return String
     * */
    public static String joinByDelimiter(char delimiter, String...args) {
        StringBuilder result = new StringBuilder();

        int i = 0;
        for (i = 0; i < args.length - 1; i++) {
            result.append(args[i]).append(delimiter);
        }
        result.append(args[i]);

        return result.toString();
    }

    /**
     * 3. Starting with Java 8, there are at least 3 more solutions to this problem.
     * The third solution relies on the StringJoiner utility class. This class can
     * be used to construct a sequence of characters separated by a delimiter (for
     * example, a comma).
     * It supports an optional prefix and suffix as well (ignored here)
     * This is shown in the following code:
     *
     * @param delimiter
     * @param args
     * @return String
     * */
    public static String joinByDelimiterUsingStringJoiner(char delimiter, String...args) {
        // Param of StringJoiner is CharSequence delimiter
        StringJoiner joiner = new StringJoiner(String.valueOf(delimiter));

        for (String character : args) {
            joiner.add(character);
        }

        return joiner.toString();
    }

    /**
     * 4. The fourth solution is using the String.join() method
     * This method was introduced in Java 8 and comes in two flavors:
     * String join(CharSequence delimiter, CharSequence... elems)
     * String join(CharSequence delimiter, Iterable<? extends CharSequence> elems)
     * This is shown in the following code:
     *
     * @param delimiter
     * @param args
     * @return String
     * */
    public static String joinByDelimiterUsingJoin(CharSequence delimiter, String...args) {
        // String message = String.join("-", "Java", "is", "cool");
        // message returned is: "Java-is-cool"
        return String.join(delimiter, args);
    }

    /**
     * 5. The final solution is using the Collectors.joining() in Java 8 streams
     * This is shown in the following code:
     *
     * @param delimiter
     * @param args
     * @return String
     * */
    public static String joinByDelimiterUsingCollectorJoining(char delimiter, String...args) {
        // Arrays.stream returns a Stream for the array
        return Arrays.stream(args)
                     .collect(Collectors.joining(String.valueOf(delimiter)));
    }

    public static void main(String[] args) {
        JoiningMultipleStringsWithDelimiter solution = new JoiningMultipleStringsWithDelimiter();

        // C1
        System.out.println(solution.joinByDelimiterBruteForce(',', new String[]{"Java ", "is ", "cool"}));

        // C2
        System.out.println(solution.joinByDelimiter(',', new String[]{"Java ", "is ", "cool"}));

        // C3
        System.out.println(solution.joinByDelimiterUsingStringJoiner(',', new String[]{"Java ", "is ", "cool"}));

        // C4
        System.out.println(solution.joinByDelimiterUsingJoin(",", new String[]{"Java ", "is ", "cool"}));

        // C5
        System.out.println(solution.joinByDelimiterUsingCollectorJoining(',', new String[]{"Java ", "is ", "cool"}));
    }
}
