package StringNumbersMath;

public class ConvertingLongIntoInt {
    /**
     * Math Manipulation
     * 1.34 Converting long into int
     *
     * SOLUTIONS: There are 3 solutions to this problem
     * */

    /**
     * 1. The first solution use Casting
     * But in case longInt = Long.MAX_VALUE;
     * (int) longInt will return -1
     * This is shown in the following code:
     *
     * @return int
     * */
    public static int convertLongIntoIntUsingCasting() {
        long longInt = Integer.MAX_VALUE;
        int intNrCast = (int) longInt;
        return intNrCast;
    }

    /**
     * 2. The second solution use Long.intValue()
     * But in case longInt = Long.MAX_VALUE;
     * Long.valueOf(longInt).intValue() will return -1
     * This is shown in the following code:
     *
     * @return int
     * */
    public static int convertLongIntoIntUsingIntValue() {
        long longInt = Integer.MAX_VALUE;
        int intNrValue = Long.valueOf(longInt).intValue();
        return intNrValue;
    }

    /**
     * 3. The third solution use Math.toIntExact()
     * Both above approaches will return -1
     * in case long longInt = Long.MAX_VALUE;
     * In order to avoid such results, we use Math.toIntExact() in JDK 8
     * This method gets an argument of the long type
     * and tries to convert it into int. If the obtained value overflows int,
     * then this method will throw ArithmeticException:
     * This is shown in the following code:
     *
     * @return int
     * */
    public static int convertLongIntoIntUsingToIntExact() {
        // throws ArithmeticException
        long longInt = Integer.MAX_VALUE;
        int intNrMaxExact = Math.toIntExact(longInt);
        return intNrMaxExact;
    }

    public static void main(String[] args) {
        ConvertingLongIntoInt solution = new ConvertingLongIntoInt();

        // C1
        System.out.println(solution.convertLongIntoIntUsingCasting());

        // C2
        System.out.println(solution.convertLongIntoIntUsingIntValue());

        // C3
        System.out.println(solution.convertLongIntoIntUsingToIntExact());
    }
}
