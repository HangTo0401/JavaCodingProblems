package StringNumbersMath;

public class RemovingWhiteSpacesFromString {

    /**
     * String Manipulation
     * 1.8 Removing White Spaces From A String
     *
     * SOLUTIONS: There is 1 solution to this problem
     *
     * Note that:
     * Starting with JDK 11, String.isBlank() checks
     * whether the string is empty or contains only white space code points
     * For third-party library support, please consider Apache Commons Lang,
     * StringUtils.deleteWhitespace(), and the Spring Framework,
     * StringUtils.trimAllWhitespace().
     * */

    /**
     * 1. The solution to this problem consists of using the String.replaceAll()
     * method with the \s regular expression. Mainly, \s removes all white spaces,
     * including the non-visible ones, such as \t, \n, and \r:
     * This is shown in the following code:
     *
     * @param str
     * */
    public static String removeWhitespaces(String str) {
        return str.replaceAll("\\s", "");
    }

    public static void main(String[] args) {
        RemovingWhiteSpacesFromString solution = new RemovingWhiteSpacesFromString();
        System.out.println(solution.removeWhitespaces("HELLO !!! MY NAME IS HANG"));
    }
}
