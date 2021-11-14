package ObjectsImmutabilitySwitchExpressions;

import java.util.Objects;

public class CheckingSubrangeInRangeFromZeroToLength {
    /**
     * 1.45 Checking the subrange in the range from 0 to length
     *
     * Let's follow the same flow from the previous problem. So, this time, the
     * Function class will look as follows:
     *
     * public class Function {
     * private final int n;
     *      public Function(int n) {
     *          this.n = n;
     *      }
     *
     *      public int yMinusX(int x, int y) {
     *          return y - x;
     *      }
     * }
     *
     * Notice that the preceding snippet of code doesn't assume any range
     * restrictions over x, y, and n.
     *
     * Now, let's impose the following ranges:
     * n must be between 0 (inclusive) and 101 (exclusive), so n belongs
     * to [0, 101].
     * In the yMinusX() method, the range bounded by x and y, [x, y]
     * must be a subrange of [0, n].
     * These ranges can be imposed in code via the if statements as follows:
     *
     * SOLUTIONS: There is 1 solution to this problem
     * */

    /**
     * 1. The first solution use Objects.checkIndex() method
     * Based on the previous problem, the condition for n can be replaced with
     * Objects.checkIndex().
     *
     * Moreover, the JDK 9 Objects class comes with a
     * method named checkFromToIndex(int start, int end, int length) that
     * checks whether the given subrange [given start, given end] is within the
     * bounds of the range from [0, given length].
     *
     * So, this method can be applied to
     * the yMinusX() method to check that the range bounded by x and y, [x, y) is a
     * subrange of [0, n]
     * For example, the following test will lead to IndexOutOfBoundsException
     * since x is greater than y:
     * */
    private static final int N_UPPER_BOUND = 101;
    private final int n;

    public CheckingSubrangeInRangeFromZeroToLength(int n) {
        this.n = Objects.checkIndex(n, N_UPPER_BOUND);
    }

    public int yMinusX(int x, int y) {
        Objects.checkFromToIndex(x, y, n);
        return y - x;
    }

    public static void main(String[] args) {
        CheckingSubrangeInRangeFromZeroToLength f = new CheckingSubrangeInRangeFromZeroToLength(50);
        System.out.println(f.yMinusX(30, 20));
    }
}
