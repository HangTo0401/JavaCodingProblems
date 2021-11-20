package StringNumbersMath;

public class CountingOccurrencesOfCertainCharacter {

    /**
     * String Manipulation
     * 6. Counting Occurrences Of A Certain Character
     *
     * SOLUTION: There are 4 solutions to this problem
     */

    /**
     * 1. The first solution to this problem consists of the following two steps:
     * a. Replace every occurrence of the character in the given string with
     * "" (basically, this is like removing all the occurrences of this
     * character in the given string)
     *
     * b. Subtract the length of the string that was obtained in the first step
     * from the length of the initial string.
     * The code for this method is as follows:
     *
     * @param str
     * @param ch
     * @return int
     */
    public static int countOccurrencesOfACertainCharacter(String str, char ch) {
        // Replace certain character with ""
        return str.length() - str.replace(String.valueOf(ch), "").length();
    }

    /**
     * 2. The second solution covers Unicode surrogate pairs as well
     * The code for this method is as follows:
     *
     * @param str
     * @param ch
     * @return int
     * */
    public static int countOccurrencesOfACertainCharacterCoverUnicode(String str, String ch) {
        // codePointCount() returns the number of Unicode code points in the specified text range of this String.
        if (ch.codePointCount(0, ch.length()) > 1) {
            // There is more than 1 Unicode character in the given String
            // The given String contains more than 2 characters
            return -1;
        }

        int result = str.length() - str.replace(ch, "").length();

        // if ch.length() return 2 then this is a Unicode surrogate pair
        return ch.length() == 2 ? result / 2 : result;
    }

    /**
     * 3. The third solution is fast solution consists of
     * looping the string characters (a single traversal)
     * and comparing each character with the given character
     * Increase the counter by one for every match:
     * The code for this method is as follows:
     *
     * @param str
     * @param ch
     * @return int
     * */
    public static int countOccurrencesOfACertainCharacterSingleTraversal(String str, char ch) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }

        return count;
    }

    /**
     * The final solution that covers the Unicode surrogate pairs is in the code that's
     * bundled with this book
     * In Java 8 functional style, one solution consists of using filter() or reduce()
     * For example, using filter() will result in the following code
     * The solution that covers the Unicode surrogate pairs is in the code that's
     * bundled with this book
     * The code for this method is as follows:
     *
     * @param str
     * @param ch
     * @return long
     */
    public static long countOccurrencesOfACertainCharacterUsingJavaStream(String str, char ch) {
        return str.chars()
                .filter(c -> c == ch)
                .count();
    }

    public static void main(String[] args) {
        CountingOccurrencesOfCertainCharacter solution = new CountingOccurrencesOfCertainCharacter();

        System.out.println(solution.countOccurrencesOfACertainCharacter("HOW ARE YOU HOW CAN YOU HOW DARE YOU", 'H'));
        System.out.println(solution.countOccurrencesOfACertainCharacterCoverUnicode("HOW ARE YOU HOW CAN YOU HOW DARE YOU", "H"));
        System.out.println(solution.countOccurrencesOfACertainCharacterSingleTraversal("HOW ARE YOU HOW CAN YOU HOW DARE YOU", 'H'));
        System.out.println(solution.countOccurrencesOfACertainCharacterUsingJavaStream("HOW ARE YOU HOW CAN YOU HOW DARE YOU", 'H'));
    }
}
