package StringNumbersMath;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javafx.util.Pair;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.partitioningBy;

public class CountingVowelsAndConsonants {

    /**
     * String Manipulation
     * 1.5  Counting Vowels And Consonants
     *
     * SOLUTION: There are 2 solutions to this problem
     */

    /**
     * The first solution to this problem requires traversing the string characters
     * and doing the following:
     *
     * a. We need to check whether the current character is a vowel (this is
     * convenient since we only have five pure vowels in English; other
     * languages have more vowels, but the number is still small).
     *
     * b. If the current character is not a vowel, then check whether it sits
     * between 'a' and 'z' (this means that the current character is a
     * consonant)
     *
     * Notice that, initially, the given String object is transformed into lowercase
     * This is useful to avoid comparisons with uppercase characters
     * For example, the comparison is accomplished
     * only against 'a' instead of 'A' and 'a'
     * The code for this solution is as follows:
     *
     * @param str
     * @return Pair<Integer, Integer>
     */
    private static final Set<Character> allVowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public static Pair<Integer, Integer> countVowelsAndConsonants(String str) {
        // Convert to lowercase
        str = str.toLowerCase();

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (allVowels.contains(ch)) {
                vowels++;
            } else if ((ch >= 'a' && ch <= 'z')) {
                consonants++;
            }
        }

        return new Pair(vowels, consonants);
    }

    /**
     * The first solution to this problem requires Java 8 functional style,
     * this code can be rewritten using chars() and filter():
     *
     * The given string is filtered accordingly and the count() terminal operation
     * returns the result. Relying on partitioningBy() will reduce the code
     * The code for this solution is as follows:
     *
     * @param str
     * @return Pair<Long, Long>
     */
    public static Pair<Long, Long> countVowelsAndConsonantsFunctionalStyle(String str) {
        // Using Collectors partitioningBy()
        // method to split the stream of elements into
        // contain only char from 'a' to 'z'
        Map<Boolean, Long> result = str.chars()
                                       .mapToObj(c -> (char) c)
                                       .filter(ch -> ch >= 'a' && ch <= 'z')
                                       .collect(partitioningBy(c -> allVowels.contains(c), counting()));

        return new Pair<Long, Long>(result.get(true), result.get(false));
    }

    public static void main(String[] args) {
        CountingVowelsAndConsonants solution = new CountingVowelsAndConsonants();
        Pair<Integer, Integer> firstPair = solution.countVowelsAndConsonants("fkhsdaklfashklyuhiu");
        System.out.println("Num of vowels: " + firstPair.getKey());
        System.out.println("Num of consonants: " + firstPair.getValue());

        Pair<Integer, Integer> secPair = solution.countVowelsAndConsonants("fkhsdaklfashklyuhiu");
        System.out.println("Num of vowels: " + secPair.getKey());
        System.out.println("Num of consonants: " + secPair.getValue());
    }
}
