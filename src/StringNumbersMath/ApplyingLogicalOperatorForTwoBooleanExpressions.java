package StringNumbersMath;

public class ApplyingLogicalOperatorForTwoBooleanExpressions {
    /**
     * Math Manipulation
     * 31. Applying logical AND/OR/XOR to two boolean expressions
     *
     * SOLUTIONS: There is 1 solution to this problem
     * The truth table of elementary logic operations (AND, OR, and XOR) looks
     * as follows:
     * In Java, the logical AND operator is represented as &&,
     * the logical OR operator is represented as ||,
     * and the logical XOR operator is represented as ^.
     *
     * Starting with JDK 8, these operators are applied to two booleans and are
     * wrapped in three static methods—Boolean.logicalAnd(),
     * Boolean.logicalOr(), and Boolean.logicalXor():
     * This is shown in the following code:
     *
     * @param num1
     * @param num2
     * @return void
     * */
    public static void applyLogicalOperator(int num1, int num2) {
        // if (num1 > num2 && num2 < 50)
        if (Boolean.logicalAnd(num1 > num2, num2 < 50)) {
            System.out.println(num1 + " is greater than " + num2 + " AND " + num2 + " is less than 50");
        } else if (Boolean.logicalOr(num1 > num2, num2 < 50)) {
            // if (num1 > num2 || num2 < 50)
            System.out.println(num1 + " is greater than " + num2 + " OR " + num2 + " is less than 50");
        } else if (Boolean.logicalXor(num1 > num2, num2 < 50)) {
            // if (num1 > num2 ^ num2 < 50)
            System.out.println(num1 + " is greater than " + num2 + " XOR " + num2 + " is less than 50");
        }

        if (Boolean.logicalAnd(Boolean.logicalOr(num1 > num2, num2 < 50), Boolean.logicalOr(num1 <= num2, num2 > 50))) {
            System.out.println("Using combination of these methods!!!");
        }
    }
    public static void main(String[] args) {
        ApplyingLogicalOperatorForTwoBooleanExpressions solution = new ApplyingLogicalOperatorForTwoBooleanExpressions();
        solution.applyLogicalOperator(10, 21);
    }
}
