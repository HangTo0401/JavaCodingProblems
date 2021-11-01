package StringNumbersMath;

import javafx.util.Pair;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class FindingCharacterWithMostAppearances {

    /**
     * String Manipulation
     * 1.14 Finding the character with the most appearances
     *
     * SOLUTIONS: There are 3 solutions to this problem
     * */

    /**
     * 1. The first solution is using HashMap
     * This solution consists of 3 steps:
     *
     * a. First, loop the characters of the given string and put the pairs of
     * the key-value in HashMap where the key is the current character
     * and the value is the current number of occurrences
     *
     * b. Second, compute the maximum value in HashMap (for example,
     * using Collections.max()) representing the maximum number of
     * occurrences
     *
     * c. Finally, get the character that has the maximum number of
     * occurrences by looping the HashMap entry set
     *
     * The utility method returns Pair<Character, Integer> containing the
     * character with the most appearances and the number of appearances (notice
     * that the white spaces are ignored). If you don't prefer to have this extra class,
     * that is, Pair, then just rely on Map.Entry<K, V>:
     * This is shown in the following code:
     *
     * @param str
     * @return Pair<Character, Integer>
     * */
    public static Pair<Character, Integer> maxOccurenceCharacter(String str) {
        Map<Character, Integer> map = new HashMap();
        char[] arrStr = str.toCharArray();

        for (int i = 0; i < str.length(); i++) {
            char currentChar = arrStr[i];

            if ((!Character.isWhitespace(currentChar))) {//ignore space
                if (!map.containsKey(currentChar)) {
                    map.put(currentChar, 1);
                } else {
                    map.put(currentChar, map.get(currentChar) + 1);
                }
            }
        }

        int maxOccurrences = Collections.max(map.values());
        char maxCharacter = Character.MIN_VALUE;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxOccurrences) {
                maxCharacter = entry.getKey();
            }
        }

        return new Pair(maxCharacter, maxOccurrences);
    }

    /**
     * 2. The second solution is using the ASCII codes
     * which little faster the first solution
     * This solution starts with an empty array of 256 indexes
     * (256 is the maximum number of extended ASCII table codes;
     * more information can be found in the Finding the first nonrepeated character section)
     *
     * Furthermore, this solution loops the characters of the given string
     * and keeps track of the number of appearances for each
     * character by increasing the corresponding index in this array:
     * This is shown in the following code:
     *
     * @param str
     * @return Pair<Character, Integer>
     * */
    private static final int EXTENDED_ASCII_CODES = 256;
    public static Pair<Character, Integer> maxOccurenceCharacterUsingArray(String str) {
        int[] asciiCodes = new int[EXTENDED_ASCII_CODES];
        char[] chStr = str.toCharArray();

        int maxOccurrences = -1;
        char maxCharacter = Character.MIN_VALUE;

        for (int i = 0; i < chStr.length; i++) {
            char currentCh = chStr[i];
            if (!Character.isWhitespace(currentCh)) { // ignoring space
                int code = (int) currentCh;
                asciiCodes[code]++;

                if (asciiCodes[code] > maxOccurrences) {
                    maxOccurrences = asciiCodes[code];
                    maxCharacter = currentCh;
                }
            }
        }

        return new Pair<>(maxCharacter, maxOccurrences);
    }

    /**
     * 3. The final solution relies on Java 8 functional style:
     * To start, this solution collects distinct characters as keys in Map,
     * along with their number of occurrences as values
     * Furthermore, it uses the Java 8 Map.Entry.comparingByValue()
     * and max() terminal operations to determine the entry
     * in the map with the highest value (highest number of occurrences).
     *
     * Since max() is a terminal operation, the solution may return
     * Optional<Entry<Character, Long>>, but this solution adds an extra step and
     * maps this entry to Pair<Character, Long>.
     * This is shown in the following code:
     *
     * @param str
     * @return Pair<Character, Long>
     * */
    public static Pair<Character, Long> maxOccurenceCharacterUsingJavaStream(String str) {
        return str.chars()
                  .filter(c -> Character.isWhitespace(c) == false)// ignoring space
                  .mapToObj(c -> (char) c)
                  .collect(groupingBy(c -> c, counting()))
                  .entrySet()
                  .stream()
                  .max(comparingByValue())
                  .map(p -> new Pair(p.getKey(), p.getValue()))
                  .orElse(new Pair(Character.MIN_VALUE, -1L));
    }

    public static void main(String[] args) {
        FindingCharacterWithMostAppearances solution = new FindingCharacterWithMostAppearances();
        Pair<Character, Integer> result = solution.maxOccurenceCharacter("HELLO LOLLIPOP!!!");
        System.out.println("Character: " + result.getKey());
        System.out.println("Occurrence: " + result.getValue());
        System.out.println("==============");

        Pair<Character, Integer> result1 = solution.maxOccurenceCharacterUsingArray("HELLO LOLLIPOP!!!");
        System.out.println("Character: " + result.getKey());
        System.out.println("Occurrence: " + result.getValue());
        System.out.println("==============");

        Pair<Character, Long> result2 = solution.maxOccurenceCharacterUsingJavaStream("HELLO LOLLIPOP!!!");
        System.out.println("Character: " + result.getKey());
        System.out.println("Occurrence: " + result.getValue());
    }
}
