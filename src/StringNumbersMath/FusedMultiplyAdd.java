package StringNumbersMath;

public class FusedMultiplyAdd {
    /**
     * Math Manipulation
     * 1.38 Fused Multiply Add
     *
     * SOLUTIONS: There are 2 solutions to this problem
     * The mathematical computation (a * b) + c is heavily exploited in matrix
     * multiplications, which are frequently used in High-Performance
     * Computing (HPC), AI applications, machine learning, deep learning,
     * neural networks, and so on.
     * */

    /**
     * 1. The first solution use * and + operators
     * The main problem of this implementation consists of
     * low accuracy and performance caused
     * by two rounding errors
     * (one for the multiply operation and one for the addition operation)
     * This is shown in the following code:
     *
     * @param num1
     * @param num2
     * @return long
     * */
    public static double fusedMultiplyAdd(double num1, double num2, double num3) {
        return (num1 * num2) + num3;
    }

    /**
     * 2. The second solution use Math.fma()
     * Intel AVX's instructions for performing SIMD operations and
     * to JDK 9, which added the Math.fma() method,
     * this computation can be boosted.
     * By relying on Math.fma(), the rounding is done only once using the
     * round to nearest even rounding mode
     * Notice that this improvement is available for modern Intel processors,
     * so it is not enough to just have JDK 9 in place.
     * */
    public static double fusedMultiplyAddUsingMathFma(double num1, double num2, double num3) {
        return Math.fma(num1, num2, num3);
    }

    public static void main(String[] args) {
        FusedMultiplyAdd solution = new FusedMultiplyAdd();

        // C1
        System.out.println(solution.fusedMultiplyAdd(49.29d, -28.58d, 33.63d));

        // C2
        System.out.println(solution.fusedMultiplyAddUsingMathFma(49.29d, -28.58d, 33.63d));
    }
}
