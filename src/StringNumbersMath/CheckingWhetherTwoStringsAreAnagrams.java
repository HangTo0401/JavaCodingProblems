package StringNumbersMath;

public class CheckingWhetherTwoStringsAreAnagrams {
    /**
     * String Manipulation
     * 1.18 Checking Whether Two Strings Are Anagrams
     *
     * Two strings that have the same characters,
     * but that are in a different order are anagrams.
     *
     * Some definitions impose that anagrams are case-insensitive
     * and/or that white spaces (blanks) should be ignored.
     *
     * So, independent of the applied algorithm,
     * the solution must convert the given string into lowercase
     * and remove white spaces (blanks).
     * Besides that, the first solution we mentioned
     * sorts the arrays via Arrays.sort()
     * and will check their equality via Arrays.equals().
     * Once they are sorted, if they are anagrams, they will be equal
     * The following diagram shows two words that are anagrams:
     * Example:
     * H e ll o -> hello
     * oehLL -> oehll
     * => hello and oehll are anagrams
     *
     * SOLUTIONS: There is 1 solution to this problem
     * */

    /**
     * 1. The first solution is pretty simple
     * The algorithm as below:
     *
     * a. For each character from the first string, this solution increases the
     * value in this array corresponding to the ASCII code by 1
     * b. For each character from the second string, this solution
     * decreases the value in this array corresponding to the ASCII code
     * by 1
     * At the end of this traversal, if the given strings are anagrams,
     * then this array contains only 0
     * This is shown in the following code:
     *
     * @param str1
     * @param str2
     * @return int
     * */
    private static final int EXTENDED_ASCII_CODES = 256;
    public static boolean isAnagram(String str1, String str2) {
        int[] chCounts = new int[EXTENDED_ASCII_CODES];

        // Change to lowercase and remove whitespaces
        char[] chStr1 = str1.replaceAll("\\s", "").toLowerCase().toCharArray();
        char[] chStr2 = str2.replaceAll("\\s", "").toLowerCase().toCharArray();

        if (chStr1.length != chStr2.length) {
            return false;
        }

        for (int i = 0; i < chStr1.length; i++) {
            // If the value is existed in chStr1,
            // Increases the value to 1
            chCounts[chStr1[i]]++;

            // If the value is ALSO existed in chStr2,
            // Now the value is 1, and we decrease the value from 1 to 0
            chCounts[chStr2[i]]--;
        }

        // If the given strings are anagrams, the array just have 0 value only
        for (int i = 0; i < chCounts.length; i++) {
            if (chCounts[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CheckingWhetherTwoStringsAreAnagrams solution = new CheckingWhetherTwoStringsAreAnagrams();
        System.out.println(solution.isAnagram("H e ll o", "oehLL"));
    }
}
