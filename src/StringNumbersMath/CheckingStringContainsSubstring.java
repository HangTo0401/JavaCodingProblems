package StringNumbersMath;

import java.util.regex.Pattern;

public class CheckingStringContainsSubstring {

    /**
     * String Manipulation
     * 15. Checking that a string contains a substring
     *
     * SOLUTIONS: There are 3 solutions to this problem
     * */

    /**
     * 1. The first solution is very simple, that use the String.contains() method
     * This method returns a boolean value indicating whether the given substring
     * is present in the string or not:
     * This is shown in the following code:
     *
     * @param str
     * @param subStr
     * @return boolean
     * */
    public static boolean containsSubstringUsingContains(String str, String subStr) {
        // pay attention that this will return true for subtext=""
        return str.contains(subStr);
    }

    /**
     * 2. The second solution is using String.indexOf() or String.lastIndexOf()
     * This is shown in the following code:
     *
     * @param str
     * @param subStr
     * @return boolean
     * */
    public static boolean containsSubstringUsingIndexOf(String str, String subStr) {
        // pay attention that this will return true for subtext=""
        return str.indexOf(subStr)  != -1; // or lastIndexOf()
    }

    /**
     * 3. The final solution is using a regular expression
     * Notice that the regular expression is wrapped in the Pattern.quote() method
     * This is needed to escape special characters
     * such as <([{\^-=$!|]})?*+.> in the given substring.
     * For third-party library support, please consider Apache Commons Lang,
     * StringUtils.containsIgnoreCase().
     * This is shown in the following code:
     *
     * @param str
     * @param subStr
     * @return boolean
     * */
    public static boolean containsSubstringUsingRegularExpression(String str, String subStr) {
        // pay attention that this will return true for subtext=""
        return str.matches("(?i).*" + Pattern.quote(subStr) + ".*");
    }

    public static void main(String[] args) {
        CheckingStringContainsSubstring solution = new CheckingStringContainsSubstring();

        // C1
        System.out.println(solution.containsSubstringUsingContains("hello world!", "orl"));

        // C2
        System.out.println(solution.containsSubstringUsingIndexOf("hello world!", "orl"));

        // C3
        System.out.println(solution.containsSubstringUsingRegularExpression("hello world!", "orl"));
    }
}
