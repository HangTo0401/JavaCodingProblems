package StringNumbersMath;

public class StringAsUnsignedNumberInRadix {

    /**
     * String Manipulation
     *
     * 1.27 String as an unsigned number in the radix
     *
     * The support for unsigned arithmetic was added to Java8.
     * The Byte, Short, Integer, and Long classes
     * were affected the most by this addition.
     *
     * Note that:
     * The parseUnsignedInt() method can parse strings that represent numbers
     * greater than Integer.MAX_VALUE (trying to accomplish this via
     * Integer.parseInt() will throw a java.lang.NumberFormatException exception):
     *
     * // Integer.MAX_VALUE + 1 = 2147483647 + 1 = 2147483648
     * int maxValuePlus1 = Integer.parseUnsignedInt("2147483648");
     * */

    /**
     * 1A. The first solution to parsing it into an unsigned int value
     * in the radix of 36 (the maximum accepted radix)
     *
     * In Java, strings representing positive numbers can be parsed as unsigned int
     * and long types via the parseUnsignedInt()
     * and parseUnsignedLong() methods in JDK 8
     *
     * The first argument is the number, while the second is the radix.
     * The radix should be in the range [2, 36] or [Character.MIN_RADIX,
     * Character.MAX_RADIX].
     * Using a radix of 10 can be easily accomplished as follows (this method
     * applies a radix of 10 by default):
     * This is shown in the following code:
     *
     * @param nri
     * @return int
     * */
    public static int parseUnsigned(String nri) {
        int result = Integer.parseUnsignedInt(nri, Character.MAX_RADIX);
        return result;
    }

    /**
     * 1B. Starting with JDK 9, parseUnsignedInt() has a new flavor.
     * Besides, the string and the radix,
     * this method accepts a range of the [beginIndex, endIndex] type
     * This time, the parsing is accomplished in this range.
     * For example, specifying the range [1, 3] can be done as follows:
     * This is shown in the following code:
     *
     * @param nri
     * @return int
     * */
    public static int parseUnsignedInt(String nri) {
        int result = Integer.parseUnsignedInt(nri, 1, 4, Character.MAX_RADIX);
        return result;
    }

    public static void main(String[] args) {
        StringAsUnsignedNumberInRadix solution = new StringAsUnsignedNumberInRadix();

        System.out.println(solution.parseUnsigned("25550"));
        System.out.println(solution.parseUnsignedInt("25550"));
    }
}
