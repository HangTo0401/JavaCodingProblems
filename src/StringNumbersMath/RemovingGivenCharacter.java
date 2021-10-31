package StringNumbersMath;

import java.util.stream.Collectors;

public class RemovingGivenCharacter {

    /**
     * String Manipulation
     * 1.13 Removing a given character
     *
     * SOLUTIONS: There are 4 solutions to this problem
     * */

    /**
     * 1. The first solution that relies on JDK support
     * can exploit the String.replaceAll() method
     * This method replaces each substring (in our case, each character) of
     * the given string that matches the given regular expression
     * (in our case, the regular expression is the character itself)
     * with the given replacement
     * (in our case, the replacement is an empty string, ""):
     *
     * Notice that the regular expression is wrapped in
     * the Pattern.quote() method
     *
     * This is needed to escape special characters such as
     * <, (, [, {, \, ^, -, =, $, !, |, ], }, ), ?, *, +, ., and >.
     * Mainly, this method returns a literal pattern string
     * for the specified string.
     * This is shown in the following code:
     *
     * @param str
     * @param ch
     * */
    public static String removeCharacter(String str, char ch) {
        return str.replaceAll(String.valueOf(ch), "");
    }

    /**
     * 2. The second solution avoids regular expressions. This time,
     * the solution relies on StringBuilder
     * Basically, the solution loops the characters
     * of the given string and compares each character with the
     * character to remove
     * Each time the current character is different from the character to remove,
     * the current character is appended in StringBuilder:
     * This is shown in the following code:
     *
     * @param str
     * @param ch
     * */
    public static String removeCharacterUsingStringBuilder(String str, char ch) {
        StringBuilder sb = new StringBuilder();
        char[] chArray = str.toCharArray();

        for (char c : chArray) {
            if (c != ch) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    /**
     * 3. The third solution is using Java 8 functional style approach
     * This is a four-step approach:
     *   a. Convert the string into IntStream via the String.chars() method
     *   b. Filter IntStream to eliminate duplicates
     *   c. Map the resulted IntStream to Stream<String>
     *   d. Join the strings from this stream and collect them as a single
     *   string
     * This is shown in the following code:
     *
     * @param str
     * @param ch
     * */
    public static String removeCharacterUsingJavaStream(String str, char ch) {
        return str.chars()
                  .filter(c -> c != ch)
                  .mapToObj(c -> String.valueOf((char) c))
                  .collect(Collectors.joining());
    }

    /**
     * 4. The fourth solution if we want to remove a Unicode surrogate pair,
     * then we can rely on codePointAt() and codePoints(),
     * as shown in the following implementation:
     * This is shown in the following code:
     *
     * @param str
     * @param ch
     * */
    public static String removeUnicodeCharacter(String str, String ch) {
        int codePoint = ch.codePointAt(0);

        return str.codePoints()
                  .filter(c -> c != codePoint)
                  .mapToObj(c -> String.valueOf(Character.toChars(c)))
                  .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        RemovingGivenCharacter solution = new RemovingGivenCharacter();

        // C1
        System.out.println(solution.removeCharacter("HELLO WORLD!!!", 'L'));

        // C2
        System.out.println(solution.removeCharacterUsingStringBuilder("HELLO WORLD!!!", 'L'));

        // C3
        System.out.println(solution.removeCharacterUsingJavaStream("HELLO WORLD!!!", 'L'));

        // C3
        System.out.println(solution.removeCharacterUsingJavaStream("HELLO WORLD!!!", 'L'));

        // C4
        System.out.println(solution.removeUnicodeCharacter("HELLO WORLD!!!", "L"));
    }
}
