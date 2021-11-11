package StringNumbersMath;

import java.math.BigInteger;

public class ConvertingBigIntegerToPrimitive {

    /**
     * Math Manipulation
     * 1.33 Converting BigInteger into a primitive type
     * SOLUTIONS: There is 1 solution to this problem:
     *
     * The BigInteger class is a very handy tool for representing immutable
     * arbitrary-precision integers.
     * This class also contains methods (originating from java.lang.Number)
     * that are useful for converting BigInteger into a primitive type
     * such as byte, long, or double.
     *
     * However, these methods can produce unexpected results and confusion.
     * */

    /**
     * 1. The first solution use BigInteger.longValue() and BigInteger.intValue() method
     * This time, the nrInt primitive variable will have a value of -1 (the same result
     * will produce shortValue() and byteValue()).
     *
     * Conforming to the documentation, if the value of BigInteger
     * is too big to fit in the specified primitive type,
     * only the low-order n bits are returned
     * (n depends on the specified primitive type).
     *
     * But if the code is not aware of this statement, then
     * it will push values as -1 in further computations, which will lead to confusion.
     * This is shown in the following code:
     *
     * @param bigInt
     * @return void
     * */
    public static void convertBigIntToPrimitive(BigInteger bigInt) {
        System.out.println("Double value: " + bigInt.doubleValue());
        System.out.println("Int value: " + bigInt.intValue());
    }

    /**
     * 2. The second solution use longValueExact() and intValueExact()
     * Starting with JDK 8, a new set of methods was added. These
     * methods are dedicated to identifying the information that's lost during the
     * conversion from BigInteger into the specified primitive type.
     *
     * If a piece of lost information is detected, ArithmeticException will be thrown.
     * This way, the code signals that the conversion has encountered
     * some issues and prevents this unpleasant situation.
     * These methods are longValueExact(), intValueExact(), shortValueExact(),
     * and byteValueExact():
     *
     * Notice that intValueExact() did not return -1 as intValue().
     * This time, the lost information that was caused by
     * the attempt of converting the largest
     * long value into int was signaled
     * via an exception of the ArithmeticException type.
     * */
    public static void convertBigIntToPrimitiveUsingJava8(BigInteger bigInt) {
        System.out.println("Double value: " + bigInt.longValueExact()); // works as expected
        System.out.println("Int value: " + bigInt.intValueExact()); // throws exception
    }

    public static void main(String[] args) {
        ConvertingBigIntegerToPrimitive solution = new ConvertingBigIntegerToPrimitive();
        BigInteger bigIntNum = BigInteger.valueOf(Long.MAX_VALUE);

        solution.convertBigIntToPrimitive(bigIntNum);
        solution.convertBigIntToPrimitiveUsingJava8(bigIntNum);
    }
}
