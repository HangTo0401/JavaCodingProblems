package StringNumbersMath;

import java.util.function.BinaryOperator;

public class ComputingMinAndMaxOfTwoNumbers {
    /**
     * String Manipulation
     * 25. Computing the minimum and maximum of two numbers
     *
     * SOLUTIONS: There are 3 solutions to this problem
     * */

    /**
     * 1. The first solution use Math.min() and Math.max()
     * Before JDK 8, a possible solution would be to rely on the Math.min()
     * and Math.max() methods
     * The Math class provides a min() and a max() method for each primitive
     * numeric type (int, long, float, and double).
     * This is shown in the following code:
     *
     * @param num1
     * @param num2
     * @return void
     * */
    public static void computingMinMaxOfTwoNumbers(int num1, int num2) {
        System.out.println(Math.min(num1, num2));
        System.out.println(Math.max(num1, num2));
    }

    /**
     * 2. The second solution use wrapper class
     * Starting with JDK 8, each wrapper class of primitive numeric types
     * (Integer, Long, Float, and Double)
     * comes with dedicated min() and max() methods, and behind these methods,
     * there are invocations of their correspondents from
     * the Math class.
     * This is shown in the following code:
     *
     * @param dnum1
     * @param dnum2
     * @return void
     * */
    public static void computingMinMaxOfTwoNumbersUsingWrapperClass(double dnum1, double dnum2) {
        System.out.println(Double.min(dnum1, dnum2));
        System.out.println(Double.max(dnum1, dnum2));
    }

    /**
     * 3. The third solution use BinaryOperator functional interface
     * In a functional style context, a potential solution will rely on
     * the BinaryOperator functional interface.
     * This interface comes with two methods, minBy() and maxBy()
     * These two methods are capable of returning the minimum (respectively, the
     * maximum) of two elements according to the specified comparator.
     * This is shown in the following code:
     *
     * @param fnum1
     * @param fnum2
     * @return void
     * */
    public static void computingMinMaxOfTwoNumbersUsingBinaryOperator(float fnum1, float fnum2) {
        System.out.println(BinaryOperator.minBy(Float::compare).apply(fnum1, fnum2));
        System.out.println(BinaryOperator.maxBy(Float::compare).apply(fnum1, fnum2));
    }

    public static void main(String[] args) {
        ComputingMinAndMaxOfTwoNumbers solution = new ComputingMinAndMaxOfTwoNumbers();

        int num1 = -45;
        int num2 = -79;

        // C1
        solution.computingMinMaxOfTwoNumbers(num1, num2);

        // C2
        double dnum1 = num1;
        double dnum2= num2;
        solution.computingMinMaxOfTwoNumbersUsingWrapperClass(dnum1, dnum2);

        // C3
        float fnum1 = num1;
        float fnum2= num2;
        solution.computingMinMaxOfTwoNumbersUsingBinaryOperator(fnum1, fnum2);
    }
}
