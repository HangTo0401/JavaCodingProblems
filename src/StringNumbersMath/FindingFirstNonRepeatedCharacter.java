package StringNumbersMath;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindingFirstNonRepeatedCharacter {

    /**
     * String Manipulation
     * 2. Finding the first non-repeated character in a string
     *
     * SOLUTION: There are 3 solutions to this problem
     *
     */

    /**
     * 1. The first solution is using single traversal approach
     * In the single traversal approach, we populate an array that's meant to store
     * the indexes of all the characters that appear exactly once in the string.
     * With this array, simply return the smallest index containing a non-repeated
     * character
     *
     * This solution assumes that every character from the string is part of the
     * extended ASCII table (256 codes). Having codes greater than 256 requires us
     * to increase the size of the array accordingly.
     *
     * The solution will work as long as the array size is not extended
     * beyond the largest value of the char type, which
     * is Character.MAX_VALUE, that is, 65,535.
     * On the other hand, Character.MAX_CODE_POINT returns the maximum value of
     * a Unicode code point, 1,114,111.
     * To cover this range, we need another implementation based on
     * codePointAt() and codePoints().
     *
     * This is shown in the following code:
     *
     * @param s
     * @return char
     * */
    private static final int EXTENDED_ASCII_CODES = 256;
    public static char findFirstNonRepeatedCharacterUsingSingleTraversal(String s) {
        // Create arrays with size 256
        int[] arraysOfStrIndex = new int[EXTENDED_ASCII_CODES];

        for (int i = 0; i < arraysOfStrIndex.length; i++) {
            arraysOfStrIndex[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            // Get char from s based on ASCII table
            // which is a equal to 97 and z equal to 122
            char ch = s.charAt(i);
            if (arraysOfStrIndex[ch] == -1) {
                arraysOfStrIndex[ch] = i;
            } else {
                arraysOfStrIndex[ch] = -2;
            }
        }

        int position = Integer.MAX_VALUE;

        for (int i = 0; i < EXTENDED_ASCII_CODES; i++) {
            if (arraysOfStrIndex[i] >= 0) {
                // Get the smallest index of non-repeated character
                // which is the first non-repeated character
                position = Math.min(position, arraysOfStrIndex[i]);
            }
        }

        return position == Integer.MAX_VALUE ? Character.MIN_VALUE : s.charAt(position);
    }

    /**
     * 2. The second solution consists of looping the string
     * for each character and counting the number of occurrences
     * Every second occurrence (duplicate) simply breaks the loop,
     * jumps to the next character, and repeats the algorithm
     * If the end of the string is reached,
     * then it returns the current character as the first non-repeatable character
     *
     * This is shown in the following code:
     *
     * @param s
     * @return char
     * */
    public static char findFirstNonRepeatedCharacterUsingLinkedHashSet(String s) {
        // Creating a HashMap containing char as a key and occurrences as  a value
        HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
        LinkedHashSet set = new LinkedHashSet();

        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(i));
            } else {
                charCountMap.put(s.charAt(i), 1);
                set.add(s.charAt(i));
            }
        }

        char firstNonRepeat = (char) set.stream().findFirst().orElse("");;

        return firstNonRepeat;
    }


    /**
     * 3. The final solution is using LinkedHashMap
     * This Java map is an insertion-order map (it maintains the order in which the keys
     * were inserted into the map) and is very convenient for this solution
     * LinkedHashMap is populated with characters as keys and the number
     * of occurrences as values. Once LinkedHashMap is complete, it will return the
     * first key that has a value equal to 1
     * Thanks to the insertion-order feature, this is the first non-repeatable character in the string:
     *
     * @param s
     * @return char
     */
    public static char findFirstNonRepeatedCharacterUsingLinkedHashMap(String s) {
        LinkedHashMap<Character, Integer> linkedMap = new LinkedHashMap();

        for (char ch : s.toCharArray()) {
            // Update value of key in HashMap and return
            // If char not present in charCountMap, increase number of occurrences of duplicate character
            // If char is not present in charCountMap,
            // putting this char to charCountMap with 1 as it's value
            linkedMap.compute(ch, (k,v) -> (v == null) ? 1: ++v);
        }

        for (Map.Entry<Character, Integer> entry: linkedMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return Character.MIN_VALUE;
    }
    public static char findFirstNonRepeatedCharacterUsingStream(String s) {
        // Creating a HashMap containing char as a key and occurrences as  a value
        LinkedHashMap<Character, Integer> charCountMap = new LinkedHashMap<Character, Integer>();

        for (char ch : s.toCharArray()) {
            // Update value of key in HashMap and return
            // If char not present in charCountMap, increase number of occurrences of duplicate character
            // If char is not present in charCountMap,
            // putting this char to charCountMap with 1 as it's value
            charCountMap.compute(ch, (k,v) -> (v == null) ? 1: ++v);
        }

        char firstNonRepeat = charCountMap.entrySet()
                .stream()
                .filter(e -> e.getValue().equals(1))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        return firstNonRepeat;
    }

    public static String firstNonRepeatedCharacterUsingFunctionalStyle(String str) {
        Map<Integer, Long> chs = str.codePoints()
                .mapToObj(cp -> cp)
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new, Collectors.counting()));

        int cp = chs.entrySet().stream()
                .filter(e -> e.getValue() == 1L)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(Integer.valueOf(Character.MIN_VALUE));

        return String.valueOf(Character.toChars(cp));
    }

    public static void main(String[] args) {
        FindingFirstNonRepeatedCharacter solution = new FindingFirstNonRepeatedCharacter();
        // Single Traversal
        System.out.println(solution.findFirstNonRepeatedCharacterUsingSingleTraversal("dsadssre"));

        // Looping and counting the number of occurrences
        System.out.println(solution.findFirstNonRepeatedCharacterUsingLinkedHashSet("dsadssre"));

        // Using Hashmap or LinkedHashMap
        System.out.println(solution.findFirstNonRepeatedCharacterUsingStream("dsadssre"));
        System.out.println(solution.findFirstNonRepeatedCharacterUsingLinkedHashMap("dsadssre"));
        System.out.println(solution.firstNonRepeatedCharacterUsingFunctionalStyle("dsadssre"));

        System.out.println("========");
        // Single Traversal
        System.out.println(solution.findFirstNonRepeatedCharacterUsingSingleTraversal("iooightk"));

        // Looping and counting the number of occurrences
        System.out.println(solution.findFirstNonRepeatedCharacterUsingLinkedHashSet("iooightk"));

        // Using Hashmap or LinkedHashMap
        System.out.println(solution.findFirstNonRepeatedCharacterUsingStream("iooightk"));
        System.out.println(solution.findFirstNonRepeatedCharacterUsingLinkedHashMap("iooightk"));
        System.out.println(solution.firstNonRepeatedCharacterUsingFunctionalStyle("iooightk"));
    }
}
