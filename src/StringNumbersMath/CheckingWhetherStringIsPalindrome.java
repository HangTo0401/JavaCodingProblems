package StringNumbersMath;

import java.util.stream.IntStream;

public class CheckingWhetherStringIsPalindrome {
    /**
     * String Manipulation
     * 11. Checking Whether String Is Palindrome
     *
     * A palindrome (whether a string or a number) looks
     * unchanged when it's reversed.
     *
     * This means that processing (reading) palindrome
     * can be done from both directions
     * and the same result will be obtained
     * For example, the word madam is a palindrome,
     * while the word madame is not
     *
     * SOLUTIONS: There are 4 solutions to this problem
     */

    /**
     * 1. The first solution consists of comparing the letters of the given
     * string in a meet-in-the-middle approach
     * Basically, this solution compares the first character with the last one,
     * the second character with the last by one,
     * and so on until the middle of the string is reached.
     * This is shown in the following code:
     *
     * @param str
     * */
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (right > left) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    /**
     * 2. The second solution will consist of for statement
     * instead of a while statement
     * This is shown in the following code:
     *
     * @param str
     * */
    public static boolean isPalindromeUsingSingleTraversal(String str) {
        int n = str.length();

        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                return false;
            }
        }

        return true;
    }

    /**
     * 3. The third solution will use StringBuilder class,
     * which uses the reverse() method
     * As its name suggests, the reverse() method
     * returns the reverse given string
     * In the case of a palindrome,
     * the given string should be equal to the reverse version of it:
     * This is shown in the following code:
     *
     * @param str
     * */
    public static boolean isPalindromeUsingStringBuilder(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    /**
     * 4. The fourth solution use Java 8 functional style
     * Simply define IntStream ranging from 0 to half
     * of the given string and use the noneMatch()
     * short-circuiting terminal operation with a predicate that
     * compares the letters by following the meet-in-the-middle approach:
     *
     * The noneMatch() returns:
     * true – if no element in the stream matches the given predicate, or the stream is empty
     * false – if at least one element matches the given predicate
     * This is shown in the following code:
     *
     * @param str
     * */
    public static boolean isPalindromeUsingNoneMatch(String str) {
        return IntStream.range(0, str.length() / 2)
                        .noneMatch(p -> str.charAt(p) != str.charAt(str.length() - p - 1));
    }

    public static void main(String[] args) {
        CheckingWhetherStringIsPalindrome solution = new CheckingWhetherStringIsPalindrome();

        // C1
        System.out.println(solution.isPalindrome("abba"));

        // C2
        System.out.println(solution.isPalindromeUsingSingleTraversal("abba"));

        // C3
        System.out.println(solution.isPalindromeUsingStringBuilder("abba"));

        // C4
        System.out.println(solution.isPalindromeUsingNoneMatch("abba"));
    }
}
