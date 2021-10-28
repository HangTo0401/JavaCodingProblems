package StringNumbersMath;

public class CheckingWhetherStringContainsOnlyDigits {

    /**
     * String Manipulation
     * 1.4  Checking whether a string contains only digits
     *
     * SOLUTION: There are 2 solutions to this problem
     */

    /**
     * 1. The first solution is using Character.isDigit() method
     * The solution relying on Character.isDigit() is pretty simple
     * and fast—loop the string characters
     * Then break the loop if this method returns false
     * This is shown in the following code:
     * 
     * @param str
     * @return boolean
     */
    public static boolean containsOnlyDigits(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 2. The second solution is using String.matches() method
     * with parameter is regex that accept digits only
     * This is shown in the following code:
     *
     * @param str
     * @return boolean
     */
    public static boolean containsOnlyDigitsUsingMatch(String str) {
        return str.matches("[0-9]+");
    }

    public static void main(String[] args) {
        CheckingWhetherStringContainsOnlyDigits solution = new CheckingWhetherStringContainsOnlyDigits();

        System.out.println(solution.containsOnlyDigits("3445"));
        System.out.println(solution.containsOnlyDigitsUsingMatch("yhhnnfn3445"));
    }
}
