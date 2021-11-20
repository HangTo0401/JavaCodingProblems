package StringNumbersMath;

public class FiniteFloatingPointValue {

    /**
     * Math Manipulation
     * 31. Double/float is a finite floating-point value
     *
     * SOLUTIONS: There is 2 solutions to this problem
     * The problem arises from the fact that some floating-point methods
     * and operations produce Infinity or NaN
     * as results instead of throwing an exception.
     * */

    /**
     * 1. The first solution use MAX_VALUE
     * The solution to checking whether the given float/double is a finite floating-point value
     * relies on the following conditions—the absolute value
     * of the given float/double value must not exceed
     * the largest positive finite value of the float/double type:
     * This is shown in the following code:
     *
     * @param fnum
     * @param dnum
     * */
    public static void finiteFloatingPointUsingMaxValue(float fnum, double dnum) {
        // for float
        System.out.println(Math.abs(fnum) <= Float.MAX_VALUE);

        // for double
        System.out.println(Math.abs(dnum) <= Double.MAX_VALUE);
    }

    /**
     * 2. The second solution use isFinite() method
     * Starting with Java 8, the preceding conditions were exposed
     * via two dedicated flag-methods, Float.isFinite() and Double.isFinite().
     * Therefore, the following examples are valid test cases
     * for finite floating-point values:
     *
     * @param fnum
     * @param dnum
     * */
    public static void finiteFloatingPointUsingFiniteMethod(float fnum, double dnum) {
        // For float
        System.out.println(Float.isFinite(fnum));

        // For double
        System.out.println(Double.isFinite(dnum));
    }

    public static void main(String[] args) {
        FiniteFloatingPointValue solution = new FiniteFloatingPointValue();

        solution.finiteFloatingPointUsingMaxValue(4.5f, 0.000333411333d);
        solution.finiteFloatingPointUsingFiniteMethod(4.5f, 0.000333411333d);
    }
}
