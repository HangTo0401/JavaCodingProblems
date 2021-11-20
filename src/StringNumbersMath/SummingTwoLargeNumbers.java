package StringNumbersMath;

import java.util.function.BinaryOperator;

public class SummingTwoLargeNumbers {

    /**
     * Math Manipulation
     * 26. Summing two large int/long values
     * and operation overflow
     *
     * SOLUTIONS: There are 2 solution to this problem
     *
     * Besides, addExact(), Math has multiplyExact(), substractExact(), and
     * negateExact().
     * Moreover, the well-known increment and decrement  expressions, i++ and i--,
     * can be controlled for overflowing their domains via
     * the incrementExact() and decrementExact() methods
     * (for example, Math.incrementExact(i)).
     *
     * Notice that these methods are only available for int and long
     *
     * When working with a large number, also focus on the BigInteger
     * (immutable arbitrary-precision integers)
     * and BigDecimal (immutable, arbitrary-precision signed decimal numbers) classes.
     * */

    /**
     * 1A. The first solution use + operator
     * This is a very simple approach
     * and works fine for most of the computations
     * that involve int, long, float, and double.
     * This is shown in the following code:
     *
     * @param num1
     * @param num2
     * @return int
     * */
    public static int sumTwoNums(int num1, int num2) {
        return num1 + num2;
    }

    /**
     * 1B. The another solution use + operator
     * Now, let's apply this operator on the following two large numbers
     * (sum 2,147,483,647 with itself):
     * int x = Integer.MAX_VALUE;
     * int y = Integer.MAX_VALUE;
     * int z = x + y; // -2
     *
     * This time, z will be equal to -2, which is not the expected result,
     * that is 4,294,967,294.
     *
     * Changing only the z type from int to long will not help.
     * However, changing the types of x and y from int to long as well will help:
     * This is shown in the following code:
     *
     * @param num1
     * @param num2
     * @return long
     * */
    public static long sumTwoLargeNums(int num1, int num2) {
        /* return num1 + num2 then it still returns int value -2 */
        /* return (long) num1 + num2 then it returns long value 4,294,967,294 */
        return (long) num1 + num2;
    }

    /**
     * 1C. The another solution use + operator
     * But the problem will reappear if, instead of Integer.MAX_VALUE,
     * there is Long.MAX_VALUE
     *
     * long x = Long.MAX_VALUE;
     * long y = Long.MAX_VALUE;
     * long z = x + y; // -2
     * This is shown in the following code:
     *
     * @param num1
     * @param num2
     * @return long
     * */
    public static long sumTwoLargeLongNums(long num1, long num2) {
        /* return num1 + num2 then it still returns int value -2 */
        /* return (long) num1 + num2 then it returns long value 4,294,967,294 */
        return num1 + num2;
    }

    /**
     * 2A. The second solution use addExact() method
     * Starting with JDK 8, the + operator has been wrapped
     * in a more expressive way by each wrapper of
     * a primitive numeric type.
     * Therefore, the Integer, Long, Float, and Double classes have a sum() method:
     *
     * long x = Long.MAX_VALUE;
     * long y = Long.MAX_VALUE;
     * long z = Long.sum(); //-2 as well
     *
     * Behind the scenes, the sum() methods uses the + operator as well, so they
     * simply produce the same result as long z = x + y; // -2
     *
     * But also starting with JDK 8, the Math class was enriched with
     * two addExact() methods.
     * There is one addExact() for summing two int variables and one for
     * summing two long variables.
     *
     * These methods are very useful if the result is
     * prone to overflowing int or long, as shown in the preceding case.
     * In such cases, these methods throw ArithmeticException
     * instead of returning a misleading result, as in the following example:
     *
     * The code will throw an exception such as java.lang.ArithmeticException:
     * long overflow.
     *
     * This is useful since it allows us to avoid introducing
     * misleading results in further computations
     * (for example, earlier, -2 could silently enter further computations).
     *
     * This is shown in the following code:
     *
     * @param num1
     * @param num2
     * @return long
     * */
    public static long sumTwoLargeNumsUsingAddExact(long num1, long num2) {
        return Math.addExact(num1, num2); // throw ArithmeticException
    }

    /**
     * 2B. The second solution use addExact() method and wrapped by BinaryOperator
     * In a functional style context, a potential solution will rely on
     * the BinaryOperator functional interface, as follows (simply define the
     * operation of the two operands of the same type):
     * This is shown in the following code:
     *
     * @param num1
     * @param num2
     * @return long
     * */
    public static long sumTwoLargeNumsUsingBinaryOperator(long num1, long num2) {
        BinaryOperator<Long> operator = Math::addExact;
        long z = operator.apply(num1, num2);
        return z; // throw ArithmeticException
    }

    public static void main(String[] args) {
        SummingTwoLargeNumbers solution = new SummingTwoLargeNumbers();

        // C1A
        System.out.println(solution.sumTwoNums(2, 7));

        // C1B
        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        System.out.println(solution.sumTwoLargeNums(x1, y1));

        // C1C
        long x2 = Long.MAX_VALUE;
        long y2 = Long.MAX_VALUE;
        System.out.println(solution.sumTwoLargeLongNums(x2, y2));

        // C2A
        System.out.println(solution.sumTwoLargeNumsUsingAddExact(x2, y2));

        // C2B
        System.out.println(solution.sumTwoLargeNumsUsingBinaryOperator(x2, y2));
    }
}
