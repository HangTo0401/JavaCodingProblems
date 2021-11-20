package StringNumbersMath;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RemovingDuplicateCharacters {

    /**
     * String Manipulation
     * 12. Removing Duplicate Characters
     *
     * SOLUTIONS: There are 3 solutions to this problem
     * */

    /**
     * 1. The first solution is using StringBuilder.
     * It should loop the characters of the given string and
     * construct a new string containing unique characters
     * It is not possible to simply remove characters
     * from the given string since in Java,
     * a string is immutable
     *
     * The StringBuilder class exposes a method named indexOf(),
     * which returns the index within the given string
     * of the first occurrence of the specified substring
     * (in our case, the specified character).
     *
     * So, a potential solution to this problem
     * would be to loop the characters of the given string
     * and add them one by one in StringBuilder
     * every time the indexOf() method
     * that's applied to the current character returns -1
     *
     * (this negative means that StringBuilder doesn't contain the current character):
     * This is shown in the following code:
     *
     * @param str
     * */
    public static String removeDuplicates(String str) {
        char[] charArray = str.toCharArray(); // or, use charAt(i)
        StringBuilder stringBuilder = new StringBuilder();

        for (char ch : charArray) {
            if (stringBuilder.indexOf(String.valueOf(ch)) == -1) {
                stringBuilder.append(ch);
            }
        }

        return stringBuilder.toString();
    }

    /**
     * 2. The second solution is using a collaboration
     * between HashSet and StringBuilder
     * Mainly, HashSet ensures that duplicates are eliminated,
     * while StringBuilder stores the resulting string
     * If HashSet.add() returns true,
     * then we add the character in StringBuilder as well:
     *
     * Use the toCharArray() method to convert
     * the given string into char[].
     * Alternatively, both solutions can use
     * str.charAt(position) as well
     *
     * This is shown in the following code:
     *
     * @param
     * */
    public static String removeDuplicatesUsingHashSet(String str) {
        char[] charArray = str.toCharArray(); // or, use charAt(i)
        StringBuilder stringBuilder = new StringBuilder();
        Set<Character> character = new HashSet<>();

        for (char ch : charArray) {
            if (!character.contains(ch)) {
                stringBuilder.append(ch);
                character.add(ch);
            }
        }

        return stringBuilder.toString();
    }

    /**
     * 3. The third solution is using Java 8 functional style:
     * It converts the given string into Stream<String>,
     * where each entry is actually a single character.
     * Furthermore, the solution applies the stateful
     * intermediate operation, distinct().
     * This operation will eliminate duplicates from the stream,
     * so it returns a stream without duplicates
     *
     * Finally, the solution calls the collect() terminal operation and relies on
     * Collectors.joining(), which simply concatenates the characters into a string
     * in the encounter order.
     * This is shown in the following code:
     *
     * @param
     * */
    public static String removeDuplicatesUsingJavaStream(String str) {
        return Arrays.asList(str.split(""))
                .stream()
                .distinct()
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        RemovingDuplicateCharacters solution = new RemovingDuplicateCharacters();

        // C1
        System.out.println(solution.removeDuplicates("LELLO MYMYKKYHNH!!!"));

        // C2
        System.out.println(solution.removeDuplicatesUsingHashSet("LELLO MYMYKKYHNH!!!"));

        // C3
        System.out.println(solution.removeDuplicatesUsingJavaStream("LELLO MYMYKKYHNH!!!"));
    }
}
