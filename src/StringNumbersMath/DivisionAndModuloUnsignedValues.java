package StringNumbersMath;

public class DivisionAndModuloUnsignedValues {

    /**
     * Math Manipulation
     * 30. Division and modulo of unsigned values
     * SOLUTIONS: There is 1 solution to this problem
     *
     * Let's consider the Integer.MIN_VALUE
     * and Integer.MAX_VALUE signed numbers
     * and let's apply division and modulo
     *
     * divideUnsigned() and remainderUnsigned() are present
     * in the Integer and Long classes respectively.
     * */

    /**
     * 1A. The first solution use divideUnsigned() and remainderUnsigned() methods
     * Computing the unsigned quotient and remainder that resulted from the
     * division of two unsigned values is supported by the JDK 8 unsigned
     * arithmetic API via the divideUnsigned() and remainderUnsigned() methods.
     * This is shown in the following code:
     *
     * @param num1
     * @param num2
     * @return void
     * */
    public static void divisionUnsigned(int num1, int num2) {
        // Division unsigned
        int divisionUnsignedMinMax = Integer.divideUnsigned(num1, num2); // 1
        int divisionUnsignedMaxMin = Integer.divideUnsigned(num2, num1); // 0

        System.out.println(divisionUnsignedMinMax);
        System.out.println(divisionUnsignedMaxMin);
    }

    /**
     * 1B. The first solution use divideUnsigned() and remainderUnsigned() methods
     * Computing the unsigned quotient and remainder that resulted from the
     * division of two unsigned values is supported by the JDK 8 unsigned
     * arithmetic API via the divideUnsigned() and remainderUnsigned() methods.
     * This is shown in the following code:
     *
     * @param num1
     * @param num2
     * @return void
     * */
    public static void moduloUnsigned(int num1, int num2) {
        // modulo unsigned
        int moduloUnsignedMinMax = Integer.remainderUnsigned(num1, num2); // 1
        int moduloUnsignedMaxMin = Integer.remainderUnsigned(num2, num1); // 2147483647

        System.out.println(moduloUnsignedMinMax);
        System.out.println(moduloUnsignedMaxMin);
    }

    public static void main(String[] args) {
        DivisionAndModuloUnsignedValues solution = new DivisionAndModuloUnsignedValues();
        solution.divisionUnsigned(Integer.MIN_VALUE, Integer.MAX_VALUE);
        solution.moduloUnsigned(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
