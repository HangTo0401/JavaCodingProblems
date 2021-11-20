package StringNumbersMath;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountingSubstringOccurrencesInString {

    /**
     * String Manipulation
     * 17. Counting Substring Occurrences In A String
     *
     * Counting the number of occurrences of a string in another string is a
     * problem that can have at least two interpretations:
     *      11 in 111 occurs 1 time
     *      11 in 111 occurs 2 times
     *
     * SOLUTIONS: There are 3 solutions to this problem
     * */

    /**
     * 1. In the first case (11 in 111 occurs 1 time), the first solution use
     * the String.indexOf() method.
     *
     * One of the flavors of this method allows us to obtain the index
     * within this string of the first occurrence of the specified
     * substring, starting at the specified index
     * (or -1, if there is no such occurrence).
     *
     * Based on this method, the solution can simply traverse the
     * given string and count the given substring occurrences.
     * The traversal starts from position 0
     * and continues until the substring is not found:
     * This is shown in the following code:
     *
     * @param str
     * @param toFind
     * @return int
     * */
    public static int countStringInStringUsingIndexOf(String str, String toFind) {
        int position = 0;
        int count = 0;
        int n = toFind.length();

        // indexOf has param String toFind, int fromIndex position
        while(str.indexOf(toFind, position) != -1) {
            position = position + n;
            count++;
        }

        return count;
    }

    /**
     * 2. In the first case (11 in 111 occurs 1 time),
     * the second solution use the String.split() method
     *
     * Basically, the solution can split the given string
     * using the given substring as a delimiter.
     * The length of the resulting String[] array
     * should be equal to the number of expected occurrences:
     * This is shown in the following code:
     *
     * @param str
     * @param toFind
     * @return int
     * */
    public static int countStringInStringUsingSplit(String str, String toFind) {
        // \Q means "start of literal text" (i.e. regex "open quote")
        // \E means "end of literal text" (i.e. regex "close quote")
        System.out.println(Pattern.quote(toFind));

        // split(@String regex, int limit) to splits this string
        // around matches of the given regular expression.
        int result = str.split(Pattern.quote(toFind), -1).length - 1;
        return result < 0 ? 0 : result;
    }

    /**
     * 3. In the second case (11 in 111 occurs 2 times),
     * the final solution use the Pattern and Matcher classes
     * This is shown in the following code:
     *
     * @param str
     * @param toFind
     * @return int
     * */
    public static int countStringInStringUsingPattern(String str, String toFind) {
        // Create a pattern from the regular expression
        Pattern pattern = Pattern.compile(Pattern.quote(toFind));
        Matcher matcher = pattern.matcher(str);

        int position = 0;
        int count = 0;

        while (matcher.find(position)) {
            position = matcher.start() + 1;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        CountingSubstringOccurrencesInString solution = new CountingSubstringOccurrencesInString();

        // C1
        System.out.println("Occurrence: " + solution.countStringInStringUsingIndexOf("1111", "1"));

        // C2
        System.out.println("Occurrence: " +  solution.countStringInStringUsingSplit("1111", "1"));

        // C3
        System.out.println("Occurrence: " +  solution.countStringInStringUsingPattern("1111", "1"));
    }
}
