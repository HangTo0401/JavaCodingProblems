package StringNumbersMath;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

public class CountingDuplicateCharacters {

    /**
     * String Manipulation
     * 1.1 Counting Duplicate Characters
     * Write a program that counts duplicate characters from a given string.
     *
     * SOLUTION: There are 3 solutions to this problem
     * */

    /**
     *  1. The first solution iterates the string characters and uses Set to store the
     *  characters. If the current character was never added to Set, then add it to Set
     *  If the current character exists in Set, then simply increase countDup variable
     *  This is shown in the following code:
     *
     * @param s
     * @return int
     */
    public static int countingDuplicateCharactersUsingSet(String s) {
        HashSet set = new HashSet();
        int countDup = 1;

        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
            } else {
                countDup++;
            }
        }

        return countDup;
    }

    /**
     * 2. The second solution iterates the string characters and uses Map to store the
     * characters as keys and the number of occurrences as values.
     * If the current character was never added to Map, then add it as (character, 1).
     * If the current character exists in Map, then simply increase its occurrences by 1,
     * For example, (character, occurrences+1).
     * This is shown in the following code:
     *
     * @param s
     * @return Map<Character, Long>
     * */
    public static Map<Character, Integer> countingDuplicateCharactersUsingMap(String s) {
        HashMap<Character, Integer> map = new HashMap();

        for(char ch: s.toCharArray()) {
            map.compute(ch, (k , v) -> (v == null) ? 1 : ++v);
        }

        return map;
    }

    /**
     * 3. The final solution relies on Java 8's stream feature.
     * The first two steps are meant to transform the given string into
     * Stream<Character>, while the last step is responsible for grouping and
     * counting the characters.
     *
     * Here are the steps:
     * a. Call the String.chars() method on the original string. This will
     * return IntStream. This IntStream contains an integer
     * representation of the characters from the given string.
     * b. Transform IntStream into a stream of characters via
     * the mapToObj() method (convert the integer representation into
     * the human-friendly character form).
     * c. Finally, group the characters (Collectors.groupingBy()) and count
     * them (Collectors.counting()).
     *
     * This is shown in the following code:
     *
     * @param s
     * @return Map<Character, Long>
     * */
    public static Map<Character, Long> countDuplicateCharactersUsingStream(String s) {
        Map<Character, Long> map = s.chars()
                                    .mapToObj(c -> (char) c)
                                    .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        return map;
    }

    public static void main(String[] args) {
        CountingDuplicateCharacters countDup = new CountingDuplicateCharacters();
        System.out.println("Number of duplicate character in string: " + countDup.countingDuplicateCharactersUsingSet("ssykjnshb"));
        countDup.countingDuplicateCharactersUsingMap("ssykjnshb");
        countDup.countDuplicateCharactersUsingStream("ssykjnshb");
    }
}