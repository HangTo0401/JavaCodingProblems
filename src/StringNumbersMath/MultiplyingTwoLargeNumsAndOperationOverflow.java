package StringNumbersMath;

import java.util.function.BinaryOperator;

public class MultiplyingTwoLargeNumsAndOperationOverflow {
    /**
     * Math Manipulation
     * 1.37 Multiplying two large int/long values and operation overflow
     *
     * SOLUTIONS: There are 6 solutions to this problem
     *
     * Note that:
     * In JDK 8, Math.muliplyExact(int x, int y) returns int
     * and Math.muliplyExact(long x, long y) returns long.
     * In JDK 9, Math.muliplyExact(long, int y) returning long was added as well.
     *
     * For working with a large number, also focus on the BigInteger
     * (immutable arbitrary-precision integers)
     * and BigDecimal
     * (immutable, arbitrary-precision signed decimal numbers) classes.
     * */

    /**
     * 1. The first solution use * operator
     * This is a very simple approach
     * and works fine for most of the computations
     * that involve int, long, float, and double as well.
     *
     * In case num1 = Integer.MAX_VALUE;
     * and num2 = Integer.MAX_VALUE;
     * then num1 * num2 = 1, which is not the expected result,
     * that is 4,611,686,014,132,420,609
     * Changing only the z type from int to long will not help
     * However, changing the types of x and y from int to long will
     * So, computations that overflow the domain and rely on
     * the * operator will end up in misleading results.
     * This is shown in the following code:
     *
     * @param num1
     * @param num2
     * @return int
     * */
    public static int multiplyingTwoLargeNums(int num1, int num2) {
        return num1 * num2;
    }

    /**
     * 2. The second solution use * operator
     * This is a very simple approach
     * and works fine for most of the computations
     * that involve int, long, float, and double as well.
     *
     * In case num1 = Integer.MAX_VALUE;
     * and num2 = Integer.MAX_VALUE;
     * then num1 * num2 = 1, which is not the expected result,
     * that is 4,611,686,014,132,420,609
     * Changing only the z type from int to long will not help
     * However, changing the types of x and y from int to long will
     * solve the problem
     *
     * But the problem will reappear if we have
     * Long.MAX_VALUE instead of Integer.MAX_VALUE
     * So, computations that overflow the domain and rely on
     * the * operator will end up in misleading results.
     *
     * This is shown in the following code:
     *
     * @param num1
     * @param num2
     * @return long
     * */
    public static long multiplyingTwoLongNums(int num1, int num2) {
        return (long) num1 * num2;
    }

    /**
     * 3. The third solution use Math.multiplyExact()
     * In JDK 8 comes with the Math.multiplyExact() method
     * This method tries to multiply two integers
     * If the result overflows, int will just throw ArithmeticException:
     * This is shown in the following code:
     *
     * @param num1
     * @param num2
     * @return long
     * */
    public static long multiplyingTwoLargeNumsUsingMultiplyExact(int num1, int num2) {
        return Math.multiplyExact(num1, num2); // throw ArithmeticException
    }

    /**
     * 4. The fourth solution use Math.multiplyFull()
     * In JDK 9 comes with Math.multiplyFull(int x, int y) returning long value
     * This method is very useful for obtaining the exact mathematical product of
     * two integers as long, as follows:
     * This is shown in the following code:
     *
     * @param num1
     * @param num2
     * @return long
     * */
    public static long multiplyingTwoLargeNumsUsingMultiplyFull(int num1, int num2) {
        return Math.multiplyFull(num1, num2); // throw ArithmeticException
    }

    /**
     * 5. The fifth solution use Math.muliptlyHigh()
     * In JDK 9 also comes with a method Math.muliptlyHigh(long x, long y)
     * returning a long
     * The long value returned by this method
     * represents the most significant 64 bits of the 128-bit product
     * of two 64-bit factors
     * This is shown in the following code:
     *
     * @param num1
     * @param num2
     * @return long
     * */
    public static long multiplyingTwoLargeNumsUsingMultiplyHigh(long num1, long num2) {
        return Math.multiplyHigh(num1, num2); // throw ArithmeticException
    }

    /**
     * 6. The sixth solution use BinaryOperator functional interface
     * In a functional style context, a potential solution will rely on
     * the BinaryOperator functional interface, as follows (simply define the
     * operation of the two operands of the same type):
     * This is shown in the following code:
     *
     * @param num1
     * @param num2
     * @return long
     * */
    public static long multiplyingTwoLargeNumsUsingBinaryOperator(Integer num1, Integer num2) {
        BinaryOperator<Integer> operator = Math::multiplyExact;
        return operator.apply(num1, num2); // throw ArithmeticException
    }

    public static void main(String[] args) {
        MultiplyingTwoLargeNumsAndOperationOverflow solution = new MultiplyingTwoLargeNumsAndOperationOverflow();

        // C1A
        System.out.println(solution.multiplyingTwoLargeNums(10, 5));

        // C1B
        // throw 1 instead of 4611686014132420609
        System.out.println(solution.multiplyingTwoLargeNums(Integer.MAX_VALUE, Integer.MAX_VALUE));

        // C2
        System.out.println(solution.multiplyingTwoLongNums(Integer.MAX_VALUE, Integer.MAX_VALUE));

        // C3
        System.out.println(solution.multiplyingTwoLargeNumsUsingMultiplyExact(Integer.MAX_VALUE, Integer.MAX_VALUE));

        // C4
        System.out.println(solution.multiplyingTwoLargeNumsUsingMultiplyFull(Integer.MAX_VALUE, Integer.MAX_VALUE));

        // C5
        System.out.println(solution.multiplyingTwoLargeNumsUsingMultiplyHigh(Long.MAX_VALUE, Long.MAX_VALUE));

        // C6
        System.out.println(solution.multiplyingTwoLargeNumsUsingBinaryOperator(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }
}
