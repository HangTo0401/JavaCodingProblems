package StringNumbersMath;

public class ComputingFloorOfDivisionAndModulus {

    /**
     * Math Manipulation
     * 1.35 Computing the floor of a division and modulus
     *
     * SOLUTIONS: There are 3 solutions to this problem
     * The floor of a division for two integers that have
     * the same sign (both are positive or negative)
     * can be obtained via the / operator.
     * */

    /**
     * 1. The first solution use Math.floor()
     * This is shown in the following code:
     *
     * @param num1
     * @param num2
     * @return long
     * */
    public static long computingFloorUsingMathFloor(int num1, int num2) {
        // num1 is the dividend, num2 is the divisor
        int result = num1/num2;
        return (long) Math.floor(result); // -16
    }

    /**
     * 2. The second solution use Math.floorDiv()
     * In JDK 8 onward, all of these cases have been covered
     * and exposed via the Math.floorDiv() method.
     * This method takes two integers representing
     * the dividend and the divisor as arguments
     * and returns the largest (closest to
     * positive infinity) int value that is less than
     * or equal to the algebraic quotient:
     * The Math.floorDiv() method comes in three flavors:
     * floorDiv(int x, int y),
     * floorDiv(long x, int y),
     * floorDiv(long x, long y).
     *
     * This is shown in the following code:
     *
     * @param num1
     * @param num2
     * @return long
     * */
    public static long computingFloorUsingMathFloorDiv(int num1, int num2) {
        // num1 is the dividend, num2 is the divisor
        return (long) Math.floorDiv(num1, num2); // -16
    }

    /**
     * 2B. The another solution use Math.ceil()
     * If the integers are not positive, then we use Math.ceil()
     * This is shown in the following code:
     *
     * @param num1
     * @param num2
     * @return long
     * */
    public static long computingFloorUsingMathCell(int num1, int num2) {
        // num1 is the dividend, num2 is the divisor
        return (long) Math.ceil((double) num1/num2); // -16
    }

    public static void main(String[] args) {
        ComputingFloorOfDivisionAndModulus solution = new ComputingFloorOfDivisionAndModulus();

        // C1
        System.out.println(solution.computingFloorUsingMathFloor(-222, 14));

        // C2
        System.out.println(solution.computingFloorUsingMathFloorDiv(-222, 14));

        // C3
        System.out.println(solution.computingFloorUsingMathCell(-222, 14));
    }
}
