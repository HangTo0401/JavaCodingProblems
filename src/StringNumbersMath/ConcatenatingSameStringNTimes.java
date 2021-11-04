package StringNumbersMath;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConcatenatingSameStringNTimes {
    /**
     * String Manipulation
     * 1.20 Concatenating Same String N Times
     *
     * SOLUTIONS: There are sixth solutions to this problem
     * */

    /**
     * 1. The first solution use StringBuilder before JDK 11
     * This is shown in the following code:
     *
     * @param str
     * @param count
     * @return String
     * */
    public static String concatRepeatUsingStringBuilder(String str, int count) {
        // Capacity is str.length() * count
        StringBuilder sb = new StringBuilder(str.length() * count);

        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

    /**
     * 2. The second solution use String.repeat() with JDK 11
     * This method returns a string resulting from concatenating
     * this string count times
     * Behind the scenes, this method uses System.arraycopy(),
     * which makes this very fast:
     * This is shown in the following code:
     *
     * @param str
     * @param count
     * @return String
     * */
    public static String concatRepeatUsingStringRepeat(String str, int count) {
        String result = str.repeat(count);
        return result;
    }

    /**
     * 3. The third solution use String.join()
     * The role of Collections.nCopies() returns an immutable list
     * which contains n copies of given object
     * This is shown in the following code:
     *
     * @param str
     * @param count
     * @return String
     * */
    public static String concatRepeatUsingStringJoin(String str, int count) {
        String result = String.join("", Collections.nCopies(count, str));
        return result;
    }

    /**
     * 4. The fourth solution use Stream.generate()
     * This is shown in the following code:
     *
     * @param str
     * @param count
     * @return String
     * */
    public static String concatRepeatUsingStreamGenerate(String str, int count) {
        String result = Stream.generate(() -> str)
                              .limit(count)
                              .collect(Collectors.joining());
        return result;
    }

    /**
     * 5. The fifth solution use String.format()
     * This is shown in the following code:
     *
     * @param str
     * @param count
     * @return String
     * */
    public static String concatRepeatUsingStringFormat(String str, int count) {
        System.out.println(String.format("%0" + count + "d", 0));
        String result = String.format("%0" + count + "d", 0).replace("0", str);
        return result;
    }

    /**
     * 6. The sixth solution use String.format()
     * This is shown in the following code:
     *
     * @param str
     * @param count
     * @return String
     * */
    public static String concatRepeatUsingCharArray(String str, int count) {
        String result = new String(new char[count]).replace("\0", str);
        return result;
    }

    /**
     * 7. The seventh solution to check whether a string
     * is a sequence of the same substring,
     * The solution loops half of the given string
     * and progressively replaces it with "", a substring build,
     * by appending the original string in StringBuilder, character by character.
     * If these replacements result in an empty string,
     * it means that the given string is a sequence of the same substring.
     * This is shown in the following code:
     *
     * @param str
     * @return boolean
     * */
    public static boolean checkSequenceOfSameSubstring(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length() / 2; i++) {
            sb.append(str.charAt(i));
            String resultStr = str.replaceAll(sb.toString(), "");
            if (resultStr.length() == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ConcatenatingSameStringNTimes solution = new ConcatenatingSameStringNTimes();

        // C1
        System.out.println(solution.concatRepeatUsingStringBuilder("HELLO", 3));

        // C2
        System.out.println(solution.concatRepeatUsingStringRepeat("HELLO", 3));

        // C3
        System.out.println(solution.concatRepeatUsingStringJoin("HELLO", 3));

        // C4
        System.out.println(solution.concatRepeatUsingStreamGenerate("HELLO", 3));

        // C5
        System.out.println(solution.concatRepeatUsingStringFormat("HELLO", 3));

        // C6
        System.out.println(solution.concatRepeatUsingCharArray("HELLO", 3));

        // Other issue
        System.out.println(solution.checkSequenceOfSameSubstring("HELLO"));
    }
}
