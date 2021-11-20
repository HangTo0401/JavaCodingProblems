package StringNumbersMath;

public class NextFloatingPointValue {
    /**
     * Math Manipulation
     * 36. Next floating-point value
     *
     * SOLUTIONS: There are 2 solutions to this problem
     * */

    /**
     * 1. The first solution use nextAfter()
     * Starting with JDK 6, the Math class is enriched
     * with the nextAfter() method.
     *
     * This method takes two arguments—the initial number
     * (float or double) and the direction
     * (Float/Double.NEGATIVE/POSITIVE_INFINITY)
     * and returns the next floating-point value
     *
     * Here, it is a flavor of this method to return
     * the next-floating point adjacent to 0.1
     * in the direction of negative infinity
     * This is shown in the following code:
     *
     * @param fNum
     * @return float
     * */
    public static float nextFloatingPoint(float fNum) {
        return Math.nextAfter(fNum, Float.NEGATIVE_INFINITY);
    }

    /**
     * 2A. The second solution use nextUp()
     * Starting with JDK 8, the Math class is enriched
     * with two methods that act as shortcuts
     * for nextAfter() and are faster
     * These methods are nextUp() and nextDown()
     *
     * Therefore, nextAfter() in the direction of
     * negative infinity is available via
     * Math.nextDown() and nextAfter(),
     * while in the direction of positive infinity,
     * this is available via Math.nextUp()
     * This is shown in the following code:
     *
     * @param fNum
     * @return float
     * */
    public static float nextFloatingPointUsingNextUp(float fNum) {
        return Math.nextUp(fNum); // 0.10000001
    }

    /**
     * 2B. The second solution use nextDown()
     * Starting with JDK 8, the Math class is enriched
     * with two methods that act as shortcuts
     * for nextAfter() and are faster
     * These methods are nextUp() and nextDown()
     *
     * Therefore, nextAfter() in the direction of
     * negative infinity is available via
     * Math.nextDown() and nextAfter(),
     * while in the direction of positive infinity,
     * this is available via Math.nextUp()
     * */
    public static float nextFloatingPointUsingNextDown(float fNum) {
        return Math.nextDown(fNum); // 0.099999994
    }

    public static void main(String[] args) {
        NextFloatingPointValue solution = new NextFloatingPointValue();

        // C1
        System.out.println(solution.nextFloatingPoint(0.1f));

        // C2A
        System.out.println(solution.nextFloatingPointUsingNextUp(0.1f));

        // C2B
        System.out.println(solution.nextFloatingPointUsingNextDown(0.1f));
    }
}
