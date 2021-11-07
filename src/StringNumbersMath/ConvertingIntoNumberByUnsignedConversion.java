package StringNumbersMath;

public class ConvertingIntoNumberByUnsignedConversion {

    /**
     * String Manipulation
     * 1.28 Converting into a number by an unsigned conversion
     *
     * The problem requires that we convert the given signed int into long via an
     * unsigned conversion.
     * So, let's consider signed Integer.MIN_VALUE, which is -2,147,483,648.
     * In JDK 8, by using the Integer.toUnsignedLong() method,
     * the conversion will be as follows (the result will be 2,147,483,648):
     *
     * Other methods from the same category are Integer.toUnsignedString(),
     * Long.toUnsignedString(), Byte.toUnsignedInt(), Byte.toUnsignedLong(),
     * Short.toUnsignedInt(), and Short.toUnsignedLong().
     *
     * SOLUTIONS: There is 1 solution to this problem
     * */
    public static long convertingIntoNumByUnsignedConversion() {
        long result = Integer.toUnsignedLong(Integer.MIN_VALUE);
        return result;
    }

    public static void main(String[] args) {
        ConvertingIntoNumberByUnsignedConversion solution = new ConvertingIntoNumberByUnsignedConversion();

        solution.convertingIntoNumByUnsignedConversion();
    }
}
