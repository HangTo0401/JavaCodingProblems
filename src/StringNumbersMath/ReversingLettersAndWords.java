package StringNumbersMath;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ReversingLettersAndWords {
    /**
     * String Manipulation
     * 3. Reversing Letters And Words
     *
     * SOLUTION: There are 2 solutions to this problem
     * */

    private static final String WHITESPACE = " ";

    // Create a pattern from the regular expression passed as parameter to method
    private static final Pattern PATTERN = Pattern.compile(" +");

    /**
     * 1. First, let's reverse only the letters of each word.
     * The first solution to this problem can exploit the StringBuilder class
     * The first step consists of splitting the string into an array of words
     * using a white space as the delimiter (Spring.split(" ")).
     *
     * Furthermore, we reverse each word using the corresponding ASCII codes
     * and append the result to StringBuilder
     * First, we split the given string by space.
     * Then, we loop the obtained array of words and reverse each word by
     * fetching each character via charAt() in reverse order:
     * This is shown in the following code:
     *
     * @param str
     * @return String
     * */
    public String reverseWordsUsingStringBuilder(String str) {
        String[] words = str.split(WHITESPACE);
        StringBuilder reversedString = new StringBuilder();

        for (String word: words) {
            StringBuilder reversedWord = new StringBuilder();

            for (int i = word.length() - 1; i >= 0; i--) {
                reversedWord.append(word.charAt(i));
            }

            reversedString.append(reversedWord).append(WHITESPACE);
        }

        return reversedString.toString();
    }

    /**
     * 2. The second solution is using Java 8 style and built in function
     *
     * Notice that the preceding two methods return a string
     * containing the letters of each word reversed,
     * but the words themselves are in the same initial order
     *
     * Now, let's consider another method that reverses the letters of each
     * word and the words themselves
     * thanks to the built-in StringBuilder.reverse() method
     * This is shown in the following code:
     *
     * @param str
     * @return String
     * */
    public String reverseWordsUsingJavaStream(String str) {
        return PATTERN.splitAsStream(str)
                      .map(s -> new StringBuilder(s).reverse())
                      .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        ReversingLettersAndWords solution = new ReversingLettersAndWords();
        // C1
        System.out.println(solution.reverseWordsUsingStringBuilder("Hello World!!!"));

        // C2
        System.out.println(solution.reverseWordsUsingJavaStream("Hello World!!!"));
    }
}
