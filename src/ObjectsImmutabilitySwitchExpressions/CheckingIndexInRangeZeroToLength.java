package ObjectsImmutabilitySwitchExpressions;

import java.util.Objects;

public class CheckingIndexInRangeZeroToLength {
    /**
     * Objects Immutability Switch Expressions
     * 44. Checking the index in the range from 0 to length
     *
     * Notice that the preceding snippet of code doesn't assume any range
     * restrictions over x and y. Now, let's impose the following ranges (this is very
     * common with mathematical functions):
     * x must be between 0 (inclusive) and 11 (exclusive), so x belongs to
     * [0, 11].
     * In the xMinusY() method, y must be between 0 (inclusive) and x
     * (exclusive), so y belongs to [0, x].
     * In the oneMinusY() method, y must be between 0 (inclusive) and
     * 16 (exclusive), so y belongs to [0, 16).
     * These ranges can be imposed in code via the if statements, as follows:
     *
     * SOLUTIONS: There are 2 solutions to this problem
     * */

    /**
     * 1. The first solution defines UPPER_BOUND X and Y
     * Consider replacing IndexOutOfBoundsException with a more meaningful
     * exception (for example, extend IndexOutOfBoundsException and create a
     * custom exception to type, RangeOutOfBoundsException).
     * */
    private static final int X_UPPER_BOUND = 11;
    private static final int Y_UPPER_BOUND = 16;
    private final int x;
    private final int x1;

    public CheckingIndexInRangeZeroToLength(int x) {
        if (x < 0 || x >= X_UPPER_BOUND) {
            throw new IndexOutOfBoundsException("...");
        }
        this.x = x;
        this.x1 = Objects.checkIndex(x, X_UPPER_BOUND);
    }

    public int xMinusY(int y) {
        if (y < 0 || y >= x) {
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException in xMinusY");
        }
        return x - y;
    }

    public static int oneMinusY(int y) {
        if (y < 0 || y >= Y_UPPER_BOUND) {
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException in oneMinusY");
        }
        return 1 - y;
    }

    /**
     * 2. The second solution use Objects.checkIndex() method
     * Starting with JDK 9, the code can be rewritten to use the
     * Objects.checkIndex() method. This method verifies whether the given index
     * is in the range [0, length] and returns the given index in this range or
     * throws IndexOutOfBoundsException
     * */
    public int xMinusYUsingCheckIndex(int y) {
        Objects.checkIndex(y, x);
        return x - y;
    }

    public static int oneMinusYUsingCheckIndex(int y) {
        Objects.checkIndex(y, Y_UPPER_BOUND);
        return 1 - y;
    }

    public static void main(String[] args) {
        CheckingIndexInRangeZeroToLength solution = new CheckingIndexInRangeZeroToLength(18);

        // C1
        System.out.println(solution.xMinusY(12));
        System.out.println(solution.oneMinusY(12));

        // C2
        System.out.println(solution.xMinusYUsingCheckIndex(12));
        System.out.println(solution.oneMinusYUsingCheckIndex(12));
    }
}
