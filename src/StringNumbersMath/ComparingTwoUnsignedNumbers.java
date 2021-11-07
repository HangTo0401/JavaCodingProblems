package StringNumbersMath;

public class ComparingTwoUnsignedNumbers {

    /**
     * 1.29 Comparing two unsigned numbers
     *
     * Let's consider two signed integers, Integer.MIN_VALUE (-2,147,483,648)
     * and Integer.MAX_VALUE (2,147,483,647).
     *
     * Comparing these integers (signed values) will result in
     * -2,147,483,648 being smaller than 2,147,483,647
     * The compareUnsigned() method is available
     * in the Integer and Long classes starting with JDK 8,
     * and in the Byte and Short classes starting with JDK 9
     *
     * SOLUTIONS: There is 1 solution to this problem
     * */

    /**
     * 1. The first solution use Integer.compareUnsigned()
     * In JDK 8, these two integers can be compared as unsigned values via the
     * Integer.compareUnsigned() method
     * (this is the equivalent of Integer.compare() for unsigned values)
     *
     * Mainly, this method ignores the notion of sign bit,
     * and the left-most bit is considered the most significant bit.
     *
     * Under the unsigned values umbrella, this method returns 0
     * if the compared numbers are equal,
     * a value less than 0 if the first unsigned value is smaller than the second,
     *
     * and a value greater than 0 if the first unsigned value is greater than the second.
     * The following comparison returns 1, indicating that the unsigned value of
     * Integer.MIN_VALUE is greater than the unsigned value of Integer.MAX_VALUE:
     * This is shown in the following code:
     *
     * @param num1
     * @param num2
     * @return void
     * */
    public static void comparingTwoUnsignedNums(int num1, int num2) {
        // resultSigned is equal to 1 indicating that MIN_VALUE is greater than MAX_VALUE
        int resultUnsigned  = Integer.compareUnsigned(num1, num2);

        if (resultUnsigned == 0) {
            System.out.println("Two unsigned value are equal!");
        } else if (resultUnsigned > 0) {
            System.out.println(num1 + " is greater than the unsigned value of " + num2);
        } else {
            System.out.println(num1 + " is less than the unsigned value of " + num2);
        }
    }

    public static void main(String[] args) {
        ComparingTwoUnsignedNumbers solution = new ComparingTwoUnsignedNumbers();
        solution.comparingTwoUnsignedNums(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
